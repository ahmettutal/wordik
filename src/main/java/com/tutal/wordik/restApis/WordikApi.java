package com.tutal.wordik.restApis;

import com.tutal.wordik.core.ApiRestController;
import com.tutal.wordik.model.WordikResource;
import com.tutal.wordik.service.WordikService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@ApiRestController
public class WordikApi {

    private WordikService wordikService;

    public WordikApi(WordikService wordikService) {
        this.wordikService = wordikService;
    }

    @GetMapping("/words/{levelId}/{source}/{target}")
    public List<WordikResource> getLevels(@PathVariable Long levelId, @PathVariable String source, @PathVariable String target) {

        return wordikService.getWords(levelId, source, target);
    }

}
