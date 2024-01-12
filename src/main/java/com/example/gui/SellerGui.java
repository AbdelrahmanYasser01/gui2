package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

public class SellerGui extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        StackPane searchpane = new StackPane();

        Rectangle searchBackground = new Rectangle(707, 75, Color.rgb(255, 255, 255, 0.2));
        searchBackground.setArcWidth(90);
        searchBackground.setArcHeight(90);

        Text search = new Text("SEARCH SELLER");
        TextField searchBar = new TextField();
        Button btn = new Button("Search");
        searchBar.setOpacity(0.3);
        search.setStyle("-fx-font:normal  20px 'IMPACT' ");

        search.setFill(Color.WHITE);
        searchBar.setPrefWidth(200);
        searchBar.setPrefHeight(20);

        HBox searchBack = new HBox(search, searchBar);
        VBox searching = new VBox(searchBack, btn);
        searching.setAlignment(Pos.CENTER);
        searchBack.setAlignment(Pos.CENTER);

        searchpane.getChildren().addAll(searchBackground, searching);

        StackPane addPane = new StackPane();
        Rectangle addBackground = new Rectangle(707, 255,Color.rgb(255, 255, 255, 0.2));
        addBackground.setArcWidth(90);
        addBackground.setArcHeight(90);
        Text add = new Text("ADD SELLER NAME");
        TextField addfield = new TextField("seller");
        addfield.setOpacity(0.2);
        add.setStyle("-fx-font:normal  20px 'IMPACT' ");
        add.setFill(Color.WHITE);

        HBox addSeller = new HBox(add, addfield);
        addSeller.setAlignment(Pos.CENTER);
         //sellermail(text, textfield), password (text, textfield)

        Text addMail = new Text("ADD SELLER MAIL");
        TextField mailField = new TextField("mail");
        Button btn2 = new Button("ADD");


        mailField.setOpacity(0.2);

        Text addPass = new Text("ADD SELLER PASSWORD");
        TextField passField = new TextField("mail");
        Button btn3 = new Button("ADD");
        mailField.setOpacity(0.2);

        addMail.setStyle("-fx-font:normal  20px 'IMPACT' ");
        addMail.setFill(Color.WHITE);

        HBox addpart2 = new HBox(addMail, mailField);
        addpart2.setAlignment(Pos.CENTER);

        VBox addseller = new VBox(15, addSeller, addpart2 , btn2);
        addseller.setAlignment(Pos.CENTER);
        addPane.getChildren().addAll(addBackground, addSeller);


        StackPane removePane = new StackPane();

        Rectangle removeBackground = new Rectangle(707, 230,Color.rgb(255, 255, 255, 0.2));
        removeBackground.setArcWidth(90);
        removeBackground.setArcHeight(90);

        Text rem = new Text("REMOVE SELLER: ");
        Text remove = new Text("SELLER NAME:");
        TextField remField = new TextField("seller");

        Button btn4 = new Button("remove");

        remField.setOpacity(0.3);
        remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
        remove.setFill(Color.WHITE);
        rem.setStyle("-fx-font:normal  20px 'IMPACT' ");
        rem.setFill(Color.WHITE);

        GridPane removingSeller = new GridPane(10, 10);
        removingSeller.add(rem, 0, 0);
        removingSeller.add(remove, 0, 2);
        removingSeller.add(remField,1, 2);
        removingSeller.add(btn3, 1, 3);
        removingSeller.setAlignment(Pos.CENTER);

        removePane.getChildren().addAll(removeBackground, removingSeller);

        VBox right = new VBox(10, searchpane, addPane, removePane);
        right.setAlignment(Pos.CENTER);


        Image image = new Image("https://www.apple.com/v/iphone-15/c/images/overview/design/design_endframe__cb31n5bv6082_large.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);


        ArrayList<Seller> sList = new ArrayList<>();
        SellerGui sell = new SellerGui();
        sell.fillarraylist(sList);

        ObservableList<Seller> s = FXCollections.observableArrayList(sList);

        ListView<Seller> listView = new ListView<>(s);
        listView.setStyle("-fx-background-color: transparent;");


        FlowPane pane1 = new FlowPane();

        btn.setOnAction(event->{
            String value = searchBar.getText().trim();
            if(value.isEmpty()){
                listView.setItems(s);
            }
            else {
                ObservableList<Seller> q = filterItems(s,value);
                listView.setItems(q);
                if(q.isEmpty()){
                    noSellerFound("seller not found", "search for another one");
                }
            }

        });
        ArrayList<Seller> sellList = new ArrayList<>();
        fillarraylist(sellList);
        String path = "seller.dat";
        Database db = new Database(path);

        btn2.setOnAction(event -> {
            ArrayList<Seller> sellers = new ArrayList<>(s);
            Seller seller = new Seller();
            int id = seller.GenerateRandomID();
            String name = addfield.getText();
            String mail = mailField.getText();
            String pass = passField.getText();

            seller = new Seller(id, name, mail, pass, UserType.Seller);
            sellers.add(seller);

            try {
                db.start_write();
                db.insert(sellers);
                db.close_write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ObservableList<Seller> m = FXCollections.observableArrayList(sellers);
            listView.setItems(m);
            db.displayContent();

        });

        btn3.setOnAction(event-> {
            ArrayList<Seller> remsellers = new ArrayList<>(s);
            Iterator<Seller> iterator = remsellers.iterator();
            String name = remField.getText();
            while(iterator.hasNext()) {
                Seller pro = iterator.next();
                if (pro.getSellerName().toLowerCase().contains(name.toLowerCase())) {
                    iterator.remove();
                }
            }
            try {
                db.start_write();
                db.insert(remsellers);
                db.close_write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ObservableList<Seller> t = FXCollections.observableArrayList(remsellers);
            listView.setItems(t);
            db.displayContent();

        });

        HBox back = new HBox(10, listView, right);
        pane.getChildren().addAll(imageView, back);


        listView.setOnMouseClicked(event -> {
            Seller selected = listView.getSelectionModel().getSelectedItem();
            System.out.println("Selected: " + selected);
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        primaryStage.setX(100);
        primaryStage.setY(100);

        primaryStage.show();



    }

    private ObservableList<Seller> filterItems(ObservableList<Seller> originalList, String filter) {
        ObservableList<Seller> filteredList = FXCollections.observableArrayList();

        for (Seller item : originalList) {
            if (item.getSellerName().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    private void noSellerFound(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void fillarraylist(ArrayList<Seller> list) {
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
    //comment
}
