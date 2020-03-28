package com.tutal.wordik.service;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.repo.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    private LevelRepository repository;

    public LevelService(LevelRepository repository) {
        this.repository = repository;
    }

    public LevelModel save(LevelModel model) {
        return repository.save(model);
    }

    public LevelModel getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<LevelModel> findAll() {
        return repository.findAll();
    }

}
