package com.example.gui;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner ;
import static javafx.application.Application.launch;

public class main {

  public static void main(String[] args) throws IOException {
//        Stage main = new Stage();
//        HelloApplication h = new HelloApplication();
//       h.start(main);
        try {
            String productFilepath = "products.dat";
            Database productdatabase = new Database(productFilepath);
            productdatabase.start_write();

            Product p1 = new Product(0001,"iphone 15 Pro",100000.0);
            Product p2 = new Product(0002,"airpods 2",10000.0);
            Product p3 = new Product(0003,"watch series 9",20000.0);
            Product p4 = new Product(0004,"iPad mini",50000.0);
            Product p5 = new Product(0005,"Macbook",15000.0);
            Product p6 = new Product(0006,"HomePod",10000.0);
            Product p7 = new Product(0007,"IMac",200000.0);
            Product p8 = new Product(8,"IPad",70000.0);
            Product p9 = new Product(9,"AirPod Max",30000.0);
            Product p10 = new Product(9,"iPhone 15",90000.0);

            ArrayList<Product> prodlist = new ArrayList<>();
            prodlist.add(p1);
            prodlist.add(p2);
            prodlist.add(p3);
            prodlist.add(p4);
            prodlist.add(p5);
            prodlist.add(p6);
            prodlist.add(p7);
            prodlist.add(p8);
            prodlist.add(p9);
            prodlist.add(p10);
            productdatabase.insert(prodlist);
            productdatabase.close_write();
            productdatabase.displayContent();

            String adminsfilepath = "admin.dat";
            Database admindatabase = new Database(adminsfilepath);
            admindatabase.start_write();
            Admin a1 = new Admin(0001,"layla","layla@gmail.com","meshadra",UserType.Admin);
            Admin a2 = new Admin(0002,"nour","nour@gmail.com","aloyalayla",UserType.Admin);
            Admin a3 = new Admin(0003,"noureltanya","secondnour@gmail.com","gebtakhry",UserType.Admin);
            ArrayList<Object> admlist = new ArrayList<>();
            admlist.add(a1);
            admlist.add(a2);
            admlist.add(a3);
            admindatabase.insert(admlist);
            admindatabase.close_write();
            admindatabase.displayContent();

            String sellerfilepath = "seller.dat";
            Database sellerdatabase = new Database(sellerfilepath);
            sellerdatabase.start_write();
            Seller s1 = new Seller(0001,"malak","malak@gmail","password",UserType.Seller);
            Seller s2 = new Seller(0002,"moka","malak@gmail","word",UserType.Seller);
            ArrayList<Object> sellerlist = new ArrayList<>();
            sellerlist.add(s1);
            sellerlist.add(s2);
            sellerdatabase.insert(sellerlist);
            sellerdatabase.close_write();
            sellerdatabase.displayContent();

            String customerpath = "customer.dat";
            Database customerdatabase = new Database(customerpath);
            customerdatabase.start_write();
            Customer c1 = new Customer(0001,"amina","maadi","abd@miu","01111111","1234",UserType.Customer);
            Customer c2 = new Customer(0001,"amin","nowhere","abd@miu","01111111","5678",UserType.Customer);
            ArrayList<Object> customer =  new ArrayList<>();
            customer.add(c1);
            customer.add(c2);
            customerdatabase.insert(customer);
            customerdatabase.close_write();
            customerdatabase.displayContent();


            String orderpath = "Order.dat";


            Database m = new Database(orderpath);

            m.displayContent();

        }catch (IOException e) {
            e.printStackTrace();
        }
        //launch(args);
    }
}
