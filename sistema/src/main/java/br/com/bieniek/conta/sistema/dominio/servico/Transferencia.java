package br.com.bieniek.conta.sistema.dominio.servico;

import br.com.bieniek.conta.sistema.dominio.modelo.Conta;

import javax.inject.Named;
import java.math.BigDecimal;

import static br.com.bieniek.conta.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;

/**
 * Responsável por representar a entidade transferência e suas regras.
 * Sera gerenciado pelo IoC
 */
@Named
public class Transferencia {

    public void processar(BigDecimal valor, Conta debito, Conta credito) {
        if (isNull(valor)) {
            obrigatorio("Valor da transferência");
        }
        if (isNull(debito)) {
            obrigatorio("Conta débito");
        }
        if (isNull(credito)) {
            obrigatorio("Conta crédito");
        }
        debito.debitar(valor);
        credito.creditar(valor);
    }
}
