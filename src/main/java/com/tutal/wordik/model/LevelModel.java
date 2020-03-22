package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LEVEL")
public class LevelModel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String imageUrl;

    private int defaultQuestionCount;

}
