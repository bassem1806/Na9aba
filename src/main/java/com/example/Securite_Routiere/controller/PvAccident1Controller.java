package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/PvAccidentnew/")
public class PvAccident1Controller {

    private final PvAccident1Repository pvAccident1Repository;
    private final UniteRepository uniteRepository;
    private final GouvernoratRepository gouvernoratRepository;

    private DelegationRepository delegationRepository;

    private final SignauxCirculationRepository signauxCirculationRepository;

    private final TypeRouteRepository typeRouteRepository;

    private final SituationRouteRepository situationRouteRepository;

    private final TempsRepository tempsRepository;

    private final CauseAccidentRepository causeAccidentRepository;
    private final PartRepository partRepository;
    private Delegation delegation;




    @RequestMapping(value="loadDelegationByGouvernorat/{id}",method = RequestMethod.GET)
    public String loadDelegationByGouvernorat(@PathVariable("gouvernoratId") long gouvernoratId) {
        //  System.out.println("init loadStatesByCountry");

        System.out.println("l'id de gouvernorat gv ="+gouvernoratId);



        List<Delegation> delegationByGV = delegationRepository.findByGouvernorat(gouvernoratRepository.findById(gouvernoratId).get());
        System.out.println("la taille de la liste est egale ="+delegationByGV.size());
        Gson gson = new Gson();

        return gson.toJson(delegationRepository.findByGouvernorat((gouvernoratRepository.findById(gouvernoratId).get())));
    }




    @Autowired
    public PvAccident1Controller(PvAccident1Repository pvAccident1Repository, UniteRepository uniteRepository, GouvernoratRepository gouvernoratRepository,
                                 DelegationRepository delegationRepository, SignauxCirculationRepository signauxCirculationRepository,
                                 TypeRouteRepository typeRouteRepository, SituationRouteRepository situationRouteRepository, TempsRepository tempsRepository,
                                 CauseAccidentRepository causeAccidentRepository, PartRepository partRepository) {
        this.pvAccident1Repository = pvAccident1Repository;
        this.uniteRepository = uniteRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.delegationRepository = delegationRepository;
        this.signauxCirculationRepository = signauxCirculationRepository;
        this.typeRouteRepository = typeRouteRepository;
        this.situationRouteRepository = situationRouteRepository;
        this.tempsRepository = tempsRepository;
        this.causeAccidentRepository = causeAccidentRepository;
        this.partRepository = partRepository;




    }




    @GetMapping("list1")
    //@ResponseBody
    public String listPvAccidents(Model model) {

        List<PvAccident1> lp = (List<PvAccident1>) pvAccident1Repository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("pvAccidents1", lp);


        return "pvaccident1/listPvAccident1";

    }




    @GetMapping("add1")
    public String showAddPvAccident1Form(PvAccident1 pvAccident1, Model model) {


        model.addAttribute("unite", uniteRepository.findAll());
        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("signauxCirculation", signauxCirculationRepository.findAll());
        model.addAttribute("typeRoute", typeRouteRepository.findAll());
        model.addAttribute("situationRoute", situationRouteRepository.findAll());
        model.addAttribute("temps", tempsRepository.findAll());
        model.addAttribute("causeAccidents", causeAccidentRepository.findAll());
        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("pvAccident1", new PvAccident1());
        return "pvaccident1/addPvAccident1";

    }

    @PostMapping("addSave1")

    public String addPvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result,


