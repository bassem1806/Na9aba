package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import com.example.Securite_Routiere.service.AgentService;
import com.example.Securite_Routiere.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Agent/")
public class AgentController {
    @Autowired
    private final AgentService agentService;
    private final AgentRepository agentRepository;

    private final AgentRRepository agentRRepository;
    private final GouvernoratRepository gouvernoratRepository;
    private final DelegationRepository delegationRepository;
    private final DirectionGeneralRepository directionGeneralRepository;
    private final DirectionRepository directionRepository;
    private final SousDirectionRepository sousDirectionRepository;
    private final GradeRepository gradeRepository;
    private final UserService userService;
    private final SyndicatRepository syndicatRepository;
    //private int Transient;
  //  private RestTemplate restTemplate;
    private String dateTmp=null;
    private String cinTmp = null;
    private String cnrpsTmp = null;
    private String nomTmp = null;
    private String prenomTmp = null;
    private String prenompereTmp = null;
    private String gradeTmp = null;
    private String directiongeneralTmp = null;
    private String directionTmp = null;
    private String sousdirectionTmp = null;



    public String getCnrpsTmp() {
        return cnrpsTmp;
    }

    public void setCnrpsTmp(String cnrpsTmp) {
        this.cnrpsTmp = cnrpsTmp;
    }

    public String getCinTmp() {
        return cinTmp;
    }

    public void setCinTmp(String cinTmp) {
        this.cinTmp = cinTmp;
    }

    public String getNomTmp() {
        return nomTmp;
    }

    public void setNomTmp(String nomTmp) {
        this.nomTmp = nomTmp;
    }

    public String getPrenomTmp() {
        return prenomTmp;
    }

    public void setPrenomTmp(String prenomTmp) {
        this.prenomTmp = prenomTmp;
    }

    public String getPrenompereTmp() {
        return prenompereTmp;
    }

    public void setPrenompereTmp(String prenompereTmp) {
        this.prenompereTmp = prenompereTmp;
    }

    public String getGradeTmp() {
        return gradeTmp;
    }

    public void setGradeTmp(String gradeTmp) {
        this.gradeTmp = gradeTmp;
    }

    public String getDirectiongeneralTmp() {
        return directiongeneralTmp;
    }

    public void setDirectiongeneralTmp(String directiongeneralTmp) {
        this.directiongeneralTmp = directiongeneralTmp;
    }

    public String getDirectionTmp() {
        return directionTmp;
    }

    public void setDirectionTmp(String directionTmp) {
        this.directionTmp = directionTmp;
    }

    public String getSousdirectionTmp() {
        return sousdirectionTmp;
    }

    public void setSousdirectionTmp(String sousdirectionTmp) {
        this.sousdirectionTmp = sousdirectionTmp;
    }

    public String getDateTmp() {
        return dateTmp;
    }

    public void setDateTmp(String dateTmp) {
        this.dateTmp = dateTmp;
    }

    public AgentRepository getAgentRepository() {
        return agentRepository;
    }



