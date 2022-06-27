package com.withoutstress.ws_api.common;

import com.withoutstress.ws_api.dto.*;
import com.withoutstress.ws_api.entities.*;
import com.withoutstress.ws_api.dto.ActividadResponse;
import com.withoutstress.ws_api.dto.RecompensaResponse;
import com.withoutstress.ws_api.dto.UsuarioResponse;
import com.withoutstress.ws_api.entities.Actividad;
import com.withoutstress.ws_api.entities.Recompensa;
import com.withoutstress.ws_api.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioResponse convertEntityToDtoUser(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponse.class);
    }

    public RecompensaResponse convertEntityToDtoRecompensa(Recompensa recompensa) {
        return modelMapper.map(recompensa, RecompensaResponse.class);
    }

    public ActividadResponse convertEntityToDtoActividad(Actividad actividad) {
        return modelMapper.map(actividad, ActividadResponse.class);
    }

    public List<UsuarioResponse> convertEntityToDtoUser(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::convertEntityToDtoUser)
                .collect(Collectors.toList());
    }

    public List<RecompensaResponse> convertEntityToDtoRecompensa(List<Recompensa> recompensas) {
        return recompensas.stream()
                .map(this::convertEntityToDtoRecompensa)
                .collect(Collectors.toList());
    }

    public List<ActividadResponse> convertEntityToDtoActividad(List<Actividad> actividades) {
        return actividades.stream()
                .map(this::convertEntityToDtoActividad)
                .collect(Collectors.toList());
    }
}
