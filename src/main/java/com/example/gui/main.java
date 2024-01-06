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

            Product p1 = new Product(0001,"low dunks",100.0);
            Product p2 = new Product(0002,"air force",80.0);
            Product p3 = new Product(0003,"jordan",200.0);
            ArrayList<Product> prodlist = new ArrayList<>();
            prodlist.add(p1);
            prodlist.add(p2);
            prodlist.add(p3);
            productdatabase.insert(prodlist);
            productdatabase.close_write();
            productdatabase.displayContent();
        }catch (IOException e) {
            e.printStackTrace();
        }
        //launch(args);
    }
}
