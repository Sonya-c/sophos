package com.reto.sophos.controllers;

import com.reto.sophos.models.Client;
import com.reto.sophos.repo.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("")
    public String listClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @PostMapping("")
    public String createClient(Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable("id") int id, Model model) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
            return "edit-client";
        }
        return "redirect:/clients";
    }
    
    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable("id") int id, @ModelAttribute("client") Client updatedClient) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client c = client.get();
            c.setUsername(updatedClient.getUsername());
            c.setNames(updatedClient.getNames());
            c.setLastnames(updatedClient.getLastnames());
            c.setEmail(updatedClient.getEmail());
            c.setCellphone(updatedClient.getCellphone());
            c.setAddress(updatedClient.getAddress());
            c.setBirthdate(updatedClient.getBirthdate());
            clientRepository.save(c);
        }
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}
