package com.ceiba.compra.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Compra {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_USUARIO = "Se debe ingresar la identificación del usuario";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la dirección para el envío";
    private static final String SE_DEBE_INGRESAR_LA_CIUDAD = "Se debe ingresar la ciudad";
    private static final String SE_DEBE_INGRESAR_CODIGO_PRODUCTO = "Se debe ingresar el código del producto";
    private static final String IDENTIFICACION_USUARIO_LONGITUD = "La identificación del usuario debe tener una longitud de entre 6 y 10 dígitos";
    private static final String CAMPO_LONGITUD_MAXIMA = "La longitud de el campo %s no puede superar los %s caracteres";
    private static final String VALOR_PRODUCTO_MIN_MAX = "El valor del producto no puede ser menor a %s ni mayor a %s";
    private static final String El_CAMPO_DEBE_SER_ALFANUMERICO = "El campo %s debe ser alfanumérico";
    private static final String TIPO_USUARIO_NO_PERMITIDO = "El tipo de usuario no está permitido";


    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private String codigoProducto;
    private int valorProducto;
    private int tipoUsuario;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

    public Compra(Long id, Long identificadorUsuario, String direccion, String ciudad, String codigoProducto, int valorProducto, int tipoUsuario) {
        validarObligatorio(identificadorUsuario, SE_DEBE_INGRESAR_LA_IDENTIFICACION_USUARIO);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(ciudad, SE_DEBE_INGRESAR_LA_CIUDAD);
        validarObligatorio(codigoProducto, SE_DEBE_INGRESAR_CODIGO_PRODUCTO);
        validadLongitud(String.valueOf(identificadorUsuario), 6, 10, IDENTIFICACION_USUARIO_LONGITUD);
        validadLongitud(direccion, 1, 25, String.format(CAMPO_LONGITUD_MAXIMA, "direccion", 25));
        validadLongitud(ciudad, 1, 21, String.format(CAMPO_LONGITUD_MAXIMA, "ciudad", 21));
        validadLongitud(codigoProducto, 1, 6, String.format(CAMPO_LONGITUD_MAXIMA, "codigoProducto", 6));
        validarMenorMayor(valorProducto, 1L, 500000L, String.format(VALOR_PRODUCTO_MIN_MAX, 1, 5000000));
        validarAlfanumerico(ciudad, String.format(El_CAMPO_DEBE_SER_ALFANUMERICO, "ciudad"));
        validarAlfanumerico(codigoProducto, String.format(El_CAMPO_DEBE_SER_ALFANUMERICO, "codigoProducto"));
        validarRegex(String.valueOf(tipoUsuario), "(1|2|3)", TIPO_USUARIO_NO_PERMITIDO);

        this.id = id;
        this.identificadorUsuario = identificadorUsuario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoProducto = codigoProducto;
        this.valorProducto = valorProducto;
        this.tipoUsuario = tipoUsuario;
        this.fechaCompra = LocalDate.now();
    }

    public void asignarFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
