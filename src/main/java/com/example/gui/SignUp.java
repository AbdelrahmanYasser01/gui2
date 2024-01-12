package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class SignUp extends Application {

    public static void main() {
        launch();
    }

    private Stage stage;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;




    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        stage.setTitle("SignUp");


        scene1 = SignUpScene();
        scene2 = AdminScene();
        scene3 = CustomerScene();
        scene4 = SellerScene();
        stage.setScene(scene1);
        stage.show();


    }

    private Scene SignUpScene() {
        Button AdminButton = new Button("Admin");


        Button CustomerButton = new Button("Customer");


        Button SellerButton = new Button("Seller");
        vbox3 = new VBox(AdminButton, CustomerButton, SellerButton);
        AdminButton.setOnAction(e -> switchScenes(scene2));
        CustomerButton.setOnAction(e -> switchScenes(scene3));
        SellerButton.setOnAction(e -> switchScenes(scene4));
        scene1 = new Scene(vbox3, 800, 500);

        return scene1;
    }

    private Scene AdminScene() {
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
        HBox h = new HBox(text1);
        scene2 = new Scene(h);

        return scene2;
    }

    private Scene CustomerScene() {
        Text text1 = new Text("username:");
        Text text2 = new Text("password:");
        Text text3 = new Text("location:");

        return scene3;
    }

    private Scene SellerScene() {
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");

        return scene4;
    }


    public void switchScenes(Scene scene) {
        stage.setScene(scene);
    }
}

