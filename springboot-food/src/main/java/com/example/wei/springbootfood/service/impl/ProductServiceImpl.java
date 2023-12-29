package com.example.wei.springbootfood.service.impl;

import com.example.wei.springbootfood.dao.ProductDao;
import com.example.wei.springbootfood.model.Product;
import com.example.wei.springbootfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(Product product) {
        return productDao.createProduct(product);
    }

    @Override
    public void updateProduct(Integer productId, Product product) {

    }
}
