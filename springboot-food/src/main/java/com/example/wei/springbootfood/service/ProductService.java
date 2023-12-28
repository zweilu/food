package com.example.wei.springbootfood.service;

import com.example.wei.springbootfood.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductService {

    Product getProductById(Integer productId);
}
