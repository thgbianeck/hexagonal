package br.com.bieniek.conta.adaptador;

import br.com.bieniek.conta.sistema.dominio.modelo.Conta;
import br.com.bieniek.conta.sistema.dominio.modelo.NegocioException;
import br.com.bieniek.conta.sistema.porta.ContaRepositorio;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Responsável por implementar a porta de saída (driven) de serviços de banco de dados falso.
 * Sera gerenciado pelo IoC
 */
@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {

    private Map<Integer, Conta> banco = new HashMap<>();

    public AdaptadorContaFakeImp() {
        banco.put(10, new Conta(10, new BigDecimal(100), "Fernando Fake"));
        banco.put(20, new Conta(20, new BigDecimal(100), "Rebeca Fake"));
    }

    public Conta get(Integer numero) {
        System.out.println("Fake banco de dados -> Conta get(numero)");
        return banco.get(numero);
    }

    public void alterar(Conta conta) {
        System.out.println("Fake banco de dados -> alterar(conta)");
        var ct = banco.get(conta.getNumero());
        if (!isNull(ct)) {
            banco.put(conta.getNumero(), conta);
        } else {
            throw new NegocioException("Conta inexistente: " + conta.getNumero());
        }
    }
}