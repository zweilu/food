package com.example.wei.springbootfood.rowmapper;

import com.example.wei.springbootfood.model.Trxdetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class TrxRowMapper implements RowMapper<Trxdetail> {


    @Override
    public Trxdetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trxdetail trxdetail = new Trxdetail();

        trxdetail.setId(rs.getInt("id"));
        trxdetail.setTrxId(rs.getInt("trx_id"));
        trxdetail.setProductId((rs.getInt("product_id")));
        trxdetail.setQTY(rs.getInt(rs.getInt("qty")));
        trxdetail.setPrice(rs.getInt("price"));

        return trxdetail;
    }
}
