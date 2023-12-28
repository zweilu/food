package com.example.wei.springbootfood.dao;

import com.example.wei.springbootfood.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
