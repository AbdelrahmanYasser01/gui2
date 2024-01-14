package com.example.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Customer extends User implements Serializable{
    //comment
    private static final long serialVersionUID = 6921455283210236562L; // Or use the original value


    private
    String CustomerName;
    String address;
    String Email;
    String Phonenum;
    int Id;
    int numoforders;
    String password;

    Order[] order = new Order[numoforders];
    private ArrayList<Product> Cart = new ArrayList<>();

    public Customer() {
    }

    public Customer(int Id, String Name, String location, String email, String phone, String Password, UserType user) {
        super(Id, Password, user);
        CustomerName = Name;
        address = location;
        Email = email;
        Phonenum = phone;
        this.password = Password;
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getpassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return CustomerName;
    }


    ArrayList<Product> searchproducts(String name , ArrayList<Product> products){
       ArrayList<Product> product = new ArrayList<>();
        if(name.isEmpty()){
            System.out.print(products);
        }else{
            for (Product item : products) {
                if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                    product.add(item);
                }
            }
        }
        return product;
    }

    Order DetailedOrders(int CostId,ArrayList<Order> order) {
        //search in list and print the orders
        for (Order order1 : order) {
            if (order1.GetCustomerId() == CostId) {
                return order1; // Found the order
            }
        }
        return null;
    }
    // get cost name then search w name and between times provided
    ArrayList<Order> specifiedDateOrder(Date Startdate , Date enddate , String name , ArrayList<Order> orders){
        ArrayList<Order> specifiedorder = new ArrayList<>();
        for (Order order : orders) {
            if (order.getName().equalsIgnoreCase(name)) {
                Date orderDate = order.getOrderDate();
                if (orderDate.after(Startdate) && orderDate.before(enddate)) {
                    specifiedorder.add(order);
                }
            }
        }
        return  specifiedorder;
    }
    int countSpecifiedDateOrders(Date startDate, Date endDate, String name, ArrayList<Order> orders) {
        int count = 0;

        for (Order order : orders) {
            if (order.getName().equalsIgnoreCase(name)) {
                Date orderDate = order.getOrderDate();
                if (orderDate.after(startDate) && orderDate.before(endDate)) {
                    count++;
                }
            }
        }

        return count;
    }

    void CreateCart(Product product,ArrayList<Product> Cart) {
        Cart.add(product);
    }
    ArrayList<Order> Checkout(ArrayList<Product> Cart , String Quantity , String Amount ,int cid ,String name,String email , String Location , String phone ,Date date ){
        ArrayList<Order> order = new ArrayList<>();
        int id = GenerateRandomID();

        Order order1 = new Order(id,cid,name,Quantity,Amount,Location,phone,email,date,Cart);
        order.add(order1);
        return order;
        // baaden append ala el binaryfile bel list deh
    }
    void CancelCart(ArrayList<Product> Cart) {
        Cart.clear();
    }
    //
    void addToCart(Product product,ArrayList<Product> Cart) {

        Cart.add(product);
    }

    void RemoveFromCart(Product product,ArrayList<Product> Cart) {
        if(Cart.contains(product)){
            Cart.remove(product);
        }
        else System.out.println("   product isnt in cart   ");
    }


    public static Customer parse(String data) {
        String[] parts = data.split(",");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        int customerID = Integer.parseInt(parts[0].trim());
        String customerName = parts[1];
        String Address = parts[2];
        String email = parts[3];
        String phone = parts[4];
        String password = parts[5];
        UserType user = UserType.Customer;


        return new Customer(customerID, customerName, Address, email, phone, password, user);

    }  // text file
    @Override
    public String toString() {
        return this.getid() + "," + this.CustomerName + "," + this.address + "," + this.Email + "," + this.Phonenum + "," + this.password;
    } // text files

    public static int GenerateRandomID() {

        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public void launchgui(){
        CustomerGui.launch(CustomerGui.class);
    }
}
