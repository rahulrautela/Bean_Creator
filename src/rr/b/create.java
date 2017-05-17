
package rr.b;

import java.sql.*;
import java.sql.DatabaseMetaData;
import java.util.*;
import tsol.data.DBManager;
import java.io.*;

public class create {
   
    public static void cfile()
  {
      
    
   
       
                     

      try
      {
          Connection con;
          Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","username","password");
      
        Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from tableName");
        ResultSetMetaData rsmd = rs.getMetaData();
        int col= rsmd.getColumnCount();
    		
    		File file =new File("FILEPATH.java");   //d:\Bean.java
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		
    		FileWriter fw = new FileWriter("FILEPATH.java");	 //d:\Bean.java
               // String data = " public class Beans" + fileWritter.write("\n") + "{";
    	        BufferedWriter bw = new BufferedWriter(fw);
    	        bw.write(" public class Beans {");
                bw.write(System.getProperty("line.separator"));
               String dt[]= DBManager.getdt();
               String p[]= DBManager.getp();
               for(int i=0;i<col;i++)
               {bw.write(dt[i]+" "+p[i]+";");
               bw.write(System.getProperty("line.separator"));
               }
                bw.write(System.getProperty("line.separator"));
               
                for(int i=0;i<col;i++)
               {
               bw.write("public"+" "+dt[i]+" "+"get"+p[i]+"()");
               bw.write(System.getProperty("line.separator"));
               bw.write("{");
               bw.write(System.getProperty("line.separator"));
               bw.write("  "+"return"+" "+p[i]+";");
               bw.write(System.getProperty("line.separator"));
               bw.write("}");
               bw.write(System.getProperty("line.separator"));
               bw.write(System.getProperty("line.separator"));
               
                bw.write("public void "+"set"+p[i]+"("+dt[i]+" "+p[i]+")");
               bw.write(System.getProperty("line.separator")); 
               bw.write("{");
               bw.write(System.getProperty("line.separator"));
               bw.write("  "+"this."+p[i]+"="+p[i]+";");
               bw.write(System.getProperty("line.separator"));
               bw.write("}");
               bw.write(System.getProperty("line.separator"));
               bw.write(System.getProperty("line.separator"));
               }
                bw.write("}");
               
                bw.close();
      }
      catch(Exception ex){
      System.out.println(ex.getMessage());
      }
      }
    
}
