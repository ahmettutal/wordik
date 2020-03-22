package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WORDIK")
public class WordikModel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageUrl;

    private String name;

    private String tr;

    private String en;

    private String de;

    private String fr;

    private String sp;

    private String it;

    private String ru;

    private String ar;

    private String pt;

    private String ja;

}
