package edu.uafs.model;

public class OrderDetails {
    private int orderDetailsID;
    private int orderID;
    private int bakeryItemID;
    private int quantity;

    
    public OrderDetails(int orderDetailsID, int orderID, int bakeryItemID, int quantity) {
        super();
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.bakeryItemID = bakeryItemID;
        this.quantity = quantity;
    }
    
    public int getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getBakeryItemID() {
        return bakeryItemID;
    }

    public void setBakeryItemID(int bakeryItemID) {
        this.bakeryItemID = bakeryItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

