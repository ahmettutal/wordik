package com.tutal.wordik.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    private LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }


    public LevelModel save(LevelModel levelModel) {
        return levelRepository.save(levelModel);
    }

    public LevelModel getById(Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    public List<LevelModel> findBySourceLanguageAndTargetLanguage(String sourceLanguage, String targetLanguage) {
        return levelRepository.findBySourceLanguageAndTargetLanguage(sourceLanguage, targetLanguage);
    }
}
