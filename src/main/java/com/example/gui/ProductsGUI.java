package com.example.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductsGUI extends Application {
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage prodstage)  {
        Text text = new Text("hello");
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
        HBox addpart= new HBox(add,addfield);
        addpart.setAlignment(Pos.CENTER);
        Text addPRICE = new Text("ADD PRODUCT PRICE");
        TextField pricefield = new TextField("price");
        pricefield.setOpacity(0.2);
        addPRICE.setStyle("-fx-font:normal  20px 'IMPACT' ");
        addPRICE.setFill(Color.WHITE);
        HBox addpart2= new HBox(addPRICE,pricefield);
        addpart2.setAlignment(Pos.CENTER);
        VBox addproduct = new VBox(15,addpart,addpart2);
        addproduct.setAlignment(Pos.CENTER);
        addPane.getChildren().addAll(addBackground,addproduct);


        VBox right = new VBox(10,searchPane , addPane);


        Image image = new Image("https://static.nike.com/a/images/f_auto/6c735bd0-26db-460d-a3d7-2848211e7c77/image.jpeg"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(prodstage.getWidth());
        imageView.setFitHeight(prodstage.getHeight());
        
        Rectangle background = new Rectangle(714, 700, Color.rgb(0, 0, 0, 0.5));
        background.setArcWidth(60);
        background.setArcHeight(60);
        HBox back = new HBox(10, background, right);

        pane.getChildren().addAll(imageView, back, text);

        Scene scene = new Scene(pane);
        prodstage.setScene(scene);
        prodstage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth((double) newVal);
        });
        prodstage.heightProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitHeight((double) newVal);
        });
        prodstage.show();


    }
}
