package com.tutal.wordik.controller;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.service.LevelService;
import com.tutal.wordik.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.tutal.wordik.util.Constants.UPLOAD_DIR_LEVEL;

@Controller
@RequestMapping("/levels")
public class LevelController {

    private LevelService service;

    private PictureService pictureService;

    private HttpServletRequest request;

    public LevelController(LevelService service, PictureService pictureService, HttpServletRequest request) {
        this.service = service;
        this.pictureService = pictureService;
        this.request = request;
    }

    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("levels", service.findAll());

        return "levels";
    }

    @GetMapping("/new")
    public String newRecord(Model model) {

        model.addAttribute("level", new LevelModel());

        return "level";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("level") LevelModel level, @RequestParam("files") MultipartFile[] images) {

        service.save(request, level, images);

        return "redirect:/levels";
    }

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable Long id) {

        model.addAttribute("level", service.getById(id));

        return "level";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        final LevelModel byId = service.getById(id);

        service.delete(byId);
        pictureService.deletePic(request, byId.getId(), byId.getPicture(), UPLOAD_DIR_LEVEL);

        return "redirect:/levels";
    }

}
