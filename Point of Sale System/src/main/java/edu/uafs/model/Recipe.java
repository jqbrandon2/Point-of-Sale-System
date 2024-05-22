package edu.uafs.model;

public class Recipe {
    private int recipeID;
    private int bakeryItemID;
    private int invID;
    private int invQtyNeeded;

    
    public Recipe(int recipeID, int bakeryItemID, int invID, int invQtyNeeded) {
        super();
        this.recipeID = recipeID;
        this.bakeryItemID = bakeryItemID;
        this.invID = invID;
        this.invQtyNeeded = invQtyNeeded;
    }
    
    
    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getBakeryItemID() {
        return bakeryItemID;
    }

    public void setBakeryItemID(int bakeryItemID) {
        this.bakeryItemID = bakeryItemID;
    }

    public int getInvID() {
        return invID;
    }

    public void setInvID(int invID) {
        this.invID = invID;
    }

    public int getInvQtyNeeded() {
        return invQtyNeeded;
    }

    public void setInvQtyNeeded(int invQtyNeeded) {
        this.invQtyNeeded = invQtyNeeded;
    }
}
