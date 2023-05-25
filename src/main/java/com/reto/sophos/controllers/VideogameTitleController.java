package com.reto.sophos.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reto.sophos.models.Director;
import com.reto.sophos.models.Platform;
import com.reto.sophos.models.Producer;
import com.reto.sophos.models.VideogameTitle;
import com.reto.sophos.repo.DirectorRepository;
import com.reto.sophos.repo.PlatformRepository;
import com.reto.sophos.repo.ProducerRepository;
import com.reto.sophos.repo.VideogameTitleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/videogames")
public class VideogameTitleController {
  
  @Autowired
  private VideogameTitleRepository videogameTitleRepository;
  
  @Autowired
  private DirectorRepository directorRepository;
  
  @Autowired
  private ProducerRepository producerRepository;
  
  @Autowired
  private PlatformRepository platformRepository;
  
  @GetMapping("")
  public String listVideogameTitles(Model model) {
    List<VideogameTitle> videogameTitles = videogameTitleRepository.findAll();
    model.addAttribute("videogames", videogameTitles);
    model.addAttribute("newVideogame", new VideogameTitle());
    model.addAttribute("directors", directorRepository.findAll());
    model.addAttribute("producers", producerRepository.findAll());
    model.addAttribute("platforms", platformRepository.findAll());
    return "videogames";
  }
  
  @GetMapping("/videogames/{id}")
  public String getVideogameTitle(@PathVariable("id") int id, Model model) {
    VideogameTitle videogameTitle = videogameTitleRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid video game title id: " + id));
    model.addAttribute("videogame", videogameTitle);
    return "edit-videogame";
  }
  @PostMapping("")
public String createVideogameTitle(VideogameTitle videogameTitle,
        @RequestParam("director.id") int directorId,
        @RequestParam("producer.id") int producerId,
        @RequestParam("platform.id") int platformId) {
        
    Director director = directorRepository.findById(directorId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid director ID: " + directorId));
            
    Producer producer = producerRepository.findById(producerId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid producer ID: " + producerId));
            
    Platform platform = platformRepository.findById(platformId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid platform ID: " + platformId));

    videogameTitle.setDirector(director);
    videogameTitle.setProducer(producer);
    videogameTitle.setPlatform(platform);

    videogameTitleRepository.save(videogameTitle);

    return "redirect:/videogames";
}
}
