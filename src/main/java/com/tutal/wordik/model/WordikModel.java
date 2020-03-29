package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "WORDIK")
public class WordikModel extends AuditModel {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "WORDIK_LEVEL",
            joinColumns = {@JoinColumn(name = "wordik_id")},
            inverseJoinColumns = {@JoinColumn(name = "level_id")}
    )
    private Set<LevelModel> levels = new HashSet<>();

    @OneToOne
    private PictureModel picture;

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

    @Transient
    private String levelNames;

}
