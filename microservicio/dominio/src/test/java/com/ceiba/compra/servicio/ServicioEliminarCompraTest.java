package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCompraNoRealizadaHoy;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioEliminarCompraTest {
    @Test
    public void validarEliminarCompraRealizadaHoyFallidaTest() {
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
        Mockito.when(repositorioCompra.existeHoy(Mockito.anyLong(), Mockito.any())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarCompra.ejecutar(1L), ExcepcionCompraNoRealizadaHoy.class, "Solo se pueden cancelar las compras realizadas el día de hoy");
    }

    @Test
    public void validarEliminarCompraRealizadaHoyExitosaTest() {
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
        Mockito.when(repositorioCompra.existeHoy(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarCompra.ejecutar(1L));
    }
}
