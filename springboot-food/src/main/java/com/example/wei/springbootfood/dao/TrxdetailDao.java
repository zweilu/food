package com.example.wei.springbootfood.dao;

import com.example.wei.springbootfood.model.Trxdetail;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TrxdetailDao {
    Integer createTrxdetail(Trxdetail trxdetail);
    List<Trxdetail> getAllTrxdetails();
    Trxdetail getTrxdetailById(Integer id);
    void updateTrxdetail(Trxdetail trxdetail);
    void deleteTrxdetail(Integer id);
}
