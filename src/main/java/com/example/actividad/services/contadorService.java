package com.example.actividad.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad.models.contadorModel;
import com.example.actividad.repositories.contadorRepository;

@Service
public class contadorService {
    @Autowired
    contadorRepository contadorRepository;

    public ArrayList<contadorModel> obtenerContadores(){
        return (ArrayList<contadorModel>) contadorRepository.findAll();
    }
    //ID
    public Optional <contadorModel> obtenerporId(Integer Id){
        return contadorRepository.findById(Id);
    }
    //guardar
    public contadorModel guardar(contadorModel contador){
        return contadorRepository.save(contador);
    }
    public boolean eliminar (Integer Id) {
        try {
            contadorRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
