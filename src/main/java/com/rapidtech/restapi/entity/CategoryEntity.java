package com.rapidtech.restapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "id", length = 36)
    private int id;

    @Column(name = "code", length = 120)
    private String code;

    @Column(name = "name", length = 120)
    private String name;
}
