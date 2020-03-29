package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "LEVEL")
public class LevelModel extends AuditModel {

    private String name;

    @OneToOne
    private PictureModel picture;

    private int defaultQuestionCount;

}
