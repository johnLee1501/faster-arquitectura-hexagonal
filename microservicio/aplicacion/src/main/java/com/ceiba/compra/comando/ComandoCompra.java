package com.ceiba.compra.comando;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public class ComandoCompra {

    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private String codigoProducto;
    private int valorProducto;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public ComandoCompra(Long id, Long identificadorUsuario, String direccion, String ciudad, String codigoProducto, int valorProducto, int tipoUsuario, LocalDate fechaCompra, LocalDate fechaEntrega) {
        this.id = id;
        this.identificadorUsuario = identificadorUsuario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoProducto = codigoProducto;
        this.valorProducto = valorProducto;
        this.tipoUsuario = tipoUsuario;
        this.fechaCompra = fechaCompra;
        this.fechaEntrega = fechaEntrega;
    }

    public ComandoCompra() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentificadorUsuario(Long identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
