/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.service;

import com.dev.barbearia.model.Cliente;
import com.dev.barbearia.model.Profissional;
import com.dev.barbearia.repository.ClienteRepository;
import com.dev.barbearia.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {
    
    @Autowired
    ProfissionalRepository profissionalRepository;
    
     public Profissional cadastrar(Profissional profissional){
        profissional.setId(null);
        profissionalRepository.save(profissional);
        return profissional;
    }
}
