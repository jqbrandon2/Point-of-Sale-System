package edu.uafs.control;

import edu.uafs.model.Customers;
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



public class CustomerDAO implements UADataAccess<Customers> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<Customers> getAllItemsFromDatabase() {
        
        List<Customers> items = new ArrayList<>();
        
        String sql = "SELECT * FROM Customers";
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
               
                    
               int custID = rs.getInt("custid");
               String firstname = rs.getString("firstname");
               String lastname = rs.getString("lastname");
               
                    
               items.add(new Customers(custID, firstname, lastname));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public Customers getItem(int key) {
        Customers cust = null;
        String sql = "SELECT CUSTID, FIRSTNAME, LASTNAME FROM CUSTOMERS WHERE CUSTID = (?)";
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
               int custID = rs.getInt("custid");
               String firstname = rs.getString("firstname");
               String lastname = rs.getString("lastname");
              
               
               cust = new Customers(custID, firstname, lastname);
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return cust;
    }

    @Override
    public void update(Customers item) {
     
        String sql = "UPDATE CUSTOMERS set CUSTID = (?), FIRSTNAME = (?), LASTNAME = (?)";
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

            pstmt.setInt(1, item.getCustID());
            pstmt.setString(2,item.getCustFirstName());
            pstmt.setString(3, item.getCustLastName());
           
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(Customers item) {
        
        
        String sql = "DELETE FROM CUSTOMERS WHERE CUSTID = (?)";
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

            pstmt.setInt(1, item.getCustID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(Customers item) {
      
        String sql = "INSERT INTO CUSTOMERS VALUES (Default, ? , ? )";
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

            
            pstmt.setString(1,item.getCustFirstName());
            pstmt.setString(2, item.getCustLastName());
           
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }
    
}

