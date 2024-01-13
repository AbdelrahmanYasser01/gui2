package com.example.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productID;
    private String productName;
    private double price;
    private int quantity;

    private String seller;



    public Product() {
    }

    public Product(int productID, String productName, double price , String seller ,int Quantity){ // todo: hoteh quantity // seller name
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
        this.quantity=Quantity;
    }
    int getId(){
        productID = GenerateRandomID();
        return productID;
    }
    String getName(){
        return productName;
    }
    Double getPrice(){
        return price;
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

    void setQuantity(int Quantity){
        quantity=Quantity;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }



    //Converts a string line coming from the txt file into an object of product.
    public static Product parse(String data) {
        String[] parts = data.split(",");

        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }

        try {
            int productID = Integer.parseInt(parts[0].trim());
            String productName = parts[1].trim();
            double price = Double.parseDouble(parts[2].trim());
            String sellerName = parts[3].trim();  // Adjusted index for sellerName
            int quantity = Integer.parseInt(parts[4].trim());  // Adjusted index for quantity

            return new Product(productID, productName, price, sellerName, quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format in data: " + data, e);
        }
    }


    @Override
    public String toString() {
        return String.format("%d, %s, %.2f, %s, %d", productID, productName, price, seller, quantity);
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // Add custom serialization logic if needed
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Add custom deserialization logic if needed
    }
    public static int GenerateRandomID() {

        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }

//comment
}
