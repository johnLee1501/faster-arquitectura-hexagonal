package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCompraNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionCompraNoRealizadaHoy;

import java.time.LocalDate;

public class ServicioEliminarCompra {
    private static final String COMPRA_NO_REALIZADA_HOY = "Solo se pueden cancelar las compras realizadas el día de hoy";
    private static final String COMPRA_NO_EXISTE = "La compra a eliminar no existe";

    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Long id) {
        validarCompraExiste(id);
        validarCompraRealizadaHoy(id);
        this.repositorioCompra.eliminar(id);
    }

    private void validarCompraExiste(Long id) {
        boolean existe = this.repositorioCompra.existe(id);
        if (!existe) {
            throw new ExcepcionCompraNoExiste(COMPRA_NO_EXISTE);
        }
    }

    private void validarCompraRealizadaHoy(Long id) {
        boolean existeHoy = this.repositorioCompra.existeHoy(id, LocalDate.now());
        if (!existeHoy) {
            throw new ExcepcionCompraNoRealizadaHoy(COMPRA_NO_REALIZADA_HOY);
        }
    }
}
