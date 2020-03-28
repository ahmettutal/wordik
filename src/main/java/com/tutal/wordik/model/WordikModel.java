package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "WORDIK")
public class WordikModel extends AuditModel {

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
