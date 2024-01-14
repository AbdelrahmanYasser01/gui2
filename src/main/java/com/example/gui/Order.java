package com.example.gui;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 8549695678159894382L;

    public
    int orderId ;
    int customerId;
    ArrayList<Product> Products = new ArrayList<>();
    String Totalamount;
    String Quantity ;
    String location;
    String Phonenumber;
    String Email;
    String name;
    Date orderDate = new Date();

    public Order() {
    }

    Order(int id , int customerId , String name , String Quantity , String totalamount , String location , String phone , String email , Date date , ArrayList<Product> products  ){
        this.orderId=id;
        this.customerId=customerId;
        this.name=name;
        this.Quantity=Quantity;
        this.Totalamount=totalamount;
        this.Products=products;
        this.Email=email;
        this.orderDate=date;
        this.Phonenumber=phone;
        this.location=location;

       // todo:write in uml
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int GetCustomerId() {
        return customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Product> products) {
        Products = products;
    }

    public String getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(String totalamount) {
        Totalamount = totalamount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private ArrayList<Order> readOrdersFromFile() {
        ArrayList<Order> orders = new ArrayList<>();

        String orderpath = "Order.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderpath))) {
            while (true) {
                try {
                    orders.add((Order) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return orders;
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
                ", orderDate=" + orderDate +
                ", products=" + Products +
                '}';
    }
    public static int GenerateRandomID() {

        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
