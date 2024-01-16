package com.example.wei.springbootfood.dao.impl;

import com.example.wei.springbootfood.dao.TrxDetailDao;
import com.example.wei.springbootfood.model.TrxDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TrxDetailDaoImpl implements TrxDetailDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int save(TrxDetail trxDetail) {
        String sql = "INSERT INTO trx_detail (PRODUCT_ID, QTY, PRICE) VALUES (:productId, :qty, :price)";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", trxDetail.getId());
        map.put("qty", trxDetail.getQty());
        map.put("price", trxDetail.getPrice());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        return id;

    }

}