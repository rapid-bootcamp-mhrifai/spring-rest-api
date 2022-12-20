package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String gender;
    private Date dateOfBirth;
    private String dateOfPlace;

    public CustomerModel(CustomerEntity entity){
        /*
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.categoryId = entity.getCategoryId();*/
        BeanUtils.copyProperties(entity, this);
    }
}
