package com.withoutstress.ws_api.service;

import com.withoutstress.ws_api.dto.RecompensaRequest;
import com.withoutstress.ws_api.entities.Recompensa;
import com.withoutstress.ws_api.repository.RecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Recompensa createRecompensa(RecompensaRequest recompensaRequest) {
        Recompensa newRecompensa = initRecompensa(recompensaRequest);
        return recompensaRepository.save(newRecompensa);
    }

    @Transactional(readOnly = true)
    public List<Recompensa> findAllRecompensas() {
        List<Recompensa> recompensas = recompensaRepository.findAll();
        return recompensas;
    }

    private Recompensa initRecompensa(RecompensaRequest recompensaRequest) {
        Recompensa recompensa = new Recompensa();
        recompensa.setNombre(recompensaRequest.getNombre());
        recompensa.setDetalles(recompensaRequest.getDetalles());
        return recompensa;
    }
}
