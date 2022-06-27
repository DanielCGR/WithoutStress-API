package com.withoutstress.ws_api.controller;

import com.withoutstress.ws_api.common.EntityDtoConverter;
import com.withoutstress.ws_api.dto.RecompensaRequest;
import com.withoutstress.ws_api.dto.RecompensaResponse;
import com.withoutstress.ws_api.entities.Recompensa;
import com.withoutstress.ws_api.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {

    @Autowired
    private RecompensaService recompensaService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostMapping
    public ResponseEntity<RecompensaResponse> createRecompensa(@RequestBody RecompensaRequest recompensaRequest) throws Exception{
        Recompensa recompensa = recompensaService.createRecompensa(recompensaRequest);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDtoRecompensa(recompensa), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecompensaResponse>> findAll() throws Exception{
        List<Recompensa> recompensas = recompensaService.findAllRecompensas();
        return new ResponseEntity<List<RecompensaResponse>>(
                entityDtoConverter.convertEntityToDtoRecompensa(recompensas),
                HttpStatus.OK);
    }
}
