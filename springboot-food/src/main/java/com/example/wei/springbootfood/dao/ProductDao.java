package com.example.wei.springbootfood.dao;

import com.example.wei.springbootfood.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(Product product);

    void updateProduct(Integer productId,Product product);

    void deleteProductById(Integer productId);
}
