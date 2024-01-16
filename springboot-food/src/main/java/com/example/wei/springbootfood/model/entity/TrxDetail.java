package com.example.wei.springbootfood.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrxDetail {
	
    private int id;
    
    private int trxId;
    
    private int productId;
    
    private int qty;
    
    private int price;
}