                                 @RequestParam(name = "uniteId", required = true) Long h,
                                 @RequestParam(name = "gouvernoratId", required = true) Long k,
                                 @RequestParam(name = "gouvernoratId1", required = true) Long b,
                                 @RequestParam(name = "signauxCirculationId", required = true) Long s,
                                 @RequestParam(name = "typeRouteId", required = true) Long t,
                                 @RequestParam(name = "situationRouteId", required = true) Long z,
                                 @RequestParam(name = "tempsId", required = true) Long r,
                                 @RequestParam("causeAccidents") List<Long> causeAccident,
                                 @RequestParam("parts") List<Long> part)




    {
      //List<Delegation> delegationByGov = delegationRepository.findByGouvernorat(gouvernoratRepository.findById());

      //System.out.println("size listes  :" + delegationByGov.size());

        List<CauseAccident> parts;
        

       

        Unite unite = uniteRepository.findById(h).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + h));
        pvAccident1.setUnite(unite);


        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + b));


        pvAccident1.setDelegation(delegation);

        SignauxCirculation signauxCirculation = signauxCirculationRepository.findById(s).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Signaux Circulation Id:" + s));
        pvAccident1.setSignauxCirculation(signauxCirculation);


        TypeRoute typeRoute = typeRouteRepository.findById(t).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  type route Id:" + t));
        pvAccident1.setTypeRoute(typeRoute);

        SituationRoute situationRoute = situationRouteRepository.findById(z).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  Situation route Id:" + z));

        // System.out.println("id sit routeId :"+z);
        pvAccident1.setSituationRoute(situationRoute);


        Temps temps = tempsRepository.findById(r).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  Situation route Id:" + r));

        pvAccident1.setTemps(temps);

        pvAccident1Repository.save(pvAccident1);


        return "redirect:list1";

    }

    @GetMapping("delete/{pvaccidId}")


    public String deletePvAccident1(@PathVariable("pvaccidId") long pvaccidId, Model model) {


        PvAccident1 pvAccident1 = pvAccident1Repository.findById(pvaccidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pvAccident1 Id:" + pvaccidId));

        System.out.println("id pvaccidId :" + pvaccidId);

        pvAccident1Repository.delete(pvAccident1);

        return "redirect:../list1";


    }

    @GetMapping("edit/{pvaccidId}")
    public String showPvAccident1FormToUpdate(@PathVariable("pvaccidId") long pvaccidId, Model model) {
        PvAccident1 pvAccident1 = pvAccident1Repository.findById(pvaccidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Pv Accident Id:" + pvaccidId));

        model.addAttribute("pvAccident1", pvAccident1);

        model.addAttribute("unite", uniteRepository.findAll());
        model.addAttribute("idUnite", pvAccident1.getUnite().getId());

        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("idGouvernourat", pvAccident1.getDelegation().getGouvernorat().getId());

        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("idDelegation", pvAccident1.getDelegation().getDelegationId());

        model.addAttribute("signauxCirculation", signauxCirculationRepository.findAll());
        model.addAttribute("idSignauxCirculation", pvAccident1.getSignauxCirculation().getSigneId());

        model.addAttribute("typeRoute", typeRouteRepository.findAll());
        model.addAttribute("idTypeRoute", pvAccident1.getTypeRoute().getId());

        model.addAttribute("situationRoute", situationRouteRepository.findAll());
        model.addAttribute("idSituationRoute", pvAccident1.getSituationRoute().getId());


        model.addAttribute("temps", tempsRepository.findAll());
        model.addAttribute("idTemps", pvAccident1.getTemps().getId());

        model.addAttribute("causeAccidents", causeAccidentRepository.findAll());
        model.addAttribute("idCauseAccidents", pvAccident1.getCauseAccidents());

        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("idParts", pvAccident1.getParts());

        return "pvaccident1/updatePvAccident1";
    }

    @PostMapping("edit")
    public String updatePvAccident1(@Valid PvAccident1 pvAccident1, BindingResult result, Model model,

                                    @RequestParam(name = "uniteId", required = true) Long h,
                                    @RequestParam(name = "gouvernoratId", required = true) Long k,
                                    @RequestParam(name = "gouvernoratId1", required = true) Long b,
                                    @RequestParam(name = "signauxCirculationId", required = true) Long s,
                                    @RequestParam(name = "typeRouteId", required = true) Long t,
                                    @RequestParam(name = "situationRouteId", required = true) Long z,
                                    @RequestParam(name = "tempsId", required = true) Long r,
                                    @RequestParam("causeAccidents") List<Long> causeAccident,
                                    @RequestParam("parts") List<Long> part) {
        if (result.hasErrors()) {

            return "pvaccident1/updatePvAccident1";
        }
        Unite unite = uniteRepository.findById(h).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + h));
        pvAccident1.setUnite(unite);


        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + b));
        pvAccident1.setDelegation(delegation);


        SignauxCirculation signauxCirculation = signauxCirculationRepository.findById(s).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Signaux Circulation Id:" + s));
        pvAccident1.setSignauxCirculation(signauxCirculation);


        TypeRoute typeRoute = typeRouteRepository.findById(t).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  type route Id:" + t));
        pvAccident1.setTypeRoute(typeRoute);

        SituationRoute situationRoute = situationRouteRepository.findById(z).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  Situation route Id:" + z));
        pvAccident1.setSituationRoute(situationRoute);


        Temps temps = tempsRepository.findById(r).orElseThrow(() -> new IllegalArgumentException
                ("Invalid  Situation route Id:" + r));
        pvAccident1.setTemps(temps);


        pvAccident1Repository.save(pvAccident1);

        return "redirect:../PvAccidentnew/list1";
    }




}




