package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "product")
@Entity
@NoArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id", length = 36)
    private int id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "price")
    private Double price;

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
