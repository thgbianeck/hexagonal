package br.com.bieniek.conta.sistema.dominio.modelo;

/**
 * Responsável por centralizar todas as mensagens de validações.
 */
public class Erro {

    public static void obrigatorio(String nome) {
        throw new NegocioException(nome + " é obrigatório.");
    }

    public static void inexistente(String nome) {
        throw new NegocioException(nome + " é inexistente.");
    }

    public static void saldoInsuficiente() {
        throw new NegocioException("Saldo Insuficiente.");
    }

    public static void mesmaConta() {
        throw new NegocioException("Conta débito e crédito devem ser diferentes.\");");
    }
}
