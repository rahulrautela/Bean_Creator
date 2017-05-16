package tsol.data;
import java.sql.*;
import java.util.*;
import java.io.*;

public class DBManager 
{
 private static Connection con ;
    static
            {
            try
                {
                    String url= "jdbc:mysql://localhost:3306/pro";
                    String user= "root";
                    String pass= "root";
                    Class.forName("com.mysql.jdbc.Driver");
                    con= DriverManager.getConnection(url,user, pass);
                    
               
                }
            catch(Exception ex)
                {
                    throw new RuntimeException(ex.getMessage());
                }
    }  
    
    
    public static String[] getdt() throws SQLException
    {
    String h =null;
    
     Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from dept");
   ResultSetMetaData rsmd = rs.getMetaData();
        int col= rsmd.getColumnCount();
    
        String[] pk,ck;
       pk= new String[col];
       DatabaseMetaData dmd = con.getMetaData();
    rs= dmd.getColumns("", "", "dept", "");
      rsmd = rs.getMetaData();
       int i=0;
    
       while(rs.next())
    {
    
       
    pk[i] =rs.getString("TYPE_NAME"); 
   // ck[i] =rs.getString("COLUMN_NAME");
    if(pk[i].equalsIgnoreCase("varchar"))
        pk[i]= "String";
    
   i++;
   
        
        }
    return pk;
    }
     
 
public static String[] getp() throws SQLException
    {
    String h =null;
    
     Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from dept");
   ResultSetMetaData rsmd = rs.getMetaData();
        int col= rsmd.getColumnCount();
    
        String[] pk,ck;
       ck= new String[col];
       DatabaseMetaData dmd = con.getMetaData();
    rs= dmd.getColumns("", "", "dept", "");
      rsmd = rs.getMetaData();
       int i=0;
    
       while(rs.next())
    {
    
       
   // pk[i] =rs.getString("TYPE_NAME"); 
    ck[i] =rs.getString("COLUMN_NAME");
    if(ck[i].equalsIgnoreCase("varchar"))
        ck[i]= "String";
    
   i++;
   
        
        }
    return ck;
    }
}
    
    
  


