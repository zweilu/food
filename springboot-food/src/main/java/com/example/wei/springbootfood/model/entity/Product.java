package com.example.wei.springbootfood.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	Integer productId;

	String productName;

	Integer price;

	String pic;
}
