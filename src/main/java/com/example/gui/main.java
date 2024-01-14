package com.example.gui;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner ;
import static javafx.application.Application.launch;

public class main {
    private static final long serialVersionUID = 1841367976866765392L;

  public static void main(String[] args) throws IOException {
//        Stage main = new Stage();
//        HelloApplication h = new HelloApplication();
//       h.start(main);
        try {
            String productFilepath = "products.dat";
            Database productdatabase = new Database(productFilepath);
            //productdatabase.start_write();

            Product p1 = new Product(7890,"iphone 15 Pro",100000.0,"malak",5);
            Product p2 = new Product(1324,"airpods 2",10000.0,"malak",10);
            Product p3 = new Product(7233,"watch series 9",20000.0,"malak",7);
            Product p4 = new Product(2909,"iPad mini",50000.0,"abdulrahman",10);
            Product p5 = new Product(1098,"Macbook",15000.0,"abdulrahman",15);
            Product p6 = new Product(4657,"HomePod",10000.0,"abdulrahman",19);
            Product p7 = new Product(8345,"IMac",200000.0,"abdulrahman",5);
            Product p8 = new Product(7970,"IPad",70000.0,"abdulrahman",20);
            Product p9 = new Product(1342,"AirPod Max",30000.0,"malak",13);
            Product p10 = new Product(6087,"iPhone 15",90000.0,"malak",17);

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
            //productdatabase.insert(prodlist);
            //productdatabase.close_write();
            productdatabase.displayContent();

            String adminsfilepath = "admin.dat";
            Database admindatabase = new Database(adminsfilepath);
            //admindatabase.start_write();
            Admin a1 = new Admin(9867,"layla","layla@gmail.com","meshadra",UserType.Admin);
            Admin a2 = new Admin(1222,"nour","nour@gmail.com","aloyalayla",UserType.Admin);
            Admin a3 = new Admin(1212,"maya","secondn@gmail.com","mayasr",UserType.Admin);
            Admin a4 = new Admin(2444,"osama","osamaa@gmail.com","1234",UserType.Admin);
            Admin a5 = new Admin(5646,"kareem","krem@gmail.com","k1233",UserType.Admin);
            Admin a6 = new Admin(3535,"omar","or@gmail.com","2005",UserType.Admin);
            ArrayList<Object> admlist = new ArrayList<>();
            admlist.add(a1);
            admlist.add(a2);
            admlist.add(a3);
            admlist.add(a4);
            admlist.add(a5);
            admlist.add(a6);
            //admindatabase.insert(admlist);
            //admindatabase.close_write();
            admindatabase.displayContent();

            String sellerfilepath = "seller.dat";
            Database sellerdatabase = new Database(sellerfilepath);
            //sellerdatabase.start_write();
            Seller s1 = new Seller(0001,"malak","malak@gmail","password",UserType.Seller);
            Seller s2 = new Seller(0002,"abdulrahman","abdulrahman@gmail","word",UserType.Seller);
            Seller s3 = new Seller(0001,"adham","adham@gmail","1234",UserType.Seller);
            Seller s4 = new Seller(0002,"mai","mai@gmail","mai76",UserType.Seller);
            Seller s5 = new Seller(0001,"tarek","tarek@gmail","tarek1997",UserType.Seller);
            Seller s6 = new Seller(0002,"reem","reem@gmail","7890",UserType.Seller);
            ArrayList<Object> sellerlist = new ArrayList<>();
            sellerlist.add(s1);
            sellerlist.add(s2);
            sellerlist.add(s3);
            sellerlist.add(s4);
            sellerlist.add(s5);
            sellerlist.add(s6);
            //sellerdatabase.insert(sellerlist);
            //sellerdatabase.close_write();
            sellerdatabase.displayContent();

            String customerpath = "customer.dat";
            Database customerdatabase = new Database(customerpath);
           // customerdatabase.start_write();
            Customer c1 = new Customer(0001,"amina","maadi","abd@miu","01111111","1234",UserType.Customer);
            Customer c2 = new Customer(0001,"amin","nowhere","abd@miu","01111111","5678",UserType.Customer);
            Customer c3 = new Customer();
            int id = c3.GenerateRandomID();
            c3 = new Customer(id,"layla","orabi","layla@gmail.com","0110876688","12345678",UserType.Customer);
            Customer c4 = new Customer();
            int id2 = c4.GenerateRandomID();
            c4 = new Customer(id2,"nour","sherok","nour@hotmail.com","0123875999","0980",UserType.Customer);
            Customer c5 = new Customer();
            int id3 = c5.GenerateRandomID();
            c5 = new Customer(id3,"maryam","madinty","maryam12@gmail.com","011647888","0000",UserType.Customer);
            Customer c6 = new Customer();
            int id6 = c6.GenerateRandomID();
            c6 = new Customer(id6,"salma","sherok","salma@gmail.com","0100876688","1234",UserType.Customer);
            Customer c7 = new Customer();
            int id7 = c7.GenerateRandomID();
            c7 = new Customer(id7,"marwan","tagamo3","marwan88@gmail.com","0129076688","m2m",UserType.Customer);
            Customer c8 = new Customer();
            int id8 = c8.GenerateRandomID();
            c8 = new Customer(id8,"seif","obour","seifi@gmail.com","010006688","seif24",UserType.Customer);


            ArrayList<Object> customer =  new ArrayList<>();
            customer.add(c1);
            customer.add(c2);
            customer.add(c3);
            customer.add(c4);
            customer.add(c5);
            customer.add(c6);
            customer.add(c7);
            customer.add(c8);
            //customerdatabase.insert(customer);
           //customerdatabase.close_write();
           customerdatabase.displayContent();
//
            System.out.println( "hello");

            String orderpath = "Order.dat";


            Database m = new Database(orderpath);

            m.displayContent();

        }catch (IOException e) {
            e.printStackTrace();
        }
        //launch(args);
    }
}
