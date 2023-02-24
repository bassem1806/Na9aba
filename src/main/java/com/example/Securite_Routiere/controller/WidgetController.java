package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.repositories.AgentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/widget")
public class WidgetController {


    private AgentRepository agentRepository;

    private Home1Controller home1Controller;

    public WidgetController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
/*
    @GetMapping("/nbagent")

    public String nbagent(Model model) {

   int nbag =agentRepository.nbagent();
        model.addAttribute("nbagent", nbag);

        System.out.println("nb agent widget -************************************************************ :" +nbag);

        return "widget";

    }

*/

    @ResponseBody
    @RequestMapping(value = "loadNbAgent", method = RequestMethod.GET)
    public int  nbagent() throws JsonProcessingException

    {

      int x= agentRepository.nbagent();




        System.out.println("nb agent model widget  87877878978978978979797979797979879797=" +x);

        return x;

    }



}
