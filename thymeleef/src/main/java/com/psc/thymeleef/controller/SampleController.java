package com.psc.thymeleef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("message", "Hello World");
    }
}
