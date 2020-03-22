package com.tutal.wordik.service;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.repo.LevelRepository;
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

    public List<LevelModel> findAll() {
        return levelRepository.findAll();
    }

}
