package com.example.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
//todo:abstract , binary file

    public abstract class User implements Serializable {
        private static final long serialVersionUID = 1841367976866765392L;

        public int userId;
        public String password;
        public
        UserType userType ;

        //constructor

        public User() {
        }

        User(int id , String Password, UserType user){
            userId=id;
            this.password = Password;
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



        //trying
        /*static List<User> readCustomersFromFile(String filePath) {
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
        }*/
    }

