package com.withoutstress.ws_api.controller;

import com.withoutstress.ws_api.converters.UsuarioConverter;
import com.withoutstress.ws_api.dto.LoginRequest;
import com.withoutstress.ws_api.dto.LoginResponse;
import com.withoutstress.ws_api.dto.UsuarioRequest;
import com.withoutstress.ws_api.dto.UsuarioResponse;
import com.withoutstress.ws_api.entities.Usuario;
import com.withoutstress.ws_api.service.UsuarioService;
import com.withoutstress.ws_api.utils.WrapperResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
    private UsuarioService userService;
	@Autowired
	private UsuarioConverter usuarioConverter;



    @PostMapping("/signup")
    public ResponseEntity<WrapperResponse<UsuarioResponse>> signup(@RequestBody UsuarioRequest request){
		Usuario user = userService.createUser(request);
        return new WrapperResponse<>(true,"success", usuarioConverter.fromEntity(user))
                .createResponse();
    }

    @PostMapping("/login")
    public ResponseEntity<WrapperResponse<LoginResponse>> login(@RequestBody LoginRequest request){
        LoginResponse response=userService.login(request);
        return new WrapperResponse<>(true,"success",response)
                .createResponse();
    }

}