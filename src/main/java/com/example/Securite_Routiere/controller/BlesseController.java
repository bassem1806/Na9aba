package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Blesse;
import com.example.Securite_Routiere.repositories.BlesseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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

        List<Blesse> lp = (List<Blesse>)blesseRepository.findAll();

        if(lp.size()==0)
            lp = null;
        model.addAttribute("blesses", lp);

        return "blesse/listBlesse";

    }

    @GetMapping("delete/{blesseId}")

    public String deleteBlesse(@PathVariable("blesseId") long blesseId, Model model) {

        Blesse blesse = blesseRepository.findById(blesseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Blesse Id:" + blesseId));

         System.out.println("id blesse..." + blesseId);


        blesseRepository.delete(blesse);

        model.addAttribute("blesse", blesseRepository.findAll());

        return "redirect:../list";
    }


}
