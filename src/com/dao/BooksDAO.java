package com.dao;
import java.util.*;
import java.sql.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
public class BooksDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

   // private static DataSource dataSource;
	public  List<Integer> findbooks(String from) throws ClassNotFoundException, SQLException

    {
                    List<Integer> books = new ArrayList<>();
                    Connection con=null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
        			Class.forName("com.mysql.jdbc.Driver");
        			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
                    String query = "Select book_id from add_to_cart where customer_id='"+from+"' and price_per_book=0";
                    try
                    {

                    	//con=dataSource.getConnection();
                                    stmt=con.createStatement();
                                    rs = stmt.executeQuery(query);
                                    while(rs.next())
                                    {
                                    	int bid=rs.getInt(1);
                                    
                                    	books.add(bid);
                                    }
                     }catch(Exception ex)
            		{
             			System.out.println(ex);
             		}
             		finally
             		{
             			try
             			{
             				if(con!=null)
             				{
             					con.close();
             					
             				}
             			}catch(Exception ex1)
             			{
             			System.out.println("closed");	
             			}
             		}
             		return books;
                              
}
	
	public  String search(int bookid) throws SQLException, ClassNotFoundException

    {

		// List<String> books = new ArrayList<>();
		 Connection con=null;
		 PreparedStatement ps = null;
         ResultSet rs = null;
       
         String query = "Select book_id,book_name,price,quantity from product where book_id=?";
         String val="";
        // String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
         try

         {

        	// con=dataSource.getConnection();

                         ps = con.prepareStatement(query);

                         ps.setInt(1, bookid);
                         rs = ps.executeQuery();
                         
                         if(rs.next())

                         {
                        	 			val = "{\"bid\":\""+rs.getInt(1)+"\",";
                                         val+="\"bname\":\""+rs.getString(2)+"\",";
                                         val+="\"price\":\""+rs.getDouble(3)+"\",";
                                         val+="\"tobo\":\""+rs.getInt(4)+"\"}";

                         }

                        

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

         return val;

}

}
