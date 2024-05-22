package edu.uafs.control;

import edu.uafs.model.Orders;
import edu.uafs.system.UAParms;
import edu.uafs.view.UADataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;



public class OrderDAO implements UADataAccess<Orders> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<Orders> getAllItemsFromDatabase() {
        
        List<Orders> items = new ArrayList<>();
        
        String sql = "SELECT * FROM Orders";
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
               
                    
               int orderID = rs.getInt("orderID");
               String orderDate = rs.getString("orderDate");
               String orderTime = rs.getString("orderTime");
               int customersCustID = rs.getInt("customersCustID");
                    
               items.add(new Orders(orderID, orderDate, orderTime, customersCustID));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public Orders getItem(int key) {
        Orders inv = null;
        String sql = "SELECT orderID, orderDate, orderTime, customersCustID FROM Orders WHERE orderID = (?)";
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
        	   int orderID = rs.getInt("orderID");
               String orderDate = rs.getString("orderDate");
               String orderTime = rs.getString("orderTime");
               int customersCustID = rs.getInt("customersCustID");
               
               inv = (new Orders(orderID, orderDate, orderTime, customersCustID));
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return inv;
    }

    @Override
    public void update(Orders item) {
     
        String sql = "UPDATE Orders set orderID = (?), orderDate = (?), orderTime = (?), customersCustID = (?)";
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

            pstmt.setInt(1, item.getOrderID());
            pstmt.setString(2,item.getOrderDate());
            pstmt.setString(3, item.getOrderTime());
            pstmt.setInt(4, item.getCustomersCustID());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(Orders item) {
        
        
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

            pstmt.setInt(1, item.getOrderID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(Orders item) {
      
        String sql = "INSERT INTO Orders VALUES (Default, ? , ? , ? )";
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

            
            pstmt.setString(1,item.getOrderDate());
            pstmt.setString(2, item.getOrderTime());
            pstmt.setInt(3, item.getCustomersCustID());
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }

}

	
