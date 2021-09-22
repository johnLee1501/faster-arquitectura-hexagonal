package com.ceiba.dominio.excepcion;

public class ExcepcionProductoComprado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionProductoComprado(String mensaje) {
        super(mensaje);
    }
}


