package com.example.wei.springbootfood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.wei.springbootfood.dao.ProductDao;
import com.example.wei.springbootfood.model.entity.Product;
import com.example.wei.springbootfood.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

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
         productDao.updateProduct(productId, product);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public void save(Product product) {

    }
}


