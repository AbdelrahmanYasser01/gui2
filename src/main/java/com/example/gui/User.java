package com.example.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//todo:abstract , binary file

    public class User {
        public int userId;
        public String password;
        public
        UserType userType ;
        Database database;
        Scanner scanner;
        //constructor
        User(int id , String Password, UserType user){
            userId=id;
            password = Password;
            //       userType= user;
        }
        ArrayList<String> orders;
        //Getters
        int getid(){

            return userId;
        }
        public String getPassword(){
            return password;
        }
        UserType getUserType(){

            return userType;
        }
        //Setters
        void setUserId(int id){
            userId=id;
        }
        void setPassword(String pass){
            password=pass;
        }
        void setUserType(UserType type){
            userType=type;
        }
        //methods
        void Login(int email , String password , UserType userType  ) throws IOException {
       /* switch (userType) {
            case com.example.gui.Admin -> {


                String filePath = "src/files/admin.txt";
                database = new com.example.gui.Database(filePath);
                database.start_read();
                ArrayList adminData = database.read("admin");
                database.close_read();
                boolean adminFound = false;
                for (Object AdminData : adminData) {
                    if (AdminData != null) {
                        com.example.gui.Admin admin = com.example.gui.Admin.parse(AdminData.toString());
                        if (admin != null && admin.getEmail().equals(signInEmail) && admin.getPassword().equals(signInPassword)) {
                            System.out.println("Sign In successful!");
                            adminFound = true;
                            break;
                        }
                        else {
                            System.out.println("failed");
                            System.exit(0);
                        }
                    }

                }

            }
            case com.example.gui.Customer -> {
                System.out.println("Signing In "); // Sign In logic
                System.out.print("Enter email: ");
                String signInEmail = scanner.nextLine();
                System.out.print("Enter password: ");
                String signInPassword = scanner.nextLine();

                //Search for the customer in the customer text file
                String filePath = "src/files/customer.txt";
                database = new com.example.gui.Database(filePath);
                database.start_read();
                ArrayList customersData = database.read("customer");

                database.close_read();
                boolean customerFound = false;
                for (Object customerData : customersData) {
                    com.example.gui.Customer customer = com.example.gui.Customer.parse( customerData.toString());
                    if (customer != null && customer.getEmail().equals(signInEmail) && customer.getPassword().equals(signInPassword)) {
                        System.out.println("Sign In successful!");
                        customerFound = true;
                        break;
                    }
                    else {
                        System.out.println("failed");
                        System.exit(0);
                    }

                }

            }
            case com.example.gui.Seller -> {
                System.out.println("Signing In "); // Sign In logic
                System.out.print("Enter email: ");
                String signInEmail = scanner.nextLine();
                System.out.print("Enter password: ");
                String signInPassword = scanner.nextLine();

                String filePath = "src/files/seller.txt";
                database = new com.example.gui.Database(filePath);
                database.start_read();
                ArrayList sellerData = database.read("seller");
                database.close_read();
                boolean sellerFound = false;
                for (Object SellerData : sellerData) {
                    if (SellerData != null) {
                        com.example.gui.Seller seller = com.example.gui.Seller.parse(SellerData.toString());
                        if (seller != null && seller.getEmail().equals(signInEmail) && seller.getPassword().equals(signInPassword)) {
                            System.out.println("Sign In successful!");
                            sellerFound = true;
                            break;
                        }
                        else {
                            System.out.println("failed");
                            System.exit(0);
                        }
                    }

                }
            }
        }
    }
      */
        }
        void signup(int id , String pass){
            // law costumer add in list of users plus list of costumers
        }
        //trying
        static List<User> readCustomersFromFile(String filePath) {
            List<User> customers = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(" ");
                    if (data.length == 3) {
                        String password = data[0];
                        int id = Integer.parseInt(data[1]);
                        UserType Type = UserType.valueOf(data[2]);
                        User user;

                        user = new User(id,password, Type);
                        customers.add(user);
                    } else {
                        System.out.println("Invalid data format: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return customers;
        }
    }

