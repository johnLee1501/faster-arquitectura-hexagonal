package com.ceiba.compra.comando;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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
}
