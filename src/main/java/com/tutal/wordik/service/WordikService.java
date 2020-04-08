package com.tutal.wordik.service;

import com.tutal.wordik.model.PictureModel;
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

    private PictureService pictureService;

    public WordikService(WordikRepository repository, PictureService pictureService) {
        this.repository = repository;
        this.pictureService = pictureService;
    }

    public WordikModel save(WordikModel model) {
        return repository.save(model);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void delete(WordikModel model) {
        repository.delete(model);
    }

    public WordikModel save(HttpServletRequest request, WordikModel model, MultipartFile[] images) {

        if (Objects.isNull(model.getId())) {
            model = repository.save(model);
        } else {
            WordikModel byId = repository.findById(model.getId()).orElse(new WordikModel());

            byId.setLevels(model.getLevels());
            byId.setName(model.getName());
            byId.setTr(model.getTr());
            byId.setEn(model.getEn());
            byId.setDe(model.getDe());
            byId.setFr(model.getFr());
            byId.setSp(model.getSp());
            byId.setIt(model.getIt());
            byId.setRu(model.getRu());
            byId.setAr(model.getAr());
            byId.setPt(model.getPt());
            byId.setJa(model.getJa());

            model = repository.save(byId);
        }

        if (images != null) {
            final PictureModel picture = pictureService.saveImages(request, model.getId(), UPLOAD_DIR_WORDIK, images);
            if (!Objects.isNull(picture)) {
                model.setPicture(picture);
                model = repository.save(model);
            }
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
