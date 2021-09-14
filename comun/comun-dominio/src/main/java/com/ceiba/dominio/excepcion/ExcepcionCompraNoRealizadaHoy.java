package com.ceiba.dominio.excepcion;


public class ExcepcionCompraNoRealizadaHoy extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCompraNoRealizadaHoy(String mensaje) {
        super(mensaje);
    }
}

