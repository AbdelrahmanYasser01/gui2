package com.example.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    static Product[] products;
    /*  database(){

          com.example.gui.Product[] products = {
                  new com.example.gui.Product(1001, "T-Shirt", 19.99),
                  new com.example.gui.Product(1002, "Jeans", 49.99),
                  new com.example.gui.Product(1003, "Sneakers", 39.99)
                  // Add more products as needed
          };
      }
  */
    private String file_path;
    private FileWriter write;
    private PrintWriter print_line;
    private Scanner read;
    private File file;
    public Database(String file_path) throws IOException {
        this.file_path = file_path;

    }

    public void start_write() throws IOException{
        this.write = new FileWriter(file_path, true);
        this.print_line = new PrintWriter(this.write);
    }


    public void insert(String data) throws IOException{
        this.print_line.println(data);
    }

    public void start_read() throws IOException{
        this.file = new File(this.file_path);
        this.read = new Scanner(this.file);

    }

    public ArrayList read(String type) throws IOException{
        ArrayList result = new ArrayList();
        while(this.read.hasNext()){
            String data = this.read.next();
            Object parsed_data = null;
            if(Objects.equals(type, "product")){
                parsed_data = Product.parse(data);
            }
            else if(Objects.equals(type, "customer")){
                // do something
                parsed_data = Customer.parse(data);
            }

            else if(Objects.equals(type, "seller")) {
                parsed_data = Seller.parse(data);
            }
            result.add(parsed_data);
        }
        return result;
    }

    public void close_write(){
        this.print_line.close();
    }

    public void close_read(){
        this.read.close();
    }
}
// ma3mlnash interface bec. there is no class that extends database class
