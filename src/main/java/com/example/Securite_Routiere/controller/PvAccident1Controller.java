package com.example.Securite_Routiere.controller;

import com.example.Securite_Routiere.entities.*;
import com.example.Securite_Routiere.repositories.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
@RequestMapping("/PvAccidentnew/")
public class PvAccident1Controller {


    private final PvAccident1Repository pvAccident1Repository;

    private final UniteRepository uniteRepository;

    private final GouvernoratRepository gouvernoratRepository;


    private final DelegationRepository delegationRepository;


    private final SignauxCirculationRepository signauxCirculationRepository;


    private final TypeRouteRepository typeRouteRepository;


    private final SituationRouteRepository situationRouteRepository;


    private final TempsRepository tempsRepository;


    private final CauseAccidentRepository causeAccidentRepository;

    private final PartRepository partRepository;
    private Delegation delegation;

    private final BlesseRepository blesseRepository;


    @Autowired
    public PvAccident1Controller(PvAccident1Repository pvAccident1Repository, UniteRepository uniteRepository, GouvernoratRepository gouvernoratRepository,
                                 DelegationRepository delegationRepository, SignauxCirculationRepository signauxCirculationRepository, TypeRouteRepository typeRouteRepository,
                                 SituationRouteRepository situationRouteRepository, TempsRepository tempsRepository, CauseAccidentRepository causeAccidentRepository,
                                 PartRepository partRepository, BlesseRepository blesseRepository) {
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

        this.blesseRepository = blesseRepository;
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
                                 @RequestParam("parts") List<Long> part,
                                 // attribut blesse
                                 @RequestParam(name = "firstname", required = true) String firstName,
                                 @RequestParam(name = "CIN", required = true) String cin,
                                 @RequestParam(name = "sexe", required = true) String sexe,
                                 @RequestParam(name = "age", required = true) String age,
                                 @RequestParam(name = "EtatBlesse", required = true) String etatBlesse,
                                 @RequestParam(name = "Observation", required = true) String observation)



    {

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



        pvAccident1 = pvAccident1Repository.save(pvAccident1);

        List<Blesse> blesses  =new ArrayList<>();
        if (firstName != null && firstName.length() >0) {
            String[] fn = firstName.split(",");
            String[] cinarr = cin.split(",");
            String[] sexearr = sexe.split(",");
            String[] agearr = age.split(",");
            String[] etatBlessearr = etatBlesse.split(",");
            String[] obsarr = observation.split(",");
            int ii = 0;
            for (String f: fn ) {
                Blesse bl = new Blesse();
                bl.setFirstname(f);
                bl.setCIN(cinarr[ii]);
                bl.setAge(agearr[ii]);
                bl.setSexe(sexearr[ii]);
                bl.setEtatBlesse(etatBlessearr[ii]);
                bl.setObservation(obsarr[ii]);
                bl = blesseRepository.save(bl);
                pvAccident1.addBlesse(bl);
                blesses.add(bl);
                ii++;
            }
        }

        pvAccident1 = pvAccident1Repository.save(pvAccident1);

        return "redirect:list1";

    }

    @GetMapping("deletepv/{pvaccidId}")


