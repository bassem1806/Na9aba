package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.DirectionGeneral;
import com.example.Securite_Routiere.repositories.DirectionGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/DirectionGeneral/")
public class DirectionGeneralController {

    private final DirectionGeneralRepository directionGeneralRepository;

    @Autowired
    public DirectionGeneralController(DirectionGeneralRepository directionGeneralRepository) {
        this.directionGeneralRepository = directionGeneralRepository;
    }

    @GetMapping("list")

    public String listDirectionGenerals(Model model) {

        List<DirectionGeneral> lp = (List<DirectionGeneral>) directionGeneralRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("directionGenerals", lp);

        return "DirectionGeneral/listDirectionGenerals";

    }

    @GetMapping("add")
    public String showAddDirectionGeneralForm(Model model) {
        DirectionGeneral directionGeneral = new DirectionGeneral();// object dont la valeur des attributs par defaut
        model.addAttribute("directionGeneral", directionGeneral);
        System.out.println("direction general :" + directionGeneral);
        return "DirectionGeneral/addDirectionGeneral";
    }


    @PostMapping("addSave")

    public String addDirectionGeneral(@Valid DirectionGeneral directionGeneral, BindingResult result) {
        if (result.hasErrors()) {
            return "DirectionGeneral/addDirectionGeneral";
        }
        directionGeneralRepository.save(directionGeneral);

        System.out.println("direction general :" + directionGeneral);

        return "redirect:list";
    }

    @GetMapping("delete/{DgId}")


    public String deleteDirectionGeneral(@PathVariable("DgId") long DgId, Model model) {


        DirectionGeneral directionGeneral = directionGeneralRepository.findById(DgId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Direction G??n??ral Id:" + DgId));


        directionGeneralRepository.delete(directionGeneral);

        System.out.println("id dg : " + directionGeneral.getDgId());
        return "redirect:../list";

    }


    @GetMapping("edit/{DgId}")
    public String showDirectionGeneralFormToUpdate(@PathVariable("DgId") long DgId, Model model) {
        DirectionGeneral directionGeneral = directionGeneralRepository.findById(DgId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Direction G??n??ral Id:" + DgId));

        model.addAttribute("directionGeneral", directionGeneral);

        return "DirectionGeneral/updateDirectionGeneral";
    }

    @PostMapping("update")
    public String updateDirectionGeneral(@Valid DirectionGeneral directionGeneral, BindingResult result) {
        if (result.hasErrors()) {
            return "DirectionGeneral/updateDirectionGeneral";
        }
        directionGeneralRepository.save(directionGeneral);
        return "redirect:list";

    }
}
