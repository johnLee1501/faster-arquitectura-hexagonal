package com.ceiba.producto.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionProductoComprado;
import com.ceiba.dominio.excepcion.ExcepcionProductoNoExiste;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {
    private static final String PRODUCTO_COMPRADO_NO_ELIMINAR = "El producto ha sido comprado, elimine la compra primero";
    private static final String PRODUCTO_NO_EXISTE = "El producto ha eliminar no existe";

    private final RepositorioProducto repositorioProducto;
    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto, RepositorioCompra repositorioCompra) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Long id) {
        validarProductoExiste(id);
        validarProductoComprado(id);
        this.repositorioProducto.eliminar(id);
    }

    private void validarProductoComprado(Long id) {
        boolean existeCompra = this.repositorioCompra.existeCompra(id);
        if (existeCompra) {
            throw new ExcepcionProductoComprado(PRODUCTO_COMPRADO_NO_ELIMINAR);
        }
    }

    private void validarProductoExiste(Long id) {
        boolean existe = this.repositorioCompra.existe(id);
        if (!existe) {
            throw new ExcepcionProductoNoExiste(PRODUCTO_NO_EXISTE);
        }
    }
}
