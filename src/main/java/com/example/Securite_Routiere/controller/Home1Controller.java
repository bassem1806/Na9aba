package com.example.Securite_Routiere.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;



import com.example.Securite_Routiere.entities.Delegation;
import com.example.Securite_Routiere.entities.Gouvernorat;
import com.example.Securite_Routiere.repositories.DelegationRepository;
import com.example.Securite_Routiere.repositories.GouvernoratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home1Controller {


    @Autowired

    private DelegationRepository delegationRepository;
    @Autowired
    private GouvernoratRepository gouvernoratRepository;



    @RequestMapping(value = "/home1")
    public ModelAndView home1( Model model) {





            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String date_time = dtf.format(now);

            Map params = new HashMap<String, Object>();
            params.put("date_time", date_time);

            return new ModelAndView("home1", params);

        }









    }






