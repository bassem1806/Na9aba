package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.repositories.AgentRepository;
import com.example.Securite_Routiere.repositories.DelegationRepository;
import com.example.Securite_Routiere.repositories.GouvernoratRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/home1")
public class Home1Controller {
    private static final Logger log = LoggerFactory.getLogger(Home1Controller.class);
@Autowired
    private  final AgentRepository agentRepository;

    // private final dataSyndicatService dataSyndicatService;

    @Autowired
    private DelegationRepository delegationRepository;

    @Autowired
    private GouvernoratRepository gouvernoratRepository;

@Autowired
    public Home1Controller(AgentRepository agentRepository, DelegationRepository delegationRepository, GouvernoratRepository gouvernoratRepository) {
        this.agentRepository = agentRepository;
       // this.dataSyndicatService = dataSyndicatService;
        this.delegationRepository = delegationRepository;
        this.gouvernoratRepository = gouvernoratRepository;
    }


    @GetMapping(value = "/home")
    public ModelAndView home1(Model model) {


        int nbag =agentRepository.nbagent();
      //  System.out.println("----------------------------------------------------------------------------------------------------------------------------------- :" + nbag);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date_time = dtf.format(now);

        Map params = new HashMap<String, Object>();
        params.put("date_time", date_time);
       // model.addAttribute("nbrAg",nbag);
       // System.out.println("nbr agnet model :"  +nbag);
        return new ModelAndView("home1", params);

    }
    /*** methode nb abbonne par syndicat**/
    @ResponseBody
    @RequestMapping(value = "loadNbsyndicat", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry2() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry2");

        List<Object> nbsyndicat=agentRepository.getCountBySyndicat();

              System.out.println("la taille de la liste est egale =" + agentRepository.getCountBySyndicat().size());
       System.out.println("la taille de la liste est egale =" + agentRepository.getCountBySyndicat().get(0));
        System.out.println("la taille de la liste est egale =" + agentRepository.getCountBySyndicat().get(0).toString());

        return nbsyndicat;

    }

    /*** methode nb abbonne par s direction**/
    @ResponseBody
    @RequestMapping(value = "loadNbsdirection", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry");

        List<Object> nbdirection =agentRepository.getCountBySDirection();

        System.out.println("nbdirection : " +agentRepository.getCountBySDirection());

        return nbdirection;

    }

    /*** methode nb abbonne par grade**/
    @ResponseBody
    @RequestMapping(value = "loadNbgrade", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry1() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry1");


        List<Object> nbgrade = agentRepository.getCountByGrade();
        System.out.println("nbdirection : " + agentRepository.getCountByGrade());

        return nbgrade;

    }

    /*** methode nb abbonne par periode **/
    @ResponseBody
    @RequestMapping(value = "loadNbagentperiode", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry3() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry3");

        List<Object> nbagentperiode = agentRepository.getCountnbagentperiode();
        System.out.println("nbagent periode : " + agentRepository.getCountnbagentperiode());

        return nbagentperiode;

    }

}








