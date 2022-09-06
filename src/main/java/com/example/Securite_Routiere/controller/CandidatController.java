package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Candidat;
import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.PvAccident1;
import com.example.Securite_Routiere.repositories.CandidatRepository;
import com.example.Securite_Routiere.repositories.DelegationRepository;
import com.example.Securite_Routiere.repositories.GouvernoratRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/Candidat/")
public class CandidatController {

    private  final CandidatRepository candidatRepository;
    private final DelegationRepository delegationRepository;
    private final GouvernoratRepository gouvernoratRepository;

    @Autowired
    public CandidatController(CandidatRepository candidatRepository, DelegationRepository delegationRepository, GouvernoratRepository gouvernoratRepository) {
        this.candidatRepository = candidatRepository;
        this.delegationRepository = delegationRepository;
        this.gouvernoratRepository = gouvernoratRepository;
    }
    @GetMapping("list")
    //@ResponseBody
    public String listcandidats(Model model) {

        List<Candidat> lp = (List<Candidat>) candidatRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("candidats", lp);


        return "candidat/listCandidat";

    }

    @GetMapping("add")

    public String showAddCandidatForm(Candidat candidat, Model model){

        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("candidat", new Candidat());

        return "candidat/addcandidat";
    }

    @PostMapping("addSave")

    public String addPvAccident1(@Valid Candidat candidat, BindingResult result,

                                 @RequestParam(name = "gouvernoratId", required = true) Long k,
                                 @RequestParam(name = "gouvernoratId1", required = true) Long b)
    {
        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + b));


        candidat.setDelegation(delegation);

        candidat = candidatRepository.save(candidat);

        return "redirect:list";
    }


    @ResponseBody
    @RequestMapping(value="loadDelegationByGouvernorat/{id}",method = RequestMethod.GET)
    public String loadStatesByCountry(@PathVariable("id") long id) {

        ArrayList<Delegation> delegationByGV = delegationRepository.findByGouvernorat(gouvernoratRepository.findById(id).get());

        List<Delegation> delegations = new ArrayList<>();
        for (Delegation temp : delegationByGV) {
            delegations.add(new Delegation(temp.getDelegationId(), temp.getName()));
        }

        Gson gson = new Gson();

        return gson.toJson(delegations);
    }

}
