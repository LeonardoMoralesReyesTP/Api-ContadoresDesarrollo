package com.example.actividad.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad.models.contadorModel;
import com.example.actividad.services.contadorService;


@RestController
@RequestMapping
public class contadorController {
    @Autowired
    contadorService contadorService;

    @PostMapping("/crear")
    public contadorModel guardarModel(@RequestBody contadorModel contador){
        return this.contadorService.guardar(contador);
    }
    @GetMapping ("/todo")
    public ArrayList<contadorModel> obtenerTodoModel(){
        return contadorService.obtenerContadores();
    }
    @GetMapping(path= "/{Id}")
    public Optional<contadorModel> obtenerContadorModel(@PathVariable("Id") Integer Id){
        return this.contadorService.obtenerporId(Id);
    }
    @DeleteMapping(path="/{Id}")
    public String eliminarContador(@PathVariable("Id") Integer Id){
        boolean ok = this.contadorService.eliminar(Id);
        if(ok){
            return "El contador fue eliminado" + Id;
        }else {
            return "El jugador no se encuentra en el registro";
        }
    }
    
}
