package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionCiudadNoRegistrada;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
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
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarFechaEntregaComprasMayoresACientoCincuentaMilSinContarFindeSemanaTest() {
        LocalDate fechaEntrega = sumarDiasSinFinesDeSemana(2);
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioProducto.obtenerPrecioProducto(Mockito.anyLong())).thenReturn(180000);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
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
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioProducto.obtenerPrecioProducto(Mockito.anyLong())).thenReturn(140000);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
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
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioProducto.obtenerPrecioProducto(Mockito.anyLong())).thenReturn(140000);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
        // act
        servicioCrearCompra.ejecutar(compra);
        // assert
        Assert.assertEquals(compra.getFechaEntrega(), fechaEntrega);
    }

    @Test
    public void validarCiudadNoRegistradaEnElSistemaTest() {
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionCiudadNoRegistrada.class, "Envios no disponibles para esta ciudad");
    }

    @Test
    public void validarTipoDeUsuarioIncorrectoTest() {
        Compra compra = new CompraTestDataBuilder().conTipoUsuario(4).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionValorInvalido.class, "El tipo de usuario no está permitido");
    }

    @Test
    public void validarProductoNoRegistradoEnElSistemaTest() {
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        DaoCiudad daoCiudad = Mockito.mock(DaoCiudad.class);
        Mockito.when(repositorioProducto.existeId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(daoCiudad.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, repositorioProducto, daoCiudad);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionCiudadNoRegistrada.class, "El producto no se encuentra registrado en el sistema");
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
