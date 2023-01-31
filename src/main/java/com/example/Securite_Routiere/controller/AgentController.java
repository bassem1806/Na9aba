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

@Controller
@RequestMapping("/Agent/")
public class AgentController {

    private final AgentRepository agentRepository;
    private final GouvernoratRepository gouvernoratRepository;
    private final DelegationRepository delegationRepository;
    private final DirectionGeneralRepository directionGeneralRepository;
    private  final DirectionRepository directionRepository;
    private final SousDirectionRepository sousDirectionRepository;
  private final GradeRepository gradeRepository;

  // private final SyndicatRepository syndicatRepository;

    @Autowired
    public AgentController(AgentRepository agentRepository, GouvernoratRepository gouvernoratRepository, DelegationRepository delegationRepository, DirectionGeneralRepository directionGeneralRepository, DirectionRepository directionRepository, SousDirectionRepository sousDirectionRepository, GradeRepository gradeRepository) {
        this.agentRepository = agentRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.delegationRepository = delegationRepository;
        this.directionGeneralRepository = directionGeneralRepository;
        this.directionRepository = directionRepository;
        this.sousDirectionRepository = sousDirectionRepository;
        this.gradeRepository = gradeRepository;
   // this.syndicatRepository = syndicatRepository;
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

     model.addAttribute("sousDirection",sousDirectionRepository.findAll());
        model.addAttribute("grade",gradeRepository.findAll());

       // model.addAttribute("syndicat", syndicatRepository.findAll());



                model.addAttribute("agent", new Agent());

      System.out.println("size dg :" +directionGeneralRepository.findAll().size());
        System.out.println("size direction :" +directionRepository.findAll().size());



        return "Agent/addAgent";

        }


    @PostMapping("addSave")

    public String addAgent(@Valid Agent agent, BindingResult result,

                           @RequestParam(name = "gouvernoratId", required = true) Long k,
                           @RequestParam(name = "gouvernoratId1", required = true) Long b,
                           @RequestParam(name = "DirectionGeneralId", required = false) Long dg,
                           @RequestParam(name = "DirectionId", required = true) Long d,
                           @RequestParam(name = "SousDirectionId", required = true) Long sd,
                           @RequestParam(name = " GradeId", required = true) Long g) {


        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Delegation Id:" + b));
        agent.setDelegation(delegation);




        SousDirection sousDirection= sousDirectionRepository.findById(sd).orElseThrow(()-> new IllegalArgumentException
                ("Invalid sous direction Id:" +sd));
    agent.setSousDirection(sousDirection);

    Grade grade= gradeRepository.findById(g).orElseThrow(()-> new IllegalArgumentException
            ("Invalid  grade Id:" +g));

    agent.setGrade(grade);


    agent =agentRepository.save(agent);


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
        System.out.println("l id de la direction générale st ="+DgId);

        System.out.println("la taille de la liste est egale ="+directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

        List<Direction> directionByDg= directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get());


        System.out.println("la taille de la liste est egale ="+directionByDg.size());

        Gson gson = new Gson();
        // GsonBuilder gsonBuilder = new GsonBuilder();
        // Gson gson = gsonBuilder.registerTypeAdapter(Direction.class, new MessageAdapter()).create();
        return gson.toJson(directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

    }

    @ResponseBody
    @RequestMapping(value = "loadSousDirectionByDirection/{DId}", method = RequestMethod.GET)
    public String loadStatesByCountry2(@PathVariable("DId") long DId) {

        System.out.println("init loadStatesByCountrysd");
        System.out.println("l id de la direction d=" + DId);

        System.out.println("la taille de la liste est egale sd =" + sousDirectionRepository.findByDirection(directionRepository.findById(DId).get()));


        List<SousDirection> sousDirectionByD = sousDirectionRepository.findByDirection(directionRepository.findById(DId).get());

        System.out.println("la taille de la liste est egale  sd=" + sousDirectionByD.size());

        Gson gson = new Gson();
GsonBuilder gsonBuilder = new GsonBuilder();

       return gson.toJson(sousDirectionRepository.findByDirection(directionRepository.findById(DId).get()));


    }

}
