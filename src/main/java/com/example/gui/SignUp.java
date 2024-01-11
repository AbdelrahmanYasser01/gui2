package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


    }

    private Scene SignUpScene() {
        Button AdminButton = new Button("Admin");
        AdminButton.setOnAction(e -> switchScenes(scene2));
        vbox1 = new VBox(AdminButton);
        scene1 = new Scene(vbox1, 800, 500);

        Button CustomerButton = new Button("Customer");
        CustomerButton.setOnAction(e -> switchScenes(scene3));
        vbox2 = new VBox(CustomerButton);
        scene2 = new Scene(vbox2, 800, 500);

        Button SellerButton = new Button("Seller");
        SellerButton.setOnAction(e -> switchScenes(scene4));
        vbox3 = new VBox(SellerButton);
        scene3 = new Scene(vbox3, 800, 500);

        return scene1;
    }

    private Scene AdminScene() {
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
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

