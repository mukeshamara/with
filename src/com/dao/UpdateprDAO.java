package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class UpdateprDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

   // private static DataSource dataSource;
	public static int update(double price,int quanneeded,int bo_id) throws ClassNotFoundException, SQLException

    {
		

		// List<String> books = new ArrayList<>();
		 Connection con=null;
		 PreparedStatement ps = null;
         int rs = 0;
         String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
         String query = "update add_to_cart set quantity_needed=?,price_per_book=? where book_id=?";
         String val="";
         double topr=quanneeded*price;
         try

         {

        	// con = dataSource.getConnection();
                         ps = con.prepareStatement(query);
                         ps.setInt(1, quanneeded);
                         ps.setDouble(2,topr);
                         ps.setInt(3, bo_id);
                         rs = ps.executeUpdate();
    
         }catch(Exception ex)

         {

                         System.out.println("Exception at UserDAO find user method: "+ex);

         }

         finally

         {

                         try{

                                         if(con!=null)

                                         {

                                                         con.close();

                                         }

                         }catch(Exception ex2)

                         {

                                         System.out.println("Exception while closing conn at find user: "+ex2);

                         }

         }

         return rs;

}

	
	 public static int reserve(int booid,int qct) throws ClassNotFoundException, SQLException

     {

                     int res=0;

                     Connection con=null;

                     PreparedStatement ps = null;

                     String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
         			Class.forName("com.mysql.jdbc.Driver");
         			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
                     String query = "update product set quantity=quantity-? where book_id=?";

                     try

                     {

                    	 //con = dataSource.getConnection();

                                     ps = con.prepareStatement(query);

                                     ps.setInt(1, qct);

                                     ps.setInt(2, booid);

                                    

                                     res = ps.executeUpdate();

                     }catch(Exception ex)

                     {

                                     System.out.println("Exception at UserDAO find user method: "+ex);

                     }

                     finally

                     {

                                     try{

                                                     if(con!=null)

                                                     {

                                                                     con.close();

                                                     }

                                     }catch(Exception ex2)

                                     {

                                                     System.out.println("Exception while closing conn at find user: "+ex2);

                                     }

                     }

                    

                     return res;

     }

    
	
}
