package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Direction;
import com.example.Securite_Routiere.entities.DirectionGeneral;
import com.example.Securite_Routiere.repositories.DirectionGeneralRepository;
import com.example.Securite_Routiere.repositories.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Direction/")
public class DirectionController {

    private final DirectionRepository directionRepository;
    private final DirectionGeneralRepository directionGeneralRepository;

@Autowired
    public DirectionController(DirectionRepository directionRepository, DirectionGeneralRepository directionGeneralRepository) {
        this.directionRepository = directionRepository;
        this.directionGeneralRepository = directionGeneralRepository;
    }

    @GetMapping("list")

    public String listDirections(Model model) {

        List<Direction> lp = (List<Direction>)directionRepository.findAll();

        if(lp.size()==0)
            lp = null;
        model.addAttribute("directions", lp);

        return "Direction/listDirections";

    }

    @GetMapping("add")
    public String showAddDirectionForm(Direction direction, Model model) {
        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());

        model.addAttribute("direction", new Direction());

        return "Direction/addDirection";
    }


    @PostMapping("addSave")

    public String addDirection(@Valid Direction direction, BindingResult result,
                               @RequestParam(name = "DirectionGeneralId",required = true)long d) {

    DirectionGeneral directionGeneral=directionGeneralRepository.findById(d).orElseThrow(()-> new IllegalArgumentException
                ("Invalid directiong Id:" +d));
    direction.setDirectionGeneral(directionGeneral);

        directionRepository.save(direction);

        return "redirect:list";
    }

    @GetMapping("delete/{DId}")
    public String deleteDirection(@PathVariable("DId") long DId, Model model) {
        Direction direction = directionRepository.findById(DId)
                .orElseThrow(()-> new IllegalArgumentException("Invalid Direction Id:" + DId));
        directionRepository.delete(direction);
        model.addAttribute("directions", directionRepository.findAll());

        return "Direction/listDirections";
    }


    @GetMapping("edit/{DId}")
    public String showDirectionFormToUpdate(@PathVariable("DId") long DId, Model model) {
        Direction direction = directionRepository.findById(DId)
                .orElseThrow(()->new IllegalArgumentException("Invalid Direction Id:" + DId));

        model.addAttribute("direction", direction);
        model.addAttribute("directionGenerals", directionGeneralRepository.findAll());
        model.addAttribute("idDirectionGeneral", direction.getDirectionGeneral().getDgId());

        return "Direction/updateDirection";
    }

}
