package com.example.gui;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    public
    int orderId ;
    int customerId;
    ArrayList<Product> Products = new ArrayList<>();
    ArrayList<String> details;
    double Totalamount;
    int Quantity ;
    int ProductId;
    String location;
    String Phonenumber;
    String Email;
    String name;
    Date StartDate = new Date();
    Date EndDate = new Date();
    Order(int id , int customerId , String name ,int Quantity , double totalamount , String location , String phone , String email ,ArrayList<Product> products  ){
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
    //ay betngan
}
