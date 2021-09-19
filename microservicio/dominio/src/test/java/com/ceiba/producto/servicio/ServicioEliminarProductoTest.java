package com.ceiba.producto.servicio;

import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioEliminarProductoTest {

    @Test
    public void validarEliminarProductoTest() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarProducto.ejecutar(1L));
    }
}
