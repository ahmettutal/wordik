package com.tutal.wordik.repo;

import com.tutal.wordik.model.WordikModel;
import org.springframework.stereotype.Repository;

@Repository
public interface WordikRepository extends BaseRepository<WordikModel, Long> {

}
