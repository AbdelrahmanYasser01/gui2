package com.example.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = 8549695678159894382L;

    public
    int orderId ;
    int customerId;
    ArrayList<Product> Products = new ArrayList<>();
    ArrayList<String> details;
    String Totalamount;
    String Quantity ;
    int ProductId;
    String location;
    String Phonenumber;
    String Email;
    String name;
    Date StartDate = new Date();
    Date EndDate = new Date();
    Order(int id , int customerId , String name ,String Quantity , String totalamount , String location , String phone , String email ,ArrayList<Product> products  ){
        this.orderId=id;
        this.customerId=customerId;
        this.name=name;
        this.Quantity=Quantity;
        this.Totalamount=totalamount;
        this.Products=products;
        this.Email=email;
        this.Phonenumber=phone;
        this.location=location;

       // todo:write in uml
    }
    void NumofOrders (Date Start , Date End){
        //search in list and count
    }
    void viewOrdersDetails(){
        //print order details : address order phone email id
    }
    void PlaceOrder(){
        // confirm order -> go to payment
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + orderId +
                ", customerId=" + customerId +
                ", name='" + name + '\'' +
                ", quantity='" + Quantity + '\'' +
                ", totalAmount='" + Totalamount + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + Phonenumber + '\'' +
                ", email='" + Email + '\'' +
                ", products=" + Products +
                '}';
    }
}
