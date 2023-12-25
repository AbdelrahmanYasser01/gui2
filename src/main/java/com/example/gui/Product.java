package com.example.gui;

import java.util.Date;

public class Product {
    private int productID;
    private String productName;
    private double price;
    private int quantity;
    private Seller seller;
    private Date StartDate = new Date();
    private Date EndDate = new Date();

    public Product(int productID, String productName,double price){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }
    int getId(){
        return productID;
    }
    String getName(){
        return productName;
    }
    Double getPrice(){
        return price;
    }
    Seller getSeller(){
        return seller;
    }
    int getQuantity(){
        return quantity;
    }
    void setId(int id){
        productID=id;
    }
    void setName(String name){
        productName=name;
    }
    void setPrice(Double Price){
        price=Price;
    }
    public void setSeller(int id, String password, String sellerName, String email1, String start, String end) {

    }
    void setQuantity(int Quantity){
        quantity=Quantity;
    }

    public void numOfProductsSold() {

    }
    public void bestSellerProduct() {

    }
    public void mostRevenueMadeFromProduct() {

    }

    //Converts a string line coming from the txt file into an object of product.
    public static Product parse(String data){
        String[] parts = data.split(",");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }

        int productID = Integer.parseInt(parts[0].trim()); //casting from string to int
        String productName = parts[1];
        double price = Double.parseDouble(parts[2].trim()); //casting from string to double

        return new Product(productID, productName, price);
    }

    @Override
    public String toString(){
        return this.productID+","+this.productName + ","+ this.price;
    }

//comment
}
