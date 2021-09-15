package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra crear(ComandoCompra comandoCompra) {
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getIdentificadorUsuario(),
                comandoCompra.getDireccion(),
                comandoCompra.getCiudad(),
                comandoCompra.getCodigoProducto(),
                comandoCompra.getValorProducto(),
                comandoCompra.getTipoUsuario());
    }

}
