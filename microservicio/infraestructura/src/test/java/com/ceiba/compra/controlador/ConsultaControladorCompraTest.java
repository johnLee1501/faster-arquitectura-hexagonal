package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorCompra.class)
public class ConsultaControladorCompraTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarPorUsuario() throws Exception {

        // arrange
        Long identificadorUsuario = 987654321L;

        // act - assert
        mocMvc.perform(get("/compras/{identificadorUsuario}", identificadorUsuario)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].ciudad", is("Medellín")))
                .andExpect(jsonPath("$[0].productoId", is(1)));
    }
    @Test
    public void listar() throws Exception {

        // arrange

        // act - assert
        mocMvc.perform(get("/compras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].ciudad", is("Bogotá")))
                .andExpect(jsonPath("$[0].productoId", is(1)));
    }
}
