package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.DelegationRepository;
import com.example.Securite_Routiere.repositories.GouvernoratRepository;
import com.example.Securite_Routiere.repositories.PvAccident1Repository;

import com.example.Securite_Routiere.repositories.UniteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/PvAccidentnew/")
public class PvAccident1Controller {

        private final PvAccident1Repository pvAccident1Repository;
        private final UniteRepository uniteRepository;
    private final GouvernoratRepository gouvernoratRepository;

    private final DelegationRepository delegationRepository;

@Autowired
        public PvAccident1Controller(PvAccident1Repository pvAccident1Repository, UniteRepository uniteRepository,GouvernoratRepository gouvernoratRepository, DelegationRepository delegationRepository) {
            this.pvAccident1Repository = pvAccident1Repository;
            this.uniteRepository = uniteRepository;
             this.gouvernoratRepository = gouvernoratRepository;
    this.delegationRepository = delegationRepository;
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
        model.addAttribute("gouvernorat", gouvernoratRepository.findAll() );
               model.addAttribute("templates/delegation",delegationRepository.findAll());
        model.addAttribute("pvAccident1", new PvAccident1());
        return "pvaccident1/addPvAccident1";

    }

    @PostMapping("addSave1")

    public String addPvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result,


                                @RequestParam(name = "uniteId", required = true) Long h,
                              @RequestParam(name = "gouvernoratId", required = true) Long k,
                                  @RequestParam(name = "delegationdId",required = true) Long b)





    {



        Unite unite= uniteRepository.findById(h).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Unite Id:" +h));
        pvAccident1.setUnite(unite);



        Delegation delegation= delegationRepository.findById(b).orElseThrow(()-> new IllegalArgumentException
       ("Invalid Delegation Id:" +b));
        pvAccident1.setDelegation(delegation);


pvAccident1Repository.save(pvAccident1);

        return "redirect:list1";

    }




    }




