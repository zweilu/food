package com.example.wei.springbootfood.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE } )
    public String order(

    ) {
        return "";
    }
}
