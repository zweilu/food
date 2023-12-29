package com.example.wei.springbootfood.controller;

import com.example.wei.springbootfood.model.Product;
import com.example.wei.springbootfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productsId}")
    public ResponseEntity<Product>getProduct(@PathVariable Integer productsId){
        Product product = productService.getProductById(productsId);

        if (product !=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Integer productId = productService.createProduct(product);

        Product pd = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(pd);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody Product product){

        //檢查product是否存在
        Product upProduct = productService.getProductById(productId);

        if (upProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品數據
        productService.updateProduct(productId , product);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }



}

