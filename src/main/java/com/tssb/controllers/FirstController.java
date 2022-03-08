package com.tssb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "/goodbye";
    }
}
