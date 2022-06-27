package com.withoutstress.ws_api.repository;

import com.withoutstress.ws_api.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long>{

    @Query(value = "SELECT actividad FROM Actividad actividad WHERE actividad.usuario.id=?1")
    List<Actividad> findActividadesByUserId(Long userId);
}
