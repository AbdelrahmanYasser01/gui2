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

        VBox right = new VBox(searchPane);

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
        prodstage.show();


    }
}
