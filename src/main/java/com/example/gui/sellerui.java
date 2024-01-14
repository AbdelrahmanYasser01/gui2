package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class sellerui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("hello");


        StackPane stack1 = new StackPane();
        Rectangle sBackground = new Rectangle(707, 190, Color.rgb(255, 255, 255, 0.2));
        sBackground.setArcHeight(90);
        sBackground.setArcWidth(90);
        Text showmyproducts = new Text("Show my products");
        TextField yourproducts = new TextField("enter your name ");
        Button shwbtn = new Button("Show");
        shwbtn.setStyle("-fx-background-color: rgba(255, 182, 193, 0.5);");
        yourproducts.setOpacity(0.2);
        showmyproducts.setStyle("-fx-font:normal  20px 'IMPACT' ");
        showmyproducts.setFill(Color.LIGHTPINK);
        yourproducts.setPrefHeight(20);
        yourproducts.setPrefWidth(200);
        Text search = new Text("search product");
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
        HBox showingf = new HBox(showmyproducts,yourproducts);
        VBox show = new VBox(10,showingf,shwbtn);
        VBox all = new VBox(10,searchingv,show);
        searchingv.setAlignment(Pos.CENTER);
        searching.setAlignment(Pos.CENTER);
        show.setAlignment(Pos.CENTER);
        showingf.setAlignment(Pos.CENTER);
        all.setAlignment(Pos.CENTER);
        stack1.getChildren().addAll(sBackground,all);


        StackPane addcustomer = new StackPane();
        Rectangle aBackground = new Rectangle(707, 255,Color.rgb(255, 255, 255, 0.2));
        aBackground.setArcWidth(90);
        aBackground.setArcHeight(90);
        Text add = new Text("  name :");
        TextField addfield = new TextField("product name");
        addfield.setOpacity(0.2);
        add.setStyle("-fx-font:normal  20px 'IMPACT' ");
        add.setFill(Color.LIGHTPINK);


        Text location = new Text("price :");
        TextField addloc = new TextField("price");
        addloc.setOpacity(0.2);
        location.setStyle("-fx-font:normal  20px 'IMPACT' ");
        location.setFill(Color.LIGHTPINK);

        Text email = new Text("seller name :");
        TextField emailadd = new TextField("name");
        emailadd.setOpacity(0.2);
        email.setStyle("-fx-font:normal  20px 'IMPACT' ");
        email.setFill(Color.LIGHTPINK);

        Text phone = new Text("Quantity  :");
        TextField phoneadd = new TextField("number");
        phoneadd.setOpacity(0.2);
        phone.setStyle("-fx-font:normal  20px 'IMPACT' ");
        phone.setFill(Color.LIGHTPINK);



        Label title = new Label ("Add product");
        title.setStyle("-fx-font:normal  15px 'IMPACT' ");
        title.setTextFill(Color.LIGHTPINK);
        Button btn2 = new Button("Add product");


        btn2.setStyle("-fx-background-color: rgba(255, 182, 193, 0.5);");
        VBox fields = new VBox(10,addfield,addloc,emailadd,phoneadd);
        VBox labels = new VBox(10,add,location,email,phone);

        HBox addingpart = new HBox(10,labels,fields);
        VBox adding1 = new VBox(10,title,addingpart,btn2);
        adding1.setAlignment(Pos.CENTER);
        title.setAlignment(Pos.CENTER);
        btn2.setAlignment(Pos.CENTER);
        addingpart.setAlignment(Pos.CENTER);
        addcustomer.getChildren().addAll(aBackground,adding1);


        StackPane removecustomerpane = new StackPane();
        Rectangle rBackground= new Rectangle(707, 110,Color.rgb(255, 255, 255, 0.2));
        rBackground.setArcHeight(90);
        rBackground.setArcWidth(90);
        Text remove = new Text("remove :");
        remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
        remove.setFill(Color.PINK);
        TextField rem = new TextField("product");
        rem.setOpacity(0.2);
        Button btn3 = new Button("remove product");
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

        ArrayList<Product> alist = new ArrayList<>();
        Product cust = new Product();
        fillarraylist(alist);
        System.out.println(alist);
        ObservableList<Product> c = FXCollections.observableArrayList(alist);
        ListView<Product> listview = new ListView<>(c);
        listview.setStyle("-fx-background-color: transparent;");


        btn.setOnAction(event ->{
            String value = searchbar.getText().trim();
            if(value.isEmpty()){
                listview.setItems(c);
            }
            else{
                ObservableList<Product> cs = filterItems(c,value);
                listview.setItems(cs);
                if(c.isEmpty()){
                    noCustomerFound("product not found", "make sure to type correctly");
                }
            }
        });

        ArrayList<Product> cus = new ArrayList<>();
        fillarraylist(cus);
        String path ="products.dat";
        Database db = new Database(path);

        btn2.setOnAction(event->{
            ArrayList<Product> product = new ArrayList<>(c);
            Product user= new Product();
            int id = user.GenerateRandomID();
            String name = addfield.getText();
            String loc = addloc.getText();
            double price = Double.parseDouble(loc);
            String email1 = emailadd.getText();
            String phone1 = phoneadd.getText();
            int quantity = Integer.parseInt(phone1);
            user = new Product(id,name,price,email1,quantity);
            product.add(user);
            try{
                db.start_write();
                db.insert(product);
                db.close_write();
            } catch(IOException ee){
                throw  new RuntimeException(ee);
            }
            ObservableList<Product> ö = FXCollections.observableArrayList(product);
            listview.setItems(ö);
            db.displayContent();
        });

        btn3.setOnAction(event-> {
            ArrayList<Product> remcust = new ArrayList<>(c);
            Iterator<Product> iterator = remcust.iterator();
            String name = rem.getText();
            while (iterator.hasNext()){
                Product custom = iterator.next();
                if(custom.getName().toLowerCase().contains(name.toLowerCase())){
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
            ObservableList<Product> v = FXCollections.observableArrayList(remcust);
            listview.setItems(v);
            db.displayContent();

        });
        shwbtn.setOnAction(e->{
            String name = yourproducts.getText();
            if(name.isEmpty()){
                listview.setItems(c);
            }
            else{
                ObservableList<Product> cs = filter(c,name);
                listview.setItems(cs);
                if(c.isEmpty()){
                    noCustomerFound("product not found", "you didnt display any products");
                }
            }
        });
        HelloApplication h = new HelloApplication();
        Button prevbtn = new Button("previous page");
        prevbtn.setAlignment(Pos.BOTTOM_LEFT);
        prevbtn.setOnAction(e->{
            try {
                h.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        VBox lp = new VBox(10,listview,prevbtn);
        lp.setAlignment(Pos.CENTER);
        HBox back = new HBox(10,lp,right);
        StackPane pane = new StackPane();
        pane.getChildren().addAll(imageView,back);
        primaryStage.setTitle("seller menu");
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private ObservableList<Product> filterItems(ObservableList<Product> originalList, String filter) {
        ObservableList<Product> filteredList = FXCollections.observableArrayList();

        for (Product item : originalList) {
            if (item.getName().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }
    private ObservableList<Product> filter(ObservableList<Product> originalList, String filter) {
        ObservableList<Product> filteredList = FXCollections.observableArrayList();

        for (Product item : originalList) {
            if (item.getSeller().toLowerCase().contains(filter.toLowerCase())) {
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
    public void fillarraylist(ArrayList<Product> list) {
        String fileName = "products.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Product>) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
