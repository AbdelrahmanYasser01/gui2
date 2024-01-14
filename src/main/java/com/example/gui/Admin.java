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



    //_______________________________________________________________________________
    //_________________________________adding user and products______________________________________________
    //_______________________________________________________________________________
    public User addUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter user id");
        int userID = scanner.nextInt();

        System.out.println("Please enter user password");
        String userPass = scanner.next();

        //return new User(userID, userPass, userType);

        return null;
    }


    //________________________________________________________________________________
    //________________________remove user and product_________________________________
    //________________________________________________________________________________

    public void removeUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the ID of the user to remove:");
        int userId = scanner.nextInt();


        for (User User : users) {
            if (User.getid() == userId) {
                users.remove(User);
                break;
            }
            System.out.println("Thank You!! com.example.gui.Product removed successfully.");
        }
        System.out.println("Sorry! com.example.gui.User not found.");

    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter the ID of the product to remove:");
        int productId = scanner.nextInt();

        boolean removed = false;
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Thank You!! com.example.gui.Product removed successfully.");
        } else {
            System.out.println("Sorry! com.example.gui.Product not found.");
        }
    }

    //____________________________________________________________________________
    //________________________editting user and products__________________________
    //____________________________________________________________________________

    public void editUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the ID of the product to edit:");
        int UserId = scanner.nextInt();

        boolean foundUser = false;

        for(User user : users){

            if(user.getid() == UserId){
                foundUser = true;

                System.out.println("Please Enter new ID (current ID is " + user.getid() + ") :");
                int newID = scanner.nextInt();
                user.setUserId(newID);

                System.out.println("Please Enter new password (current password is " + user.getPassword() + ") :");
                String newpass = scanner.next();
                user.setPassword(newpass);

                break;
            }

        }
        if(foundUser == true)
            System.out.println("com.example.gui.User succesfully Edited!");
        else
            System.out.println("com.example.gui.User not found!");
    }





    public void listUser(){
        if (users.isEmpty()) {
            System.out.println("Sorry! No users found .");
            return;
        }
        System.out.println("List of Current Users:");
        for (User user : users) {
            System.out.println("        ");
            System.out.println("ID: " + user.getid());
            System.out.println("Password: " + user.getPassword());
            System.out.println("----------------------");
        }
    }



    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Sorry! No products found .");
            return;
        }

        System.out.println("List of Current Products:");
        for (Product product : products) {
            System.out.println("        ");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Supplier: " + product.getSeller());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("----------------------");
        }
    }

    //____________________________________________________________________________
    //___________________________Searching Users and products_____________________
    //____________________________________________________________________________

    public void searchUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter the search by ID:");
        int query1 = scanner.nextInt();

        List<User> searchResults1 = new ArrayList<>();
        for (User user : users) {
            if (user.getid() == query1) {
                searchResults1.add(user);
            }
        }
        if (searchResults1.isEmpty()) {
            System.out.println("Sorry! No users found matching the searched ID.");
        } else {
            System.out.println("Search results:");
            for (User user : searchResults1) {
                System.out.println("ID: " + user.getid());
                System.out.println("Password: " + user.getPassword());
                System.out.println("----------------------");
            }
        }
    }

    public void searchProducts() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter the search by Name:");
        String query = scanner.next();

        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(query)) {
                searchResults.add(product);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("Sorry! No products found matching the searched name.");
        } else {
            System.out.println("Search results:");
            for (Product product : searchResults) {
                System.out.println("ID: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Supplier: " + product.getSeller());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("----------------------");
            }
        }
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
