package com.example.wei.springbootfood.dao;

import java.util.List;

import com.example.wei.springbootfood.model.entity.Product;

public interface ProductDao {

    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(Product product);

    void updateProduct(Integer productId,Product product);

    void deleteProductById(Integer productId);
}
