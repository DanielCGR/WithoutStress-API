package com.withoutstress.ws_api.common;

import com.withoutstress.ws_api.dto.UsuarioRequest;
import com.withoutstress.ws_api.exception.BadResourceRequestException;

public class UsuarioValidator {
    public static boolean validateUser(UsuarioRequest usuario) {
        if(usuario.getNombres().isBlank() || usuario.getApellidos().isBlank() ||
        usuario.getCorreo().isBlank() || usuario.getPassword().isBlank()) {
            throw new BadResourceRequestException("Completar todos los datos en blanco.");
        }
        return true;
    }

    public static boolean validateFollow(Long usuarioId, Long followedId){
        if(usuarioId == followedId){
            throw new BadResourceRequestException("No te puedes seguir a ti mismo");
        }
        return true;
    }
}
