package com.example.wei.springbootfood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wei.springbootfood.dao.TrxDetailDao;
import com.example.wei.springbootfood.model.entity.TrxDetail;
import com.example.wei.springbootfood.service.TrxDetailService;

@Service
public class TrxDetailServiceImpl implements TrxDetailService {

    @Autowired
    private TrxDetailDao trxDetailDao;

    @Override
    public void saveTrxDetail(TrxDetail trxDetail) {
        trxDetailDao.save(trxDetail);
    }
}