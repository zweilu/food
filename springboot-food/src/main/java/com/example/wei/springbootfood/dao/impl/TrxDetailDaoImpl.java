package com.example.wei.springbootfood.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.wei.springbootfood.dao.TrxDetailDao;
import com.example.wei.springbootfood.model.entity.TrxDetail;

@Repository
public class TrxDetailDaoImpl implements TrxDetailDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int save(TrxDetail trxDetail) {
        String sql = "INSERT INTO trx_detail (TRX_ID, PRODUCT_ID, QTY, PRICE) VALUES (:trxId, :productId, :qty, :price)";
        Map<String, Object> map = new HashMap<>();
        map.put("trxId", trxDetail.getTrxId());
        map.put("productId", trxDetail.getProductId());
        map.put("qty", trxDetail.getQty());
        map.put("price", trxDetail.getPrice());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowUpdate = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int id = keyHolder.getKey().intValue();
        trxDetail.setId(id);
        return rowUpdate;
    }

}