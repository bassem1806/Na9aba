package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Direction;
import com.example.Securite_Routiere.entities.DirectionGeneral;
import com.example.Securite_Routiere.entities.SousDirection;
import com.example.Securite_Routiere.repositories.DirectionGeneralRepository;
import com.example.Securite_Routiere.repositories.DirectionRepository;
import com.example.Securite_Routiere.repositories.SousDirectionRepository;
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
@RequestMapping ("/SousDirection/")
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

        List<SousDirection> lp = (List<SousDirection>)sousDirectionRepository.findAll();

        if(lp.size()==0)
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
                                   @RequestParam(name = "DirectionGeneralId",required = true)long dg)
    {

        Direction direction= directionRepository.findById(d).orElseThrow(()-> new IllegalArgumentException
                ("Invalid direction Id:" +d));
        sousdirection.setDirection(direction);

        DirectionGeneral directionGeneral = directionGeneralRepository.findById(dg).orElseThrow(()-> new IllegalArgumentException
                ("Invalid directiong Id:" +dg));
        // System.out.println("libille artile" +article.getLabel());


        sousdirection.setDirectionGeneral(directionGeneral);


  sousDirectionRepository.save(sousdirection);
        return "redirect:list";

    }


}
