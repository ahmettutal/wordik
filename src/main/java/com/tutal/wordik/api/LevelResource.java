package com.tutal.wordik.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/level")
public class LevelResource {

    private LevelService levelService;

    public LevelResource(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/{sourceLanguage}/{targetLanguage}")
    public List<LevelModel> findBySourceLanguageAndTargetLanguage(@PathVariable String sourceLanguage, @PathVariable String targetLanguage) {

        System.out.println("findBySourceLanguageAndTargetLanguage sourceLanguage: " + sourceLanguage
                + " - targetLanguage: " + targetLanguage);

        return levelService.findBySourceLanguageAndTargetLanguage(sourceLanguage, targetLanguage);
    }

    @GetMapping("/{id}")
    public LevelModel getById(@PathVariable Long id) {

        System.out.println("getting with id: " + id);

        return levelService.getById(id);
    }

    @PostMapping
    public LevelModel save(@RequestBody LevelModel levelModel) {

        System.out.println("save start");

        final LevelModel save = levelService.save(levelModel);

        System.out.println("save end with: " + save);

        return save;
    }

}
