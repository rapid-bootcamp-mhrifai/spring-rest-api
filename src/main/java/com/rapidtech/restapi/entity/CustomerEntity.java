package com.rapidtech.restapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "id", length = 36)
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "dateOfPlace")
    private String dateOfPlace;
}
