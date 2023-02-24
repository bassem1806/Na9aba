package com.example.Securite_Routiere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionnaire")
public class DictionnaireController {

    @GetMapping(value = "/dic")
    public ModelAndView dictionnaire(Model model) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date_time = dtf.format(now);

        Map params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("dictionnaire", params);

    }


}
