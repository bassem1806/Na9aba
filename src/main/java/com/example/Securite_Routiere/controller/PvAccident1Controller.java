package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

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

    private  final SignauxCirculationRepository signauxCirculationRepository;

    private final TypeRouteRepository typeRouteRepository;


    @Autowired
    public PvAccident1Controller(PvAccident1Repository pvAccident1Repository, UniteRepository uniteRepository, GouvernoratRepository gouvernoratRepository, DelegationRepository delegationRepository, SignauxCirculationRepository signauxCirculationRepository, TypeRouteRepository typeRouteRepository) {
        this.pvAccident1Repository = pvAccident1Repository;
        this.uniteRepository = uniteRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.delegationRepository = delegationRepository;
        this.signauxCirculationRepository = signauxCirculationRepository;
        this.typeRouteRepository = typeRouteRepository;

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
               model.addAttribute("delegation",delegationRepository.findAll());
               model.addAttribute("signauxCirculation",signauxCirculationRepository.findAll());
        model.addAttribute("typeRoute",typeRouteRepository.findAll());
               model.addAttribute("pvAccident1", new PvAccident1());
        return "pvaccident1/addPvAccident1";

    }

    @PostMapping("addSave1")

    public String addPvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result,


                                @RequestParam(name = "uniteId", required = true) Long h,
                              @RequestParam(name = "gouvernoratId", required = true) Long k,
                                  @RequestParam(name = "gouvernoratId1",required = true) Long b,
                                 @RequestParam(name="signauxCirculationId",required = true)Long s,
                                 @RequestParam(name="typeRouteId",required = true)Long t)


    {
        List<Delegation>delegationByGov = delegationRepository.findByGouvernorat(gouvernoratRepository.findById(11L));

        System.out.println("size listes  :" +delegationByGov.size());


        Unite unite= uniteRepository.findById(h).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Unite Id:" +h));
        pvAccident1.setUnite(unite);
       // System.out.println("id unite :"+ h);
        //System.out.println("id gouvernoratId :"+k);
      //  System.out.println("id gouvernoratId :"+b);

        Delegation delegation= delegationRepository.findById(b).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Unite Id:" +b));
             //   System.out.println("delegation  :" +delegation.getName());

        pvAccident1.setDelegation(delegation);

        SignauxCirculation signauxCirculation= signauxCirculationRepository.findById(s).orElseThrow(()-> new IllegalArgumentException
                ("Invalid Signaux Circulation Id:" +s));
              pvAccident1.setSignauxCirculation(signauxCirculation);


        TypeRoute typeRoute= typeRouteRepository.findById(t).orElseThrow(()-> new IllegalArgumentException
                ("Invalid  type route Id:" +t));
        pvAccident1.setTypeRoute(typeRoute);



        pvAccident1Repository.save(pvAccident1);



        return "redirect:list1";

    }




    }




