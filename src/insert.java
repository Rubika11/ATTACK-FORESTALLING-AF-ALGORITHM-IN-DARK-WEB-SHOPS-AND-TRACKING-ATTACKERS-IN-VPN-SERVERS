
import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class insert {
     public void insert1( String tblname,String a ,String b,String c,String d,String e)
    {
         try
            {
//            Class.forName("oracle.jdbc.OracleDriver");
//            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
//            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "system");
           String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
               Class.forName("com.mysql.jdbc.Driver");
               String DB_URL = "jdbc:mysql://localhost:3306/sdep?autoReconnect=true";
             Connection con = DriverManager.getConnection(DB_URL,"root","system");
                
                PreparedStatement ps;
            String sql;
            sql="insert into "+tblname+" values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,a);
            ps.setString(2,b);
            ps.setString(3,c);
            ps.setString(4,d);
            ps.setString(5,e);
                        
            
            ps.executeUpdate();
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println("insert_exception===>Signup"+ex);
            }
    
    }

   
   
}
