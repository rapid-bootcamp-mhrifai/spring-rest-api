package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderModel {
    private Integer id;
    private String poCode;
    private Integer customerId;
    private Integer employeeId;
    private Integer shipperId;
    private Date poDate;
    private Double totalAmount;

    public PurchaseOrderModel (PurchaseOrderEntity entity){
        BeanUtils.copyProperties(entity,this);
    }
}
