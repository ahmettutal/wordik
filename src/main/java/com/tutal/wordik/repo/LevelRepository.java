package com.tutal.wordik.repo;

import com.tutal.wordik.model.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<LevelModel, Long> {

}
