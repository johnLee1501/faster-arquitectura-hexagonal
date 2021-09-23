package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ceiba.BasePrueba.assertThrows;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorProducto.class)
public class ComandoControladorProductoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoProducto daoProducto;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoProducto producto = new ComandoProductoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"))
                .andDo(
                        resultValorar -> {
                            DtoProducto producto1 = daoProducto.obtenerPorId(4L);
                            assertEquals("HSJDH9", producto1.getCodigoProducto());
                            assertEquals("Xiaomi Note 9", producto1.getNombre());
                            assertEquals(140000, producto1.getValorProducto());
                        }
                );

        ;
    }


    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/productos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        resultValorar -> {
                            assertThrows(() -> daoProducto.obtenerPorId(2L), IndexOutOfBoundsException.class, "Index: 0, Size: 0");
                        }
                );
    }
}
