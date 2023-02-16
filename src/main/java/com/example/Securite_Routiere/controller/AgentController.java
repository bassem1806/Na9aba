package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import com.example.Securite_Routiere.service.AgentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/Agent/")
public class AgentController {
    @Autowired
    private final AgentService agentService;
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
        agentService = null;
    }



    /*
    @GetMapping("list")
    //@ResponseBody
    public String listAgents(Model model) {

        List<Agent> lp = (List<Agent>) agentRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("agents", lp);



        return "Agent/listAgents";

    }
*/
    /******* search *******/

    @RequestMapping(path = {"list/{pageNumber}/search"})
    public String listAgents(Agent agent, Model model, String keyword ) {

        System.out.println(" methode recherche in");
        if(keyword!=null) {
            List<Agent> agents = agentService.getByKeyword(keyword);
            model.addAttribute("agents", agents);
        }else {
            List<Agent> agents = agentService.getAllAgent();
            model.addAttribute("agents", agents);}
        return "Agent/listAgents";
    }


/******* pagination get the first page *******/

    @GetMapping("list/{pageNumber}")

    public String getOnePage(Model model, String DateInscription, String DirectionGeneralId, String DirectionId, String SousDirectionId, String gouvernoratId1,String SyndicatId,String GradeId, @PathVariable("pageNumber") int currentPage) {
     Page<Agent> page=null;
        int totalPages = 0;
        long totalItems = 0;
        List<Agent> agents = null;


        page=agentService.findPage(currentPage);
        totalPages = page.getTotalPages();
        totalItems = page.getTotalElements();
        agents=page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("agents", agents);



        return "Agent/listAgents";

    }

    /******* sorting with filed  *******/

    @GetMapping("list/{pageNumber}/{field}")

    public String getPageWithSort(Model model,
                                  @PathVariable("pageNumber") int currentPage,
                                  @PathVariable String field,
                                  @PathParam("sortDir") String sortDir) {
        System.out.println("pagination :");
        Page<Agent> page = agentService.findAlLWithSort(field, sortDir, currentPage);

        List<Agent> agents = page.getContent();
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();


        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("agents", agents);

        return "Agent/listAgents";

    }

    @GetMapping("add")

    public String showAddَAgentForm(Agent agent, Model model) {


        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

        model.addAttribute("directions", directionRepository.findAll());

        model.addAttribute("sousDirections", sousDirectionRepository.findAll());
        model.addAttribute("grades", gradeRepository.findAll());

        model.addAttribute("syndicat", syndicatRepository.findAll());


        model.addAttribute("agent", new Agent());

        System.out.println("size dg :" + directionGeneralRepository.findAll().size());
        System.out.println("size direction :" + directionRepository.findAll().size());

        System.out.println("size direction sd :" + sousDirectionRepository.findAll().size());
        System.out.println("grade liste :" + gradeRepository.findAll().size());





        return "Agent/addAgent";

    }


    @PostMapping("addSave")

    public String addAgent(@Valid Agent agent, BindingResult result,

                           @RequestParam(name = "gouvernoratId", required = true) Long k,
                           @RequestParam(name = "gouvernoratId1", required = true) Long b,
                           @RequestParam(name = "DirectionGeneralId", required = true) Long dg,
                           @RequestParam(name = "DirectionId", required = true) Long d,
                           @RequestParam(name = "SousDirectionId", required = true) Long sd,
                           @RequestParam(name = "GradeId", required = true) Long g,
                           @RequestParam(name = "SyndicatId", required = true) Long sy) {

        System.out.println("bonjourrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr les amis");

        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Delegation Id:" + b));
        agent.setDelegation(delegation);

        System.out.println("delegation " + delegationRepository.findById(b));

        SousDirection sousDirection = sousDirectionRepository.findById(sd).orElseThrow(() -> new IllegalArgumentException
                ("Invalid sous direction Id:" + sd));
        agent.setSousDirection(sousDirection);

        System.out.println("Sousdirection " + sousDirectionRepository.findById(sd));

        Grade grade = gradeRepository.findById(g).orElseThrow(() -> new IllegalArgumentException
                ("Invalid grade Id:" + g));
        agent.setGrade(grade);
        System.out.println("grade id :" + gradeRepository.findById(g));

        Syndicat syndicat = syndicatRepository.findById(sy).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  sundicat Id:" + sy));
agent.setSyndicat(syndicat);

agent= (Agent) agentRepository.save(agent);

        if (agentRepository.existsByCNRPS(agent.getCNRPS())) {
           // throw new RuntimeException(" CNRPS is already present");
            return "error/403";
        }
        return "redirect:list/1";

    }

    @GetMapping("delete/{AgentId}")


    public String deleteDirectionGeneral(@PathVariable("AgentId") long AgentId, Model model) throws Throwable {

Agent agent = (Agent) agentRepository.findById(AgentId)
        .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + AgentId));
        agentRepository.delete(agent);
       return "redirect:../list/1";

    }

    @GetMapping("edit/{AgentId}")
    public String showDirectionGeneralFormToUpdate(@PathVariable("AgentId") long AgentId, Model model) throws Throwable {
        Agent agent = (Agent) agentRepository.findById(AgentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid agent Id:" + AgentId));

        model.addAttribute("agent", agent);

        return "Agent/updateAgent";
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
    public String loadStatesByCountry2(@PathVariable("DId") long DId) throws JsonProcessingException {

        System.out.println("init loadStatesByCountry2");
        System.out.println("l id de la direction  =" + DId);

        System.out.println("la taille de la liste est egale =" + sousDirectionRepository.findByDirection(directionRepository.findById(DId).get()));

        List<SousDirection> sousDirectionByD = sousDirectionRepository.findByDirection(directionRepository.findById(DId).get());


        System.out.println("la taille de la liste est egale =" + sousDirectionByD.size());
        System.out.println("la taille de la liste est egale =" + sousDirectionByD.get(0).getSdId());
        System.out.println("la taille de la liste est egale =" + sousDirectionByD.get(0).getNomSDir());



        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().excludeFieldsWithModifiers(Transient).create();
        //Gson gson = new Gson();

        //return gson.toJson(sousDirectionByD);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(sousDirectionByD);
    }



}



