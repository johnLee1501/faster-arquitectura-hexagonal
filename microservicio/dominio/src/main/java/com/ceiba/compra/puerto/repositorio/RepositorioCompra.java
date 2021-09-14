package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDate;

public interface RepositorioCompra {
    /**
     * Permite crear un compra
     * @param compra
     * @return el id generado
     */
    Long crear(Compra compra);

    /**
     * Permite eliminar un compra
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un compra realizada el día de hoy
     * @param id
     * @return si existe o no
     */
    boolean existeHoy(Long id, LocalDate fecha);

}
