package com.withoutstress.ws_api.common;

import com.withoutstress.ws_api.dto.ActividadRequest;
import com.withoutstress.ws_api.exception.BadResourceRequestException;

public class ActividadValidator {
    public static boolean validateActividad(ActividadRequest actividad) {
        if(actividad.getNombre().isBlank() || actividad.getDetalles().isBlank()) {
            throw new BadResourceRequestException("Completar todos los datos en blanco.");
        }
        return true;
    }
}
