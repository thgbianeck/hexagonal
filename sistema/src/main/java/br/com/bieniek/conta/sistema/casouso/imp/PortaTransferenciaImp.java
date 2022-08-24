package br.com.bieniek.conta.sistema.casouso.imp;

import br.com.bieniek.conta.sistema.casouso.porta.PortaTransferencia;
import br.com.bieniek.conta.sistema.dominio.modelo.Conta;
import br.com.bieniek.conta.sistema.dominio.servico.Transferencia;
import br.com.bieniek.conta.sistema.porta.ContaRepositorio;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

import static br.com.bieniek.conta.sistema.dominio.modelo.Erro.*;
import static java.util.Objects.isNull;

/**
 * Responsável por implementar a porta de operações para caso de uso de transferencia.
 * Sera gerenciado pelo IoC
 */
@Named
public class PortaTransferenciaImp implements PortaTransferencia {

    private final ContaRepositorio repositorio;
    private final Transferencia transferencia;

    // Ioc por construtor
    @Inject
    public PortaTransferenciaImp(
            ContaRepositorio repositorio,
            Transferencia transferencia) {
        this.repositorio = repositorio;
        this.transferencia = transferencia;
    }

    @Override
    public Conta getConta(Integer numero) {
        return repositorio.get(numero);
    }

    @Override
    @Transactional
    public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor) {
        //1. validação de parametros
        if (isNull(contaDebito)) obrigatorio("Conta débito");
        if (isNull(contaCredito)) obrigatorio("Conta crédito");
        if (isNull(valor)) obrigatorio("Valor");

        //2. validação de contas
        var debito = repositorio.get(contaDebito);
        if (isNull(debito)) inexistente("Conta débito");

        var credito = repositorio.get(contaCredito);
        if (isNull(credito)) inexistente("Conta crédito");

        //3.validacao mesma conta
        if (debito.getNumero().equals(credito.getNumero())) mesmaConta();

        //4. operação
        transferencia.processar(valor, debito, credito);
        repositorio.alterar(debito);
        repositorio.alterar(credito);
    }
}
