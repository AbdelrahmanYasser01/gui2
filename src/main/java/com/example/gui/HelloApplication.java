package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Text text1 = new Text("Username");
        Text text2 = new Text("Password");

        TextField usertext=new TextField();
        PasswordField passtext = new PasswordField();

        Button bt1 = new Button("SIGN IN");
        Button bt2 = new Button("cancel ");
        Button bt = new Button("sign up");
        GridPane pane = new GridPane();
        pane.setMinSize(400,200);
        pane.setPadding(new Insets(10,10,10,10));

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        pane.add(text1,0,0);
        pane.add(text2,0,1);
        pane.add(usertext,1,0);
        pane.add(passtext,1,1);
        pane.add(bt1,0,3);
        pane.add(bt2,1,3);
        pane.add(bt,1,4);

        bt1.setStyle("-fx-background-color:black ; -fx-text-fill:white ; -fx-background-radius: 30 ");
        bt1.setPrefWidth(100);
        bt2.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        bt2.setPrefWidth(100);
        bt.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        bt.setPrefWidth(100);

        text1.setStyle("-fx-font:normal bold 20px 'Arial' ");
        text1.setFill(Color.WHITE);

        text2.setStyle("-fx-font:normal bold 20px 'Arial' ");
        text2.setFill(Color.WHITE);

        Image image = new Image("https://static.nike.com/a/images/f_auto/6c735bd0-26db-460d-a3d7-2848211e7c77/image.jpeg"); // Assuming the image file is in the project directory
        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Create layout
        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView,pane);
        StackPane.setAlignment(pane, Pos.TOP_LEFT);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("login page");
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