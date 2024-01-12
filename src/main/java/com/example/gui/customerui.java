package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class customerui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("hello");
        Scene scene = new Scene(hello);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
