package com.example.gui;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = -5387575740051064873L;
    private int Adminid;
    private String adminName;
    private String email;
    private Product prod;
    private Date StartDate;
    private Date EndDate;
    static private List<Product> products;
    static private List<User> users;



    public Admin() {
        // default constructor
    }

    public Admin(int adminid, String adminName, String email, String password, UserType admin) {
        super(adminid, password, admin);
        this.products = new ArrayList<>();
        this.adminName = adminName;
        this.email = email;
    }
    int getid(){
        return Adminid;
    }
    public String getpassword(){
        return password ;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {

        this.adminName = adminName;
    }




   //adding user and products

    void Addproduct(ArrayList<Product> products,Product product){
        products.add(product);
    }
    void removeProduct(ArrayList<Product> products,Product product) {
        products.remove(product);
    }
    public void editProduct(ArrayList<Product> products , String prodname,int id ,String newProductName, double newPrice, String newSeller, int newQuantity) {
        Product product = new Product();
        product = new Product(id,newProductName,newPrice,newSeller,newQuantity);
        for (Product item : products) {
            if (item.getName().toLowerCase().contains(prodname.toLowerCase())) {
                products.remove(item);
                products.add(product);
            }
        }
    }
    ArrayList<Product> searchproducts(String name , ArrayList<Product> products){
        ArrayList<Product> product = new ArrayList<>();
        if(name.isEmpty()){
            System.out.print(products);
        }else{
            for (Product item : products) {
                if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(item);
                    product.add(item);
                }
            }
        }
        return product;
    }
    void Addcustomer(ArrayList<Customer> customers,Customer customer){
        customers.add(customer);
    }
    void removecustomer(ArrayList<Customer> customers,Customer customer) {
        customers.remove(customer);
    }
    public void editCust(ArrayList<Customer> customers , String name,int id ,String newname,String newlocation, String newemail, String newphone,String newpass) {
        Customer cust = new Customer();
        cust = new Customer(id,newname,newlocation,newemail,newphone,newpass,UserType.Customer);
        for (Customer item : customers) {
            if (item.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                customers.remove(item);
                customers.add(cust);
            }
        }
    }
    ArrayList<Customer> searchcustomers(String name , ArrayList<Customer> customers){
        ArrayList<Customer> cust = new ArrayList<>();
        if(name.isEmpty()){
            System.out.print(customers);
        }else{
            for (Customer item : customers) {
                if (item.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(item);
                    cust.add(item);
                }
            }
        }
        return cust;
    }
    void Addseller(ArrayList<Seller> sellers,Seller seller){
        sellers.add(seller);
    }
    void removeseller(ArrayList<Seller> sellers,Seller seller) {
        sellers.remove(seller);
    }

    public void editseller(ArrayList<Seller> sellers , String name,int id ,String newname, String newemail,String newpass) {
        Seller sel = new Seller();
        sel = new Seller(id,newname,newemail,newpass,UserType.Seller);
        for (Seller item : sellers) {
            if (item.getSellerName().toLowerCase().contains(name.toLowerCase())) {
                sellers.remove(item);
                sellers.add(sel);
            }
        }
    }
    ArrayList<Seller> searchsellers(String name , ArrayList<Seller> sellers){
        ArrayList<Seller> sel = new ArrayList<>();
        if(name.isEmpty()){
            System.out.print(sellers);
        }else{
            for (Seller item : sellers) {
                if (item.getSellerName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(item);
                    sel.add(item);
                }
            }
        }
        return sel;
    }

    public void vieworders(){}

    public void AverageRevenueoford(){}

    public void calculateRevenue(){}

    public void customerMaxOrders(){}

    public void customerMaxRevenue(){}

    public void listOfsuppliers(){}

    public void SuppliersPricing(){}

    public static Admin parse(String data) {
        String[] parts = data.split(",");
        if (parts.length < 4) {
            throw new IllegalArgumentException("invalid data format: "+ data);
        }
        int adminID = Integer.parseInt(parts[0].trim());
        String adminName = parts[1];
        String email = parts[2];
        String password = parts[3];
        UserType admin = UserType.Admin;

        return new Admin(adminID, adminName, email, password, admin);
    }

    @Override
    public String toString() {
        return this.userId + "," + this.adminName + "," + this.email + "," + this.password;
    }
    public void fillarraylist(ArrayList<Admin> list) {
        String fileName = "admin.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Admin>) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int GenerateRandomID() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public void launchgui(){
        AdminGui.launch(AdminGui.class);
    }

}
