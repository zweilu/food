package com.example.wei.springbootfood.dao;

import com.example.wei.springbootfood.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(Product product);

    void updateProduct(Integer productId,Product product);
}
