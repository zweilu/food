package com.example.wei.springbootfood.model;

public class TrxDetail {
    private int Id;
    private String name;
    private int qty;
    private int price;

    public int getId() {
        return Id;
    }

    public void setId(int productId) {
        this.Id = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
