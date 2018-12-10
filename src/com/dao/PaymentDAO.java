package com.dao;
import java.sql.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.model.Addintocart;

public class PaymentDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

    //private static DataSource dataSource;
	public double totalprice(String username) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		double pri=0;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con = dataSource.getConnection();
				Statement stmt=con.createStatement();
			String query="select sum(price_per_book) from add_to_cart where customer_id='"+username+"' and order_id not like 'ORD%'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				pri=rs.getDouble(1);
			}
			System.out.println(pri);
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
		return pri;
	}
	
}
