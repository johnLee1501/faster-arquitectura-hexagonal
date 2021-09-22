package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCompraNoRealizadaHoy;

import java.time.LocalDate;

public class ServicioEliminarCompra {
    private static final String COMPRA_NO_REALIZADA_HOY = "Solo se pueden cancelar las compras realizadas el día de hoy";

    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Long id) {
        validadCompraRealizadaHoy(id);
        this.repositorioCompra.eliminar(id);
    }

    private void validadCompraRealizadaHoy(Long id) {
        boolean existeHoy = this.repositorioCompra.existeHoy(id, LocalDate.now());
        boolean existe = this.repositorioCompra.existe(id);
        if (!existeHoy && existe) {
            throw new ExcepcionCompraNoRealizadaHoy(COMPRA_NO_REALIZADA_HOY);
        }
    }
}
