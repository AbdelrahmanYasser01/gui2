package com.example.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminGui extends Application {
    //admin admin = new admin
    @Override
    public void start(Stage primaryStage)  {
        //admin.getid();
        Text text1 = new Text("hello");
        StackPane layout = new StackPane(text1);
        layout.setMinSize(400,200);
        layout.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin menu");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}