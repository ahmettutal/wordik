package com.tutal.wordik.controller;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.service.LevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WordController {

    private LevelService service;

    public WordController(LevelService service) {
        this.service = service;
    }

    @GetMapping("/words")
    public String findAll(Model model) {

        model.addAttribute("levels", service.findAll());

        return "levels";
    }

    @GetMapping("words/new")
    public String newRecord(Model model) {

        model.addAttribute("level", new LevelModel());

        return "level";
    }

}
