package com.example.wei.springbootfood.dao.impl;

import com.example.wei.springbootfood.dao.TrxdetailDao;
import com.example.wei.springbootfood.model.Trxdetail;

import com.example.wei.springbootfood.rowmapper.TrxRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrxdetailDaoImpl implements TrxdetailDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createTrxdetail(Trxdetail trxdetail) {
        return null;
    }

    @Override
    public List<Trxdetail> getAllTrxdetails() {
        return null;
    }

    @Override
    public Trxdetail getTrxdetailById(Integer id){

         String sql =  "select id, trx_id,product_id, qty,price "+
                 " from trx-deatil where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        List<Trxdetail> trxdetailList = namedParameterJdbcTemplate.query(sql, map, new TrxRowMapper());

        if(trxdetailList.size() > 0){
            return trxdetailList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public void updateTrxdetail(Trxdetail trxdetail) {

    }

    @Override
    public void deleteTrxdetail(Integer id) {

    }
}
