package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

// TODO: after he signed in got to menu for admin , customer , seller
// todo : sign up page
// todo : binary files

public class HelloApplication extends Application {
    public static void main(String[] args) {

    launch();
}
    @Override
    public void start(Stage stage) throws IOException {
        AdminGui admin = new AdminGui();
        Text text1 = new Text(" username:");
        Text text2 = new Text(" password:");
        Text text3 = new Text("or if you don't have an account");
        Text text4 = new Text(" usertype :");

        TextField usertext=new TextField();
        PasswordField passtext = new PasswordField();

        ObservableList<String> o;
        o = FXCollections.observableArrayList("Admin","Seller","Customer");
        ComboBox cbx = new ComboBox(o);
        cbx.setValue("Select");

        String sc = (String) cbx.getValue();

        Button bt1 = new Button("sign in");
        //check if usertext and passtext and cbx matches admin
        bt1.setOnAction(e ->{
            //admin.start(stage));
            String selectedRole = (String)cbx.getValue();
            if ("Admin".equals(selectedRole)) {
                // search in file if pass and username
                admin.start(stage);
            }
        });

        Button bt = new Button("sign up");
        GridPane pane = new GridPane();
        pane.setMinSize(400,200);
        pane.setPadding(new Insets(10,10,10,10));

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        pane.add(text4,0,0);
        pane.add(cbx,1,0);
        pane.add(text1,0,1);
        pane.add(text2,0,2);
        pane.add(usertext,1,1);
        pane.add(passtext,1,2);
        pane.add(bt1,1,3);
        pane.add(bt,1,5);
        pane.add(text3,0,5);
        // adding btns and labes to a grid pane
        bt1.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30 ");
        bt1.setPrefWidth(100);
        bt1.setOpacity(0.7);
        //bt2.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        //bt2.setPrefWidth(100);
        bt.setStyle("-fx-background-color:grey ; -fx-text-fill:white ; -fx-background-radius: 30");
        bt.setPrefWidth(100);
        bt.setOpacity(0.7);

        text1.setStyle("-fx-font:normal  20px 'Montserrat' ");
        text1.setFill(Color.WHITE);

        text2.setStyle("-fx-font:normal  20px 'Montserrat' ");
        text2.setFill(Color.WHITE);

        text3.setStyle("-fx-font:normal 15px 'Montserrat'");
        text3.setFill(Color.WHITE);

        text4.setStyle("-fx-font:normal 20px 'Montserrat'");
        text4.setFill(Color.WHITE);
// setting btns and labels style
        Image image = new Image("https://static.nike.com/a/images/f_auto/6c735bd0-26db-460d-a3d7-2848211e7c77/image.jpeg"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(stage.getWidth());
        imageView.setFitHeight(stage.getHeight());
        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.5));
        background.setArcWidth(20);
        background.setArcHeight(20);
// adding image and background
        StackPane layout = new StackPane();
        layout.getChildren().addAll(imageView,background,pane);
        StackPane.setAlignment(pane, Pos.TOP_LEFT);

        layout.setMaxWidth(Region.USE_PREF_SIZE);
        layout.setMaxHeight(Region.USE_PREF_SIZE);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("login page");
// adding them to a stack
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth((double) newVal);
        });
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitHeight((double) newVal);
        });


        stage.show();


    }


}

//FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
  //  Scene scene = new Scene(fxmlLoader.load(), 320, 240);
       // stage.setTitle("Hello!");
   //             stage.setScene(scene);
// stage.show();