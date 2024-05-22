package edu.uafs.model;

public class Inventory {
    private int invID;
    private String invName;
    private String invDescription;
    private int qtyOnHand;
    private int invReorderAmt;
    private int inReorderPrice;

     public Inventory(int invID, String invName, String invDescription, int qtyOnHand) {
        super();
        this.invID = invID;
        this.invName = invName;
        this.invDescription = invDescription;
        this.qtyOnHand = qtyOnHand;
    }
    
    public int getInvID() {
        return invID;
    }

    public void setInvID(int invID) {
        this.invID = invID;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = invDescription;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public int getInvReorderAmt() {
        return invReorderAmt;
    }

    public void setInvReorderAmt(int invReorderAmt) {
        this.invReorderAmt = invReorderAmt;
    }

    public int getInReorderPrice() {
        return inReorderPrice;
    }

    public void setInReorderPrice(int inReorderPrice) {
        this.inReorderPrice = inReorderPrice;
    }
}

