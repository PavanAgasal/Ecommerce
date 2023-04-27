package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Date;

public class OrderList {
    private TableView<Orders> productTable;

    public VBox createTable(ObservableList<Orders> data){
        //columns
        TableColumn<Orders, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setStyle("-fx-alignment: CENTER;");

        TableColumn<Orders, String> name = new TableColumn<>("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        name.setStyle("-fx-alignment: CENTER; -fx-font-weight: bold;");

        TableColumn<Orders, Integer> quantity = new TableColumn<>("QUANTITY");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantity.setStyle("-fx-alignment: CENTER;");

        TableColumn<Orders, String> date = new TableColumn<>("ORDER_DATE");
       date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        date.setStyle("-fx-alignment: CENTER;");

        TableColumn<Orders, String> status = new TableColumn<>("ORDER_STATUS");
        status.setCellValueFactory(new PropertyValueFactory<>("order_status"));
        status.setStyle("-fx-alignment: CENTER;");


        productTable = new TableView<>();
        productTable.getColumns().addAll(id,name,quantity,date,status);
        productTable.setItems(data);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        productTable.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-font-size: 14px; -fx-font-family: 'Arial';");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(productTable);

        return vBox;
    }

    public VBox getAllProducts(){
        ObservableList<Orders> data= Orders.getAllOrders();
        return createTable(data);
    }
    public Orders getSelectedProduct() {
        return productTable.getSelectionModel().getSelectedItem();
    }

}
