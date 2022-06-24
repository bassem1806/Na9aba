package com.example.Securite_Routiere.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SigninController {
	
	@RequestMapping(value = "/sign-in")
    public ModelAndView signin() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date_time = dtf.format(now);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("date_time", date_time);

        return new ModelAndView("sign-in", params);
    }

}
