package br.com.bieniek.conta.teste.unidade.dominio.servico;

import br.com.bieniek.conta.sistema.dominio.modelo.Conta;
import br.com.bieniek.conta.sistema.dominio.modelo.NegocioException;
import br.com.bieniek.conta.sistema.dominio.servico.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Regra de Transferência")
public class TesteTransferencia {

    // armazena o cem para teste ficar dinamico
    BigDecimal cem = new BigDecimal(100);
    BigDecimal vinte = new BigDecimal(20);
    Transferencia trans = new Transferencia();
    Conta contaDebito;
    Conta contaCredito;

    @BeforeEach
    void prepara() {
        contaDebito = new Conta(1, cem, "Fernando");
        contaCredito = new Conta(2, cem, "Rebeca");
        trans = new Transferencia();
    }

    // negativos

    @Test
    @DisplayName("valor nulo como obrigatório")
    void teste1() {
        try {
            trans.processar(null, contaDebito, contaCredito);
            fail("Valor da trasnferência obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor da transferência é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    // Observação:
    // Não se faz necessario refazer os testes de nulo, zero ou negativo, na transferencia,
    // pois ele repassa para conta.debitar() e conta.creditar() os testes desses já garantem isso.
    // Cada teste deve garantir o serviço implementadas dentro da classe a ser testada e não
    // testar coisas de classes agregadas.

    @Test
    @DisplayName("conta debito como obrigatório")
    void teste2() {
        try {
            trans.processar(vinte, null, contaCredito);
            fail("conta debito obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta credito como obrigatório")
    void teste3() {
        try {
            trans.processar(vinte, contaDebito, null);
            fail("conta credito obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    // positivos

    @Test
    @DisplayName("transferir 20 reais")
    void teste4() {
        try {
            trans.processar(vinte, contaDebito, contaCredito);
            assertEquals(contaDebito.getSaldo(), cem.subtract(vinte),
                    "Saldo da conta débito deve bater");
            assertEquals(contaCredito.getSaldo(), cem.add(vinte),
                    "Saldo da conta crédito deve bater");
        } catch (NegocioException e) {
            fail("Deve transferir com sucesso");
        }
    }
}
