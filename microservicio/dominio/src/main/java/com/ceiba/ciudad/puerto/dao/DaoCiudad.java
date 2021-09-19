package com.ceiba.ciudad.puerto.dao;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;

import java.util.List;

public interface DaoCiudad {

    /**
     * Permite listar ciudadess
     *
     * @return los ciudadess
     */
    List<DtoCiudad> listar();

    /**
     * Valida si una ciudad existe
     *
     * @param nombre
     * @return
     */
    boolean existe(String nombre);
}
