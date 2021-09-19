package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoCompra {

    /**
     * Permite listar usuarios
     *
     * @return los usuarios
     */
    List<DtoCompra> listarPorUsuario(Long identificadorUsuario);

    /**
     * Si una compra existe obtenerlo por Id
     *
     * @param id
     * @return
     */
    DtoCompra obtenerPorId(Long id);
}
