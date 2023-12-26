package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
        pane.getChildren().add(text);
        Scene scene = new Scene(pane);
        prodstage.setScene(scene);
        prodstage.show();
    }
}
