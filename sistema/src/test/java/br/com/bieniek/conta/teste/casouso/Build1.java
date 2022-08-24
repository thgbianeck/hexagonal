package br.com.bieniek.conta.teste.casouso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Responsável por configurar os serviços do spring
 */
@Configuration
@ComponentScan({
        // objetos de sistema
        "br.com.bieniek.conta.sistema",
        // adptadores falsos
        "br.com.bieniek.conta.adaptador"})
public class Build1 {
    // Build 1: Adaptador Testes -> Sistema <- Adptadores Mocks
}
