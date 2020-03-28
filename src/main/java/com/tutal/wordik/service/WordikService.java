package com.tutal.wordik.service;

import com.tutal.wordik.model.WordikModel;
import com.tutal.wordik.repo.WordikRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static com.tutal.wordik.util.Constants.UPLOAD_DIR_WORDIK;

@Service
public class WordikService {

    private WordikRepository repository;

    private HttpServletRequest request;

    private PictureService pictureService;

    public WordikService(WordikRepository repository, HttpServletRequest request, PictureService pictureService) {
        this.repository = repository;
        this.request = request;
        this.pictureService = pictureService;
    }

    public WordikModel save(WordikModel model, MultipartFile[] images) {

        if (images != null) {
            final String imageUrl = pictureService.saveImages(request, model, images, UPLOAD_DIR_WORDIK);
            model.setImageUrl(imageUrl);
        }

        if (Objects.isNull(model.getId())) {
            model = repository.save(model);
        } else {
            WordikModel byId = repository.findById(model.getId()).orElse(new WordikModel());

            byId.setName(model.getName());
            byId.setImageUrl(model.getImageUrl());
            byId.setTr(model.getTr());
            byId.setEn(model.getEn());
            byId.setDe(model.getDe());

            model = repository.save(byId);
        }

        return model;
    }

    public WordikModel getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<WordikModel> findAll() {
        return repository.findAll();
    }

}
