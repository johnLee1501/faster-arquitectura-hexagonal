package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDate;


public class ComandoCompraTestDataBuilder {

    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private Long productoId;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public ComandoCompraTestDataBuilder() {
        identificadorUsuario = 123456789L;
        direccion = "Calle 4 #25b32";
        ciudad = "Bogotá";
        productoId = 1L;
        tipoUsuario = 1;
        fechaCompra = LocalDate.now();
    }

    public ComandoCompra build() {
        return new ComandoCompra(
                identificadorUsuario,
                direccion,
                ciudad,
                productoId,
                tipoUsuario);
    }
}