package com.example.wei.springbootfood.dao.impl;

import com.example.wei.springbootfood.dao.ProductDao;
import com.example.wei.springbootfood.model.Product;
import com.example.wei.springbootfood.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
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


        @Override
        public Integer createProduct(Product product) {
            String sql = "INSERT INTO product (product_name, price, pic) VALUES (:productName, :price, :pic)";

            Map<String, Object> map = new HashMap<>();
            map.put("productName", product.getProductName());
            map.put("price", product.getPrice());
            map.put("pic", product.getPic());

            KeyHolder keyHolder = new GeneratedKeyHolder();

            namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map), keyHolder);

            int productId = keyHolder.getKey().intValue();

            return  productId;

        }

    @Override
    public void updateProduct(Integer productId,Product product) {
        String sql = "UPDATE product SET product_name = :productName, price = :price, pic = :pic WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId); // Assuming productId exists in the Product object

        map.put("productName", product.getProductName());
        map.put("price", product.getPrice());
        map.put("pic", product.getPic());


        namedParameterJdbcTemplate.update(sql, map);
    }

    }





