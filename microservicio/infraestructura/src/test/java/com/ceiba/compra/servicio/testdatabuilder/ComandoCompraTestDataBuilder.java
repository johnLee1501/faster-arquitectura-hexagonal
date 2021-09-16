package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDate;


public class ComandoCompraTestDataBuilder {

    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private String codigoProducto;
    private int valorProducto;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public ComandoCompraTestDataBuilder() {
        identificadorUsuario = 123456789L;
        direccion = "Calle 4 #25b32";
        ciudad = "Bogotá";
        codigoProducto = "25L8G4";
        valorProducto = 100000;
        tipoUsuario = 1;
        fechaCompra = LocalDate.now();
    }

    public ComandoCompra build() {
        return new ComandoCompra(
                identificadorUsuario,
                direccion,
                ciudad,
                codigoProducto,
                valorProducto,
                tipoUsuario);
    }
}