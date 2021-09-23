package com.ceiba.dominio.excepcion;

public class ExcepcionProductoNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionProductoNoExiste(String mensaje) {
        super(mensaje);
    }
}


