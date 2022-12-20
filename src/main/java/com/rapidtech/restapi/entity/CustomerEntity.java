package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.CustomerModel;
import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    private Long id;

    @Column(name = "customer_name", length = 100)
    private String fullName;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "gender", length = 100)
    private String gender;

    @Column(name = "date_Of_Birth", length = 100)
    private Date dateOfBirth;

    @Column(name = "date_Of_Place", length = 100)
    private String dateOfPlace;


    public CustomerEntity(CustomerModel model) {
        BeanUtils.copyProperties(model, this);
        /*
        this.code = model.getCode();
        this.name = model.getName();
        this.price = model.getPrice();
        this.categoryId = model.getCategoryId();
         */
    }
}
