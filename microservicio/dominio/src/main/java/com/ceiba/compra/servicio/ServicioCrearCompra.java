package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCiudadNoRegistrada;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ServicioCrearCompra {

    private static final int VALOR_ENVIO_PRIORITARIO = 150000;
    private static final int USUARIO_NIVEL_1 = 1;
    private static final int USUARIO_NIVEL_2 = 2;
    private static final int USUARIO_NIVEL_3 = 3;
    private static final int ENVIO_PRIORITARIO = 2;
    private static final int ENVIO_NIVEL_2 = 6;
    private static final int ENVIO_NIVEL_1 = 10;
    private static final String CIUDAD_NO_REGISTRADA = "Envios no disponibles para esta ciudad";
    private static final String PRODUCTO_NO_REGISTRADO = "El producto no se encuentra registrado en el sistema";
    private static final String TIPO_USUARIO_NO_PERMITIDO = "El tipo de usuario no está permitido";
    List<String> ciudades = new ArrayList<>(Arrays.asList("Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena de Indias", "Cúcuta", "Soledad", "Ibagué"));

    private final RepositorioCompra repositorioCompra;
    private final RepositorioProducto repositorioProducto;
    public ServicioCrearCompra(RepositorioCompra repositorioCompra, RepositorioProducto repositorioProducto) {
        this.repositorioCompra = repositorioCompra;
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Compra compra) {
        esProductoValido(compra.getProductoId());
        esCiudadValida(compra.getCiudad());

        int valorProducto = repositorioProducto.obtenerPrecioProducto(compra.getProductoId());
        LocalDate fechaEntregaEnvio = calcularFechaEntrega(compra.getTipoUsuario(), valorProducto);
        compra.asignarFechaEntrega(fechaEntregaEnvio);
        return this.repositorioCompra.crear(compra);
    }

    private void esCiudadValida(String ciudad) {
        boolean existe = ciudades.contains(ciudad);
        if (!existe) {
            throw new ExcepcionCiudadNoRegistrada(CIUDAD_NO_REGISTRADA);
        }
    }

    private void esProductoValido(Long id) {
        boolean existe = repositorioProducto.existeId(id);
        if (!existe) {
            throw new ExcepcionCiudadNoRegistrada(PRODUCTO_NO_REGISTRADO);
        }
    }

    private LocalDate calcularFechaEntrega(int tipoUsuario, int valorProducto) {
        int diasDuracionEnvio = calcularNumeroDiasEnvio(tipoUsuario);

        if (valorProducto >= VALOR_ENVIO_PRIORITARIO) {
            diasDuracionEnvio = ENVIO_PRIORITARIO;
        }
        return sumarDiasSinFinesDeSemana(diasDuracionEnvio);
    }

    private int calcularNumeroDiasEnvio(int tipoUsuario) {
        int diasEnvio;
        switch (tipoUsuario) {
            case USUARIO_NIVEL_1:
                diasEnvio = ENVIO_NIVEL_1;
                break;
            case USUARIO_NIVEL_2:
                diasEnvio = ENVIO_NIVEL_2;
                break;
            case USUARIO_NIVEL_3:
                diasEnvio = ENVIO_PRIORITARIO;
                break;
            default:
                throw new ExcepcionValorInvalido(TIPO_USUARIO_NO_PERMITIDO);
        }
        return diasEnvio;
    }

    private LocalDate sumarDiasSinFinesDeSemana(int dias) {
        LocalDate fechaActual = LocalDate.now();
        int diasAgregados = 0;
        LocalDate nuevaFecha = fechaActual;
        while (diasAgregados < dias) {
            nuevaFecha = nuevaFecha.plusDays(1);
            if (!(nuevaFecha.getDayOfWeek() == DayOfWeek.SATURDAY || nuevaFecha.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }
        return nuevaFecha;
    }
}
