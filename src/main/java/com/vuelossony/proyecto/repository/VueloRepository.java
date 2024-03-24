package com.vuelossony.proyecto.repository;

import com.vuelossony.proyecto.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByOrigen(String origen);

    List<Vuelo> findByOrigenAndDestino(String origen, String destino);

}
