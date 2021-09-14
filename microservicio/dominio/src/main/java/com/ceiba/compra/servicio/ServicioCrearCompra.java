package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.utils.Utils;
import com.ceiba.dominio.excepcion.ExcepcionCiudadNoRegistrada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ServicioCrearCompra {

    private static final String CIUDAD_NO_REGISTRADA = "Envios no disponibles para esta ciudad";
    List<String> ciudades = new ArrayList<String>(Arrays.asList("Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena de Indias", "Cúcuta", "Soledad", "Ibagué"));

    private final RepositorioCompra repositorioCompra;
    private final Utils utils;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
        this.utils = new Utils();
    }

    public Long ejecutar(Compra compra) {

        esCiudadValida(compra.getCiudad());

        LocalDate fechaEntregaEnvio = utils.calcularFechaEntrega(compra.getTipoUsuario(),compra.getValorProducto());
        compra.asignarFechaEntrega(fechaEntregaEnvio);
        return this.repositorioCompra.crear(compra);
    }
    public void esCiudadValida(String ciudad) {
        boolean existe = ciudades.contains(ciudad);
        if (!existe) {
            throw new ExcepcionCiudadNoRegistrada(CIUDAD_NO_REGISTRADA);
        }
    }

}
