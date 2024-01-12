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

import java.io.IOException;
import java.util.ArrayList;


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
        AdminButton.setOnAction(e -> {
            try {
                switchScenes(AdminScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        CustomerButton.setOnAction(e -> {
            try {
                switchScenes(CustomerScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        SellerButton.setOnAction(e -> {
            try {
                switchScenes(SellerScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

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

    private Scene AdminScene() throws IOException {
        Text text1 = new Text(" username:");
        Text text2 = new Text("      email: ");
        Text email1 = new Text("password:");

        text1.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text2.setStyle("-fx-font:normal  20px 'IMPACT' ");

        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        email1.setFill(Color.WHITE);

        TextField username = new TextField();
        TextField password = new TextField();
        TextField email = new TextField();

        email1.setStyle("-fx-font:normal  20px 'IMPACT' ");

        Button signUp = new Button("Sign Up");

        GridPane s1 = new GridPane();
        s1.add(text1, 0,0);
        s1.add(text2, 0, 1);
        s1.add(email1, 0, 2);
        s1.add(username, 1, 0);
        s1.add(password, 1, 1);
        s1.add(email, 1, 2);
        s1.add(signUp, 1, 3);
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



        String filepath = "admin.dat";
        Database d = new Database(filepath);
        d.start_write();

        signUp.setOnAction(e -> {
            ArrayList<Admin> adminList = new ArrayList<>();

            String us = username.getText();
            String mail = email.getText();
            String pass = password.getText();

            Admin a = new Admin(1233, us, mail, pass, UserType.Admin);
            System.out.println("Username: " + us);
            System.out.println("Email: " + mail);
            System.out.println("Password: " + pass);

            adminList.add(a);
            try {
                d.insert(adminList);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                d.close_write();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            d.displayContent();

        });

        scene2 = new Scene(layout);
        return scene2;
    }
//todo: howar el previous stage(event handling)
    private Scene CustomerScene() throws IOException {
        Text text1 = new Text("username:");
        Text text2 = new Text("     email: ");
        Text text3 = new Text("password:");
        Text text4 = new Text("    phone: ");
        Text text5 = new Text(" location:");

        text1.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text2.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text3.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text4.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text5.setStyle("-fx-font:normal  20px 'IMPACT'  ");

        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        text3.setFill(Color.WHITE);
        text4.setFill(Color.WHITE);
        text5.setFill(Color.WHITE);

        TextField username = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();
        TextField phone = new TextField();
        TextField loc = new TextField();

        Button signUp = new Button("Sign Up");

        GridPane s2 = new GridPane();
        s2.add(text1, 0, 0);
        s2.add(text2, 0, 1);
        s2.add(text3, 0, 2);
        s2.add(text4, 0, 3);
        s2.add(text5, 0, 4);
        s2.add(username, 1, 0);
        s2.add(email, 1, 1);
        s2.add(password, 1, 2);
        s2.add(phone, 1, 3);
        s2.add(loc, 1, 4);
        s2.add(signUp, 1,5 );

        s2.setHgap(5);
        s2.setVgap(7);

        Image image = new Image("https://www.apple.com/newsroom/images/environments/stores/Apple_Changsha_NewStore_09012021.jpg.og.jpg?202310121158");
        ImageView view = new ImageView(image);
        view.setPreserveRatio(true);
        view.setFitWidth(stage.getWidth());
        view.setFitHeight(stage.getHeight());

        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.75));
        background.setArcWidth(20);
        background.setArcHeight(20);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(view, background, s2);
        s2.setAlignment(Pos.CENTER);

        String filepath = "customer.dat";
        Database d = new Database(filepath);
        d.start_write();;

        signUp.setOnAction(e -> {
            ArrayList<Customer> customerList = new ArrayList<>();

            String us = username.getText();
            String mail = email.getText();
            String pass = password.getText();
            String num = phone.getText();
            String locc = loc.getText();

            Customer c = new Customer(3211, us, mail, pass, num, locc, UserType.Customer);
            System.out.println("Username: " + us);
            System.out.println("Email: " + mail);
            System.out.println("Password: " + pass);
            System.out.println("phone: " + num);
            System.out.println("Location: " + locc);

            customerList.add(c);
            try {
                d.insert(customerList);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                d.close_write();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            d.displayContent();

        });

        scene3 = new Scene(layout);
        return scene3;
    }

    private Scene SellerScene() throws IOException {
        Text text1 = new Text(" username:");
        Text text2 = new Text("     email: ");
        Text text3 = new Text("password:");

        text1.setStyle("-fx-font:normal  20px 'IMPACT'  ");
        text2.setStyle("-fx-font:normal  20px 'IMPACT' ");
        text3.setStyle("-fx-font:normal  20px 'IMPACT'  ");

        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        text3.setFill(Color.WHITE);

        TextField username = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();

        Button signUp = new Button("Sign Up");

        GridPane s3 = new GridPane();
        s3.add(text1, 0, 0);
        s3.add(text2, 0, 1);
        s3.add(text3, 0,2);
        s3.add(username, 1, 0);
        s3.add(email, 1,1 );
        s3.add(password, 1, 2);
        s3.add(signUp, 1, 3);

        s3.setHgap(5);
        s3.setVgap(7);

        Image image = new Image("https://www.apple.com/newsroom/images/environments/stores/Apple_Changsha_OpensSaturday_09012021_big.jpg.slideshow-xlarge_2x.jpg");
        ImageView view = new ImageView(image);
        view.setPreserveRatio(true);
        view.setFitWidth(stage.getMaxWidth());
        view.setFitHeight(stage.getHeight());

        Rectangle background = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.75));
        background.setArcWidth(20);
        background.setArcHeight(20);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(view, background, s3);
        s3.setAlignment(Pos.CENTER);

        String filepath = "seller.dat";
        Database d = new Database(filepath);
        d.start_write();

        signUp.setOnAction(e -> {
            ArrayList<Seller> sellerList = new ArrayList<>();

            String us = username.getText();
            String mail = email.getText();
            String pass = password.getText();

            Seller s = new Seller(4321, us, mail, pass, UserType.Seller);
            System.out.println("Username: " + us);
            System.out.println("Email: " + mail);
            System.out.println("Password: " + pass);

            sellerList.add(s);
            try {
                d.insert(sellerList);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                d.close_write();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            d.displayContent();
        });

        scene4 = new Scene(layout);
        return scene4;
    }


    public void switchScenes(Scene scene) {

        stage.setScene(scene);
    }
    public static int generateRandomID() {
        //  generate a random ID
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

