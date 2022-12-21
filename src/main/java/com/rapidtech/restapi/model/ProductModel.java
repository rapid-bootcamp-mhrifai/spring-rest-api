package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Integer categoryId;
    private Long supplierId;
    private String categoryName;

    public ProductModel(ProductEntity entity){
        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
    }
}