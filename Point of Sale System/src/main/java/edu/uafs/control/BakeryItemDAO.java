package edu.uafs.control;

import edu.uafs.model.BakeryItems;
import edu.uafs.system.UAParms;
import edu.uafs.view.UADataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author encry
 */



public class BakeryItemDAO implements UADataAccess<BakeryItems> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<BakeryItems> getAllItemsFromDatabase() {
        
        List<BakeryItems> items = new ArrayList<>();
        
        String sql = "SELECT * FROM BakeryItems";
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
               
                    
               int bakeryId = rs.getInt("itemID");
               String itemName = rs.getString("itemname");
               String desc = rs.getString("desc");
               double price = rs.getDouble("price");
                    
               items.add(new BakeryItems(bakeryId, itemName, desc, price));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public BakeryItems getItem(int key) {
        BakeryItems bakeryItem = null;
        String sql = "SELECT ITEMID, ITEMNAME, DESC, PRICE FROM BakeryItems WHERE ITEMID = (?)";
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
               int bakeryId = rs.getInt("itemID");
               String itemName = rs.getString("itemname");
               String desc = rs.getString("desc");
               double price = rs.getDouble("price");
               
               bakeryItem = new BakeryItems(bakeryId, itemName, desc, price);
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return bakeryItem;
    }

    @Override
    public void update(BakeryItems item) {
     
        String sql = "UPDATE BakeryItems set itemid = (?), itemname = (?), desc = (?), price = (?)";
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

            pstmt.setInt(1, item.getBakeryItemID());
            pstmt.setString(2,item.getBakeryItemName());
            pstmt.setString(3, item.getBakeryItemDescription());
            pstmt.setDouble(4, item.getBakeryItemPrice());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(BakeryItems item) {
        
        
        String sql = "DELETE FROM BakeryItems WHERE ITEMID = (?)";
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

            pstmt.setInt(1, item.getBakeryItemID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(BakeryItems item) {
      
        String sql = "INSERT INTO BakeryItems VALUES (Default, ? , ? , ? )";
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

            
            pstmt.setString(1,item.getBakeryItemName());
            pstmt.setString(2, item.getBakeryItemDescription());
            pstmt.setDouble(3, item.getBakeryItemPrice());
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }
    
}
