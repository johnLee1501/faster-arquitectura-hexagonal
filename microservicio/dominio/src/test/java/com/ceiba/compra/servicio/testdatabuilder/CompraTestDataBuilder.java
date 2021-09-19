package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;

public class CompraTestDataBuilder {

    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private Long productoId;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public CompraTestDataBuilder() {
        id = 1L;
        identificadorUsuario = 1091677862L;
        direccion = "Calle 4 #25b32";
        ciudad = "Bogotá";
        productoId = 1L;
        tipoUsuario = 1;
        fechaCompra = LocalDate.now();
    }

    public CompraTestDataBuilder sinIdentificadorUsuario() {
        this.identificadorUsuario = null;
        return this;
    }
    public CompraTestDataBuilder sinProductoId() {
        this.productoId = null;
        return this;
    }
    public CompraTestDataBuilder sinDireccion() {
        this.direccion = null;
        return this;
    }

    public CompraTestDataBuilder sinCiudad() {
        this.ciudad = null;
        return this;
    }

    public CompraTestDataBuilder conIdentificadorUsuario(Long identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
        return this;
    }

    public CompraTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public CompraTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }


    public CompraTestDataBuilder conTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }


    public Compra build() {
        return new Compra(
                identificadorUsuario,
                direccion,
                ciudad,
                productoId,
                tipoUsuario);
    }
}
