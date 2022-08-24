package br.com.bieniek.conta.sistema.porta;

import br.com.bieniek.conta.sistema.dominio.modelo.Conta;

import javax.inject.Named;

/**
 * Responsável por definir a porta de saída (driven) de serviços de banco de dados.
 */
public interface ContaRepositorio {

    Conta get(Integer numero);

    void alterar(Conta conta);
}
