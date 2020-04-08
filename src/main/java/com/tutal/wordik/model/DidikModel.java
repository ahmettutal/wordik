package com.tutal.wordik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "DIDIK")
public class DidikModel extends AuditModel {

    private String url;

    private String didik;

}
