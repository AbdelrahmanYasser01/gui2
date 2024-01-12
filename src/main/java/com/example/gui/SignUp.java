package com.example.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        vbox3 = new VBox(10, AdminButton, CustomerButton, SellerButton);
        AdminButton.setOnAction(e -> switchScenes(AdminScene()));
        CustomerButton.setOnAction(e -> switchScenes(CustomerScene()));
        SellerButton.setOnAction(e -> switchScenes(SellerScene()));

        Image image = new Image("https://images.squarespace-cdn.com/content/v1/5e66664810c4ff5e8746a290/1637101970501-RJF7RZC58EKEOE389CIF/Apple+Ring+Building+Night.jpg"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());

        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.75));
        background.setArcWidth(20);
        background.setArcHeight(20);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView, background, vbox3);
        vbox3.setAlignment(Pos.CENTER);

        scene1 = new Scene(layout, 800, 500);





        return scene1;
    }

    private Scene AdminScene() {
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
        Text email1 = new Text("      email: ");

        text1.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text2.setStyle("-fx-font:normal  20px 'IMPACT' ");

        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        email1.setFill(Color.WHITE);

        TextField username = new TextField();
        TextField password = new TextField();
        TextField email = new TextField();

        email1.setStyle("-fx-font:normal  20px 'IMPACT' ");

        GridPane s1 = new GridPane();
        s1.add(text1, 0,0);
        s1.add(text2, 0, 1);
        s1.add(email1, 0, 2);
        s1.add(username, 1, 0);
        s1.add(password, 1, 1);
        s1.add(email, 1, 2);
        //searchBack.setAlignment(Pos.CENTER);

        //s1.setPadding(new Insets(10));
        s1.setHgap(5);
        s1.setVgap(7);
        Image image = new Image("https://images.macrumors.com/t/CYBGrcgOUFSPMWdwq-gEH4Mi_L4=/1600x/article-new/2017/04/applecampusatnight.jpg"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());

        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.75));
        background.setArcWidth(20);
        background.setArcHeight(20);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView, background, s1);
        s1.setAlignment(Pos.CENTER);

        scene2 = new Scene(layout);


        return scene2;
    }

    private Scene CustomerScene() {
        Text text1 = new Text("username:");
        Text text2 = new Text("password:");
        Text text3 = new Text("location:");

        VBox h1 = new VBox(text1, text2);
        scene2 = new Scene(h1);
        return scene3;
    }

    private Scene SellerScene() {
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
        VBox h1 = new VBox(text1, text2);
        scene2 = new Scene(h1);
        return scene4;
    }


    public void switchScenes(Scene scene) {
        stage.setScene(scene);
    }
}

