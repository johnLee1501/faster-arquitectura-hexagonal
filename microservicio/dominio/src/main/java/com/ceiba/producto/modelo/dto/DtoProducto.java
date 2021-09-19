package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private Long id;
    private String codigoProducto;
    private String nombre;
    private int valorProducto;

}
