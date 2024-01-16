package com.example.wei.springbootfood.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrxDetailDto {

	int productId;

	String name;

	int qty;

	int price;
	
	
}
