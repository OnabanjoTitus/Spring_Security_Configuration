package com.security.security_configurations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("")
    public String itWorks(){
        return "It works";
    }
    @GetMapping("/admin")
    public String itWorksAdmin(){
        return "It works admin";
    }
    @GetMapping("/user")
    public String itWorksUser(){
        return "It works users";
    }
}
