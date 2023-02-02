package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Agent;
import com.example.Securite_Routiere.entities.Syndicat;
import com.example.Securite_Routiere.repositories.AgentRepository;
import com.example.Securite_Routiere.repositories.SyndicatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


        if (lp.size() == 0)
            lp = null;
        model.addAttribute("syndicats", lp);
        model.addAttribute("agent", ag);

        return "Syndicat/listSyndicats";


    }

    @GetMapping("add")
    public String showAddSyndicatForm(Model model) {

        Syndicat syndicat = new Syndicat();

        System.out.println("syndicat  eaeaeaeae azeazeazeae:");
        model.addAttribute("syndicat", syndicat);


        return "Syndicat/addSyndicat";
    }

    @PostMapping("addSave")

    public String addSyndicat(@Valid Syndicat syndicat, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("syndicat  eaeaeaeae azeazeazeae azeaeae615464:");
            return "Syndicat/addSyndicat";
        }
        System.out.println("syndicat  :" + syndicat.getNomSyndicat());
        System.out.println("syndicat  :" + syndicat.getCodeSyndicat());
        syndicatRepository.save(syndicat);

        return "redirect:list";
    }

    @GetMapping("delete/{SynId}")

    public String deleteSyndicat(@PathVariable("SynId") long SynId, Model model) {

        Syndicat syndicat = syndicatRepository.findById(SynId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Syndicat  Id:" + SynId));

        syndicatRepository.delete(syndicat);

        return "redirect:../list";

    }

    @GetMapping("edit/{SynId}")
    public String showSyndicatFormToUpdate(@PathVariable("SynId") long SynId, Model model) {
        Syndicat syndicat = syndicatRepository.findById(SynId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Syndicat  Id:" + SynId));

        model.addAttribute("syndicat", syndicat);

        return "Syndicat/updateSyndicat";

    }

    @PostMapping("update")
    public String updateSyndicat(@Valid Syndicat syndicat, BindingResult result) {
        if (result.hasErrors()) {
            return "Syndicat/updateSyndicat";
        }
        syndicatRepository.save(syndicat);
        return "redirect:list";

    }

}
