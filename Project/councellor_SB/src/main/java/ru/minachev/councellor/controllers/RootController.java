package ru.minachev.councellor.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/")
public class RootController {

    @GetMapping
    public String getRoot() {
            return "redirect:/collected_tech_data";
        }
}