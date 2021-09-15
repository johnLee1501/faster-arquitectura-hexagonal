package com.ceiba.compra.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utils {


    private static final int VALOR_ENVIO_PRIORITARIO = 150000;
    private static final int USUARIO_NIVEL_1 = 1;
    private static final int USUARIO_NIVEL_2 = 2;
    private static final int USUARIO_NIVEL_3 = 3;
    private static final int ENVIO_PRIORITARIO = 2;
    private static final int ENVIO_NIVEL_2 = 6;
    private static final int ENVIO_NIVEL_1 = 10;

    public LocalDate calcularFechaEntrega(int tipoUsuario, int valorProducto) {
        int diasDuracionEnvio;

        if (valorProducto >= VALOR_ENVIO_PRIORITARIO) {
            diasDuracionEnvio = ENVIO_PRIORITARIO;
        } else {
            diasDuracionEnvio = calcularNumeroDiasEnvio(tipoUsuario);
        }
        return sumarDiasSinFinesDeSemana(diasDuracionEnvio);
    }

    private int calcularNumeroDiasEnvio(int tipoUsuario) {
        int diasEnvio = 0;
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
