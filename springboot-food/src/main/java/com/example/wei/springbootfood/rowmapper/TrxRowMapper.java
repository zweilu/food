package com.example.wei.springbootfood.rowmapper;

import com.example.wei.springbootfood.model.TrxDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



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
