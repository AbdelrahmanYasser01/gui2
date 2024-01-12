package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
import java.util.List;
import java.util.concurrent.Flow;

public class ProductsGUI extends Application implements Serializable  {
        public static void main(String[] args) {

                launch(args);
        }

        @Override
        public void start(Stage prodstage) throws IOException {

                StackPane pane = new StackPane();
                StackPane searchPane = new StackPane();

                Rectangle searchBackground = new Rectangle(707, 75,Color.rgb(255, 255, 255, 0.2));
                searchBackground.setArcWidth(90);
                searchBackground.setArcHeight(90);
                Text search = new Text("SEARCH PRODUCT");
                TextField searchBar = new TextField();
                Button btn = new Button("search");
                searchBar.setOpacity(0.2);
                search.setStyle("-fx-font:normal  20px 'IMPACT' ");
                search.setFill(Color.WHITE);
                searchBar.setPrefWidth(200); // Set the preferred width as needed
                searchBar.setPrefHeight(20);
                HBox searchBack = new HBox(search, searchBar);
                VBox searching = new VBox(searchBack,btn);
                searching.setAlignment(Pos.CENTER);
                searchBack.setAlignment(Pos.CENTER);
                searchPane.getChildren().addAll(searchBackground, searching);



                StackPane addPane = new StackPane();
                Rectangle addBackground = new Rectangle(707, 255,Color.rgb(255, 255, 255, 0.2));
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
                Button btn2 = new Button("ADD");
                pricefield.setOpacity(0.2);
                addPRICE.setStyle("-fx-font:normal  20px 'IMPACT' ");
                addPRICE.setFill(Color.WHITE);
                HBox addpart2 = new HBox(addPRICE, pricefield);
                addpart2.setAlignment(Pos.CENTER);
                VBox addproduct = new VBox(15, addpart, addpart2 , btn2);
                addproduct.setAlignment(Pos.CENTER);
                addPane.getChildren().addAll(addBackground, addproduct);


                StackPane removePane = new StackPane();
                Rectangle removeBackground = new Rectangle(707, 230,Color.rgb(255, 255, 255, 0.2));
                removeBackground.setArcWidth(90);
                removeBackground.setArcHeight(90);
                Text rem = new Text("REMOVE PRODUCT :");
                Text remove = new Text("PRODUCT NAME");
                TextField remfield = new TextField("product");
                Button btn3 = new Button("Remove");
                remfield.setOpacity(0.2);
                remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
                remove.setFill(Color.WHITE);
                rem.setStyle("-fx-font:normal  20px 'IMPACT' ");
                rem.setFill(Color.WHITE);
                GridPane removingprod = new GridPane(10, 10);
                removingprod.add(rem, 0, 0);
                removingprod.add(remove, 0, 2);
                removingprod.add(remfield, 1, 2);
                removingprod.add(btn3,1,3);
                removingprod.setAlignment(Pos.CENTER);
                removePane.getChildren().addAll(removeBackground, removingprod);

                VBox right = new VBox(10, searchPane, addPane, removePane);
                right.setAlignment(Pos.CENTER);

                Image image = new Image("https://www.apple.com/v/iphone-15/c/images/overview/design/design_endframe__cb31n5bv6082_large.jpg"); // Assuming the image file is in the project directory
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(true);



                ArrayList<Product> alist = new ArrayList<>();
                ProductsGUI prod = new ProductsGUI();
                prod.fillarraylist(alist);
                ObservableList<Product> p = FXCollections.observableArrayList(alist);
                ListView<Product> listview = new ListView<>(p);
                listview.setStyle("-fx-background-color: transparent;");


                FlowPane pane1 = new FlowPane();

                btn.setOnAction(event->{
                        String value = searchBar.getText().trim();
                        if(value.isEmpty()){
                                listview.setItems(p);
                        }
                        else {
                                ObservableList<Product> q = filterItems(p,value);
                                listview.setItems(q);
                                if(q.isEmpty()){
                                    noproductFound("product not found", "search for another one");
                                }
                        }

                });
                ArrayList<Product> prodlist = new ArrayList<>();
                fillarraylist(prodlist);
                String path = "products.dat";
                Database db = new Database(path);


                btn2.setOnAction(event->{
                   ArrayList<Product> products = new ArrayList<>(p);
                   Product product = new Product();
                   int id =  product.GenerateRandomID();
                   String name = addfield.getText();
                   String price = pricefield.getText();
                   double value = Double.parseDouble(price);
                   product = new Product(id,name,value);
                   products.add(product);
                        try {
                                db.start_write();
                                db.insert(products);
                                db.close_write();
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }
                        ObservableList<Product> m = FXCollections.observableArrayList(products);
                        listview.setItems(m);
                     db.displayContent();
                });

                btn3.setOnAction(event-> {
                        ArrayList<Product> remproducts = new ArrayList<>(p);
                        Iterator<Product> iterator = remproducts.iterator();
                        String name = remfield.getText();
                        while(iterator.hasNext()) {
                                Product pro = iterator.next();
                                if (pro.getName().toLowerCase().contains(name.toLowerCase())) {
                                        iterator.remove();
                                }
                        }
                        try {
                                db.start_write();
                                db.insert(remproducts);
                                db.close_write();
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }
                        ObservableList<Product> t = FXCollections.observableArrayList(remproducts);
                        listview.setItems(t);
                        db.displayContent();

                });
                HBox back = new HBox(10, listview, right);
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
        private ObservableList<Product> filterItems(ObservableList<Product> originalList, String filter) {
                ObservableList<Product> filteredList = FXCollections.observableArrayList();

                for (Product item : originalList) {
                        if (item.getName().toLowerCase().contains(filter.toLowerCase())) {
                                filteredList.add(item);
                        }
                }

                return filteredList;
        }
        private void noproductFound(String title, String content) {
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

