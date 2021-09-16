package com.ceiba.compra.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

public class CompraTest {
    @Test
    public void validarIdentificadorUsuarioObligatorioTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().sinIdentificadorUsuario();
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la identificación del usuario");
    }

    @Test
    public void validarDireccionObligatoriaTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().sinDireccion();
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la dirección para el envío");
    }

    @Test
    public void validarCiudadObligatoriaTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().sinCiudad();
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la ciudad");
    }

    @Test
    public void validarCodigoProductoObligatorioTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().sinCodigoProducto();
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el código del producto");
    }

    @Test
    public void validarLongitudIdentificadorTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conIdentificadorUsuario(12345678901L);
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionLongitudValor.class, "La identificación del usuario debe tener una longitud de entre 6 y 10 dígitos");
    }

    @Test
    public void validarLongitudDireccionTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conDireccion("Calle 4 N25a62 Santa Barbara Avenida 1 con 62");
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionLongitudValor.class, "La longitud de el campo direccion no puede superar los 25 caracteres");
    }

    @Test
    public void validarLongitudCiudadTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCiudad("Nueva Cartagena de Indias");
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionLongitudValor.class, "La longitud de el campo ciudad no puede superar los 21 caracteres");
    }

    @Test
    public void validarLongitudCodigoProductoUsuarioTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCodigoProducto("1KMDLAS8G");
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionLongitudValor.class, "La longitud de el campo codigoProducto no puede superar los 6 caracteres");
    }

    @Test
    public void validarValorProductoMenorAMayorATest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conValorProducto(50000000);
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorInvalido.class, "El valor del producto no puede ser menor a 1 ni mayor a 5000000");
    }

    @Test
    public void validarCiudadCampoAlfanumericoTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCiudad("Bogotá&");
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorInvalido.class, "El campo ciudad debe ser alfanumérico");
    }

    @Test
    public void validarCodigoProductoCampoAlfanumericoTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conCodigoProducto("$125GD");
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorInvalido.class, "El campo codigoProducto debe ser alfanumérico");
    }

    @Test
    public void validarTipoUsuarioValidoTest() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conTipoUsuario(4);
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorInvalido.class, "El tipo de usuario no está permitido");
    }
}
