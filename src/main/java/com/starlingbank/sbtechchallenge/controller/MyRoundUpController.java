package com.starlingbank.sbtechchallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRoundUpController {

    @GetMapping("/home")
    public String home(){
        return "Welcome to Starling";
    }
}
