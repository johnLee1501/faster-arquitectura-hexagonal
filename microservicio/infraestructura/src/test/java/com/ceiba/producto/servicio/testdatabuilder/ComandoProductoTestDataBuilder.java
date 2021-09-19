package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private String codigoProducto;
    private String nombre;
    private int valorProducto;

    public ComandoProductoTestDataBuilder() {
        codigoProducto = "HSJDH9";
        nombre = "Xiaomi Note 9";
        valorProducto = 140000;
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(codigoProducto, nombre, valorProducto);
    }
}
