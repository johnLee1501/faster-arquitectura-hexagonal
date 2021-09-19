package com.ceiba.ciudad.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCiudad implements RowMapper<DtoCiudad>, MapperResult {

    @Override
    public DtoCiudad mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");

        return new DtoCiudad(id, nombre);
    }
}
