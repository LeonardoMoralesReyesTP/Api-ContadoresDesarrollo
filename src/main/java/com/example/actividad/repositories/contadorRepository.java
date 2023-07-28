package com.example.actividad.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.actividad.models.contadorModel;

public interface contadorRepository extends CrudRepository<contadorModel, Integer>{
    
}
