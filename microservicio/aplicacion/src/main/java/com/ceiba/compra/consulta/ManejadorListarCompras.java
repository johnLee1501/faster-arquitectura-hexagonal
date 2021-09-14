package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCompras {

    private final DaoCompra daoCompra;

    public ManejadorListarCompras(DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar(Long identificadorUsuario){ return this.daoCompra.listarPorUsuario(identificadorUsuario); }
}
