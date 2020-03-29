package com.tutal.wordik.service;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.model.PictureModel;
import com.tutal.wordik.repo.LevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static com.tutal.wordik.util.Constants.UPLOAD_DIR_LEVEL;

@Service
public class LevelService {

    private LevelRepository repository;

    private PictureService pictureService;

    public LevelService(LevelRepository repository, PictureService pictureService) {
        this.repository = repository;
        this.pictureService = pictureService;
    }

    public LevelModel save(LevelModel model) {
        return repository.save(model);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void delete(LevelModel model) {
        repository.delete(model);
    }

    public LevelModel save(HttpServletRequest request, LevelModel model, MultipartFile[] images) {

        if (Objects.isNull(model.getId())) {
            model = repository.save(model);
        } else {
            LevelModel byId = repository.findById(model.getId()).orElse(new LevelModel());

            byId.setName(model.getName());
            byId.setDefaultQuestionCount(model.getDefaultQuestionCount());

            model = repository.save(byId);
        }

        if (images != null) {
            final PictureModel picture = pictureService.saveImages(request, model.getId(), UPLOAD_DIR_LEVEL, images);
            model.setPicture(picture);
            model = repository.save(model);
        }

        return model;
    }

    public LevelModel getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<LevelModel> findAll() {
        return repository.findAll();
    }

}
