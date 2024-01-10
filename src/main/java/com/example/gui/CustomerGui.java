package com.example.gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerGui extends Application  {

    private int currentIndex = 0;
    private ImageView image1 = new ImageView();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Tab with Image Example");

        ObservableList<Product> products = FXCollections.observableArrayList();
        // Create a TabPane
        TabPane tabPane = new TabPane();


        Image image = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        Image image2 = new Image("https://cdn.thewirecutter.com/wp-content/media/2023/09/appleiphonesep2023-2048px-applewatch1.jpg?auto=webp&quality=60&width=570&dpr=2"); // Assuming the image file is in the project directory


        // Product tab
        Tab imageTab = new Tab("Products");
        ArrayList<Product> alist = new ArrayList<>();
        ProductsGUI prod = new ProductsGUI();
        prod.fillarraylist(alist);
        ObservableList<Product> p = FXCollections.observableArrayList();
        imageTab.setContent(createAddtocartContent(p));
        imageTab.setClosable(false);
        imageTab.setClosable(false);

        //Cart tab
        Tab image2tab = new Tab("Cart");
        ImageView image22 = new ImageView(image2);
        image22.setFitWidth(image.getWidth());
        image22.setFitHeight(image.getHeight());
        StackPane p1 = new StackPane();
        image2tab.setClosable(false);
        image2tab.setContent(createDisplayCart(p));



        tabPane.getTabs().addAll(imageTab,image2tab);
        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    private StackPane createAddtocartContent(ObservableList<Product> products) {
        StackPane Productcon = new StackPane();
        HBox Addingprod = new HBox();

        Image img = new Image("https://www.apple.com/newsroom/images/product/apple-news/Apple-BKC-Mumbai-India-media-preview-hero.jpg.landing-regular_2x.jpg");
        ImageView imgvw = new ImageView(img);

        ArrayList<Product> alist = new ArrayList<>();
        ProductsGUI prod = new ProductsGUI();
        prod.fillarraylist(alist);
        ObservableList<Product> p = FXCollections.observableArrayList(alist);
        ListView<Product> listview = new ListView<>(p);
        listview.setStyle("-fx-control-inner-background: light grey;");
        listview.setPrefSize(300,300);
        listview.setCellFactory(param -> new ListCell<Product>() {
            private final HBox graphicContainer = new HBox(10);

            @Override
            protected void updateItem(Product item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    ImageView imageView = null;

                    if ("iphone 15 Pro".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-13-iphone-nav-202309_GEO_US?wid=400&hei=260&fmt=png-alpha&.v=1692971740190", 800, 200, true, true));
                    } else if ("airpods 2".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MME73?wid=532&hei=582&fmt=png-alpha&.v=1632861342000", 800, 200, true, true));
                    } else if ("watch series 9".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-13-watch-nav-202309?wid=400&hei=260&fmt=png-alpha&.v=1693703822208", 800, 200, true, true));
                    }else if ("iPad mini".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-13-ipad-nav-202210?wid=400&hei=260&fmt=png-alpha&.v=1664912135437", 800, 200, true, true));
                    }else if ("Macbook".equals(item.getName())) { //
                        imageView = new ImageView(new Image("https://www.apple.com/v/macbook-pro/aj/images/overview/contrast/product_tile_mba_13_15__cw1q3qd2yyeu_large_2x.png", 800, 200, true, true));
                    }else if ("HomePod".equals(item.getName())) {//
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/homepod-mini-select-blue-202110?wid=532&hei=582&fmt=png-alpha&.v=1632925511000", 800, 200, true, true));
                    }else if ("IMac".equals(item.getName())) {//
                        imageView = new ImageView(new Image("https://www.apple.com/v/imac/p/images/overview/routers/compare_imac__f7hnie54ekii_large_2x.png", 800, 200, true, true));
                    }else if ("IPad".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-13-ipad-nav-202210?wid=400&hei=260&fmt=png-alpha&.v=1664912135437", 800, 200, true, true));
                    }else if ("AirPod Max".equals(item.getName())) {//
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/airpods-max-select-silver-202011?wid=532&hei=582&fmt=png-alpha&.v=1604021221000", 800, 200, true, true));
                    }else if ("iPhone 15".equals(item.getName())) {
                        imageView = new ImageView(new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/store-card-13-accessories-nav-202309?wid=400&hei=260&fmt=png-alpha&.v=1692803114952", 800, 200, true, true));
                    }

                    if (imageView != null) {
                        StackPane imagePane = new StackPane(imageView);
                        graphicContainer.getChildren().setAll(imagePane);
                        setGraphic(graphicContainer);
                    }
                }
            }
        } );
        TextField productType = new TextField("add product");
        Button addprod = new Button("ADD TO CART");
        TextField searchField = new TextField("search");
        Button searchbtn = new Button("Search");
        HBox srch = new HBox(searchField,searchbtn);
        HBox adding = new HBox(productType,addprod);
        VBox allmanaging = new VBox(srch,adding);
        allmanaging.setAlignment(Pos.CENTER_RIGHT);

        searchbtn.setOnAction(event -> {
            String newValue = searchField.getText().trim();
            if (newValue.isEmpty()) {
                // If the search field is empty, display the original list
                listview.setItems(p);
            } else {
                ObservableList<Product> filteredItems = filterItems(p, newValue);
                listview.setItems(filteredItems);
                if (filteredItems.isEmpty()) {
                    noproductFound("No Products Found", "No products matching the search criteria.");
                }
            }
            });

        listview.setOnMouseClicked(event -> {
            Product selectedItem = listview.getSelectionModel().getSelectedItem();
            productType.setText(String.valueOf(selectedItem));
            System.out.println("Selected Item: " + selectedItem);

        });
        addprod.setOnAction(event -> {
            // Add the product to the shared data model
            // productType.getText();
            // Product newProduct = new Product(211,"Iphone",1900);
            products.add(Product.parse(productType.getText()));
        });

        Addingprod.getChildren().addAll(listview,allmanaging);
        // Add UI components for adding products (e.g., TextFields, Buttons, etc.)
        Rectangle background = new Rectangle(800, 800, Color.rgb(0, 0, 0, 0.2));

        Productcon.getChildren().addAll(imgvw,Addingprod);

        return Productcon;
    }
    private StackPane createDisplayCart(ObservableList<Product> products) {
        StackPane displayProductsContent = new StackPane();

        // Add UI components for displaying products (e.g., ListView, TableView, etc.)
        ListView<Product> listView = new ListView<>(products);

        displayProductsContent.getChildren().add(listView);

        return displayProductsContent;
    }
    public void fillarraylist(ArrayList<Product> list) {
        String fileName = "products.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Product>) ois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached, exit the loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Product> filterItems(ObservableList<Product> originalList, String filter) {
        ObservableList<Product> filteredList = FXCollections.observableArrayList();

        for (Product item : originalList) {
            if (item.getName().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }
    private void noproductFound(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


