package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.ProductEntity;
import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.repository.PurchaseOrderRepo;
import com.rapidtech.restapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderRepo repo;

    @Autowired
    public PurchaseOrderServiceImpl (PurchaseOrderRepo repo){
        this.repo = repo;
    }
    @Override
    public List<PurchaseOrderModel> getAll() {
        return this.repo.findAll().stream().map(PurchaseOrderModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseOrderModel> getById(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<PurchaseOrderEntity> result = this.repo.findById(id);
        /*
        if(result.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new ProductModel(result.get()));
         */
        return result.map(PurchaseOrderModel::new);
    }

    @Override
    public Optional<PurchaseOrderModel> save(PurchaseOrderModel model) {
        if(model == null) {
            return Optional.empty();
        }
        PurchaseOrderEntity entity = new PurchaseOrderEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new PurchaseOrderModel(entity));
        }catch (Exception e){
            log.error("Product save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PurchaseOrderModel> update(Integer id, PurchaseOrderModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<PurchaseOrderModel> delete(Integer id) {
        if(id == 0) {
            return Optional.empty();
        }

        PurchaseOrderEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new PurchaseOrderModel(result));
        }catch (Exception e){
            log.error("Product delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
