package com.example.gui;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.ArrayList;

// TODO: after he signed in got to menu for admin , customer , seller
// todo : sign up page
// todo : binary files
// todo: ask abdelrahman's brother ( null oasswords / how to delete data from a binary file

public class HelloApplication extends Application {
    public static void main(String[] args) {

        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {
        AdminGui admin = new AdminGui();
        CustomerGui customer = new CustomerGui();
        SellerGui seller = new SellerGui();
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
        Text text3 = new Text("or if you don't have an account");
        Text text4 = new Text(" usertype :");

        TextField usertext=new TextField();

        PasswordField passtext = new PasswordField();

        ObservableList<String> o;
        o = FXCollections.observableArrayList("Admin","Seller","Customer");
        ComboBox cbx = new ComboBox(o);
        cbx.setValue("Select");

        String sc = (String) cbx.getValue();

        HelloApplication h1 = new HelloApplication();
        Button bt1 = new Button("sign in");

        ArrayList<Admin> adminslist = new ArrayList<>();
        ArrayList<Customer> customerlist = new ArrayList<>();
        ArrayList<Seller> Sellerlist = new ArrayList<>();
        bt1.setOnAction(e ->{
            //admin.start(stage));
            String selectedRole = (String)cbx.getValue();
            String username = usertext.getText();

            String pass = passtext.getText();
            h1.fillarraylist(adminslist);
            h1.fillarraylist2(customerlist);
            h1.fillarraylist3(Sellerlist);
            System.out.println(adminslist.toString());
            System.out.println(customerlist.toString());
            System.out.println(Sellerlist.toString());
            if ("Admin".equals(selectedRole)) {
                for (Admin admin6 : adminslist) {
                    if (username.equals(admin6.getAdminName()) && pass.equals(admin6.getpassword()) ) {
                        // search in file if pass and username
                        System.out.println("yes");
                        admin.start(stage);
                    } else {
                        System.out.println("wrong ");
                    }
                }
            }
            else if("Customer".equals(selectedRole)){
                for (Customer admin6 : customerlist) {
                    if (username.equals(admin6.getCustomerName()) && pass.equals(admin6.getpassword()) ) {
                        // search in file if pass and username
                        System.out.println("yes");
                        try {
                            customer.start(stage);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
            }
            else if ("Seller".equals(selectedRole)){
                for (Seller admin6 : Sellerlist) {
                    if (username.equals(admin6.getSellerName()) ) {
                        // search in file if pass and username
                        System.out.println("yes sir");

                    }
                }
            }
        });

        Button bt = new Button("sign up");
        GridPane pane = new GridPane();
        pane.setMinSize(400,200);
        pane.setPadding(new Insets(10,10,10,10));

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        pane.add(text4,0,0);
        pane.add(cbx,1,0);
        pane.add(text1,0,1);
        pane.add(text2,0,2);
        pane.add(usertext,1,1);
        pane.add(passtext,1,2);
        pane.add(bt1,1,3);
        pane.add(bt,1,5);
        pane.add(text3,0,5);
        // adding btns and labes to a grid pane
        bt1.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30 ");
        bt1.setPrefWidth(100);
        bt1.setOpacity(0.7);
        //bt2.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        //bt2.setPrefWidth(100);
        bt.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        bt.setPrefWidth(100);
        bt.setOpacity(0.7);

        text1.setStyle("-fx-font:normal  20px 'Montserrat' ");
        text1.setFill(Color.WHITE);

        text2.setStyle("-fx-font:normal  20px 'Montserrat' ");
        text2.setFill(Color.WHITE);

        text3.setStyle("-fx-font:normal 15px 'Montserrat'");
        text3.setFill(Color.WHITE);

        text4.setStyle("-fx-font:normal 20px 'Montserrat'");
        text4.setFill(Color.WHITE);
// setting btns and labels style
        Image image = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());
        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.5));
        background.setArcWidth(20);
        background.setArcHeight(20);
// adding image and background
        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView,background,pane);
        StackPane.setAlignment(pane, Pos.TOP_LEFT);

        layout.setMaxWidth(Region.USE_PREF_SIZE);
        layout.setMaxHeight(Region.USE_PREF_SIZE);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("login page");
// adding them to a stack
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth((double) newVal);
        });
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitHeight((double) newVal);
        });


        stage.show();


    }

    public static Boolean searchPerson(ArrayList<Admin> admins, String name, String password) {
        for (Admin person : admins) {
            if (name.equals(person.getAdminName()) && password.equals(person.getPassword())) {
                return true; // Found the person
            }
        }
        return false; // Person not found
    }
    // read file into arraylist
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
    public void fillarraylist2(ArrayList<Customer> list) {
        String fileName = "customer.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Customer>) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fillarraylist3(ArrayList<Seller> list) {
        String fileName = "seller.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Seller>) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

