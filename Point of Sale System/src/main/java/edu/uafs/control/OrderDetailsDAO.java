package edu.uafs.control;

import edu.uafs.model.OrderDetails;
import edu.uafs.system.UAParms;
import edu.uafs.view.UADataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;



public class OrderDetailsDAO implements UADataAccess<OrderDetails> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<OrderDetails> getAllItemsFromDatabase() {
        
        List<OrderDetails> items = new ArrayList<>();
        
        String sql = "SELECT * FROM OrderDetails";
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
               
                    
        	   int orderDetailsID = rs.getInt("orderDetailsID");
               int orderID = rs.getInt("orderID");
               int bakeryItemID = rs.getInt("bakeryItemID");
               int quantity = rs.getInt("quantity");
                    
               items.add(new OrderDetails(orderDetailsID, orderID, bakeryItemID, quantity));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public OrderDetails getItem(int key) {
        OrderDetails inv = null;
        String sql = "SELECT orderDetailsID, orderID, bakeryItemID, quantity FROM OrderDetails WHERE orderDetailsID = (?)";
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
        	   int orderDetailsID = rs.getInt("orderDetailsID");
               int orderID = rs.getInt("orderID");
               int bakeryItemID = rs.getInt("bakeryItemID");
               int quantity = rs.getInt("quantity");
               
               inv = (new OrderDetails(orderDetailsID, orderID, bakeryItemID, quantity));
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return inv;
    }

    @Override
    public void update(OrderDetails item) {
     
        String sql = "UPDATE OrderDetails set orderDetailsID = (?), orderID = (?), bakeryItemID = (?), quantity = (?)";
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

            pstmt.setInt(1, item.getOrderDetailsID());
            pstmt.setInt(2,item.getOrderID());
            pstmt.setInt(3, item.getBakeryItemID());
            pstmt.setInt(4, item.getQuantity());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(OrderDetails item) {
        
        
        String sql = "DELETE FROM OrderDetails WHERE orderDetailsID = (?)";
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

            pstmt.setInt(1, item.getOrderDetailsID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(OrderDetails item) {
      
        String sql = "INSERT INTO OrderDetails VALUES (Default, ? , ? , ? )";
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
            
            pstmt.setInt(1,item.getOrderID());
            pstmt.setInt(2, item.getBakeryItemID());
            pstmt.setInt(3, item.getQuantity());;
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }

}

