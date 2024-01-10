package com.example.gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Customereditui extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Shopping Cart");

            // Create TableView and columns
            TableView<PProduct> cartTableView = new TableView<>();
            TableColumn<PProduct, String> nameColumn = new TableColumn<>("Name");
            TableColumn<PProduct, Integer> idColumn = new TableColumn<>("ID");
            TableColumn<PProduct, Double> priceColumn = new TableColumn<>("Price");

            nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
            idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

            cartTableView.getColumns().addAll(nameColumn, idColumn, priceColumn);

            // Create cart data
            ObservableList<PProduct> cartItems = FXCollections.observableArrayList(
                    new PProduct("Product1", 1, 19.99),
                    new PProduct("Product2", 2, 29.99),
                    new PProduct("Product3", 3, 39.99)
            );

            // Set cart data to the TableView
            cartTableView.setItems(cartItems);

            // Create a layout
            VBox vbox = new VBox(cartTableView);

            // Create a scene
            Scene scene = new Scene(vbox, 400, 300);

            // Set the scene to the stage
            primaryStage.setScene(scene);

            // Show the stage
            primaryStage.show();
        }
    }



    class PProduct {
            private final StringProperty name;
            private final IntegerProperty id;
            private final DoubleProperty price;

            public PProduct(String name, int id, double price) {
                this.name = new SimpleStringProperty(name);
                this.id = new SimpleIntegerProperty(id);
                this.price = new SimpleDoubleProperty(price);
            }

            public StringProperty nameProperty() {
                return name;
            }

            public int getId() {
                return id.get();
            }

            public IntegerProperty idProperty() {
                return id;
            }

            public double getPrice() {
                return price.get();
            }

            public DoubleProperty priceProperty() {
                return price;
            }
        }


