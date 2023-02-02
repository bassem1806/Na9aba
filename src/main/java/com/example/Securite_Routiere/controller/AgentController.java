package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/Agent/")
public class AgentController {

    private final AgentRepository agentRepository;
    private final GouvernoratRepository gouvernoratRepository;
    private final DelegationRepository delegationRepository;
    private final DirectionGeneralRepository directionGeneralRepository;
    private final DirectionRepository directionRepository;
    private final SousDirectionRepository sousDirectionRepository;
    private final GradeRepository gradeRepository;

    private final SyndicatRepository syndicatRepository;
    private int Transient;

    @Autowired
    public AgentController(AgentRepository agentRepository, GouvernoratRepository gouvernoratRepository, DelegationRepository delegationRepository, DirectionGeneralRepository directionGeneralRepository, DirectionRepository directionRepository, SousDirectionRepository sousDirectionRepository, GradeRepository gradeRepository, SyndicatRepository syndicatRepository) {
        this.agentRepository = agentRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.delegationRepository = delegationRepository;
        this.directionGeneralRepository = directionGeneralRepository;
        this.directionRepository = directionRepository;
        this.sousDirectionRepository = sousDirectionRepository;
        this.gradeRepository = gradeRepository;
        this.syndicatRepository = syndicatRepository;
    }


    @GetMapping("list")
    //@ResponseBody
    public String listAgents(Model model) {

        List<Agent> lp = (List<Agent>) agentRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("agents", lp);


        return "Agent/listAgent";

    }

    @GetMapping("add")

    public String showAddَAgentForm(Agent agent, Model model) {


        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

        model.addAttribute("directions", directionRepository.findAll());

        model.addAttribute("sousDirection", sousDirectionRepository.findAll());
        model.addAttribute("grade", gradeRepository.findAll());

        model.addAttribute("syndicat", syndicatRepository.findAll());


        model.addAttribute("agent", new Agent());

        System.out.println("size dg :" + directionGeneralRepository.findAll().size());
        System.out.println("size direction :" + directionRepository.findAll().size());

        System.out.println("size direction sd :" + sousDirectionRepository.findAll().size());


        return "Agent/addAgent";

    }


    @PostMapping("addSave")

    public String addAgent(@Valid Agent agent, BindingResult result,

                           @RequestParam(name = "gouvernoratId", required = true) Long k,
                           @RequestParam(name = "gouvernoratId1", required = true) Long b,
                           @RequestParam(name = "DirectionGeneralId", required = true) Long dg,
                           @RequestParam(name = "DirectionId", required = true) Long d,
                           @RequestParam(name = "SousDirectionId", required = false) Long sd,
                           @RequestParam(name = " GradeId", required = false) Long g,
                           @RequestParam(name = " SyndicatId", required = false) Long sy) {


        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Delegation Id:" + b));
        agent.setDelegation(delegation);

        SousDirection sousDirection = sousDirectionRepository.findById(sd).orElseThrow(() -> new IllegalArgumentException
                ("Invalid sous direction Id:" + sd));
        agent.setSousDirection(sousDirection);

        Grade grade = gradeRepository.findById(g).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  grade Id:" + g));
        agent.setGrade(grade);

        Syndicat syndicat = syndicatRepository.findById(sy).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  grade Id:" + sy));


        agent.setSyndicats((Set<Syndicat>) syndicat);


        agent = agentRepository.save(agent);


        return "redirect:list1";

    }


    @ResponseBody
    @RequestMapping(value = "loadDelegationByGouvernorat/{id}", method = RequestMethod.GET)
    public String loadStatesByCountry1(@PathVariable("id") long id) {

        ArrayList<Delegation> delegationByGV = delegationRepository.findByGouvernorat(gouvernoratRepository.findById(id).get());

        List<Delegation> delegations = new ArrayList<>();
        for (Delegation temp : delegationByGV) {
            delegations.add(new Delegation(temp.getDelegationId(), temp.getName()));
        }

        Gson gson = new Gson();

        return gson.toJson(delegations);


    }

    @ResponseBody
    @RequestMapping(value = "loadDirectionByDirectionGeneral/{DgId}", method = RequestMethod.GET)
    public String loadStatesByCountry(@PathVariable("DgId") long DgId) {

        System.out.println("init loadStatesByCountry");
        System.out.println("l id de la direction générale st =" + DgId);

        System.out.println("la taille de la liste est egale =" + directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

        List<Direction> directionByDg = directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get());


        System.out.println("la taille de la liste est egale =" + directionByDg.size());

        Gson gson = new Gson();

        return gson.toJson(directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

    }

    @ResponseBody
    @RequestMapping(value = "loadSousDirectionByDirection/{DId}", method = RequestMethod.GET)
    public String loadStatesByCountry2(@PathVariable("DId") long DId) {

        System.out.println("init loadStatesByCountry2");
        System.out.println("l id de la direction  =" + DId);

        System.out.println("la taille de la liste est egale =" + sousDirectionRepository.findByDirection(directionRepository.findById(DId).get()));

        List<SousDirection> sousDirectionByD =sousDirectionRepository.findByDirection(directionRepository.findById(DId).get());


        System.out.println("la taille de la liste est egale =" + sousDirectionByD.size());
        System.out.println("la taille de la liste est egale =" + sousDirectionByD.get(0).getSdId());
        System.out.println("la taille de la liste est egale =" + sousDirectionByD.get(0).getNomSDir());


        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().excludeFieldsWithModifiers(Transient).create();

        return gson.toJson(sousDirectionRepository.findByDirection(directionRepository.findById(DId).get()));

    }

}


