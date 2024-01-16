package com.example.wei.springbootfood.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrxMain {

    Integer trxId;
   
    Date checkoutTime;
    
    Integer total;
}
