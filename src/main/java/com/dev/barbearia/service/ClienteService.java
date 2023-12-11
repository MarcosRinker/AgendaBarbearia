/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.service;

import com.dev.barbearia.model.Cliente;
import com.dev.barbearia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
      public Cliente cadastrar(Cliente cliente){
        cliente.setId(null);
        clienteRepository.save(cliente);
        return cliente;
    }
    
    
}
