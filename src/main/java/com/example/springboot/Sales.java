package com.example.springboot;

public class Sales {

    private Integer sales_id;
    private String seller;
    private String purchaser;
    private Float price;

    public Sales(Integer sales_id, String seller, String purchaser, Float price) {
        this.sales_id = sales_id;
        this.seller = seller;
        this.purchaser = purchaser;
        this.price = price;
    }

    public Sales(Integer sales_id, String seller, Float price) {
        this.sales_id = sales_id;
        this.seller = seller;
        this.price = price;
    }

    public Integer getSales_id() {
        return sales_id;
    }

    public void setSales_id(Integer sales_id) {
        this.sales_id = sales_id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sales [sales_id=" + sales_id + ", seller=" + seller + ", purchaser=" + purchaser + ", price=" + price
                + "]";
    }
}
