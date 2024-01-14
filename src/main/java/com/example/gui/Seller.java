package com.example.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seller extends User implements Serializable {
    private static final long serialVersionUID = -8580606279018224531L;

    private
    String sellerName;
    int sellerid;
    String email;
    String password ;
    Date StartDate = new Date();
    Date EndDate = new Date();
    List<Product> products;

    public Seller() {
    }

    public Seller(int id , String sellerName, String email, String password, UserType user) {
        super(id,password,user);
        this.sellerid=id;
        this.sellerName = sellerName;
        this.email = email;
        this.password = password;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    void Addproduct(ArrayList<Product> products, Product product){
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
    public double AverageRevenueOfOrders(ArrayList<Order> orders){
        double total=0.0;
        int i=0;
        for(Order order : orders){
            double total1 = Double.parseDouble(order.getTotalamount());
            total+=total1;
            i++;
        }
        if(i==0)
            return 0;
        return total/i;
    }
    public double CalculateRevenue(ArrayList<Order> orders){
        double total=0.0;
        for(Order order: orders){
            double total1 = Double.parseDouble(order.getTotalamount());
            total+=total1;
        }
        return total;
    }
    public void ViewOrderDetails(ArrayList<Order> orders){
        System.out.println(sellerName+"'s Order Details:");
        for(Order order: orders){
            System.out.println("Order ID: "+order.getOrderId());
            System.out.println("Customer ID: "+order.getCustomerId());
            System.out.println("Total Amount: "+order.getTotalamount());
            System.out.println("Products:");
            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + " $" + product.getPrice());
            }
            System.out.println("------------------");
        }

    }



    public String getSellerName() {
        return sellerName;
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
