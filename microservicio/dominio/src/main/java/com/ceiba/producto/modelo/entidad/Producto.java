package com.ceiba.producto.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.*;

public class Producto {

    private static final String SE_DEBE_INGRESAR_CODIGO_DEL_PRODUCTO = "Se debe ingresar el código del producto";
    private static final String SE_DEBE_INGRESAR_NOMBRE_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String CAMPO_LONGITUD_MAXIMA = "La longitud de el campo %s no puede superar los %s caracteres";
    private static final String VALOR_PRODUCTO_MIN_MAX = "El valor del producto no puede ser menor a %s ni mayor a %s";
    private static final String CODIGO_PRODUCTO_SOLO_ALFANUMERICO = "El campo codigoProducto debe ser alfanumérico";


    private Long id;
    private String codigoProducto;
    private String nombre;
    private int valorProducto;

    public Producto(String codigoProducto, String nombre, int valorProducto) {
        validarObligatorio(codigoProducto, SE_DEBE_INGRESAR_CODIGO_DEL_PRODUCTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE_PRODUCTO);
        validadLongitud(codigoProducto, 1, 6, String.format(CAMPO_LONGITUD_MAXIMA, "codigoProducto", 6));
        validarMenorMayor(valorProducto, 1L, 5000000L, String.format(VALOR_PRODUCTO_MIN_MAX, 1, 5000000));
        validarAlfanumerico(codigoProducto, CODIGO_PRODUCTO_SOLO_ALFANUMERICO);

        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.valorProducto = valorProducto;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValorProducto() {
        return valorProducto;
    }
}
