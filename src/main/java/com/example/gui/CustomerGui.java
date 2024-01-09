package com.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CustomerGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Tab with Image Example");

        // Create a TabPane
        TabPane tabPane = new TabPane();

        // Load the image (replace "your_image_path.jpg" with the actual path to your image)
        Image image = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        Image image2 = new Image("https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-applewatch1.jpg?auto=webp&quality=60&width=570&dpr=2"); // Assuming the image file is in the project directory


        // Product tab
        Tab imageTab = new Tab("Products");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth());
        imageView.setFitHeight(image.getHeight());
        imageTab.setContent(new StackPane(imageView));
        imageTab.setClosable(false);

        //Cart tab
        Tab image2tab = new Tab("Cart");
        ImageView image22 = new ImageView(image2);
        image22.setFitWidth(image.getWidth());
        image22.setFitHeight(image.getHeight());
        StackPane p1 = new StackPane();
        image2tab.setClosable(false);
        image2tab.setContent(new StackPane(image22));



        tabPane.getTabs().addAll(imageTab,image2tab);
        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //comment
}
