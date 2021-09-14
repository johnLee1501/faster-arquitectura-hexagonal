package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        Long id = resultSet.getLong("id");
        Long identificadorUsuario = resultSet.getLong("identificador_usuario");
        String direccion = resultSet.getString("direccion");
        String ciudad = resultSet.getString("ciudad");
        String codigoProducto = resultSet.getString("codigo_producto");
        int valorProducto = resultSet.getInt("valor_producto");
        int tipoUsuario = resultSet.getInt("tipo_usuario");
        LocalDate fechaCompra = extraerLocalDate(resultSet, "fecha_compra");
        LocalDate fechaEntrega = extraerLocalDate(resultSet, "fecha_entrega");

        return new DtoCompra(id, identificadorUsuario, direccion, ciudad, codigoProducto, valorProducto, tipoUsuario, fechaCompra, fechaEntrega);
    }

}
