package com.example.wei.springbootfood.service;

import com.example.wei.springbootfood.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(Product product);

    void updateProduct(Integer productId,Product product);

    void deleteProductById(Integer productId);


    void save(Product product);
}
