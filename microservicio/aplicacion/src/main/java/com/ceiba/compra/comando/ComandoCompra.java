package com.ceiba.compra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra {

    private Long identificadorUsuario;
    private String direccion;
    private String ciudad;
    private String codigoProducto;
    private int valorProducto;
    private int tipoUsuario;
}
