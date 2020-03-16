package com.tutal.wordik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Support {

    @GetMapping("/support")
    public String support() {

        return "support";
    }

}