    @Autowired
    public AgentController(AgentRepository agentRepository, AgentRRepository agentRRepository, GouvernoratRepository gouvernoratRepository, DelegationRepository delegationRepository, DirectionGeneralRepository directionGeneralRepository, DirectionRepository directionRepository, SousDirectionRepository sousDirectionRepository, GradeRepository gradeRepository, UserService userService, SyndicatRepository syndicatRepository) {
        this.agentRepository = agentRepository;
        this.agentRRepository = agentRRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.delegationRepository = delegationRepository;
        this.directionGeneralRepository = directionGeneralRepository;
        this.directionRepository = directionRepository;
        this.sousDirectionRepository = sousDirectionRepository;
        this.gradeRepository = gradeRepository;
        this.userService = userService;
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
    public String listAgents(Agent agent, Model model, String keyword) {

        System.out.println(" methode recherche in");
        if (keyword != null) {

            List<Agent> agents1 = agentService.getByKeyword(keyword);
            model.addAttribute("agents", agents1);
            System.out.println("taille de la liste keyword rempli :" + agents1.size());
            return "Agent/listAgents";
        } else {
            List<Agent> agents = agentService.getAllAgent();
            model.addAttribute("agents", agents);
            System.out.println("taille de la liste keyword vide :" + agents.size());
            return "Agent/listAgents";
        }

    }


    /******* export to csv *******/
   /* @GetMapping("export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Agent" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        // List<User> listUsers = service.listAll();
        List<Agent> agents = (List<Agent>) agentRepository.findAll();
        System.out.println("taille de la liste keyword :" + agents.size());

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"nom ", "prenom ", "CNRPS", "date insecription", "Grade"};
        String[] nameMapping = {"Nom", "prenom", "CNRPS", "dateInscription", "grade"};




        csvWriter.writeHeader(csvHeader);

        for (Agent agent : agents) {
            csvWriter.write(agent, nameMapping);
        }

        csvWriter.close();


    }
*/
    /******* pagination get the first page *******/

    @GetMapping("list/{pageNumber}")

    public String getOnePage(Model model, String DateInscription, String DirectionGeneralId, String DirectionId, String SousDirectionId, String gouvernoratId1, String SyndicatId, String GradeId, @PathVariable("pageNumber") int currentPage) {
        Page<Agent> page = null;
        int totalPages = 0;
        long totalItems = 0;
        List<Agent> agents = null;


        page = agentService.findPage(currentPage);
        totalPages = page.getTotalPages();
        totalItems = page.getTotalElements();
        agents = page.getContent();
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
       // return "Agent/test";


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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());

        agent.setAgentSaisie(user.getName() + "" + user.getLastName());
        agent.setDateSaisie(String.valueOf(LocalDateTime.now()));


//agent= (Agent) agentRepository.save(agent);

        if (agentRepository.existsByCNRPS(agent.getCNRPS())) {

            return "error/403";
        } else {

            agent = (Agent) agentRepository.save(agent);
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


    /************ loadDelegationByGouvernorat/{id}   ******/
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

    /************ loadDirectionByDirectionGeneral/{DgId}   ******/
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

    /************ loadSousDirectionByDirection/{DId}  ******/
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

    @ResponseBody
    @RequestMapping(value = "loadAgentR", method = RequestMethod.GET)
    public List<AgentR> loadStatesByCountry() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry");

        List<AgentR> AgentRcnrps = agentRRepository.FindByCNRPSAgentR();

        System.out.println("nbdirection : " + agentRepository.getCountBySDirection());

        return AgentRcnrps;

    }


    /******* search cnrps *******/

    @RequestMapping(path = {"add/search"})
    public String searchAgentR(Model model, String keywordd) {

         System.out.println("cnrps:" + keywordd);

            if (keywordd == null){
                System.out.println("cnrps2:" + keywordd);
                this.setCinTmp(null);
                this.setCnrpsTmp(null);
                this.setNomTmp(null);
                this.setPrenompereTmp(null);
                this.setPrenompereTmp(null);
               this.setDirectiongeneralTmp(null);
              this.setDirectionTmp(null);
               this.setSousdirectionTmp(null);
                this.setGradeTmp(null);


                model.addAttribute("cinTmp", cinTmp);
                model.addAttribute("cnrpsTmp", cnrpsTmp);
                model.addAttribute("nomTmp", nomTmp);
                model.addAttribute("prenomTmp", prenomTmp);
                model.addAttribute("prenompereTmp",prenompereTmp);
                model.addAttribute("directiongeneralTmp", directiongeneralTmp);
                model.addAttribute("directionTmp", directionTmp);
                model.addAttribute("sousdirectionTmp", sousdirectionTmp);
               model.addAttribute("gradeTmp", gradeTmp);


            }


            if (keywordd != null) {
                List<AgentR> agentfind = agentService.GetByCNRPSAgentR1(keywordd);

                System.out.println("agent find :"+agentfind);
                System.out.println("agent find :"+agentfind.size());
              //  AgentR agentrTmp = agentService.getByKeyword(keywordd);


               // for  (AgentR agentr : agentfind){
              //    System.out.println("directiin G R := "+agentr.getDirectionGeneralR());
            //    }


                System.out.println("cnrps3:" + keywordd);
                if (keywordd==""){

                    this.setCinTmp((null));
                    model.addAttribute("cinTmp", cinTmp);

                    this.setCnrpsTmp((null));
                    model.addAttribute("cnrpsTmp", cnrpsTmp);

                    this.setNomTmp((null));
                    model.addAttribute("nomTmp", nomTmp);

                    this.setPrenomTmp((null));
                    model.addAttribute("prenomTmp", prenomTmp);

                    this.setPrenompereTmp((null));
                    model.addAttribute("prenompereTmp", prenompereTmp);

                    this.setDirectiongeneralTmp((null));
                    model.addAttribute("directiongeneralTmp", directiongeneralTmp);

                    this.setDirectionTmp((null));
                    model.addAttribute("directionTmp", directionTmp);

                    this.setSousdirectionTmp((null));
                    model.addAttribute("sousdirectionTmp", sousdirectionTmp);

                    this.setGradeTmp((null));
                    model.addAttribute("gradeTmp", gradeTmp);

                    this.gouvernoratRepository.findAll();
                    model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
                    this.delegationRepository.findAll();
                    model.addAttribute("delegation", delegationRepository.findAll());

                    this.syndicatRepository.findAll();
                    model.addAttribute("syndicat", syndicatRepository.findAll());

                     this.directionGeneralRepository.findAll();
                    model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

                    this.directionRepository.findAll();
                    model.addAttribute("directions", directionRepository.findAll());

                     this.sousDirectionRepository.findAll();
                    model.addAttribute("sousDirections", sousDirectionRepository.findAll());




                }else
                {


                for (AgentR searchAgentR : agentfind) {

                    Agent agentrempl = new Agent();

                    agentrempl.setCNRPS(searchAgentR.getCnrpsR());

                    agentrempl.setCIN(searchAgentR.getCinR());

                    this.setCnrpsTmp(String.valueOf(searchAgentR.getCnrpsR()));
                    model.addAttribute("cnrpsTmp", cnrpsTmp);


                    this.setCinTmp(String.valueOf(searchAgentR.getCinR()));
                    model.addAttribute("cinTmp", cinTmp);

                    this.setNomTmp(String.valueOf(searchAgentR.getNomR()));
                    model.addAttribute("nomTmp", nomTmp);

                    this.setPrenomTmp(String.valueOf(searchAgentR.getPrenomR()));
                    model.addAttribute("prenomTmp", prenomTmp);

                    this.setPrenompereTmp(String.valueOf(searchAgentR.getPrenomPereR()));
                    model.addAttribute("prenompereTmp", prenompereTmp);

                    this.setDirectiongeneralTmp(String.valueOf(searchAgentR.getDirectionGeneralR()));
                    model.addAttribute("directiongeneralTmp", directiongeneralTmp);

                    this.setDirectionTmp(String.valueOf(searchAgentR.getDirectionR()));
                    model.addAttribute("directionTmp", directionTmp);

                    this.setSousdirectionTmp(String.valueOf(searchAgentR.getSousDirectionR()));
                    model.addAttribute("sousdirectionTmp", sousdirectionTmp);

                    this.setGradeTmp(String.valueOf(searchAgentR.getGradeR()));
                    model.addAttribute("gradeTmp", gradeTmp);

                    this.gouvernoratRepository.findAll();
                    model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
                    this.delegationRepository.findAll();
                    model.addAttribute("delegation", delegationRepository.findAll());

                    this.syndicatRepository.findAll();
                    model.addAttribute("syndicat", syndicatRepository.findAll());

                    this.directionGeneralRepository.findAll();
                    model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

                    this.directionRepository.findAll();
                    model.addAttribute("directions", directionRepository.findAll());

                    this.sousDirectionRepository.findAll();
                    model.addAttribute("sousDirections", sousDirectionRepository.findAll());


                }

                }

            }

          return "Agent/addAgent";
    }










    }




