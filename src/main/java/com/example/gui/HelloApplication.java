package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button bt = new Button("sign up");
        Scene scene = new Scene(bt);
        stage.setScene(scene);
        stage.setTitle("GUI Example");
        stage.show();


    }

    public static void main(String[] args) {

        launch();
    }
}

//FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
  //  Scene scene = new Scene(fxmlLoader.load(), 320, 240);
       // stage.setTitle("Hello!");
   //             stage.setScene(scene);
// stage.show();