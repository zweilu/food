package com.example.wei.springbootfood.request;

public class ProductRequest {

        private String productName;
        private Integer productPrice;
        // 无需添加图片字段，因为它将作为MultipartFile处理
        // getter和setter方法


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
