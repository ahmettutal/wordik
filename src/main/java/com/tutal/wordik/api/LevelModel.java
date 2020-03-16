package com.tutal.wordik.api;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LEVEL")
public class LevelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageUrl;

    private String name;

    private String sourceLanguage;

    private String targetLanguage;

}
