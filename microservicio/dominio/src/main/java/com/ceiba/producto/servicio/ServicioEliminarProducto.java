package com.ceiba.producto.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionProductoComprado;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {
    private static final String PRODUCTO_COMPRADO_NO_ELIMINAR = "El producto ha sido comprado, elimine la compra primero";

    private final RepositorioProducto repositorioProducto;
    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto, RepositorioCompra repositorioCompra) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Long id) {
        validarProductoComprado(id);
        this.repositorioProducto.eliminar(id);
    }

    private void validarProductoComprado(Long id) {
        boolean existe = this.repositorioCompra.existeCompra(id);
        if (existe) {
            throw new ExcepcionProductoComprado(PRODUCTO_COMPRADO_NO_ELIMINAR);
        }
    }
}
