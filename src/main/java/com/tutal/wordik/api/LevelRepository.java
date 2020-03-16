package com.tutal.wordik.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends CrudRepository<LevelModel, Long> {

    List<LevelModel> findBySourceLanguageAndTargetLanguage(String sourceLanguage, String targetLanguage);

}
