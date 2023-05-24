

package com.reto.sophos.controllers;

import com.reto.sophos.models.Producer;
import com.reto.sophos.repo.ProducerRepository;
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
@RequestMapping("/producers")
public class ProducerController {
    private final ProducerRepository producerRepository;

    public ProducerController(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping("")
    public String listProducers(Model model) {
        List<Producer> producers = producerRepository.findAll();
        model.addAttribute("producers", producers);
        return "producers";
    }

    @PostMapping("")
    public String createProducer(Producer producer) {
        producerRepository.save(producer);
        return "redirect:/producers";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProducer(@PathVariable("id") int id) {
        producerRepository.deleteById(id);
        return "redirect:/producers";
    }
}
