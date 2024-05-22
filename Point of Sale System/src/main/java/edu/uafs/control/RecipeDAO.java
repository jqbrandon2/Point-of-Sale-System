package edu.uafs.control;

import edu.uafs.model.Recipe;
import edu.uafs.system.UAParms;
import edu.uafs.view.UADataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;



public class RecipeDAO implements UADataAccess<Recipe> {

    UAParms parms = new UAParms();
    
    
    @Override
    public List<Recipe> getAllItemsFromDatabase() {
        
        List<Recipe> items = new ArrayList<>();
        
        String sql = "SELECT * FROM Recipe";
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
               
                    
        	   int recipeID = rs.getInt("recipeID");
        	   int bakeryItemID = rs.getInt("bakeryItemID");
               int invID = rs.getInt("invID");
               int invQtyNeeded = rs.getInt("invQtyNeeded");
                    
               items.add(new Recipe(recipeID, bakeryItemID, invID, invQtyNeeded));
              
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return items;
        
    }

    @Override
    public Recipe getItem(int key) {
        Recipe inv = null;
        String sql = "SELECT recipeID, bakeryItemID, invID, invQtyNeeded FROM Recipe WHERE recipeID = (?)";
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
        	   int recipeID = rs.getInt("recipeID");
        	   int bakeryItemID = rs.getInt("bakeryItemID");
               int invID = rs.getInt("invID");
               int invQtyNeeded = rs.getInt("invQtyNeeded");
               
               inv = (new Recipe(recipeID, bakeryItemID, invID, invQtyNeeded));
               
           }

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
        return inv;
    }

    @Override
    public void update(Recipe item) {
     
        String sql = "UPDATE Recipe set recipeID = (?), bakeryItemID = (?), invID = (?), invQtyNeeded = (?)";
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

            pstmt.setInt(1, item.getRecipeID());
            pstmt.setInt(2,item.getBakeryItemID());
            pstmt.setInt(3, item.getInvID());
            pstmt.setInt(4, item.getInvQtyNeeded());
            
            pstmt.execute();

         

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
       
    }

    @Override
    public void delete(Recipe item) {
        
        
        String sql = "DELETE FROM Recipe WHERE recipeID = (?)";
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

            pstmt.setInt(1, item.getRecipeID()); 
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
    }

    @Override
    public void insert(Recipe item) {
      
        String sql = "INSERT INTO Recipe VALUES (Default, ? , ? , ? )";
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
            
            pstmt.setInt(1,item.getBakeryItemID());
            pstmt.setInt(2, item.getInvID());
            pstmt.setInt(3, item.getInvQtyNeeded());
            
            
            pstmt.execute();

            con.close();

        } catch(Exception ex) {
            ex.printStackTrace();
           
        }
  
    }

}

