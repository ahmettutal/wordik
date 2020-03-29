package com.tutal.wordik.controller;

import com.tutal.wordik.model.WordikModel;
import com.tutal.wordik.service.LevelService;
import com.tutal.wordik.service.PictureService;
import com.tutal.wordik.service.WordikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.tutal.wordik.util.Constants.UPLOAD_DIR_WORDIK;

@Controller
@RequestMapping("/words")
public class WordController {

    private WordikService service;

    private LevelService levelService;

    private PictureService pictureService;

    private HttpServletRequest request;

    public WordController(WordikService service, LevelService levelService,
                          PictureService pictureService, HttpServletRequest request) {
        this.service = service;
        this.levelService = levelService;
        this.pictureService = pictureService;
        this.request = request;
    }

    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("words", service.findAll());

        return "words";
    }

    @GetMapping("/new")
    public String newRecord(Model model) {

        model.addAttribute("word", new WordikModel());
        model.addAttribute("levelList", levelService.findAll());

        return "word";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("word") WordikModel wordik, @RequestParam("files") MultipartFile[] images) {

        service.save(request, wordik, images);

        return "redirect:/words";
    }

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable Long id) {

        model.addAttribute("word", service.getById(id));
        model.addAttribute("levelList", levelService.findAll());

        return "word";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable Long id) {

        final WordikModel byId = service.getById(id);

        service.delete(byId);
        pictureService.deletePic(request, byId.getId(), byId.getPicture(), UPLOAD_DIR_WORDIK);

        return "redirect:/words";
    }

}
