package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private String codigoProducto;
    private String nombre;
    private int valorProducto;

    public ProductoTestDataBuilder() {
        codigoProducto = "HSJDH9";
        nombre = "Xiaomi Note 8";
        valorProducto = 140000;
    }

    public ProductoTestDataBuilder conCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
        return this;
    }
    public ProductoTestDataBuilder sinCodigoProducto() {
        this.codigoProducto = null;
        return this;
    }

    public ProductoTestDataBuilder sinNombre() {
        this.nombre = null;
        return this;
    }

    public ProductoTestDataBuilder conValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
        return this;
    }

    public Producto build() {
        return new Producto(codigoProducto, nombre, valorProducto);
    }
}
