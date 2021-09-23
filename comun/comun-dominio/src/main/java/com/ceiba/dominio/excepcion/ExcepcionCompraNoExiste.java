package com.ceiba.dominio.excepcion;

public class ExcepcionCompraNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCompraNoExiste(String mensaje) {
        super(mensaje);
    }
}


