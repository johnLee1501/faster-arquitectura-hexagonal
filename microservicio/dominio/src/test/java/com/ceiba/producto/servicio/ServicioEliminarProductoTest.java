package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCompraNoRealizadaHoy;
import com.ceiba.dominio.excepcion.ExcepcionProductoComprado;
import com.ceiba.dominio.excepcion.ExcepcionProductoNoExiste;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioEliminarProductoTest {

    @Test
    public void validarEliminarProductoTest() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existeCompra(Mockito.anyLong())).thenReturn(false);
        Mockito.doNothing().when(repositorioProducto).eliminar(Mockito.anyLong());
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto, repositorioCompra);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarProducto.ejecutar(1L));
        Mockito.verify(repositorioProducto, Mockito.times(1)).eliminar(Mockito.anyLong());
    }
    @Test
    public void validarEliminarProductoNoExisteTest() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto, repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarProducto.ejecutar(1L), ExcepcionProductoNoExiste.class, "El producto a eliminar no existe");

    }
    @Test
    public void validarEliminarProductoCompradoTest() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCompra.existeCompra(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto, repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarProducto.ejecutar(1L), ExcepcionProductoComprado.class, "El producto ha sido comprado, elimine la compra primero");

    }
}
