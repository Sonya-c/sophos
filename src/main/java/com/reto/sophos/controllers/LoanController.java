package com.reto.sophos.controllers;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.Optional;
import com.reto.sophos.models.*;
import com.reto.sophos.repo.*;
import java.util.Date;
@Controller
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private VideogameTitleRepository videogameTitleRepository;
  
    @Autowired
    private VideogameUnitRepository videogameUnitRepository; 
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired 
    private LoanRepository loanRepository;

    @GetMapping("")
    public String listLoans(Model model) {
        List<Loan> loans = loanRepository.findAll();
        model.addAttribute("loans", loans);
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("videogames", videogameTitleRepository.findAll());
        return "loans";
    }

    @PostMapping("")
    public String createLoan(
            @RequestParam("videogame.id") int videogameID,
            @RequestParam("client.id") int clientID,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("loandate") Date returnDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("returndate") Date loanDate,
            Model model) {
        
        Client client = clientRepository.findById(clientID).orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + clientID));

        VideogameTitle videogame = videogameTitleRepository.findById(videogameID).orElseThrow(() -> new IllegalArgumentException("Invalid videogameTitle ID: " + videogameID));
        System.out.println("Error here");
        for (VideogameUnit unit: videogame.getVideogameUnits()) {
            if (unit.getAvaliable_status()) {
                Loan l = new Loan();
                l.setReturnDate(loanDate);
                l.setLoanDate(returnDate);
                l.setVideogameUnit(unit);
                l.setClient(client);
                l.setStatus(false);
                loanRepository.save(l);
                return "redirect:/loans";
            }
        }
        
        model.addAttribute("error", "There are no units aviable");
        model.addAttribute("message", "Try adding more unit for this videogame title");
        return "error";
    }
}
