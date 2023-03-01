/*package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.repositories.AgentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.Map;

@Controller
@RequestMapping("/widget1")
public class WidgetController {


    private AgentRepository agentRepository;

    private Home1Controller home1Controller;

    public WidgetController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }



    @GetMapping(value = "/widget")
    public ModelAndView widget (Model model) {



        //  System.out.println("----------------------------------------------------------------------------------------------------------------------------------- :" + nbag);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date_time = dtf.format(now);

        Map params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("widget1", params);

    }

}
*/