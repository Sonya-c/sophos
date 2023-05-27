package com.reto.sophos.controllers;
import java.util.List;
import java.util.stream.*;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
import com.reto.sophos.models.Director;
import com.reto.sophos.models.Platform;
import com.reto.sophos.models.Producer;
import com.reto.sophos.models.VideogameTitle;
import com.reto.sophos.models.VideogameUnit;
import com.reto.sophos.repo.DirectorRepository;
import com.reto.sophos.repo.PlatformRepository;
import com.reto.sophos.repo.ProducerRepository;
import com.reto.sophos.repo.VideogameTitleRepository;
import com.reto.sophos.repo.VideogameUnitRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/videogames")
public class VideogameTitleController {
  
  @Autowired
  private VideogameTitleRepository videogameTitleRepository;
  
  @Autowired
  private VideogameUnitRepository videogameUnitRepository; 

  @Autowired
  private DirectorRepository directorRepository;
  
  @Autowired
  private ProducerRepository producerRepository;
  
  @Autowired
  private PlatformRepository platformRepository;
  
  @GetMapping("")
  public String listVideogameTitles(
      Model model,
      @RequestParam(value = "director.id", required=false) Integer directorId,
      @RequestParam(value = "producer.id", required=false) Integer producerId,
      @RequestParam(value = "platform.id", required=false) Integer platformId) {
    List<VideogameTitle> videogameTitles = videogameTitleRepository
      .findAll()
      .stream()
      .filter(videogame -> 
              (directorId == null || Objects.equals(videogame.getDirector().getId(),directorId)) &&
              (producerId == null || Objects.equals(videogame.getProducer().getId(),producerId)) &&
              (platformId == null || Objects.equals(videogame.getPlatform().getId(),platformId))
            )
      .collect(Collectors.toList());

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
    return "edit-videogames";
  }

  @PostMapping("")
  public String createVideogameTitle(
      VideogameTitle videogameTitle,
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

  @GetMapping("/edit/{id}")
  public String editVideogame(@PathVariable("id") int id, Model model) {
    Optional<VideogameTitle> videogame = videogameTitleRepository.findById(id);
      if (videogame.isPresent()) {
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("producers", producerRepository.findAll());
        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("videogame", videogame.get());
        return "edit-videogames";
      }
      return "redirect:/videogames";
  }

  @PostMapping("/edit/{id}")
    public String updateVideogame(
        @PathVariable("id") int id,
        @ModelAttribute("videogame") VideogameTitle uv,  
        @RequestParam("director.id") int directorId, 
        @RequestParam("producer.id") int producerId,
        @RequestParam("platform.id") int platformId) {
    Optional<VideogameTitle> videogame = videogameTitleRepository.findById(id);
    Director director = directorRepository.findById(directorId).orElseThrow(() -> new IllegalArgumentException("Invalid director ID: " + directorId));
            
    Producer producer = producerRepository.findById(producerId).orElseThrow(() -> new IllegalArgumentException("Invalid producer ID: " + producerId));
            
    Platform platform = platformRepository.findById(platformId).orElseThrow(() -> new IllegalArgumentException("Invalid platform ID: " + platformId));

    if (videogame.isPresent()) {
      VideogameTitle v = videogame.get();
      v.setTitle(uv.getTitle());
      v.setRealiseDate(uv.getRealiseDate());
      v.setLoanPrice(uv.getLoanPrice());
      v.setProtagonists(uv.getProtagonists());
      v.setDirector(director);
      v.setProducer(producer);
      v.setPlatform(platform);
      videogameTitleRepository.save(v);
    }
    return "redirect:/videogames";
  }

  @PostMapping("/unit/add/{id}")
  public String addUnit(@PathVariable("id") int id, VideogameUnit unit) {
    Optional<VideogameTitle> videogame = videogameTitleRepository.findById(id);
    if (videogame.isPresent()) {
      VideogameTitle v = videogame.get();
      unit.setVideogameTitle(v);
      unit.setAvaliable_status(true);
      v.getVideogameUnits().add(unit);
      videogameUnitRepository.save(unit); 
      return "redirect:/videogames/edit/{id}";
    }

    return "redirect:/videogames";
  }

}
