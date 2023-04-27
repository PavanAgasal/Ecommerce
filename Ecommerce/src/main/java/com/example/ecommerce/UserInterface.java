package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class UserInterface {
 GridPane loginPage;
 HBox headerBar;

 HBox footerBar;
 Button signInButton;
 Label welcomeLabel;
 VBox body;
 Customer loggedInCustomer;

 ProductList productList = new ProductList();

 OrderList orderList = new OrderList();
 VBox productPage;
 VBox orderPage;

 Button placeOrderButton = new Button("Place Order");


 ObservableList<Product> itemsInCart = FXCollections.observableArrayList();


    public BorderPane createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(800,600);

        Image backgroundImage = new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\img1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(root.getPrefWidth());
        backgroundImageView.setFitHeight(root.getPrefHeight());
        root.getChildren().add(backgroundImageView);

        //root.getChildren().add(loginPage);
        root.setTop(headerBar);
        //root.setCenter(loginPage);
        body = new VBox();
        body.setPadding(new Insets(10));
        body.setAlignment(Pos.CENTER);
        root.setCenter(body);
        productPage = productList.getAllProducts();
        body.getChildren().add(productPage);

        root.setBottom(footerBar);

        return root;
    }

    public UserInterface(){
        createLoginPage();
        createHeaderBar();
        createFooterBar();

    }
    private void createLoginPage(){



        TextField userName = new TextField("pavanagasal@gmail.com");
        userName.setPromptText("Type your user name here:");
        userName.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333; -fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-radius: 5px; -fx-padding: 5px;");

        PasswordField password = new PasswordField();
        password.setText("abc123");
        password.setPromptText("Type your password here:");
        password.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333; -fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-radius: 5px; -fx-padding: 5px;");


        HBox userNameBox = new HBox();
        userNameBox.setAlignment(Pos.CENTER_LEFT);
        userNameBox.setSpacing(5);

// Create an ImageView for the icon and set its size
        ImageView userIcon = new ImageView(new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\username.png"));
        userIcon.setFitHeight(50);
        userIcon.setFitWidth(50);

// Add the icon and the TextField to the HBox
        userNameBox.getChildren().addAll(userIcon, userName);

        HBox passwordBox = new HBox();
        passwordBox.setAlignment(Pos.CENTER_LEFT);
       passwordBox.setSpacing(5);

        ImageView passIcon = new ImageView(new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\password.png"));
        passIcon.setFitHeight(40);
        passIcon.setFitWidth(40);

// Add the icon and the TextField to the HBox
        userNameBox.getChildren().addAll(passIcon, password);

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        messageLabel.setTextFill(Color.web("white"));

        Image logo = new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\loginicon.png");
        ImageView logoView = new ImageView(logo);

        Text loginLabel = new Text("Welcome Back! " +
                                  "Login to Continue");

        loginLabel.setFill(Color.BLACK);
        loginLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button loginButton = new Button("Login");


        loginButton.setStyle("-fx-background-color:  darkslateblue; -fx-text-fill: white; -fx-font-size:18px; -fx-font-weight: bold;");

        loginPage = new GridPane();
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(0);
        loginPage.setVgap(5);

        // Add image to center and above username field
        loginPage.add(logoView, 1, 0);
        loginPage.add(loginLabel,1,1,1,1);
        loginPage.add(userIcon, 0, 2);
        loginPage.add(userName, 1, 2);
        loginPage.add(passIcon, 0, 3);
        loginPage.add(password, 1, 3);
        loginPage.add(messageLabel, 0, 4, 2, 1);
        loginPage.add(loginButton, 1, 4);


        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = userName.getText();
                String pass = password.getText();
                Login login = new Login();
                loggedInCustomer=login.customerLogin(name,pass);
                if(loggedInCustomer!=null){

                    welcomeLabel.setText("Hello, "+loggedInCustomer.getName());
                    welcomeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
                    headerBar.getChildren().add(welcomeLabel);
                    body.getChildren().clear();
                    body.getChildren().add((productPage));
                    footerBar.setVisible(true);
                }
                else{
                    messageLabel.setText("Login Failed !! please give correct usename and password");
                }
            }
        });

    }

    private void createHeaderBar(){
        Button homeButton = new Button();
        Image image = new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\shopping.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        homeButton.setGraphic(imageView);
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search here");
        searchBar.setPrefWidth(300);
        searchBar.setPrefHeight(35);

        Button searchButton = new Button();
        searchButton.setStyle("-fx-background-color:  white;");
        Image image1 = new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\img4.png");
        ImageView imageView1= new ImageView();
        imageView1.setImage(image1);
        imageView1.setFitHeight(25);
        imageView1.setFitWidth(25);
        searchButton.setGraphic(imageView1);


         signInButton = new Button("Sign In");
        signInButton.setStyle("-fx-background-color:  darkslateblue; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
         welcomeLabel = new Label();

         Button cartButton = new Button();
        Image image2 = new Image("C:\\Users\\ADMIN\\IdeaProjects\\Ecommerce\\src\\main\\resources\\cart1.png");
        ImageView imageView2= new ImageView();
        imageView2.setImage(image2);
        imageView2.setFitHeight(40);
        imageView2.setFitWidth(40);
        cartButton.setGraphic(imageView2);

        Button ordersButton = new Button("Orders");
        ordersButton.setStyle("-fx-background-color:  darkslateblue; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");



        headerBar = new HBox();
        //headerBar.setStyle("-fx-background-color:grey");
        headerBar.setPadding(new Insets(10));
        headerBar.setSpacing(10);
        headerBar.setAlignment(Pos.CENTER);
        headerBar.getChildren().addAll(homeButton,searchBar,searchButton,signInButton,cartButton,ordersButton);


        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                footerBar.setVisible(false);
                body.getChildren().add(loginPage);
                headerBar.getChildren().remove(signInButton);
            }
        });
        cartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               body.getChildren().clear();
               VBox prodPage = productList.getProductsInCart(itemsInCart);
               prodPage.setAlignment(Pos.CENTER);
               productPage.setSpacing(10);
               prodPage.getChildren().add(placeOrderButton);
               body.getChildren().add(prodPage);
               footerBar.setVisible(false);
            }
        });

        ordersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                VBox orderPage = orderList.getAllProducts();
                body.getChildren().add(orderPage);
                footerBar.setVisible(false);
            }
        });

        placeOrderButton.setStyle("-fx-background-color:  darkslateblue; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(itemsInCart==null){
                    //select product first
                    showDialog("Please add some products in the cart to place order!");
                    return;
                }
                if(loggedInCustomer == null){
                    showDialog("Please login first to place order");
                    return;
                }
                int count=Order.placeMultipleOrder(loggedInCustomer,itemsInCart);
                if(count!=0)
                {
                    showDialog("Order for "+count+" product placed successfully!!");
                    itemsInCart.clear();
                }
                else{
                    showDialog("Order failed!");
                }
            }
        });
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(productPage);
                footerBar.setVisible(true);
                if(loggedInCustomer == null &&headerBar.getChildren().indexOf(signInButton)==-1){

                    headerBar.getChildren().add(signInButton);
                    //
                }
            }
        });


    }

    private void createFooterBar(){

        Button buyNowButton = new Button("BuyNow");
        buyNowButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setStyle("-fx-background-color:  darkslateblue; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");


        // Add the image to the VBox
        footerBar = new HBox();
        //headerBar.setStyle("-fx-background-color:grey");
        footerBar.setPadding(new Insets(10));
        footerBar.setSpacing(10);
        footerBar.setAlignment(Pos.CENTER);
        footerBar.getChildren().addAll(buyNowButton,addToCartButton);

        buyNowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct();
                if(product==null){
                    //select product first
                    showDialog("Please select a product first to place order!");
                    return;
                }
                if(loggedInCustomer == null){
                    showDialog("Please login first to place order");
                    return;
                }
                boolean status=Order.placeOrder(loggedInCustomer,product);
                if(status==true)
                {
                    showDialog("Order placed successfully!!");
                }
                else{
                    showDialog("Order failed!");
                }
            }
        });
        addToCartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct();
                if(product==null){
                    //select product first
                    showDialog("Please select a product first to add it to Cart!");
                    return;
                }
                itemsInCart.add(product);
                showDialog("Selected item has been added to the cart successfully!!");
            }
        });
    }


    private void showDialog(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setTitle("Message");
        alert.showAndWait();
    }

}
