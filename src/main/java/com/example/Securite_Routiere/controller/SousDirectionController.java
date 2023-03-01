package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Direction;
import com.example.Securite_Routiere.entities.DirectionGeneral;
import com.example.Securite_Routiere.entities.SousDirection;
import com.example.Securite_Routiere.repositories.DirectionGeneralRepository;
import com.example.Securite_Routiere.repositories.DirectionRepository;
import com.example.Securite_Routiere.repositories.SousDirectionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/SousDirection/")
public class SousDirectionController {

    private final SousDirectionRepository sousDirectionRepository;
    private final DirectionRepository directionRepository;
    private final DirectionGeneralRepository directionGeneralRepository;

    @Autowired
    public SousDirectionController(SousDirectionRepository sousDirectionRepository, DirectionRepository directionRepository, DirectionGeneralRepository directionGeneralRepository) {
        this.sousDirectionRepository = sousDirectionRepository;
        this.directionRepository = directionRepository;
        this.directionGeneralRepository = directionGeneralRepository;
    }

    @GetMapping("list")
    //@ResponseBody
    public String listSousDirections(Model model) {

        List<SousDirection> lp = (List<SousDirection>) sousDirectionRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("sousDirections", lp);

        return "SousDirection/listSousDirections";

    }


    @GetMapping("add")
    public String showAddSousDirectionForm(SousDirection sousDirection, Model model) {


        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

        model.addAttribute("directions", directionRepository.findAll());
        model.addAttribute("sousdirection", new SousDirection());

        return "SousDirection/addSousDirection";
    }

    @PostMapping("addSave")

    public String addSousDirection(@Valid SousDirection sousdirection, BindingResult result,

                                   @RequestParam(name = "DirectionId", required = true) Long d,
                                   @RequestParam(name = "DirectionGeneralId", required = true) long dg) {

        Direction direction = directionRepository.findById(d).orElseThrow(() -> new IllegalArgumentException
                ("Invalid direction Id:" + d));
        sousdirection.setDirection(direction);

        DirectionGeneral directionGeneral = directionGeneralRepository.findById(dg).orElseThrow(() -> new IllegalArgumentException
                ("Invalid directiong Id:" + dg));
        // System.out.println("libille artile" +article.getLabel());


        // sousdirection.setDirectionGeneral(directionGeneral);


        sousDirectionRepository.save(sousdirection);
        return "redirect:list";

    }


    @GetMapping("delete/{sdId}")
    public String deleteDirection(@PathVariable("sdId") Long sdId, Model model) {
        SousDirection sousDirection = sousDirectionRepository.findById(sdId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid SousDirection Id:" + sdId));
        sousDirectionRepository.delete(sousDirection);
        model.addAttribute("sousDirection", sousDirectionRepository.findAll());

        return "redirect:../list";
    }


    @GetMapping("edit/{sdId}")
    public String showDirectionFormToUpdate(@PathVariable("sdId") Long sdId, Model model) {
        SousDirection sousDirection = sousDirectionRepository.findById(sdId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Direction Id:" + sdId));

        model.addAttribute("sousDirection", sousDirection);

        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());
        // model.addAttribute("idDirectionGeneral", sousDirection.getDirectionGeneral().getDgId());

        model.addAttribute("directions", directionRepository.findAll());
        model.addAttribute("idDirection", sousDirection.getDirection().getDId());

        return "SousDirection/updateSousDirection";
    }


    @PostMapping("edit")
    public String updateSousDirection(@Valid SousDirection sousdirection, BindingResult result, Model model,
                                      @RequestParam(name = "DirectionGeneralId", required = false) Long dg,
                                      @RequestParam(name = "directionId", required = true) Long d) {
        if (result.hasErrors()) {
            // System.out.println("direction id : " +direction.getCodeDir());
            return "SousDirection/updateSousDirection";
        }

        Direction direction = directionRepository.findById(d)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Direction Id:" + d));

        sousdirection.setDirection(direction);


        sousDirectionRepository.save(sousdirection);

        return "redirect:../SousDirection/list";


    }


    @ResponseBody
    @RequestMapping(value = "loadDirectionByDirectionGeneral/{DgId}", method = RequestMethod.GET)
    public String loadStatesByCountry3(@PathVariable("DgId") long DgId) {

        System.out.println("init loadStatesByCountry");
        System.out.println("l id de la direction générale st =" + DgId);

        System.out.println("la taille de la liste est egale =" + directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

        List<Direction> directionByDg = directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get());


        System.out.println("la taille de la liste est egale =" + directionByDg.size());

        Gson gson = new Gson();

        return gson.toJson(directionRepository.findByDirectionGeneral(directionGeneralRepository.findById(DgId).get()));

    }

}
