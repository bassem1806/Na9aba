package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Grade;
import com.example.Securite_Routiere.repositories.GradeRepository;
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
@RequestMapping("/Grade")
public class GradeController {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("list")

    public String listGrades(Model model) {

        List<Grade> lp = (List<Grade>) gradeRepository.findAll();

        if (lp.size() == 0)
            lp = null;
        model.addAttribute("grades", lp);

        return "Grade/listGrades";

    }

    @GetMapping("add")
    public String showAddDGradeForm(Model model) {

        Grade grade = new Grade();

        model.addAttribute("grade", grade);
        System.out.println("grade:" + grade);
        return "Grade/addGrade";
    }

    @PostMapping("addSave")

    public String addGrade(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "Grade/addGrade";
        }
        gradeRepository.save(grade);
        System.out.println("grade :" + grade);
        return "redirect:list";
    }

    @GetMapping("delete/{GradeId}")


    public String deleteDirectionGeneral(@PathVariable("GradeId") long GradeId, Model model) {

        Grade grade = gradeRepository.findById(GradeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid GradeId:" + GradeId));

        gradeRepository.delete(grade);


        System.out.println("Grade id  : " + grade.getGradeId());
        return "redirect:../list";

    }

    @GetMapping("edit/{GradeId}")
    public String showDirectionGeneralFormToUpdate(@PathVariable("GradeId") long GradeId, Model model) {

        Grade grade = gradeRepository.findById(GradeId)

                .orElseThrow(() -> new IllegalArgumentException("Invalid GradeId:" + GradeId));

        model.addAttribute("grade", grade);

        return "Grade/updateGrade";
    }

    @PostMapping("update")
    public String updateGrade(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "Grade/updateGrade";
        }
        gradeRepository.save(grade);

        return "redirect:list";

    }
}
