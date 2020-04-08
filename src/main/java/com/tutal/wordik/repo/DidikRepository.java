package com.tutal.wordik.repo;

import com.tutal.wordik.model.DidikModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DidikRepository extends BaseRepository<DidikModel, Long> {

    List<DidikModel> findByUrl(String url);

}
