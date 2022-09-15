package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.*;


import com.example.Securite_Routiere.repositories.*;

import com.example.Securite_Routiere.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/Candidat/")
public class CandidatController {

    private  final CandidatRepository candidatRepository;
    private final DelegationRepository delegationRepository;
    private final GouvernoratRepository gouvernoratRepository;

    private final ConcourRepository concourRepository;

    private final NiveauRepository niveauRepository;

    private final SpecialiteRepository specialiteRepository;

    private final UserService userService;
    




    @Autowired
    public CandidatController(CandidatRepository candidatRepository, DelegationRepository delegationRepository, GouvernoratRepository gouvernoratRepository,
                              ConcourRepository concourRepository, NiveauRepository niveauRepository,SpecialiteRepository specialiteRepository,UserService userService ) {
        this.candidatRepository = candidatRepository;
        this.delegationRepository = delegationRepository;
        this.gouvernoratRepository = gouvernoratRepository;
        this.concourRepository = concourRepository;
        this.niveauRepository =niveauRepository;
        this.specialiteRepository =specialiteRepository;
        this.userService=userService;

    }
    @GetMapping("list")
    //@ResponseBody
    public String listcandidats(Model model) {

        List<Candidat> lp = (List<Candidat>) candidatRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("candidats", lp);


        return "candidat/listCandidat";

    }

    @GetMapping("add")

    public String showAddCandidatForm(Candidat candidat, Model model){

        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("concour", concourRepository.findAll());
        model.addAttribute("niveau", niveauRepository.findAll());

        model.addAttribute("specialite", specialiteRepository.findAll());




        model.addAttribute("candidat", new Candidat());


        return "candidat/addcandidat";
    }

    @PostMapping("addSave")

    public String addPvAccident1(@Valid Candidat candidat, BindingResult result,

                                 @RequestParam(name = "gouvernoratId", required = true) Long k,
                                 @RequestParam(name = "gouvernoratId1", required = true) Long b,
                                 @RequestParam(name = "concourId", required = true) Long c,
                                 @RequestParam(name = "niveauId", required = true) Long n,
                                 @RequestParam(name = "specialiteId", required = true) Long s
                                 )
    {
        Delegation delegation = delegationRepository.findById(b).orElseThrow(() -> new IllegalArgumentException
                ("Invalid Unite Id:" + b));
        candidat.setDelegation(delegation);


        Concour concour = concourRepository.findById(c).orElseThrow(() -> new IllegalArgumentException
                ("Invalid concour Id:" + c));
        candidat.setConcour(concour);

        Niveau niveau = niveauRepository.findById(n).orElseThrow(() -> new IllegalArgumentException
                ("Invalid niveau Id:" + n));
     candidat.setNiveau(niveau);


        Specialite specialite = specialiteRepository.findById(s).orElseThrow(() -> new IllegalArgumentException
                ("Invalid niveau Id:" + s));
        candidat.setSpecialite(specialite);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
candidat.setAgentsaissie(user.getName()+" "+user.getLastName());



        candidat = candidatRepository.save(candidat);

        return "redirect:list";
    }

    @GetMapping("delete/{candidatId}")

    public String deletecandidat(@PathVariable("candidatId") long candidatId,Model model) {

        Candidat candidat=candidatRepository.findById(candidatId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidat Id:" + candidatId));



        System.out.println("id candidat :" + candidatId);

        candidatRepository.delete(candidat);
        return "redirect:../list";
    }

    @GetMapping("edit/{candidatId}")

    public String showcandidatFormToUpdate(@PathVariable("candidatId") long candidatId, Model model) {
        Candidat candidat =candidatRepository.findById(candidatId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidat  Id:" + candidatId));

        model.addAttribute("candidat", candidat);

        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("idGouvernourat", candidat.getDelegation().getGouvernorat().getId());

        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("idDelegation", candidat.getDelegation().getDelegationId());

        model.addAttribute("concour", concourRepository.findAll());
        model.addAttribute("idConcour", candidat.getConcour().getConcourId());

        model.addAttribute("niveau", niveauRepository.findAll());
        model.addAttribute("idniveau", candidat.getNiveau().getNiveautId());

        model.addAttribute("specialite", specialiteRepository.findAll());
        model.addAttribute("idspecialite", candidat.getSpecialite().getSpecialiteId());



        return "candidat/updateCandidat";

    }


    @ResponseBody
    @RequestMapping(value="loadDelegationByGouvernorat/{id}",method = RequestMethod.GET)
    public String loadStatesByCountry(@PathVariable("id") long id) {

        ArrayList<Delegation> delegationByGV = delegationRepository.findByGouvernorat(gouvernoratRepository.findById(id).get());

        List<Delegation> delegations = new ArrayList<>();
        for (Delegation temp : delegationByGV) {
            delegations.add(new Delegation(temp.getDelegationId(), temp.getName()));
        }

        Gson gson = new Gson();

        return gson.toJson(delegations);
    }

}
