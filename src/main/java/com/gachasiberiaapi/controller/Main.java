package com.gachasiberiaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class Main {
        @GetMapping("/")
        public String home() {
                return "Gachas Iberia API está corriendo";
        }
    }

