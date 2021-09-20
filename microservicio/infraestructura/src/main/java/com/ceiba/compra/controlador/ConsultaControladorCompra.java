package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListarCompras;
import com.ceiba.compra.consulta.ManejadorListarComprasUsuario;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags = {"Controlador consulta compra"})
public class ConsultaControladorCompra {

    private final ManejadorListarComprasUsuario manejadorListarComprasUsuario;
    private final ManejadorListarCompras manejadorListarCompras;
    public ConsultaControladorCompra(ManejadorListarComprasUsuario manejadorListarComprasUsuario, ManejadorListarCompras manejadorListarCompras) {
        this.manejadorListarComprasUsuario = manejadorListarComprasUsuario;
        this.manejadorListarCompras = manejadorListarCompras;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/{identificadorUsuario}")
    @ApiOperation("Consultar Compras Usuario")
    public List<DtoCompra> listarPorIdentificacion(@PathVariable Long identificadorUsuario) {
        return this.manejadorListarComprasUsuario.ejecutar(identificadorUsuario);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ApiOperation("Consultar Compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }

}
