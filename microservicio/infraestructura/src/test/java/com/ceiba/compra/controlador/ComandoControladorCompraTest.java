package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.servicio.testdatabuilder.ComandoCompraTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCompra.class)
public class ComandoControladorCompraTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoCompra daoCompra;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoCompra compra = new ComandoCompraTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/compras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
//                .andDo(
//                        resultValorar -> {
//                             updateJugadorResponse = daoCompra.listarPorUsuario(compra.getIdentificadorUsuario());
//                            assertEquals(1116745412, updateJugadorResponse.getInt("numeroIdentificacion"));
//                            assertEquals("100000000.00", updateJugadorResponse.getString("valorizacion"));
//                            assertEquals("2021-04-13 00:00:00.0", updateJugadorResponse.getString("fechaValorizacion"));
//                        }
//                ); ;
    }


    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/compras/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
