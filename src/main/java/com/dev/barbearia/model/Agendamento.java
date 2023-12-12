/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Agendamento")
public class Agendamento {
    
       @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

       @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
       
    private String hora_Inicio;
    
      @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
      
      @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
    
      @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;
    
    
    private String observacao;

    
}
