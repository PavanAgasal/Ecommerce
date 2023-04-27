package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable;

    public VBox createTable(ObservableList<Product> data){
        //columns
        TableColumn<Product, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setStyle("-fx-alignment: CENTER;");

        TableColumn<Product, String> name = new TableColumn<>("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");

        TableColumn<Product, Double> price = new TableColumn<>("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setStyle("-fx-alignment: CENTER;");


        productTable = new TableView<>();
        productTable.getColumns().addAll(id,name,price);
        productTable.setItems(data);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        productTable.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-font-size: 14px; -fx-font-family: 'Arial';");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(productTable);

        return vBox;
    }

    public VBox getAllProducts(){
        ObservableList<Product> data= Product.getAllProducts();
        return createTable(data);
    }
    public Product getSelectedProduct(){
       return productTable.getSelectionModel().getSelectedItem();

    }
    public VBox getProductsInCart(ObservableList<Product> data){
        return createTable(data);
    }


}
