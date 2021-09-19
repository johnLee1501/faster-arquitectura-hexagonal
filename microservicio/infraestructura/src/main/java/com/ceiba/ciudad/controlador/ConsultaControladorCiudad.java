package com.ceiba.ciudad.controlador;

import com.ceiba.ciudad.consulta.ManejadorListarCiudades;
import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
@Api(tags = {"Controlador consulta ciudad"})
public class ConsultaControladorCiudad {

    private final ManejadorListarCiudades manejadorListarCiudades;

    public ConsultaControladorCiudad(ManejadorListarCiudades manejadorListarCiudades) {
        this.manejadorListarCiudades = manejadorListarCiudades;
    }

    @GetMapping
    @ApiOperation("Listar Ciudads")
    public List<DtoCiudad> listar() {
        return this.manejadorListarCiudades.ejecutar();
    }

}
