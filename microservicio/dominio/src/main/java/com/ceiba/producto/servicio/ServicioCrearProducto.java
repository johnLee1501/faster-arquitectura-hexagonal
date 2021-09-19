package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private static final String EL_NOMBRE_PRODUCTO_EXISTE_EN_EL_SISTEMA = "El nombre del producto ya existe en el sistema";
    private static final String EL_CODIGO_PRODUCTO_EXISTE_EN_EL_SISTEMA = "El codigo del producto ya existe en el sistema";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        validarExistenciaPreviaCodigoProducto(producto);
        validarExistenciaPreviaNombre(producto);
        return this.repositorioProducto.crear(producto);
    }

    private void validarExistenciaPreviaCodigoProducto(Producto producto) {
        boolean existe = this.repositorioProducto.existeCodigoProducto(producto.getCodigoProducto());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_CODIGO_PRODUCTO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaNombre(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_PRODUCTO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
