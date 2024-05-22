package edu.uafs.model;

public class BakeryItems {
    private int bakeryItemID;
    private String bakeryItemName;
    private String bakeryItemDescription;
    private double bakeryItemPrice;

    public BakeryItems(int itemID, String itemName, String desc, double price) {
        super();
        this.bakeryItemID = itemID;
        this.bakeryItemName = itemName;
        this.bakeryItemDescription = desc;
        this.bakeryItemPrice = price;
    }
    
    public int getBakeryItemID() {
        return bakeryItemID;
    }

    public void setBakeryItemID(int bakeryItemID) {
        this.bakeryItemID = bakeryItemID;
    }

    public String getBakeryItemName() {
        return bakeryItemName;
    }

    public void setBakeryItemName(String bakeryItemName) {
        this.bakeryItemName = bakeryItemName;
    }

    public String getBakeryItemDescription() {
        return bakeryItemDescription;
    }

    public void setBakeryItemDescription(String bakeryItemDescription) {
        this.bakeryItemDescription = bakeryItemDescription;
    }

    public double getBakeryItemPrice() {
        return bakeryItemPrice;
    }

    public void setBakeryItemPrice(double bakeryItemPrice) {
        this.bakeryItemPrice = bakeryItemPrice;
    }
}
