package com.example.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Customereditui extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            // Create a shared data model (ObservableList)
            ObservableList<Product> products = FXCollections.observableArrayList();

            // Create a TabPane
            TabPane tabPane = new TabPane();

            // Add Product tab
            Tab addProductTab = new Tab("Add Product");
            addProductTab.setContent(createAddProductContent(products));

            // Display Products tab
            Tab displayProductsTab = new Tab("Display Products");
            displayProductsTab.setContent(createDisplayProductsContent(products));

            tabPane.getTabs().addAll(addProductTab, displayProductsTab);

            Scene scene = new Scene(tabPane, 600, 400);
            primaryStage.setTitle("Product Tabs Example");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private StackPane createAddProductContent(ObservableList<Product> products) {

            StackPane addProductContent = new StackPane();

            // Add UI components for adding products (e.g., TextFields, Buttons, etc.)

            Button addButton = new Button("Add Product");
            addButton.setOnAction(event -> {
                // Add the product to the shared data model
                Product newProduct = new Product("New Product");
                products.add(newProduct);
            });

            addProductContent.getChildren().add(addButton);

            return addProductContent;
        }

        private StackPane createDisplayProductsContent(ObservableList<Product> products) {
            StackPane displayProductsContent = new StackPane();

            // Add UI components for displaying products (e.g., ListView, TableView, etc.)
            ListView<Product> listView = new ListView<>(products);

            displayProductsContent.getChildren().add(listView);

            return displayProductsContent;
        }

        public static class Product {
            private String name;

            public Product(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name;
            }
        }
    }


