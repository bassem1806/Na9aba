package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.User;
import com.example.Securite_Routiere.repositories.RoleRepository;
import com.example.Securite_Routiere.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping ("list")
    public String listUsers(Model model){

        List<User> la = (List<User>)userRepository.findAll();
        if(la.size()==0)
        {
            la = null;
        }
        model.addAttribute("users", la);
        System.out.println("nb:" +la.size());
        return "user/listUsers";
    }




}

