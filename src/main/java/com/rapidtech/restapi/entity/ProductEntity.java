package com.rapidtech.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "product")
@Entity
public class ProductEntity {
    @Id
    @Column(name = "id", length = 36)
    private int id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "price")
    private Double price;
}
