package com.rapidtech.restapi.controller;

import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.model.ResponseModel;
import com.rapidtech.restapi.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchaseOrders")
public class PurchaseOrderController {
    private PurchaseOrderService service;

    @Autowired
    public PurchaseOrderController (PurchaseOrderService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        List<PurchaseOrderModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id){
        Optional<PurchaseOrderModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PostMapping()
    public ResponseEntity<Object> saveProduct(@RequestBody PurchaseOrderModel request){
        Optional<PurchaseOrderModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody PurchaseOrderModel request){
        Optional<PurchaseOrderModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        Optional<PurchaseOrderModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }
}
