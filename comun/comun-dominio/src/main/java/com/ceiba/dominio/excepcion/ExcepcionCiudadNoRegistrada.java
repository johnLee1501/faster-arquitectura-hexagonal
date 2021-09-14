package com.ceiba.dominio.excepcion;


public class ExcepcionCiudadNoRegistrada extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCiudadNoRegistrada(String mensaje) {
        super(mensaje);
    }
}


