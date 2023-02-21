package com.example.Securite_Routiere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

@ComponentScan

public class RecrutementApplication {


    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

    public static void main(String[] args) {


        SpringApplication.run(RecrutementApplication.class, args);


    }

}
