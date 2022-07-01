package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.PvAccident;
import com.example.Securite_Routiere.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/PvAccident/")
public class PVAccidentController {
private final PvAccidentRepository pvAccidentRepository;
    private final CauseAccidentRepository causeAccidentRepository;
    private final DelegationRepository delegationRepository;
    private final PartRepository partRepository;
    private final SignauxCirculationRepository signauxCirculationRepository;
    private final SituationRouteRepository situationRouteRepository;
    private final TempsRepository tempsRepository;
    private final TypeRouteRepository typeRouteRepository;
    private final UniteRepository uniteRepository;

    public PVAccidentController(PvAccidentRepository pvAccidentRepository, CauseAccidentRepository causeAccidentRepository, DelegationRepository delegationRepository, PartRepository partRepository, SignauxCirculationRepository signauxCirculationRepository, SituationRouteRepository situationRouteRepository, TempsRepository tempsRepository, TypeRouteRepository typeRouteRepository, UniteRepository uniteRepository) {
        this.pvAccidentRepository = pvAccidentRepository;
        this.causeAccidentRepository = causeAccidentRepository;
        this.delegationRepository = delegationRepository;
        this.partRepository = partRepository;
        this.signauxCirculationRepository = signauxCirculationRepository;
        this.situationRouteRepository = situationRouteRepository;
        this.tempsRepository = tempsRepository;
        this.typeRouteRepository = typeRouteRepository;
        this.uniteRepository = uniteRepository;
    }

    @GetMapping("list")
    //@ResponseBody
    public String listPvAccidents(Model model) {

        List<PvAccident> lp = (List<PvAccident>) pvAccidentRepository.findAll();

        if(lp.size()==0)
            lp = null;
        model.addAttribute("pvAccident", lp);

        return "pvaccident/listPvAccident";

    }

    @GetMapping("add")

    public String showAddPvAccidentForm(PvAccident pvAccident, Model model) {

        model.addAttribute("causeAccident",causeAccidentRepository.findAll());
        model.addAttribute("delegation",delegationRepository.findAll());
        model.addAttribute("part",partRepository.findAll());
        model.addAttribute("signauxCirculation",signauxCirculationRepository.findAll());
        model.addAttribute("situationRoute",situationRouteRepository.findAll());
        model.addAttribute("temps",tempsRepository.findAll());
        model.addAttribute("typeRoute",typeRouteRepository.findAll());
        model.addAttribute("unite",uniteRepository.findAll());
        model.addAttribute("pvAccident", new PvAccident());
        return "pvaccident/addPvAccident";

    }






    }



