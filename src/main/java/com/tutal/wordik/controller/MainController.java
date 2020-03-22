package com.tutal.wordik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/", "/index.*", "/home.*", "/index", "/home", "/anasayfa"})
public class MainController {

    @GetMapping
    public String hello() {

        return "index";
    }

}
