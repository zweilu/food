package com.example.wei.springbootfood.controller;

import com.example.wei.springbootfood.model.TrxDetail;
import com.example.wei.springbootfood.service.TrxDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private TrxDetailService trxDetailService;

    @PostMapping("/carts")
    public ResponseEntity<TrxDetail> createTrxDetail(@RequestBody List<TrxDetail> trxDetails) {
        for (TrxDetail trxDetail : trxDetails) {
            TrxDetail trx = new TrxDetail();
            trx.setId(trxDetail.getId());
            trx.setQty(trxDetail.getQty());
            trx.setPrice(trxDetail.getPrice());

            trxDetailService.saveTrxDetail(trx);

            System.out.println(trx);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
