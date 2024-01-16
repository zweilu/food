package com.example.wei.springbootfood.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.wei.springbootfood.dao.TrxMainDao;
import com.example.wei.springbootfood.model.entity.TrxMain;

@Repository
public class TrxMainDaoImpl implements TrxMainDao {

	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int save(TrxMain trxMain) {
		String sql = "INSERT INTO trx_main (TOTAL) VALUES (:total)";
        Map<String, Object> map = new HashMap<>();
        map.put("total", trxMain.getTotal());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowUpdate = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int trxId = keyHolder.getKey().intValue();
        trxMain.setTrxId(trxId);
        return rowUpdate;
	}

}
