package com.example.ecommerce;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Orders {
    private SimpleIntegerProperty id;

    private SimpleStringProperty productName;
    private SimpleIntegerProperty quantity;
    private SimpleStringProperty order_date;
    private SimpleStringProperty order_status;

    public Orders(int id, String productName, int quantity, String order_date, String order_status) {
        this.id = new SimpleIntegerProperty(id);
        this.productName = new SimpleStringProperty(productName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.order_date = new SimpleStringProperty(order_date);
        this.order_status = new SimpleStringProperty(order_status);
    }

    public static ObservableList<Orders> getAllOrders(){
        String selectAllOrders = "select orders.id,product.name as productName,orders.quantity,orders.order_date,orders.order_status from orders join product on orders.product_id = product.id";
        return fetchOrderData(selectAllOrders);
    }

    public static ObservableList<Orders> fetchOrderData(String query){
        ObservableList<Orders> data = FXCollections.observableArrayList();
        DbConnection dbConnection = new DbConnection();
        try {
            ResultSet rs = dbConnection.getQueryTable(query);
            while (rs.next()){

                Orders order = new Orders(rs.getInt("id"), rs.getString("productName"), rs.getInt("quantity"), rs.getString("order_date"), rs.getString("order_status"));
                data.add(order);
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id.get();
    }

   public String getProductName(){
        return  productName.get();

   }

    public int getQuantity() {
        return quantity.get();
    }

    public String getOrder_date() {
        return order_date.get();
    }

    public String getOrder_status() {
        return order_status.get();
    }
}
