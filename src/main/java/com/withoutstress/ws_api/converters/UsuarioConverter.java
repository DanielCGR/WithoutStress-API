package com.withoutstress.ws_api.converters;

import com.withoutstress.ws_api.dto.LoginRequest;
import com.withoutstress.ws_api.dto.UsuarioRequest;
import com.withoutstress.ws_api.dto.UsuarioResponse;
import com.withoutstress.ws_api.dto.UsuarioToFollowResponse;
import com.withoutstress.ws_api.entities.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter extends  AbstractConverter<Usuario, UsuarioRequest, UsuarioResponse> {

    @Override
    public UsuarioResponse fromEntity(Usuario usuario) {
        if(usuario == null) return null;
        return UsuarioResponse.builder()
                .id(usuario.getId())
				.correo(usuario.getCorreo())
				.nombres(usuario.getNombres())
				.apellidos(usuario.getApellidos())
				.num_act_completas(usuario.getNum_act_completas())
				.num_monedas(usuario.getNum_monedas())
				.tipo_usuario(usuario.getTipo_usuario())
				.isPremium(usuario.getIsPremium())
                .build();
    }

    @Override
    public Usuario fromRequest(UsuarioRequest dto) {
		if(dto == null) return null;
        return Usuario.builder()
                .correo(dto.getCorreo())
                .nombres(dto.getNombres())
				.apellidos(dto.getApellidos())
				.tipo_usuario(dto.getTipo_usuario())
				.build();
    }

    public UsuarioToFollowResponse fromContact(Usuario usuario, Boolean following) {
        if(usuario == null) return null;
        return UsuarioToFollowResponse.builder()
                .id(usuario.getId())
				.correo(usuario.getCorreo())
				.nombres(usuario.getNombres())
				.apellidos(usuario.getApellidos())
				.num_monedas(usuario.getNum_monedas())
				.tipo_usuario(usuario.getTipo_usuario())
                .following(following)
                .build();
    }

    public Usuario login(LoginRequest dto){
        if(dto == null) return null;
        return Usuario.builder()
                .correo(dto.getCorreo())
                .password(dto.getPassword())
                .build();
    }
}