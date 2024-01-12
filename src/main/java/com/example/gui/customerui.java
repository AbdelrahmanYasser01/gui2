package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class customerui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("hello");


        StackPane stack1 = new StackPane();
        Rectangle sBackground = new Rectangle(707, 75, Color.rgb(255, 255, 255, 0.2));
        sBackground.setArcHeight(90);
        sBackground.setArcWidth(90);
        Text search = new Text("search customer");
        TextField searchbar = new TextField("search");
        Button btn = new Button("search");
        btn.setStyle("-fx-background-color: rgba(255, 182, 193, 0.5);");
        searchbar.setOpacity(0.2);
        search.setStyle("-fx-font:normal  20px 'IMPACT' ");
        search.setFill(Color.LIGHTPINK);
        searchbar.setPrefHeight(20);
        searchbar.setPrefWidth(200);
        HBox searching = new HBox(search,searchbar);
        VBox searchingv = new VBox(10,searching,btn);
        searchingv.setAlignment(Pos.CENTER);
        searching.setAlignment(Pos.CENTER);
        stack1.getChildren().addAll(sBackground,searchingv);


        StackPane addcustomer = new StackPane();
        Rectangle aBackground = new Rectangle(707, 255,Color.rgb(255, 255, 255, 0.2));
        aBackground.setArcWidth(90);
        aBackground.setArcHeight(90);
        Text add = new Text("  name :");
        TextField addfield = new TextField("name");
        addfield.setOpacity(0.2);
        add.setStyle("-fx-font:normal  20px 'IMPACT' ");
        add.setFill(Color.LIGHTPINK);

        //customer -> ,pass
        Text location = new Text("location :");
        TextField addloc = new TextField("location");
        addloc.setOpacity(0.2);
        location.setStyle("-fx-font:normal  20px 'IMPACT' ");
        location.setFill(Color.LIGHTPINK);

        Text email = new Text("email :");
        TextField emailadd = new TextField("mail");
        emailadd.setOpacity(0.2);
        email.setStyle("-fx-font:normal  20px 'IMPACT' ");
        email.setFill(Color.LIGHTPINK);

        Text phone = new Text("phone :");
        TextField phoneadd = new TextField("number");
        phoneadd.setOpacity(0.2);
        phone.setStyle("-fx-font:normal  20px 'IMPACT' ");
        phone.setFill(Color.LIGHTPINK);

        Text password = new Text("password :");
        TextField pass = new TextField("password");
        pass.setOpacity(0.2);
        password.setStyle("-fx-font:normal  20px 'IMPACT' ");
        password.setFill(Color.LIGHTPINK);

        Label title = new Label ("Add customer");
        title.setStyle("-fx-font:normal  15px 'IMPACT' ");
        title.setTextFill(Color.LIGHTPINK);
        Button btn2 = new Button("Add Customer");


        btn2.setStyle("-fx-background-color: rgba(255, 182, 193, 0.5);");
        VBox fields = new VBox(10,addfield,addloc,emailadd,phoneadd,pass);
        VBox labels = new VBox(10,add,location,email,phone,password);

        HBox addingpart = new HBox(10,labels,fields);
        VBox adding1 = new VBox(10,title,addingpart,btn2);
        adding1.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);
        btn2.setAlignment(Pos.CENTER);
        addingpart.setAlignment(Pos.CENTER);
        addcustomer.getChildren().addAll(aBackground,adding1);


       StackPane removecustomerpane = new StackPane();
       Rectangle rBackground= new Rectangle(707, 230,Color.rgb(255, 255, 255, 0.2));
       rBackground.setArcHeight(90);
       rBackground.setArcWidth(90);
       Text remove = new Text("remove :");
       remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
       remove.setFill(Color.LIGHTPINK);
       TextField rem = new TextField("customer");
       rem.setOpacity(0.2);
       Button btn3 = new Button("remove customer");
       btn3.setStyle("-fx-background-color: rgba(255, 182, 193, 0.5);");
       HBox a = new HBox(10,remove,rem);
       VBox q = new VBox(10,a,btn3);
       a.setAlignment(Pos.CENTER);
       q.setAlignment(Pos.CENTER);
       removecustomerpane.getChildren().addAll(rBackground,q);

       VBox right = new VBox(10,stack1,addcustomer,removecustomerpane);
       right.setAlignment(Pos.CENTER);


        Image image = new Image("https://www.apple.com/v/iphone-15/c/images/overview/design/design_endframe__cb31n5bv6082_large.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        ArrayList<Customer> alist = new ArrayList<>();
        Customer cust = new Customer();
        fillarraylist(alist);
        System.out.println(alist);
        ObservableList<Customer> c = FXCollections.observableArrayList(alist);
        ListView<Customer> listview = new ListView<>(c);
        listview.setStyle("-fx-background-color: transparent;");


        btn.setOnAction(event ->{
            String value = searchbar.getText().trim();
            if(value.isEmpty()){
                listview.setItems(c);
            }
            else{
                ObservableList<Customer> cs = filterItems(c,value);
                listview.setItems(cs);
                if(c.isEmpty()){
                    noCustomerFound("Custumer not found", "make sure to type correctly");
                }
            }
        });

        ArrayList<Customer> cus = new ArrayList<>();
        fillarraylist(cus);
        String path ="customer.dat";
        Database db = new Database(path);

        btn2.setOnAction(event->{
            ArrayList<Customer> customer = new ArrayList<>(c);
            Customer user= new Customer();
            int id = user.GenerateRandomID();
            String name = addfield.getText();
            String loc = addloc.getText();
            String password1 = pass.getText();
            String email1 = emailadd.getText();
            String phone1 = phoneadd.getText();
            user = new Customer(id,name,loc,email1,phone1,password1,UserType.Customer);
            customer.add(user);
            try{
             db.start_write();
             db.insert(customer);
             db.close_write();
            } catch(IOException ee){
                throw  new RuntimeException(ee);
            }
            ObservableList<Customer> ö = FXCollections.observableArrayList(customer);
            listview.setItems(ö);
            db.displayContent();
        });

        btn3.setOnAction(event-> {
            ArrayList<Customer> remcust = new ArrayList<>(c);
            Iterator<Customer> iterator = remcust.iterator();
            String name = rem.getText();
            while (iterator.hasNext()){
                Customer custom = iterator.next();
                if(custom.getCustomerName().toLowerCase().contains(name.toLowerCase())){
                    iterator.remove();
                }
            }

            try {
                db.start_write();
                db.insert(remcust);
                db.close_write();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ObservableList<Customer> v = FXCollections.observableArrayList(remcust);
            listview.setItems(v);
            db.displayContent();

        });
        HBox back = new HBox(10,listview,right);
        StackPane pane = new StackPane();
        pane.getChildren().addAll(imageView,back);






        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private ObservableList<Customer> filterItems(ObservableList<Customer> originalList, String filter) {
        ObservableList<Customer> filteredList = FXCollections.observableArrayList();

        for (Customer item : originalList) {
            if (item.getCustomerName().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }
    private void noCustomerFound(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void fillarraylist(ArrayList<Customer> list) {
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
}
