package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Blesse;
import com.example.Securite_Routiere.repositories.BlesseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionScope
@RequestMapping("/blesse/")
public class BlesseController {


    private final BlesseRepository blesseRepository;


    @Autowired
    public BlesseController(BlesseRepository blesseRepository) {
        this.blesseRepository = blesseRepository;
    }

    @GetMapping("list")
    //@ResponseBody
    public String listBlesses(Model model) {

        List<Blesse> lp = (List<Blesse>) blesseRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("blesses", lp);

        return "blesse/listBlesse";

    }

    @GetMapping("delete/{blesseId}")

    public String deleteBlesse(@PathVariable("blesseId") long blesseId,   Model model) {

        Blesse blesse = blesseRepository.findById(blesseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Blesse Id:" + blesseId));

        System.out.println("id blesse..." + blesseId);


        blesseRepository.delete(blesse);

        model.addAttribute("blesse", blesseRepository.findAll());

        return "redirect:../list";

    }

    @GetMapping("edit/{blesseId}")

    public String showBlesseFormToUpdate(@PathVariable("blesseId") long blesseId, Model model) {
        Blesse blesse = blesseRepository.findById(blesseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blesse:" + blesseId));

        model.addAttribute("blesse", blesse);


        System.out.println("  blesse name  : " +blesse.getFirstname());
        System.out.println("  blesse sexe : " +blesse.getSexe());
        System.out.println(" blesse age : " +blesse.getAge());

        return "blesse/updateBlesse";


    }

    @PostMapping("update")

    public String updateBlesse(@Valid Blesse blesse, BindingResult result) {
        if (result.hasErrors()) {
            return "Blesse/updateBlesse";
        }
        System.out.println("  blesse name 1  : " +blesse.getFirstname());
        System.out.println("  blesse sexe 1: " +blesse.getSexe());
        System.out.println(" blesse age 1: " +blesse.getAge());


        blesseRepository.save(blesse);


        return "redirect:list";

    }
}
