package com.dao;
import com.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class searchDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

    //private static DataSource dataSource;
	public List<product> search(String category)
	{
		List<product> searchlist=new ArrayList<>();
		Connection con=null;
		User u1=null;
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con = dataSource.getConnection();
				Statement stmt=con.createStatement();
				
		
			String query="select * FROM product where category_name='"+category+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				String cat_name=rs.getString(1);
				int cat_id=rs.getInt(2);
				int book_id=rs.getInt(3);
				String book_name=rs.getString(4);
				String language=rs.getString(5);
				Double price=rs.getDouble(6);
				String binding=rs.getString(7);
				String delivery_time=rs.getString(8);
				String author_name=rs.getString(9);
				int quantity=rs.getInt(10);
				product p=new product(cat_name, cat_id, book_id, book_name, language, price, binding, delivery_time, author_name, quantity);
				searchlist.add(p);
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
		return searchlist;
	}
	
}
