package com.vuelossony.proyecto.service;

import com.vuelossony.proyecto.model.Vuelo;
import com.vuelossony.proyecto.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    @Autowired
    VueloRepository vueloRepository;

    //Muestra el listado de todos los vuelos
    public List<Vuelo> listadoDeVuelos() {
        return vueloRepository.findAll();
    }

    //Crea un nuevo vuelo
    public Vuelo crearVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
        return vuelo;
    }

    //Busca un vuelo por ID
    public Optional<Vuelo> buscarVueloPorId(Long id) {
        return vueloRepository.findById(id);
    }

    //Elimina un vuelo de la lista de vuelos
    public void borrarVueloPorId(Long id) {
        vueloRepository.deleteById(id);
    }

    //Modifica un vuelo de la lista
    public Optional<Vuelo> actualizarVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
        return vueloRepository.findById(vuelo.getId());
    }

    //Busca un vuelo por Origen de partida
    public List<Vuelo> getByOrigen(String origen) {
        return vueloRepository.findByOrigen(origen);
    }

    //Busca un vuelo por origen y destino
    public List<Vuelo> getByOrigenAndDestino(String origen, String destino) {
        return vueloRepository.findByOrigenAndDestino(origen, destino);
    }


}
