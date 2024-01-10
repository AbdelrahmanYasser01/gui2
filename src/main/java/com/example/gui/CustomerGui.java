package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerGui extends Application  {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Tab with Image Example");

        ObservableList<Product> products = FXCollections.observableArrayList();
        // Create a TabPane
        TabPane tabPane = new TabPane();


        Image image = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        Image image2 = new Image("https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-applewatch1.jpg?auto=webp&quality=60&width=570&dpr=2"); // Assuming the image file is in the project directory


        // Product tab
        Tab imageTab = new Tab("Products");
        ArrayList<Product> alist = new ArrayList<>();
        ProductsGUI prod = new ProductsGUI();
        prod.fillarraylist(alist);
        ObservableList<Product> p = FXCollections.observableArrayList();
        imageTab.setContent(createAddtocartContent(p));
        imageTab.setClosable(false);

        //Cart tab
        Tab image2tab = new Tab("Cart");
        ImageView image22 = new ImageView(image2);
        image22.setFitWidth(image.getWidth());
        image22.setFitHeight(image.getHeight());
        StackPane p1 = new StackPane();
        image2tab.setClosable(false);
        image2tab.setContent(createDisplayCart(p));



        tabPane.getTabs().addAll(imageTab,image2tab);
        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private StackPane createAddtocartContent(ObservableList<Product> products) {
        StackPane Productcon = new StackPane();
        HBox Addingprod = new HBox();
        Image image = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth());
        imageView.setFitHeight(image.getHeight());
        ArrayList<Product> alist = new ArrayList<>();
        ProductsGUI prod = new ProductsGUI();
        prod.fillarraylist(alist);
        ObservableList<Product> p = FXCollections.observableArrayList(alist);
        ListView<Product> listview = new ListView<>(p);
        listview.setStyle("-fx-control-inner-background: Black;");


        TextField productType = new TextField("add product");
        Button addprod = new Button("ADD TO CART");
        VBox Buttons = new VBox(productType,addprod);

        listview.setOnMouseClicked(event -> {
            Product selectedItem = listview.getSelectionModel().getSelectedItem();
            productType.setText(String.valueOf(selectedItem));
            System.out.println("Selected Item: " + selectedItem);

        });
        addprod.setOnAction(event -> {
            // Add the product to the shared data model
            // productType.getText();
            // Product newProduct = new Product(211,"Iphone",1900);
            products.add(Product.parse(productType.getText()));
        });

        Addingprod.getChildren().addAll(listview,Buttons);
        // Add UI components for adding products (e.g., TextFields, Buttons, etc.)
        Productcon.getChildren().addAll(imageView,Addingprod);
        return Productcon;
    }
    private StackPane createDisplayCart(ObservableList<Product> products) {
        StackPane displayProductsContent = new StackPane();

        // Add UI components for displaying products (e.g., ListView, TableView, etc.)
        ListView<Product> listView = new ListView<>(products);

        displayProductsContent.getChildren().add(listView);

        return displayProductsContent;
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
