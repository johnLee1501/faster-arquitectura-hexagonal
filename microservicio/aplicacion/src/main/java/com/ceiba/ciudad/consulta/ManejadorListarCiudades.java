package com.ceiba.ciudad.consulta;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCiudades {

    private final DaoCiudad daoCiudad;

    public ManejadorListarCiudades(DaoCiudad daoCiudad){
        this.daoCiudad = daoCiudad;
    }

    public List<DtoCiudad> ejecutar(){ return this.daoCiudad.listar(); }
}
