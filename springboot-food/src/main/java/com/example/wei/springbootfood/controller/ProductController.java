package com.example.wei.springbootfood.controller;

import com.example.wei.springbootfood.model.Product;
import com.example.wei.springbootfood.request.ProductRequest;
import com.example.wei.springbootfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> productList = productService.getProducts();

        return  ResponseEntity.status(HttpStatus.OK).body(productList);
    }

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
    public ResponseEntity<?> createProduct(
    		@ModelAttribute ProductRequest productRequest,
    		@RequestParam("productImage") MultipartFile productImage) {

        try {
            String filename = productImage.getOriginalFilename();
            String path = "E:/"+filename;
            File newFile = new File(path);
            productImage.transferTo(newFile);
            
            Product product = new Product();
            product.setProductName(productRequest.getProductName());
            product.setPrice(productRequest.getProductPrice());
            product.setPic(filename);

            productService.save(product);

            return ResponseEntity.ok("Product successfully added");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
        }
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

    @DeleteMapping("products/{productId}")
    public  ResponseEntity<Product> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}

