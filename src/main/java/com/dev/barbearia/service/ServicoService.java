/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.service;

import com.dev.barbearia.model.Profissional;
import com.dev.barbearia.model.Servico;
import com.dev.barbearia.repository.ProfissionalRepository;
import com.dev.barbearia.repository.ServicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    
     @Autowired
    ServicoRepository servicoRepository;
     
     
      public Servico cadastrar(Servico servico){
        servico.setId(null);
        servicoRepository.save(servico);
        return servico;
    }
    
     public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }
    
}
