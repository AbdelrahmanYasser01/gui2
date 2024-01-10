package com.example.gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Customereditui extends Application {

    private static final String[] IMAGE_URLS = {
            "https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232",
            "https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-applewatch1.jpg?auto=webp&quality=60&width=570&dpr=2",

    };

    private int currentIndex = 0;
    private ImageView imageView = new ImageView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Auto Image Slider Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a timeline to switch images every 3 seconds (adjust as needed)
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), event -> nextImage(scene))
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();
    }

    private void nextImage(Scene scene) {
        if (currentIndex < IMAGE_URLS.length - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }

        loadImage(IMAGE_URLS[currentIndex], scene);    }

    private void loadImage(String imageUrl, Scene scene) {
        Image image = new Image(imageUrl);

        // Set the properties to make the image fit the window
        imageView.setImage(image);
        imageView.setFitWidth(scene.getWidth()); // Adjust to the window width
        imageView.setFitHeight(scene.getHeight()); // Adjust to the window height
    }
    }


