package com.tutal.wordik.controller;

import com.tutal.wordik.model.WordikModel;
import com.tutal.wordik.service.WordikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WordController {

    private WordikService service;

    public WordController(WordikService service) {
        this.service = service;
    }

    @GetMapping("/words")
    public String findAll(Model model) {

        model.addAttribute("words", service.findAll());

        return "words";
    }

    @GetMapping("words/new")
    public String newRecord(Model model) {

        model.addAttribute("word", new WordikModel());

        return "word";
    }

    @PostMapping("words/save")
    String save(@ModelAttribute("word") WordikModel wordik, @RequestParam("files") MultipartFile[] images) {

        service.save(wordik, images);

        return "redirect:/words";
    }

}
