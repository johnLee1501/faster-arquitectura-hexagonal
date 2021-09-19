package com.ceiba.producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "producto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "producto", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "producto", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "producto", value = "existeId")
    private static String sqlExisteId;

    @SqlStatement(namespace = "producto", value = "existeCodigoProducto")
    private static String sqlExisteCodigoProducto;

    @SqlStatement(namespace = "producto", value = "obtenerPrecioProducto")
    private static String sqlObtenerPrecioProducto;


    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crear(producto, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existeId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteId, paramSource, Boolean.class);
    }

    @Override
    public boolean existeCodigoProducto(String codigoProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigoProducto", codigoProducto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteCodigoProducto, paramSource, Boolean.class);
    }

    @Override
    public int obtenerPrecioProducto(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPrecioProducto, paramSource, Integer.class);
    }
}
