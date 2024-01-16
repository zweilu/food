package com.example.wei.springbootfood.service;

import com.example.wei.springbootfood.dao.TrxDetailDao;
import com.example.wei.springbootfood.model.TrxDetail;
import com.example.wei.springbootfood.dao.TrxDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrxDetailServiceImpl implements TrxDetailService {

    @Autowired
    private TrxDetailDao trxDetailDao;

    @Override
    public void saveTrxDetail(TrxDetail trxDetail) {
        trxDetailDao.save(trxDetail);
    }
}