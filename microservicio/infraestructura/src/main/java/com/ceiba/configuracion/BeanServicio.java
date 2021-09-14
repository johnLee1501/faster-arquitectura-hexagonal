package com.ceiba.configuracion;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra) {
        return new ServicioCrearCompra(repositorioCompra);
    }

    @Bean
    public ServicioEliminarCompra servicioEliminarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioEliminarCompra(repositorioCompra);
    }

}
