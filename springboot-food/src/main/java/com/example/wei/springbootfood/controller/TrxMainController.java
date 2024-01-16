package com.example.wei.springbootfood.controller;

import com.example.wei.springbootfood.model.TrxDetail;
import com.example.wei.springbootfood.model.TrxMain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TrxMainController {

    @PostMapping("/carts")
    public ResponseEntity<TrxMain> createTrxMain() {


        return null;
    }
}
