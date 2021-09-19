package com.ceiba.compra.modelo.entidad;


import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;


public class Compra {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_USUARIO = "Se debe ingresar la identificación del usuario";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la dirección para el envío";
    private static final String SE_DEBE_INGRESAR_LA_CIUDAD = "Se debe ingresar la ciudad";
    private static final String SE_DEBE_INGRESAR_CODIGO_PRODUCTO = "Se debe ingresar el código del producto";
    private static final String IDENTIFICACION_USUARIO_LONGITUD = "La identificación del usuario debe tener una longitud de entre 6 y 10 dígitos";
    private static final String CAMPO_LONGITUD_MAXIMA = "La longitud de el campo %s no puede superar los %s caracteres";
    private static final String CIUDAD_SOLO_ALFANUMERICO = "El campo ciudad debe ser alfanumérico";



    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private Long productoId;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public Compra(Long identificadorUsuario, String direccion, String ciudad, Long productoId, int tipoUsuario) {
        validarObligatorio(identificadorUsuario, SE_DEBE_INGRESAR_LA_IDENTIFICACION_USUARIO);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(ciudad, SE_DEBE_INGRESAR_LA_CIUDAD);
        validarObligatorio(productoId, SE_DEBE_INGRESAR_CODIGO_PRODUCTO);
        validadLongitud(String.valueOf(identificadorUsuario), 6, 10, IDENTIFICACION_USUARIO_LONGITUD);
        validadLongitud(direccion, 1, 25, String.format(CAMPO_LONGITUD_MAXIMA, "direccion", 25));
        validadLongitud(ciudad, 1, 21, String.format(CAMPO_LONGITUD_MAXIMA, "ciudad", 21));
        validarAlfanumerico(ciudad, CIUDAD_SOLO_ALFANUMERICO);

        this.identificadorUsuario = identificadorUsuario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.productoId = productoId;
        this.tipoUsuario = tipoUsuario;
        this.fechaCompra = LocalDate.now();
    }

    public void asignarFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public Long getProductoId() {
        return productoId;
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
}
