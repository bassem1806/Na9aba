package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.PvAccident1Repository;
import com.example.Securite_Routiere.repositories.PvAccidentRepository;
import com.example.Securite_Routiere.repositories.UniteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/PvAccidentnew/")
public class PvAccident1Controller {

        private final PvAccident1Repository pvAccident1Repository;
        private final UniteRepository uniteRepository;

@Autowired
        public PvAccident1Controller(PvAccident1Repository pvAccident1Repository, UniteRepository uniteRepository) {
            this.pvAccident1Repository = pvAccident1Repository;
            this.uniteRepository = uniteRepository;
        }


    @GetMapping("list1")
    //@ResponseBody
    public String listPvAccidents(Model model) {

        List<PvAccident1> lp = (List<PvAccident1>) pvAccident1Repository.findAll();

        if(lp.size()==0)
            lp = null;
        model.addAttribute("pvAccidents1", lp);

        return "pvaccident1/listPvAccident1";

    }

    @GetMapping("add1")

    public String showAddPvAccident1Form(PvAccident1 pvAccident1, Model model) {


        model.addAttribute("unite",uniteRepository.findAll());

        model.addAttribute("pvAccident", new PvAccident());
        return "pvaccident1/addPvAccident1";

    }

    @PostMapping("addSave1")

    public String addPvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result,


                                @RequestParam(name = "uniteId", required = true) Long h)

    {



        Unite unite= uniteRepository.findById(h).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Unite Id:" +h));
        pvAccident1.setUnite(unite);


/*
        System.out.println("pv accident :" +pvAccident1.getCauseAccident());
        System.out.println("pv accident :" +pvAcciden1t.getAddreaccid());*/

        pvAccident1Repository.save(pvAccident1);

        return "redirect:list1";

    }


    }



