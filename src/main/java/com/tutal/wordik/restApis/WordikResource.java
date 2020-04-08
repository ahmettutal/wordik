package com.tutal.wordik.restApis;

import com.tutal.wordik.core.ApiRestController;
import com.tutal.wordik.model.LevelResource;
import com.tutal.wordik.service.LevelService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@ApiRestController
public class WordikResource {

    private LevelService levelService;

    public WordikResource(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/levels")
    public List<LevelResource> getLevels() {

        return levelService.getLevels();
    }


}
