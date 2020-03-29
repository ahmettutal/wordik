package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PICTURE")
public class PictureModel extends AuditModel {

    private String name;

}
