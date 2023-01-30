package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Agent;
import com.example.Securite_Routiere.entities.DirectionGeneral;
import com.example.Securite_Routiere.entities.Syndicat;
import com.example.Securite_Routiere.repositories.AgentRepository;
import com.example.Securite_Routiere.repositories.SyndicatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Syndicat/")
public class SyndicatController {

    private final SyndicatRepository syndicatRepository;
    private final AgentRepository agentRepository;

    @Autowired

    public SyndicatController(SyndicatRepository syndicatRepository, AgentRepository agentRepository) {
        this.syndicatRepository = syndicatRepository;
        this.agentRepository = agentRepository;
    }

    @GetMapping("list")
    public String listSyndicats(Model model) {

        List<Syndicat> lp = (List<Syndicat>) syndicatRepository.findAll();
        List<Agent> ag = (List<Agent>) agentRepository.findAll();


        if(lp.size()==0)
            lp = null;
        model.addAttribute("syndicats", lp);
        model.addAttribute("agent",ag);

        return "Syndicat/listSyndicats";


    }

    @GetMapping("add")
    public String showAddSyndicatForm(Model model) {

        Syndicat syndicat = new Syndicat();

        model.addAttribute("syndicat", syndicat);
        System.out.println("syndicat  :" +syndicat);

        return "Syndicat/addSyndicat";
    }

    @PostMapping("addSave")

    public String addSyndicat(@Valid Syndicat syndicat, BindingResult result) {


                return "redirect:list";
    }

}
