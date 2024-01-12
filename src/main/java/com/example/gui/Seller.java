package com.example.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seller extends User implements Serializable {
    private
    String sellerName;
    int sellerid;
    String email;
    Date StartDate = new Date();
    Date EndDate = new Date();
    List<Product> products;

    public Seller() {
    }

    public Seller(int id , String sellerName, String email, String password, UserType user) {
        super(id,password,user);
        this.sellerName = sellerName;
        this.email = email;

    }



    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerId() {
        return sellerid;
    }

    public void setSellerId(int sellerid) {
        this.sellerid = sellerid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    void addProduct(Product product) {
        products.add(product);
    }
    void removeProduct(Product product) {
        products.remove(product);
    }
    List<Product> ViewProducts(){
        return products;
    }
    ArrayList<String> viewOrders() {
        return orders;
    }
    void AverageRevenueOfOrders(){

    }
    void CalculateRevenue(){

    }
    public static Seller parse(String data) {
        String[] parts = data.split(",");
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        int sellerID = Integer.parseInt(parts[0].trim()); //casting from string to int
        String sellerName = parts[1];
        String email = parts[2];
        String password = parts[3];
        UserType seller = UserType.Seller;

        return new Seller(sellerID, sellerName, email, password, seller);
    }

    @Override
    public String toString() {
        return this.getid() + "," + this.sellerName + "," + this.email + "," + this.password;
    }

    public static int generateRandomID() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public void launchgui(){
        SellerGui.launch(SellerGui.class);
    }

    public static int GenerateRandomID() {

        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
    //comment
}
