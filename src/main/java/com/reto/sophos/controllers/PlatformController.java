


package com.reto.sophos.controllers;

import com.reto.sophos.models.Platform;
import com.reto.sophos.repo.PlatformRepository;
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
@RequestMapping("/platforms")
public class PlatformController {
    private final PlatformRepository platformRepository;

    public PlatformController(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @GetMapping("")
    public String listPlatoform(Model model) {
        List<Platform> platforms = platformRepository.findAll();
        model.addAttribute("platforms", platforms);
        return "platforms";
    }

    @PostMapping("")
    public String createPlatform(Platform platform) {
        platformRepository.save(platform);
        return "redirect:/platforms";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePlatform(@PathVariable("id") int id) {
        platformRepository.deleteById(id);
        return "redirect:/platforms";
    }
}
