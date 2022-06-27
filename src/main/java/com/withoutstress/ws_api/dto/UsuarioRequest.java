package com.withoutstress.ws_api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.withoutstress.ws_api.common.UserType;

import lombok.Getter;

@Getter
public class UsuarioRequest {
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String correo;
    @NotBlank
    private String password;

    @NotNull
    private UserType tipo_usuario;
}
