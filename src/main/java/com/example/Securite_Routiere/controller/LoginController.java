package com.example.Securite_Routiere.controller;


import com.example.Securite_Routiere.entities.Role;
import com.example.Securite_Routiere.entities.User;
import com.example.Securite_Routiere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class LoginController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = {"/home1"}, method = RequestMethod.GET)
    public ModelAndView accueil() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //  User user = userService.findUserByEmail(auth.getName());
        User user = userService.findUserByLogin(auth.getName());

        System.out.println("user login" + user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");


        Set<Role> userRoles = user.getRoles();
        Object[] tab = userRoles.toArray();
        Role r = (Role) tab[0];
        String role = r.getRole();
        modelAndView.addObject("userRole", role);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        // User userExists = userService.findUserByEmail(user.getEmail());
        User userExists = userService.findUserByLogin(user.getLogin());

        if (userExists != null) {
           /* bindingResult
                    .rejectValue("email", "error.user",*/
            bindingResult
                    .rejectValue("login", "error.user",
                            "There is already a user registered with the login provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
   /* @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }*/

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}

