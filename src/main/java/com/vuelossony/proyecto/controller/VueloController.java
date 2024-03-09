package com.vuelossony.proyecto.controller;

import com.vuelossony.proyecto.model.Vuelo;
import com.vuelossony.proyecto.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public void createVuelo(@RequestBody Vuelo vuelo){
        vueloService.crearVuelo(vuelo);
    }

    @GetMapping("/{id}")
    public Vuelo findVueloById(@PathVariable Long id){
        return vueloService.buscarVueloPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteVuelo(@PathVariable Long id){
        vueloService.borrarVueloPorId(id);
    }

    @PutMapping("/actualizar")
    public Vuelo updateVuelo(@RequestBody Vuelo vuelo){
        return vueloService.actualizarVuelo(vuelo);
    }

}
