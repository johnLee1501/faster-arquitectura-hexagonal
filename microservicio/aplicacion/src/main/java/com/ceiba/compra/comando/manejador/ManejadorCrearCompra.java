package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<Long>> {

    private final FabricaCompra fabricaCompra;
    private final ServicioCrearCompra servicioCrearCompra;

    public ManejadorCrearCompra(FabricaCompra fabricaCompra, ServicioCrearCompra servicioCrearCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioCrearCompra = servicioCrearCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCompra comandoCompra) {
        Compra compra = this.fabricaCompra.crear(comandoCompra);
        return new ComandoRespuesta<>(this.servicioCrearCompra.ejecutar(compra));
    }
}
