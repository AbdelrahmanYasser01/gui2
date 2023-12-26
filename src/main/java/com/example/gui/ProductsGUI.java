package com.example.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ProductsGUI extends Application {
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage prodstage)  {
        String productFilepath = "products.dat";
       /* try{
            ArrayList<Product> products = readProductsFromFile(productFilepath);
            ListView<String> listView = new ListView<>();
            for(Product product :products){
                listView.getItems().add(product.getName());
            }
            listView.setStyle("-fx-background-color: lightgray;");*/
        StackPane pane = new StackPane();
        StackPane searchPane = new StackPane();

        Rectangle searchBackground = new Rectangle(707, 75, Color.rgb(0, 0, 0, 0.5));
        searchBackground.setArcWidth(90);
        searchBackground.setArcHeight(90);
        Text search = new Text("SEARCH PRODUCT");
        TextField searchBar = new TextField();
        searchBar.setOpacity(0.2);
        search.setStyle("-fx-font:normal  20px 'IMPACT' ");
        search.setFill(Color.WHITE);
        searchBar.setPrefWidth(200); // Set the preferred width as needed
        searchBar.setPrefHeight(20);
        HBox searchBack = new HBox(search, searchBar);
        searchBack.setAlignment(Pos.CENTER);
        searchPane.getChildren().addAll(searchBackground, searchBack);


        StackPane addPane = new StackPane();
        Rectangle addBackground = new Rectangle(707, 255, Color.rgb(0, 0, 0, 0.5));
        addBackground.setArcWidth(90);
        addBackground.setArcHeight(90);
        Text add = new Text("ADD PRODUCT NAME");
        TextField addfield = new TextField("product");
        addfield.setOpacity(0.2);
        add.setStyle("-fx-font:normal  20px 'IMPACT' ");
        add.setFill(Color.WHITE);
        HBox addpart= new HBox(add,addfield);
        addpart.setAlignment(Pos.CENTER);
        Text addPRICE = new Text("ADD PRODUCT PRICE");
        TextField pricefield = new TextField("price");
        pricefield.setOpacity(0.2);
        addPRICE.setStyle("-fx-font:normal  20px 'IMPACT' ");
        addPRICE.setFill(Color.WHITE);
        HBox addpart2= new HBox(addPRICE,pricefield);
        addpart2.setAlignment(Pos.CENTER);
        VBox addproduct = new VBox(15,addpart,addpart2);
        addproduct.setAlignment(Pos.CENTER);
        addPane.getChildren().addAll(addBackground,addproduct);


        StackPane removePane = new StackPane();
        Rectangle removeBackground = new Rectangle(707, 255, Color.rgb(0, 0, 0, 0.5));
        removeBackground.setArcWidth(90);
        removeBackground.setArcHeight(90);
        Text rem = new Text("REMOVE PRODUCT :");
        Text remove = new Text("PRODUCT NAME");
        TextField remfield = new TextField("product");
        remfield.setOpacity(0.2);
        remove.setStyle("-fx-font:normal  20px 'IMPACT' ");
        remove.setFill(Color.WHITE);
        rem.setStyle("-fx-font:normal  20px 'IMPACT' ");
        rem.setFill(Color.WHITE);
        GridPane removingprod = new GridPane(10,10);
        removingprod.add(rem,0,0);
        removingprod.add(remove,0,2);
        removingprod.add(remfield,1,2);
        removingprod.setAlignment(Pos.CENTER);
        removePane.getChildren().addAll(removeBackground,removingprod);

        VBox right = new VBox(10,searchPane , addPane , removePane);
        right.setAlignment(Pos.CENTER);

        Image image = new Image("https://static.nike.com/a/images/f_auto/6c735bd0-26db-460d-a3d7-2848211e7c77/image.jpeg"); // Assuming the image file is in the project directory
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        
        Rectangle background = new Rectangle(714, 700, Color.rgb(0, 0, 0, 0.5));
        background.setArcWidth(60);
        background.setArcHeight(60);
        StackPane stack = new StackPane();
        Text text5 = new Text("products :");
        //VBox po = new VBox(text5,listView);
        //stack.getChildren().addAll(background,po);
        HBox back = new HBox(10, background, right);

        pane.getChildren().addAll(imageView, back);


        Scene scene = new Scene(pane);
        prodstage.setScene(scene);

        prodstage.widthProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitWidth((double) newVal);
            pane.setPrefWidth((double) newVal);
        });
        prodstage.heightProperty().addListener((obs, oldVal, newVal) -> {
            imageView.setFitHeight((double) newVal);
            pane.setPrefHeight((double) newVal);
        });


        prodstage.setX(100);
        prodstage.setY(100);


        prodstage.show();
//        }catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }
//    private ArrayList<Product> readProductsFromFile(String filePath) throws IOException, ClassNotFoundException {
//        ArrayList<Product> productlist = new ArrayList<>();
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            while (true) {
//                Product prod = (Product) ois.readObject();
//                productlist.add(prod);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            // End of file or file not found
//        }
//
//        return productlist;
//    }
}
