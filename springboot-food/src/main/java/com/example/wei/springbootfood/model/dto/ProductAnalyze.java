package com.example.wei.springbootfood.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAnalyze {

	String name;
	
	Integer amount;
	
	String color;
	
	Object[] data;
	
	public Object[] getData() {
		data = new Object[3];
		data[0] = name;
		data[1] = amount;
		data[2] = color;
		return data;
	}
}
