package com.example.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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
        image2tab.setClosable(false);
        image2tab.setContent(createDisplayCart(p));


        // Customer orders details
        Tab image3tab = new Tab("Profile");
        image3tab.setClosable(false);
        HelloApplication g = new HelloApplication();
        image3tab.setContent(createdisplaydetails());


        BorderPane root = new BorderPane();
        HelloApplication h = new HelloApplication();
        Button prevbtn = new Button("previous page");
        prevbtn.setAlignment(Pos.BOTTOM_LEFT);
        prevbtn.setOnAction(e->{
            try {
                h.start(primaryStage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        BorderPane.setAlignment(prevbtn, javafx.geometry.Pos.BOTTOM_RIGHT);
        root.setBottom(prevbtn);
        tabPane.getTabs().addAll(imageTab,image2tab,image3tab);
        tabPane.setStyle("-fx-background-color: transparent;");
        Image imagetrial = new Image("https://www.apple.com/newsroom/images/2023/09/apple-unveils-iphone-15-pro-and-iphone-15-pro-max/tile/Apple-iPhone-15-Pro-lineup-hero-230912.jpg.og.jpg?202311010232"); // Assuming the image file is in the project directory
        Image img = new Image("https://www.apple.com/newsroom/images/live-action/new-store-opening/Apple-Saket-Delhi-India-media-preview-interior_big.jpg.large_2x.jpg");
        ImageView imageView = new ImageView(img);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(1200);
        imageView.setFitHeight(630);
        StackPane s = new StackPane();
        s.getChildren().addAll(imageView,tabPane,root);
        Scene scene = new Scene(s);
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

        Productcon.getChildren().addAll(Addingprod);

        return Productcon;
    }
    private StackPane createDisplayCart(ObservableList<Product> products) {
        StackPane displayProductsContent = new StackPane();
        GridPane displaycartdetails = new GridPane();
        Button cancelCart = new Button("cancel cart");
        Label price = new Label();
        Label Totprice = new Label();
        Label ShopCart = new Label("Your Shopping Cart :");
        ShopCart.setFont(new Font(20.0));
        Label removeitem = new Label(" tab to remove");
        Button checkout = new Button("Proceed to checkout");

        // Add UI components for displaying products (e.g., ListView, TableView, etc.)
        ListView<Product> listView = new ListView<>(products);
        displaycartdetails.add(ShopCart,0,0);
        displaycartdetails.add(listView,0,1);
        displaycartdetails.add(price,0,2);

        displaycartdetails.add(Totprice,0,3);
        displaycartdetails.add(cancelCart,2,3);
        displaycartdetails.add(removeitem,3,0);
        displaycartdetails.add(checkout,4,3);
        products.addListener((ListChangeListener<Product>) change -> {
            Totprice.setText(String.format("Total Amount: %.2f EGP", calculateTotalAmount(products)));
           price.setText( String.format("Quantity: %d", calculatequantity(products)));

        });
        cancelCart.setOnAction(event->{
            products.clear();
        });
        listView.setOnMouseClicked(event -> {
            // Get the selected product
            Product selectedItem = listView.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation to remove");
            alert.setHeaderText("Remove Product");
            alert.setContentText("Are you sure you want to remove this product?");

            alert.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK) {
                    // User clicked OK, remove the selected product
                    if (selectedItem != null) {
                        products.remove(selectedItem);
                    }
                }
            });
        });
        checkout.setOnAction(event -> {
           // todo here
            try {
                checkoutStage(products,price.getText(),Totprice.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
         displaycartdetails.setAlignment(Pos.CENTER);

        displayProductsContent.getChildren().add(displaycartdetails);

        return displayProductsContent;
    }
    private StackPane createdisplaydetails(){
        Order o = new Order();
        Label user = new Label("Please type your user name to view Details");
        TextField user2 = new TextField();
        Button bt = new Button("show");
        DatePicker Startdate = new DatePicker();
        DatePicker Enddate = new DatePicker();
        Button btn = new Button("show specific order");
        ArrayList<Order> al = new ArrayList<>();
        fillarraylist(al);
        ObservableList<Order> p = FXCollections.observableArrayList(al);
        ObservableList<Order> ü = FXCollections.observableArrayList();
        ListView<Order> orders = new ListView<>(ü);

        orders.setPrefSize(10,100);
        StackPane pane = new StackPane();
        HBox b = new HBox(user,user2,bt);
        HBox c = new HBox(Startdate,Enddate,btn);
        VBox n = new VBox(b,c);

        bt.setOnAction(event -> {
            String newValue  = user2.getText().trim();
            if (newValue.isEmpty()) {

                orders.setItems(ü);
            } else {
                ObservableList<Order> filteredItems = filterorders(p, newValue);
                orders.setItems(filteredItems);
                if (filteredItems.isEmpty()) {
                    noproductFound("No Products Found", "No products matching the search criteria.");
                }
            }

        });
        btn.setOnAction(event->{
            String newvalue  = user2.getText().trim();
            LocalDate dateS = Startdate.getValue();
            Date convertstart = convertToDate(dateS);

            LocalDate dateE = Enddate.getValue();
            Date convertend= convertToDate(dateE);
            ObservableList<Order> l = searchDateOrders(p,newvalue,convertstart,convertend);
            orders.setItems(l);
        });
//        orders.setCellFactory(param -> new ListCell<Order>() {
//            @Override
//            protected void updateItem(Order item, boolean empty) {
//                super.updateItem(item, empty);
//                if (empty || item == null || item.getName() == null) {
//                    setText(null);
//                } else {
//                    setText(item.getName()); // Set the text to be displayed in the cell
//                }
//            }
//        });
        //Todo:count num of orders
        VBox t = new VBox(n,orders);
        pane.getChildren().addAll(t);
        return pane;
    }
    private Date convertToDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
    public static ObservableList<Order> searchDateOrders(ObservableList<Order> allOrders, String username, Date startDate, Date endDate) {

        ObservableList<Order> filteredOrders = FXCollections.observableArrayList();
        for (Order order : allOrders) {
            if (order.getName().equalsIgnoreCase(username)) {
                Date orderDate = order.getOrderDate();
                if (orderDate.after(startDate) && orderDate.before(endDate)) {
                    filteredOrders.add(order);
                }
            }
        }

        return filteredOrders;
    }
    public void fillarraylist(ArrayList<Order> list) {
        String fileName = "Order.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    list.addAll((ArrayList<Order>) ois.readObject());
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
    private ObservableList<Order> filterorders(ObservableList<Order> originalList, String filter) {
        ObservableList<Order> filteredList = FXCollections.observableArrayList();

        for (Order item : originalList) {
            if (item.getName().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }
    private ObservableList<Order> filterOrdersByDate(ObservableList<Order> orders, String customerName, Date startDate, Date endDate) {

        return orders.filtered(order ->

                order.getName().equalsIgnoreCase(customerName) &&
                        order.getOrderDate().after(startDate) &&
                        order.getOrderDate().before(endDate)
        );
    }
    private void noproductFound(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public double calculateTotalAmount(ObservableList<Product> originalList) {
        double totalAmount = 0;

        // Iterate through the list and sum up the prices
        for (Product product : originalList) {
            totalAmount += product.getPrice();
        }
        //String formattedTotalAmount = String.format("Total Amount: %.2f EGP", totalAmount);
        return totalAmount;
    }
    public int calculatequantity(ObservableList<Product> originallist){
        int countquantity = originallist.size(); // Use the size() method to get the number of elements in the list
       // String counterstring = String.format("Quantity: %d", countquantity);
        return countquantity;
    }
    public void checkoutStage(ObservableList<Product> products,String Quantity , String amount) throws IOException {
        String orderFilePath = "Order.dat";

        Database orderdb = new Database(orderFilePath);


        Stage checkoutStage = new Stage();
        checkoutStage.initModality(Modality.APPLICATION_MODAL); // Block events to other windows
        checkoutStage.initStyle(StageStyle.UTILITY);


        TextField location = new TextField();
        TextField email = new TextField();
        TextField  phone = new TextField();
        TextField name = new TextField();
        DatePicker orderdate = new DatePicker();
        VBox detail = new VBox(name,email,phone,location,orderdate);
        Label location1 = new Label("location :");
        Label email1 = new Label("email :");
        Label  phone1 = new Label("phone :");
        Label name1 = new Label("name :");
        Label date = new Label("Date :");
        Button btn = new Button("confirm");
        VBox detail2 = new VBox(name1,email1,phone1,location1,date);
        HBox detail3 = new HBox(detail2,detail,btn);
        detail3.setAlignment(Pos.CENTER);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("ORDER CONFIRMED");
        alert.setContentText("your order has been recieved and is being processed");
        ArrayList<Order> orderlists = new ArrayList<>();
        fillarraylist(orderlists);
        System.out.println(orderlists);
       btn.setOnAction(e->{
           ArrayList<Product> shoppingcart = new ArrayList<>(products);
           LocalDate chosendate =orderdate.getValue();
           Date selecteddate = Date.from(chosendate.atStartOfDay(ZoneId.systemDefault()).toInstant());
           Order order = new Order(1111,0111,name.getText(),Quantity,amount,location.getText(),phone.getText(),email.getText(),selecteddate,shoppingcart);
           orderlists.add(order);
           try {
               orderdb.start_write();
               orderdb.insert(orderlists);
               orderdb.close_write();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
           alert.showAndWait().ifPresent(result -> {
               checkoutStage.close();
           });

           orderdb.displayContent();
       });
        Scene scene = new Scene(detail3);
        checkoutStage.setScene(scene);
        checkoutStage.showAndWait();
    }
    public void fillarraylistp(ArrayList<Product> list) {
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
}


