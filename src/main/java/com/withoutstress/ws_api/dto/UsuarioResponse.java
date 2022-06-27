package com.withoutstress.ws_api.dto;

import com.withoutstress.ws_api.common.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private Integer num_act_completas;
    private Integer num_monedas;
    private UserType tipo_usuario;
    private Boolean isPremium;
}
