package com.vuelossony.proyecto.service;

import com.vuelossony.proyecto.model.Vuelo;
import com.vuelossony.proyecto.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {
    @Autowired
    VueloRepository vueloRepository;

    //Muestra el listado de todos los vuelos
    public List<Vuelo> listadoDeVuelos() {
        return vueloRepository.findAll();
    }

    //Crea un nuevo vuelo
    public void crearVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
    }

    //Busca un vuelo por ID
    public Vuelo buscarVueloPorId(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

    //Elimina un vuelo de la lista de vuelos
    public void borrarVueloPorId(Long id) {
        vueloRepository.deleteById(id);
    }

    //Modifica un vuelo de la lista
    public Vuelo actualizarVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
        return vueloRepository.findById(vuelo.getId()).orElse(null);
    }
}
