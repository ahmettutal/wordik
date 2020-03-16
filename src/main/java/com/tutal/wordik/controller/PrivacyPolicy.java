package com.tutal.wordik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivacyPolicy {

    @GetMapping("/privacy-policy")
    public String privacyPolicy() {

        return "privacy-policy";
    }

}
