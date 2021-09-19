package com.ceiba.producto.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void validarObligatorioCodigoProductoTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().sinCodigoProducto();
        BasePrueba.assertThrows(productoTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el código del producto");
    }
    @Test
    public void validarObligatotioNombreTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().sinNombre();
        BasePrueba.assertThrows(productoTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del producto");
    }
    @Test
    public void validarLongitudCodigoProductoTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conCodigoProducto("JKDFJDFK8554");
        BasePrueba.assertThrows(productoTestDataBuilder::build, ExcepcionLongitudValor.class, "La longitud de el campo codigoProducto no puede superar los 6 caracteres");
    }

    @Test
    public void validarValorProductoMenorAMayorATest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conValorProducto(6000000);
        BasePrueba.assertThrows(productoTestDataBuilder::build, ExcepcionValorInvalido.class, "El valor del producto no puede ser menor a 1 ni mayor a 5000000");
    }

    @Test
    public void validarCodigoProductoCampoAlfanumericoTest() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().conCodigoProducto("JKDF_6");
        BasePrueba.assertThrows(productoTestDataBuilder::build, ExcepcionValorInvalido.class, "El campo codigoProducto debe ser alfanumérico");
    }

}
