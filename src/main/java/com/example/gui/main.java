package com.example.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner ;
import static javafx.application.Application.launch;

public class main {

    public static void main(String[] args)  {
        try {
            String productFilepath = "products.dat";
            Database productdatabase = new Database(productFilepath);
            productdatabase.start_write();

            Product p1 = new Product(0001,"low dunks",100.0);
            Product p2 = new Product(0002,"air force",80.0);

            ArrayList<Product> prodlist = new ArrayList<>();
            prodlist.add(p1);
            prodlist.add(p2);


            productdatabase.insert(prodlist);
            productdatabase.close_write();
        }catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
