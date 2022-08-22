package br.com.bieniek.conta.sistema.dominio.modelo;

/**
 * Responsável por representar um erro de negócio de sistema.
 */
public class NegocioException extends RuntimeException{

    public NegocioException(String message) {
        super(message);
    }
}
