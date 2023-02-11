package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.repositories.AgentRepository;
import com.example.Securite_Routiere.repositories.DelegationRepository;
import com.example.Securite_Routiere.repositories.GouvernoratRepository;
//import com.example.Securite_Routiere.service.dataSyndicatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date_time = dtf.format(now);

        Map params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("home1", params);

    }

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

    @ResponseBody
    @RequestMapping(value = "loadNbsdirection", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry");

        List<Object> nbdirection =agentRepository.getCountBySDirection();

        System.out.println("nbdirection : " +agentRepository.getCountBySDirection());

        return nbdirection;

    }

    @ResponseBody
    @RequestMapping(value = "loadNbgrade", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry1() throws JsonProcessingException {

        System.out.println("init loadStatesByCountry1");


        List<Object> nbgrade=agentRepository.getCountByGrade();
        System.out.println("nbdirection : " +agentRepository.getCountByGrade());

        return nbgrade;

    }

}








