package com.vuelossony.proyecto.controller;

import com.vuelossony.proyecto.model.Vuelo;
import com.vuelossony.proyecto.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    VueloService vueloService;

    @GetMapping("")
    public List<Vuelo> getListadoDeVuelos(){
        return vueloService.listadoDeVuelos();
    }

    @PostMapping("/agregar")
    public Vuelo createVuelo(@RequestBody Vuelo vuelo){
        return vueloService.crearVuelo(vuelo);
    }

    @GetMapping("/{id}")
    public Optional<Vuelo> findVueloById(@PathVariable Long id){
        return vueloService.buscarVueloPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteVuelo(@PathVariable Long id){
        vueloService.borrarVueloPorId(id);
    }

    @PutMapping("/actualizar")
    public Optional<Vuelo> updateVuelo(@RequestBody Vuelo vuelo){
        return vueloService.actualizarVuelo(vuelo);
    }

    @GetMapping("/origen")
    public List<Vuelo> findVueloByOrigen(@RequestParam String origen){
        return vueloService.getByOrigen(origen);
    }

    @GetMapping("/ubicacion")
    public List<Vuelo> findVueloByUbicacion(@RequestParam String origen, @RequestParam String destino){
        return vueloService.getByOrigenAndDestino(origen, destino);
    }

    @GetMapping("/ofertas")
    public List<Vuelo> findListadoDeOfertas(@RequestParam double precio){
        // Obtener todos los vuelos
        List<Vuelo> vuelos = vueloService.listadoDeVuelos();

        // Filtrar los vuelos por precio menor o igual al especificado
        List<Vuelo> vuelosFiltrados = vuelos.stream()
                .filter(vuelo -> vuelo.getPrecioEnPesos() <= precio)
                .collect(Collectors.toList());

        return vuelosFiltrados;
    }

}
