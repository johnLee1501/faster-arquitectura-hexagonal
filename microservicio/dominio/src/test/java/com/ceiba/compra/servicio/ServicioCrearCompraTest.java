package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionCiudadNoRegistrada;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearCompraTest {

    @Test
    public void validarFechaEntregaUsuarioTipoTresSinContarFindeSemanaTest() {
        LocalDate fechaEntrega = sumarDiasSinFinesDeSemana(2);
        Compra compra = new CompraTestDataBuilder().conTipoUsuario(3).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarFechaEntregaComprasMayoresACientoCincuentaMilSinContarFindeSemanaTest() {
        LocalDate fechaEntrega = sumarDiasSinFinesDeSemana(2);
        Compra compra = new CompraTestDataBuilder().conValorProducto(160000).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarFechaEntregaUsuarioTipoDosCompraMenorCientoCincuentaMilSinContarFindeSemanaTest() {
        LocalDate fechaEntrega = sumarDiasSinFinesDeSemana(6);
        Compra compra = new CompraTestDataBuilder().conTipoUsuario(2).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarFechaEntregaUsuarioTipoUnoCompraMenorCientoCincuentaMilSinContarFindeSemanaTest() {
        LocalDate fechaEntrega = sumarDiasSinFinesDeSemana(10);
        Compra compra = new CompraTestDataBuilder().conTipoUsuario(1).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarCiudadNoRegistradaEnElSistemaTest() {
        Compra compra = new CompraTestDataBuilder().conCiudad("Ocaña").build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionCiudadNoRegistrada.class, "Envios no disponibles para esta ciudad");
    }


    private LocalDate sumarDiasSinFinesDeSemana(int dias) {
        LocalDate fechaActual = LocalDate.now();
        int diasAgregados = 0;
        LocalDate nuevaFecha = fechaActual;
        while (diasAgregados < dias) {
            nuevaFecha = nuevaFecha.plusDays(1);
            if (!(nuevaFecha.getDayOfWeek() == DayOfWeek.SATURDAY || nuevaFecha.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }
        return nuevaFecha;
    }
}
