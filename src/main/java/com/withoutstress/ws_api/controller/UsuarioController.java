package com.withoutstress.ws_api.controller;

import com.withoutstress.ws_api.common.EntityDtoConverter;
import com.withoutstress.ws_api.converters.UsuarioConverter;
import com.withoutstress.ws_api.dto.RecompensaResponse;
import com.withoutstress.ws_api.dto.UsuarioRequest;
import com.withoutstress.ws_api.dto.UsuarioResponse;
import com.withoutstress.ws_api.dto.UsuarioToFollowResponse;
import com.withoutstress.ws_api.entities.Recompensa;
import com.withoutstress.ws_api.entities.Usuario;
import com.withoutstress.ws_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioConverter usuarConverter;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostMapping
    public ResponseEntity<UsuarioResponse> createUser(@RequestBody UsuarioRequest usuarioRequest) throws Exception{
        Usuario usuario = usuarioService.createUser(usuarioRequest);
        return new ResponseEntity<>(usuarConverter.fromEntity(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/follows")
    public ResponseEntity<List<UsuarioResponse>> getContactos() throws Exception{
        List<Usuario> usuarios = usuarioService.getContactos();
        return new ResponseEntity<>(usuarConverter.fromEntity(usuarios),
                HttpStatus.OK);
    }

    @PutMapping("/follow/{fwId}")
    public ResponseEntity<Boolean> followToUsuario(@PathVariable Long fwId) throws Exception{
        Boolean following = usuarioService.followToUser(fwId);
        return new ResponseEntity<>(following,
                HttpStatus.OK);
    }

    @PutMapping("/premium")
    public ResponseEntity<Boolean> get_cancel_Premium() throws Exception {
        Boolean premium = usuarioService.get_cancel_Premium();
        return new ResponseEntity<>(premium, HttpStatus.OK);
    }

    @PutMapping("/premiumbycoin")
    public ResponseEntity<Boolean> buy_premium_with_coins() throws Exception {
        Boolean premium = usuarioService.buy_premium_with_coins();
        return new ResponseEntity<>(premium, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() throws Exception{
        List<Usuario> usuarios = usuarioService.findAllUsers();
        return new ResponseEntity<List<UsuarioResponse>>(
            usuarConverter.fromEntity(usuarios),
                HttpStatus.OK);
    }

    @GetMapping("/allToFollow")
    public ResponseEntity<List<UsuarioToFollowResponse>> findAllToFollow() throws Exception{
        return new ResponseEntity<List<UsuarioToFollowResponse>>(
            usuarioService.findAllUsersToFollow(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findUsuarioById(@PathVariable Long id) throws Exception{
        Usuario usuario = usuarioService.findUsuarioById(id);
        return new ResponseEntity<>(usuarConverter.fromEntity(usuario),
                HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<UsuarioResponse> findInfoUser() throws Exception{
        Usuario usuario = usuarioService.findUsuario();
        return new ResponseEntity<>(usuarConverter.fromEntity(usuario),
                HttpStatus.OK);
    }

    @GetMapping("/userinfo")
    public ResponseEntity<List<UsuarioResponse>> findUsuarioByNombresAndApellidos(@RequestParam String nombres, @RequestParam String apellidos) throws Exception{
        List<Usuario> usuarios = usuarioService.finUsuarioByNombresAndApellidos(nombres, apellidos);
        return new ResponseEntity<>(usuarConverter.fromEntity(usuarios),
                HttpStatus.OK);
    }

    @GetMapping("/userlogin")
    public ResponseEntity<UsuarioResponse> findUsuarioByCorreoAndPassword(@RequestParam String correo, @RequestParam String password) throws Exception{
        Usuario usuario = usuarioService.finUsuarioByCorreoAndPassword(correo, password);
        return new ResponseEntity<>(usuarConverter.fromEntity(usuario),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioResponse> updateUsuariobyId(@RequestBody UsuarioRequest usuarioRequest) throws Exception{
        Usuario usuario = usuarioService.updateUsuarioById(usuarioRequest);
        return new ResponseEntity<>(usuarConverter.fromEntity(usuario),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUsuarioById() throws Exception{
        usuarioService.deleteUsuarioById();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/recompensas")
    public ResponseEntity<List<RecompensaResponse>> findRecompensasByUserId() throws Exception{
        List<Recompensa> recompensas = usuarioService.findRecompensasByUserId();
        return new ResponseEntity<List<RecompensaResponse>>(
                entityDtoConverter.convertEntityToDtoRecompensa(recompensas),
                HttpStatus.OK);
    }
}
