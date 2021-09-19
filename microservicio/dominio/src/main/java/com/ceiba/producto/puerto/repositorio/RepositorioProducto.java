package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un procucto
     *
     * @param producto
     * @return el id generado
     */
    Long crear(Producto producto);

    /**
     * Permite eliminar un procucto
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un procucto con un nombre
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un producto con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeId(Long id);

    /**
     * Permite validar si existe un procucto con un codigoProducto
     *
     * @param codigoProducto
     * @return si existe o no
     */
    boolean existeCodigoProducto(String codigoProducto);

    /**
     * Permite obtener el precio de un producto
     *
     * @param id
     * @return si existe o no
     */
    int obtenerPrecioProducto(Long id);

}
