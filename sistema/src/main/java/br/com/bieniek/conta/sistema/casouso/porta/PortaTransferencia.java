package br.com.bieniek.conta.sistema.casouso.porta;

import br.com.bieniek.conta.sistema.dominio.modelo.Conta;
import br.com.bieniek.conta.sistema.dominio.modelo.NegocioException;

import java.math.BigDecimal;

/**
 * Responsável por definir a porta de entrada (driver) de operações para caso de uso de transferência.
 */
public interface PortaTransferencia {
    Conta getConta(Integer numero) throws NegocioException;
    void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor) throws NegocioException;
}
