package edu.uafs.control;

import edu.uafs.model.Inventory;
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



public class InventoryDAO implements UADataAccess<Inventory> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<Inventory> getAllItemsFromDatabase() {
        
        List<Inventory> items = new ArrayList<>();
        
        String sql = "SELECT * FROM Inventory";
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
               
                    
               int invid = rs.getInt("invid");
               String itemname = rs.getString("itemname");
               String desc = rs.getString("desc");
               int qty = rs.getInt("qty");
                    
               items.add(new Inventory(invid, itemname, desc, qty));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public Inventory getItem(int key) {
        Inventory inv = null;
        String sql = "SELECT INVID, ITEMNAME, DESC, QTY FROM INVENTORY WHERE INVID = (?)";
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
              int invid = rs.getInt("invid");
               String itemname = rs.getString("itemname");
               String desc = rs.getString("desc");
               int qty = rs.getInt("qty");
               
               inv = (new Inventory(invid, itemname, desc, qty));
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return inv;
    }

    @Override
    public void update(Inventory item) {
     
        String sql = "UPDATE INVENTORY set INVID = (?), ITEMNAME = (?), DESC = (?), QTY = (?)";
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

            pstmt.setInt(1, item.getInvID());
            pstmt.setString(2,item.getInvName());
            pstmt.setString(3, item.getInvDescription());
            pstmt.setInt(4, item.getQtyOnHand());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(Inventory item) {
        
        
        String sql = "DELETE FROM INVENTORY WHERE INVID = (?)";
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

            pstmt.setInt(1, item.getInvID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(Inventory item) {
      
        String sql = "INSERT INTO INVENTORY VALUES (Default, ? , ? , ? )";
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

            
            pstmt.setString(1,item.getInvName());
            pstmt.setString(2, item.getInvDescription());
            pstmt.setInt(3, item.getQtyOnHand());
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }
    
}
