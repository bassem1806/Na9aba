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

import javax.persistence.Id;
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

        model.addAttribute("pvAccident", new PvAccident());
        model.addAttribute("delegation",delegationRepository.findAll());
        return "pvaccident1/addPvAccident1";

    }

    @PostMapping("addSave1")

    public String addPvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result,


                                @RequestParam(name = "uniteId", required = true) Long h,
                                 @RequestParam(name = "gouvernoratId", required = true) Long k,
                                  @RequestParam(name = "delegationdId", required = false) Long b)
    {



        Unite unite= uniteRepository.findById(h).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Unite Id:" +h));
        pvAccident1.setUnite(unite);

        Gouvernorat gouvernorat= gouvernoratRepository.findById(k).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Gouvernorat Id:" +k));
        pvAccident1.setGouvernorat(gouvernorat);

        Delegation delegation= delegationRepository.findById(b).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Delegation Id:" +b));
        pvAccident1.setDelegation(delegation);
        System.out.println("gov id :" +gouvernorat.getId());
        System.out.println("delegation id :" +delegation.getDelegationId());

        pvAccident1Repository.save(pvAccident1);

        return "redirect:list1";

    }
/*
    @ResponseBody
    @RequestMapping(value = "loadDelegationByGouvernorat/{id}", method = RequestMethod.GET)
    public String loadStatesByCountry(@PathVariable("id") long id) {

        System.out.println("init loadStatesByCountry");
        System.out.println("l id de la Gouvernorat est ="+id);

        //	System.out.println("la taille de la liste est egale ="+directionRepository.findByDirectiong(directiongRepository.findById(id).get()));

        List <Delegation> delegationsByGv =delegationRepository.findByGouvernorat(gouvernoratRepository.findById(id).get());
        System.out.println("la taille de la liste est egale ="+delegationsByGv.size());

        Gson gson = new Gson();
        //  GsonBuilder gsonBuilder = new GsonBuilder();
        //    Gson gson = gsonBuilder.registerTypeAdapter(Direction.class, new MessageAdapter()).create();
        return gson.toJson(delegationRepository.findByGouvernorat(gouvernoratRepository.findById(id).get()));

    }


    private class Gson {

        public String toJson(List<Delegation> byGouvernorat) {


        }*/
    }




