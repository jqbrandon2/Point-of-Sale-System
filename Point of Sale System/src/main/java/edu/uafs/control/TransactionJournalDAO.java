package edu.uafs.control;

import edu.uafs.model.TransactionJournal;
import edu.uafs.system.UAParms;
import edu.uafs.view.UADataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;



public class TransactionJournalDAO implements UADataAccess<TransactionJournal> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<TransactionJournal> getAllItemsFromDatabase() {
        
        List<TransactionJournal> items = new ArrayList<>();
        
        String sql = "SELECT * FROM TransactionJournal";
        Connection con;
        PreparedStatement pstmt;
        String user = parms.getUsername();
        String pass = parms.getPassword();
        String url = parms.getUrl();

        try {

            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

        try {
            con = DriverManager.getConnection(url, user, pass);

            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();

           
           while(rs.next()) {   
               
                    
        	   int journalID = rs.getInt("journalID");
        	   String journalDescription = rs.getString("journalDescription");
        	   double journalAmount = rs.getDouble("journalAmount");
        	   String journalTime = rs.getString("journalTime");
                    
               items.add(new TransactionJournal(journalID, journalDescription, journalAmount, journalTime));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public TransactionJournal getItem(int key) {
    	TransactionJournal inv = null;
        String sql = "SELECT journalID, journalDescription, journalAmount, journalTime FROM TransactionJournal WHERE journalID = (?)";
        Connection con;
        PreparedStatement pstmt;
        String user = parms.getUsername();
        String pass = parms.getPassword();
        String url = parms.getUrl();

        try {

            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

        try {
            con = DriverManager.getConnection(url, user, pass);

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, key);
            
            ResultSet rs = pstmt.executeQuery();

           if(rs.next()) {
        	   int journalID = rs.getInt("journalID");
        	   String journalDescription = rs.getString("journalDescription");
        	   double journalAmount = rs.getDouble("journalAmount");
        	   String journalTime = rs.getString("journalTime");
               
               inv = (new TransactionJournal(journalID, journalDescription, journalAmount, journalTime));
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return inv;
    }

    @Override
    public void update(TransactionJournal item) {
     
        String sql = "UPDATE TransactionJournal set journalID = (?), journalDescription = (?), journalAmount = (?), journalTime = (?)";
        Connection con;
        PreparedStatement pstmt;
        String user = parms.getUsername();
        String pass = parms.getPassword();
        String url = parms.getUrl();

        try {

            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

        try {
            con = DriverManager.getConnection(url, user, pass);

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, item.getJournalID());
            pstmt.setString(2,item.getJournalDescription());
            pstmt.setDouble(3, item.getJournalAmount());
            pstmt.setString(4, item.getJournalTime());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(TransactionJournal item) {
        
        
        String sql = "DELETE FROM TransactionJournal WHERE journalID = (?)";
        Connection con;
        PreparedStatement pstmt;
        String user = parms.getUsername();
        String pass = parms.getPassword();
        String url = parms.getUrl();

        try {

            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

        try {
            con = DriverManager.getConnection(url, user, pass);

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, item.getJournalID());
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(TransactionJournal item) {
      
        String sql = "INSERT INTO TransactionJournal VALUES (Default, ? , ? , ? )";
        Connection con;
        PreparedStatement pstmt;
        String user = parms.getUsername();
        String pass = parms.getPassword();
        String url = parms.getUrl();

        try {

            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

        try {
            con = DriverManager.getConnection(url, user, pass);

            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,item.getJournalDescription());
            pstmt.setDouble(2, item.getJournalAmount());
            pstmt.setString(3, item.getJournalTime());
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }

}
