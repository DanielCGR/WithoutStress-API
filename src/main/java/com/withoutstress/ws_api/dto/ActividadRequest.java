package com.withoutstress.ws_api.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ActividadRequest {
    private String nombre;
    private String detalles;
    private Date fecha_ini;
    private Date fecha_fin;
}
