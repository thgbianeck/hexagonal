module br.com.bieniek.conta.sistema {

    requires javax.inject;
    requires spring.tx;

    // expondo porta de entrada (driver)
    exports br.com.bieniek.conta.sistema.casouso.porta;
    exports br.com.bieniek.conta.sistema.casouso.imp;
    // expondo sistema negocio
    exports br.com.bieniek.conta.sistema.dominio.modelo;
    exports br.com.bieniek.conta.sistema.dominio.servico;
    // expondo adptadores de saidas (driven)
    exports br.com.bieniek.conta.sistema.porta;
    exports br.com.bieniek.conta.adaptador;

    // abre reflexão spring
    opens br.com.bieniek.conta.sistema.casouso.porta;
    opens br.com.bieniek.conta.sistema.casouso.imp;
    opens br.com.bieniek.conta.sistema.dominio.servico;
    opens br.com.bieniek.conta.adaptador;
}