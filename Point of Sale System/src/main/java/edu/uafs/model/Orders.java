package edu.uafs.model;

public class Orders {
    private int orderID;
    private String orderDate;
    private String orderTime;
    private int customersCustID;

    public Orders(int orderID, String orderDate, String orderTime, int customersCustID) {
        super();
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.customersCustID = customersCustID;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getCustomersCustID() {
        return customersCustID;
    }

    public void setCustomersCustID(int customersCustID) {
        this.customersCustID = customersCustID;
    }
}

