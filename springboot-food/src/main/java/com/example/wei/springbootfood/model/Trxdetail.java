package com.example.wei.springbootfood.model;

public class Trxdetail {

    private Integer detail;
    private Integer trxid;
    private Integer productId;
    private Integer QTY;
    private Integer price;

    public Integer getDetail() {
        return detail;
    }

    public void setDetail(Integer detail) {
        this.detail = detail;
    }

    public Integer getTrxid() {
        return trxid;
    }

    public void setTrxid(Integer trxid) {
        this.trxid = trxid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQTY() {
        return QTY;
    }

    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
