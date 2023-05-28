package com.reto.sophos.controllers;

import com.reto.sophos.models.*;
import com.reto.sophos.repo.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Date;
import java.util.stream.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/")
public class DashboardController {
    @Autowired
    private VideogameTitleRepository videogameTitleRepository;
  
    @Autowired
    private VideogameUnitRepository videogameUnitRepository; 
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired 
    private LoanRepository loanRepository;
    
    @GetMapping("")
    public String dashboard(Model model) {
                
        if (loanRepository.findAll().size() > 0) {
            Client client = findMostFrequentClient();
            Map.Entry<VideogameTitle, Integer> videogame = findMostFrequentVideogame();
            List<Loan> loans = getTodayLoans();

            model.addAttribute("client", client);
            model.addAttribute("clientloans", client.getLoans().size());

            model.addAttribute("videogame", videogame.getKey());
            model.addAttribute("videogameloans", videogame.getValue());
            model.addAttribute("loans", loans);
        } else {
            model.addAttribute("error", "There are no loans");
            model.addAttribute("message", "Try adding loans");
            return "error";
        }
        return "dashboard";
    }

    public Client findMostFrequentClient() {
        Client mostClient = null;
        
        for (Client client : clientRepository.findAll()) {
            if (mostClient == null) {
                mostClient = client;
            } else if (client.getLoans().size() > mostClient.getLoans().size()) {
                mostClient = client;
            }
        }
        return mostClient; 
    }

    public Map.Entry<VideogameTitle, Integer> findMostFrequentVideogame() {
        List<Loan> loans = loanRepository.findAll();
        Map<VideogameTitle, Integer> loanCounts = new HashMap<>();
        for (Loan loan : loans) {
            VideogameTitle videogame = loan.getVideogameUnit().getVideogameTitle();
            loanCounts.put(videogame, loanCounts.getOrDefault(videogame, 0) + 1);
        }
        return Collections.max(loanCounts.entrySet(), Map.Entry.comparingByValue());
    }

    public List<Loan> getTodayLoans() {
        Date today = new Date();
        System.out.println(today.toString());
        for (Loan loan : loanRepository.findAll()) {
            System.out.println(today.getMonth() + " " + loan.getLoanDate().getMonth());
            
        }
        return loanRepository.findAll()
            .stream()
            .filter(loan -> 
                        loan.getLoanDate().getYear() == today.getYear() &&
                        loan.getLoanDate().getMonth() == today.getMonth() &&
                        loan.getLoanDate().getDay() == today.getDay()
                   )
            .collect(Collectors.toList());
    }

}