    public String deletePvAccident1(@PathVariable("pvaccidId") long pvaccidId,Model model) {


        PvAccident1 pvAccident1 = pvAccident1Repository.findById(pvaccidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pvAccident1 Id:" + pvaccidId));

       // Blesse blesse = blesseRepository.findById(blesseId)
             //   .orElseThrow(() -> new IllegalArgumentException("Invalid pvAccident1 Id:" + blesseId));


        System.out.println("id pvaccidId :" + pvaccidId);

        pvAccident1Repository.delete(pvAccident1);



        return "redirect:../list1";


    }


    @GetMapping("deletebl/{blesseId}")

    public String deleteBlesse(@PathVariable("blesseId") long blesseId,   Model model) {

        Blesse blesse = blesseRepository.findById(blesseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Blesse Id:" + blesseId));

        System.out.println("id blesse..." + blesseId);


        blesseRepository.delete(blesse);

        model.addAttribute("blesse", blesseRepository.findAll());

     return "redirect:../edit";



    }







        @GetMapping("editpv/{pvaccidId}")
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

       model.addAttribute("blesses",pvAccident1.getBlesses());
       model.addAttribute("idblesse", pvAccident1.getBlesses());



        return "pvaccident1/updatePvAccident1";

    }

    @GetMapping("/retour")
        public String retour(){
System.out.println("aa");
        return   "redirect:/blesse/list";
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


                                 /*  @RequestParam(name = "firstname", required = true) String firstName,
                                    @RequestParam(name = "CIN", required = true) String cin,
                                     @RequestParam(name = "sexe", required = true) String sexe,
                                     @RequestParam(name = "age", required = true) String age,
                                    @RequestParam(name = "EtatBlesse", required = true) String etatBlesse,
                                   @RequestParam(name = "Observation", required = true) String observation)*/
                                  @RequestParam("blesses") List<Blesse> blesseList)


    {




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

        Blesse blesses=blesseRepository.findById(z).orElseThrow(() -> new IllegalArgumentException
        ("Invalid  Situation route Id:" + z));

        System.out.println("name :" +blesses.getSexe());



        System.out.println("  id pv  : " +pvAccident1.getId());

        System.out.println("  id blesse  : " +blesses.getBlesseId());



     pvAccident1Repository.save(pvAccident1);





        return "redirect:../list1";
    }

/*

    @GetMapping("editbl/{pvaccidId}/{blesseId}")


    public String showBlesseFormToUpdate(@PathVariable("pvaccidId") long pvaccidId, @PathVariable("blesseId") long blesseId, Model model) {



       PvAccident1 pvAccident1= pvAccident1Repository.findById(pvaccidId)
               .orElseThrow(() -> new IllegalArgumentException("Invalid blesse:" + pvaccidId));

        model.addAttribute("pvAccident1", pvAccident1);

        System.out.println("  id pv  : " +pvAccident1.getId());

        Blesse blesse = blesseRepository.findById(blesseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blesse:" + blesseId));



        model.addAttribute("blesse", blesse);


        System.out.println("  blesse name : " +blesse.getFirstname());
        System.out.println("  blesse sexe : " +blesse.getSexe());
        System.out.println(" blesse age : " +blesse.getAge());

        return "blesse/updateBlesse";


    }
*/


   /*

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
*/

    @GetMapping("show/{pvaccidId}")
    public String showPvAccident1(@PathVariable("pvaccidId") long pvaccidId, Model model) {
        PvAccident1 pvAccident1 = pvAccident1Repository.findById(pvaccidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Pv Accident Id:" + pvaccidId));

        model.addAttribute("pvAccident1", pvAccident1);

        model.addAttribute("unite", uniteRepository.findAll());
        model.addAttribute("idUnite", pvAccident1.getUnite().getName());

        model.addAttribute("gouvernorat", gouvernoratRepository.findAll());
        model.addAttribute("idGouvernourat", pvAccident1.getDelegation().getGouvernorat().getName());

        model.addAttribute("delegation", delegationRepository.findAll());
        model.addAttribute("idDelegation", pvAccident1.getDelegation().getName());

        model.addAttribute("signauxCirculation", signauxCirculationRepository.findAll());
        model.addAttribute("idSignauxCirculation", pvAccident1.getSignauxCirculation().getName());

        model.addAttribute("typeRoute", typeRouteRepository.findAll());
        model.addAttribute("idTypeRoute", pvAccident1.getTypeRoute().getName());

        model.addAttribute("situationRoute", situationRouteRepository.findAll());
        model.addAttribute("idSituationRoute", pvAccident1.getSituationRoute().getName());


        model.addAttribute("temps", tempsRepository.findAll());
        model.addAttribute("idTemps", pvAccident1.getTemps().getName());

        model.addAttribute("causeAccidents", causeAccidentRepository.findAll());
        model.addAttribute("idCauseAccidents", pvAccident1.getCauseAccidents());

        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("idParts", pvAccident1.getParts());

        model.addAttribute("blesses",pvAccident1.getBlesses());
        model.addAttribute("idblesse", pvAccident1.getBlesses());


        return "pvaccident1/showPvAccident1";
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




