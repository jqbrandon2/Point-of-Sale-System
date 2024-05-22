package edu.uafs.model;

public class TransactionJournal {
    private int journalID;
    private String journalDescription;
    private double journalAmount;
    private String journalTime;

    
    public TransactionJournal(int journalID, String journalDescription, double journalAmount, String journalTime) {
        super();
        this.journalID = journalID;
        this.journalDescription = journalDescription;
        this.journalAmount = journalAmount;
        this.journalTime = journalTime;
    }
    
    public int getJournalID() {
        return journalID;
    }

    public void setJournalID(int journalID) {
        this.journalID = journalID;
    }

    public String getJournalDescription() {
        return journalDescription;
    }

    public void setJournalDescription(String journalDescription) {
        this.journalDescription = journalDescription;
    }

    public double getJournalAmount() {
        return journalAmount;
    }

    public void setJournalAmount(double journalAmount) {
        this.journalAmount = journalAmount;
    }

    public String getJournalTime() {
        return journalTime;
    }

    public void setJournalTime(String journalTime) {
        this.journalTime = journalTime;
    }
}
