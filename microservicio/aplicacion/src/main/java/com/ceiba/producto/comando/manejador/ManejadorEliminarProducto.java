package com.ceiba.producto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarProducto implements ManejadorComando<Long> {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public void ejecutar(Long idProducto) {
        this.servicioEliminarProducto.ejecutar(idProducto);
    }
}
