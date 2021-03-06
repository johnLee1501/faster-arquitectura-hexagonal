package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private int tipoUsuario;
    private Long productoId;
    private String codigoProducto;
    private String nombreProducto;
    private int valorProducto;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;

}
