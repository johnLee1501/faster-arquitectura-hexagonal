package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String codigoProducto = resultSet.getString("codigo_producto");
        String nombre = resultSet.getString("nombre");
        int valorProducto = resultSet.getInt("valor_producto");

        return new DtoProducto(id, codigoProducto, nombre, valorProducto);
    }
}
