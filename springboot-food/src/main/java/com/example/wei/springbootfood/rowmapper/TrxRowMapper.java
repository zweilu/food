package com.example.wei.springbootfood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.wei.springbootfood.model.entity.TrxDetail;



public class TrxRowMapper implements RowMapper<TrxDetail> {


    @Override
    public TrxDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrxDetail trxdetail = new TrxDetail();



        trxdetail.setId((rs.getInt("product_id")));
        trxdetail.setQty(rs.getInt(rs.getInt("qty")));
        trxdetail.setPrice(rs.getInt("price"));

        return trxdetail;
    }
}
