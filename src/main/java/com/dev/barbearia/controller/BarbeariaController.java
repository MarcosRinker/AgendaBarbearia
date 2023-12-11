/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarbeariaController {
    
    
    @GetMapping("/")
public String agenda(){
    
    return "agenda";
}

    @GetMapping("/agendamento")
public String agendamento(){
    
    return "agendamento";
}

   @GetMapping("/cliente")
public String cliente(){
    
    return "cliente";
}

   @GetMapping("/profissional")
public String profissional(){
    
    return "profissional";
}

   @GetMapping("/servico")
public String servico(){
    
    return "servico";
}
}
