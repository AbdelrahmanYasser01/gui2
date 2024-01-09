package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
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
import java.util.List;
import java.util.concurrent.Flow;

public class ProductsGUI extends Application implements Serializable  {
        public static void main(String[] args) {

                launch(args);
        }

        @Override
        public void start(Stage prodstage) {

                StackPane pane = new StackPane();
                StackPane searchPane = new StackPane();

                Rectangle searchBackground = new Rectangle(707, 75, Color.rgb(0, 0, 0, 0.5));
                searchBackground.setArcWidth(90);
                searchBackground.setArcHeight(90);
                Text search = new Text("SEARCH PRODUCT");
                TextField searchBar = new TextField();
                searchBar.setOpacity(0.2);
                search.setStyle("-fx-font:normal  20px 'IMPACT' ");
                search.setFill(Color.WHITE);
                searchBar.setPrefWidth(200); // Set the preferred width as needed
                searchBar.setPrefHeight(20);
                HBox searchBack = new HBox(search, searchBar);
                searchBack.setAlignment(Pos.CENTER);
                searchPane.getChildren().addAll(searchBackground, searchBack);


                StackPane addPane = new StackPane();
                Rectangle addBackground = new Rectangle(707, 255, Color.rgb(0, 0, 0, 0.5));
                addBackground.setArcWidth(90);
                addBackground.setArcHeight(90);
                Text add = new Text("ADD PRODUCT NAME");
                TextField addfield = new TextField("product");
                addfield.setOpacity(0.2);
                add.setStyle("-fx-font:normal  20px 'IMPACT' ");
                add.setFill(Color.WHITE);
                HBox addpart = new HBox(add, addfield);
                addpart.setAlignment(Pos.CENTER);
                Text addPRICE = new Text("ADD PRODUCT PRICE");
                TextField pricefield = new TextField("price");
                pricefield.setOpacity(0.2);
                addPRICE.setStyle("-fx-font:normal  20px 'IMPACT' ");
                addPRICE.setFill(Color.WHITE);
                HBox addpart2 = new HBox(addPRICE, pricefield);
                addpart2.setAlignment(Pos.CENTER);
                VBox addproduct = new VBox(15, addpart, addpart2);
                addproduct.setAlignment(Pos.CENTER);
                addPane.getChildren().addAll(addBackground, addproduct);


                StackPane removePane = new StackPane();
                Rectangle removeBackground = new Rectangle(707, 255, Color.rgb(0, 0, 0, 0.5));
                removeBackground.setArcWidth(90);
                removeBackground.setArcHeight(90);
                Text rem = new Text("REMOVE PRODUCT :");
                Text remove = new Text("PRODUCT NAME");
                TextField remfield = new TextField("product");
                remfield.setOpacity(0.2);
                remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
                remove.setFill(Color.WHITE);
                rem.setStyle("-fx-font:normal  20px 'IMPACT' ");
                rem.setFill(Color.WHITE);
                GridPane removingprod = new GridPane(10, 10);
                removingprod.add(rem, 0, 0);
                removingprod.add(remove, 0, 2);
                removingprod.add(remfield, 1, 2);
                removingprod.setAlignment(Pos.CENTER);
                removePane.getChildren().addAll(removeBackground, removingprod);

                VBox right = new VBox(10, searchPane, addPane, removePane);
                right.setAlignment(Pos.CENTER);

                Image image = new Image("https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-applewatch1.jpg?auto=webp&quality=60&width=570&dpr=2"); // Assuming the image file is in the project directory
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(true);


                Rectangle background = new Rectangle(714, 700, Color.rgb(0, 0, 0, 0.5));
                background.setArcWidth(60);
                background.setArcHeight(60);
                ArrayList<Product> alist = new ArrayList<>();
                ProductsGUI prod = new ProductsGUI();
                prod.fillarraylist(alist);
                ObservableList<Product> p = FXCollections.observableArrayList(alist);
                ListView<Product> listview = new ListView<>(p);
                 listview.setStyle("-fx-control-inner-background: Black;");
                HBox back = new HBox(10, listview, right);

                FlowPane pane1 = new FlowPane();


                pane.getChildren().addAll(imageView, back);
                //pane.getChildren().addAll(listview);

                listview.setOnMouseClicked(event -> {
                        Product selectedItem = listview.getSelectionModel().getSelectedItem();
                        System.out.println("Selected Item: " + selectedItem);

                        // Add your custom handling logic here
                });

                Scene scene = new Scene(pane);
                prodstage.setScene(scene);

                prodstage.widthProperty().addListener((obs, oldVal, newVal) -> {
                        imageView.setFitWidth((double) newVal);
                        pane.setPrefWidth((double) newVal);
                });
                prodstage.heightProperty().addListener((obs, oldVal, newVal) -> {
                        imageView.setFitHeight((double) newVal);
                        pane.setPrefHeight((double) newVal);
                });


                prodstage.setX(100);
                prodstage.setY(100);


                prodstage.show();


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




//    private void printArrayListToVBox(List<Object> list, StackPane vbox) {
//        // Clear the existing content in the VBox
//        vbox.getChildren().clear();
//
//        // Loop through the list and add each item as a label to the VBox
//        for (Object item : list) {
//            Label label = new Label(item.toString());
//            vbox.getChildren().add(label);
//        }
//    }
//
   }

