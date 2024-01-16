package com.example.wei.springbootfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wei.springbootfood.dao.TrxDetailDao;
import com.example.wei.springbootfood.dao.TrxMainDao;
import com.example.wei.springbootfood.model.dto.TrxDetailDto;
import com.example.wei.springbootfood.model.entity.TrxDetail;
import com.example.wei.springbootfood.model.entity.TrxMain;

@RestController
public class OrderController {

    @Autowired
    private TrxMainDao trxMainDao;
	
    @Autowired
    private TrxDetailDao trxDetailDao;
    
    @PostMapping("/carts")
    public ResponseEntity<TrxDetail> createTrxDetail(@RequestBody List<TrxDetailDto> trxDetailDtos) {
    	
    	// 總計
    	int total = trxDetailDtos
    			.stream()
    			.mapToInt(trxDetail -> trxDetail.getPrice() * trxDetail.getQty())
    			.sum();
    	
    	// TrxMain
    	TrxMain trxMain = new TrxMain();
    	trxMain.setTotal(total);
    	trxMainDao.save(trxMain);
    	
    	// TrxDetail
        for (TrxDetailDto trxDetailDto : trxDetailDtos) {
        	TrxDetail trxDetail = new TrxDetail();
        	trxDetail.setTrxId(trxMain.getTrxId());
        	trxDetail.setProductId(trxDetailDto.getProductId());
        	trxDetail.setQty(trxDetailDto.getQty());
        	trxDetail.setPrice(trxDetailDto.getPrice());
            trxDetailDao.save(trxDetail);
            System.out.println(trxDetail);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
