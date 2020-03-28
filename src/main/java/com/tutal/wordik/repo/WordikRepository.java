package com.tutal.wordik.repo;

import com.tutal.wordik.model.WordikModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordikRepository extends JpaRepository<WordikModel, Long> {

}
