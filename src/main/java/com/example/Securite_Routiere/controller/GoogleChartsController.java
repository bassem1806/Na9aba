package com.example.Securite_Routiere.controller;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoogleChartsController {
    @RequestMapping(value = "/home")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 19807);
        model.addAttribute("chartData", graphData);

        System.out.println("chart :");
        return "home";


    }
}