package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.app.forms.SignUpForm;
import ru.itpark.app.services.SignUpService;

@Controller
@RequestMapping(value = "/signUp")
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public String signUp(SignUpForm form) {
        service.signUp(form);
        return "redirect:/signIn";
    }
}
