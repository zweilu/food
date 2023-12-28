package com.example.wei.springbootfood.dao.impl;

import com.example.wei.springbootfood.dao.ProductDao;
import com.example.wei.springbootfood.model.Product;
import com.example.wei.springbootfood.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class productDaoImpl implements ProductDao {

    @Autowired
    private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Product getProductById(Integer productId) {
       String sql =  "select product_id, product_name, price, pic"+
               " from product where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList.size()>0){
            return productList.get(0);
        }else{
            return null;
        }


    }
}
