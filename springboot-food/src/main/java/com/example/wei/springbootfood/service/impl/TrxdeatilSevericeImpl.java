package com.example.wei.springbootfood.service.impl;

import com.example.wei.springbootfood.dao.TrxdetailDao;
import com.example.wei.springbootfood.model.Trxdetail;
import com.example.wei.springbootfood.service.TrxdetailSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrxdeatilSevericeImpl implements TrxdetailSeverice {

    @Autowired
    private TrxdetailDao trxdetailDao;
    @Override
    public Trxdetail getTrxdetailById(Integer id) {
        return trxdetailDao.getTrxdetailById(id);
    }
}
