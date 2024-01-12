package com.example.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminGui extends Application {
    //admin admin = new admin
    @Override
    public void start(Stage primaryStage)  {
        ProductsGUI prod = new ProductsGUI();
        customerui cust = new customerui();
        sellerui seller = new sellerui();
        Text text1 = new Text("ADMIN MENU");
        // label / 4 btn : view customer , seller ,product , add product
        Button bt1 = new Button("view products");
        bt1.setOnAction(e -> {
            try {
                prod.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button bt2 = new Button("view customers");
        bt2.setOnAction(e->{
            try {
                cust.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        Button bt3 = new Button("view sellers") ;
        bt3.setOnAction(e->{
            try {
                seller.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox adminmenu = new VBox(10,bt1,bt2,bt3);
        adminmenu.setAlignment(Pos.CENTER);


        Image image = new Image("https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-iphone15pro.jpg?auto=webp&quality=60&width=570&dpr=2"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        //imageView.setFitWidth(primaryStage.getWidth());
        //imageView.setFitHeight(primaryStage.getHeight());

        Rectangle adminbackground = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.5));
        adminbackground.setArcWidth(20);
        adminbackground.setArcHeight(20);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView,adminbackground,adminmenu);


        /*layout.setMinSize(400,200);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setMaxWidth(Region.USE_PREF_SIZE);
        layout.setMaxHeight(Region.USE_PREF_SIZE);*/


        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin menu");

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth((double) newVal);
        });
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitHeight((double) newVal);
        });

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}