/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.barbearia.controller;

import com.dev.barbearia.model.Agendamento;
import com.dev.barbearia.model.Cliente;
import com.dev.barbearia.model.Profissional;
import com.dev.barbearia.model.Servico;
import com.dev.barbearia.service.AgendamentoService;
import com.dev.barbearia.service.ClienteService;
import com.dev.barbearia.service.ProfissionalService;
import com.dev.barbearia.service.ServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BarbeariaController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProfissionalService profissionalService;

    @Autowired
    ServicoService servicoService;

    @Autowired
    AgendamentoService agendamentoService;

    @GetMapping("/")
    public String agenda(Model model) {

        model.addAttribute("agendamentos", agendamentoService.listarAgendamentos());

        return "agenda";
    }

    @GetMapping("/agendamento")
    public String agendamentos(Model model) {
        List<Profissional> profissionais = profissionalService.listarProfissionais();
        List<Cliente> clientes = clienteService.listarClientes();
        List<Servico> servicos = servicoService.listarServicos();

        model.addAttribute("servicos", servicos);
        model.addAttribute("clientes", clientes);
        model.addAttribute("profissionais", profissionais);
        model.addAttribute("agendamento", new Agendamento());

        System.out.println("Lista de Profissionais: " + profissionais);
        return "agendamento";
    }

    @PostMapping("/agendamento-salvar")
    public String salvarAgendamento(@ModelAttribute Agendamento agendamento, RedirectAttributes redirectAttributes) {

        agendamentoService.cadastrar(agendamento);
        redirectAttributes.addAttribute("success", true);
        return "redirect:/";
    }
    

    @GetMapping("/cliente")
    public String cliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }

    @PostMapping("/cliente-salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {

        clienteService.cadastrar(cliente);

        return "redirect:/";
    }

    @GetMapping("/profissional")
    public String profissional(Model model) {
        model.addAttribute("profissional", new Profissional());
        return "profissional";
    }

    @PostMapping("/profissional-salvar")
    public String salvarProfissional(@ModelAttribute Profissional profissional) {

        profissionalService.cadastrar(profissional);

        return "redirect:/";
    }

    @GetMapping("/servico")
    public String servico(Model model) {
        model.addAttribute("servico", new Servico());
        return "servico";
    }

    @PostMapping("/servico-salvar")
    public String salvarServico(@ModelAttribute Servico servico) {

        servicoService.cadastrar(servico);

        return "redirect:/";
    }

    @GetMapping("/agendamento/excluir/{id}")
    public String excluirAgendamento(@PathVariable Integer id) {
        agendamentoService.excluir(id);
        return "redirect:/";
    }

}
