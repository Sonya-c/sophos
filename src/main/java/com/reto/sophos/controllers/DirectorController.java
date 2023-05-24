
package com.reto.sophos.controllers;

import com.reto.sophos.models.Director;
import com.reto.sophos.repo.DirectorRepository;
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
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("")
    public String listDirector(Model model) {
        List<Director> directors = directorRepository.findAll();
        model.addAttribute("directors", directors);
        return "directors";
    }

    @PostMapping("")
    public String createDirecto(Director director) {
        directorRepository.save(director);
        return "redirect:/directors";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteDirector(@PathVariable("id") int id) {
        directorRepository.deleteById(id);
        return "redirect:/directors";
    }
}
