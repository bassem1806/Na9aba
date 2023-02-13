package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.repositories.AgentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/widget")
public class WidgetController {


    private AgentRepository agentRepository;

    public WidgetController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
/*
    @ResponseBody
    @RequestMapping(value = "loadNbAgent", method = RequestMethod.GET)
    public List<Object> loadStatesByCountry() throws JsonProcessingException

    {

        System.out.println("init loadStatesByCountry2");


        Object nbAgent =agentRepository.nbAgent();

        System.out.println("la taille de la liste est egale =" + agentRepository.nbAgent());

        return nbAgent;

    }
*/
    @ResponseBody
    @RequestMapping(value = "loadNbAgent", method = RequestMethod.GET)
    public int  nbagent() throws JsonProcessingException

    {

      int x= agentRepository.nbagent();




        System.out.println("la taille de la liste est egale =" + agentRepository.nbagent());

        return x;

    }



}
