package com.example.wei.springbootfood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.wei.springbootfood.model.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProductId(rs.getInt("product_id" ));
        product.setProductName(rs.getString("product_name"));
        product.setPrice(rs.getInt("price"));
        product.setPic(rs.getString("pic"));

        return product;
    }
}
