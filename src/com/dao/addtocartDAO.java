package com.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.model.*;

public class addtocartDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

   // private static DataSource dataSource;
	public int addintocart(long id,String book_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
			//String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				
			String query="insert into add_to_cart values(?,?,?,?,?)";
			//con=dataSource.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setInt(4,Integer.parseInt(book_id));
			ps.setString(5, Long.toString(id));
			ps.setString(3, "");
		ps.setDouble(2, 0);
			rs=ps.executeUpdate();
			
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
		return rs;
	}
	
	public List<Addintocart> search() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		List<Addintocart> cart=new ArrayList<>();
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			//con=dataSource.getConnection();
			Statement stmt=con.createStatement();	
			String query="select * from add_to_cart";
			ResultSet rs1=stmt.executeQuery(query);
			if(rs1.next())
			{
				Long quantity=rs1.getLong(1);
				Long book_id=rs1.getLong(2);
				String cus_id=rs1.getString(3);
				String ord_id=rs1.getString(4);
				Double price=rs1.getDouble(5);
				Addintocart ad=new Addintocart(quantity, book_id, cus_id,ord_id, price);
				cart.add(ad);
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
		return cart;
	}

public boolean checkincart(String book_id,long id2) throws ClassNotFoundException, SQLException
{
	Connection con=null;
	boolean rs=false;
	try
	{
			//String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
		//con=dataSource.getConnection();
		Statement stmt=con.createStatement();	
		int bookid=Integer.parseInt(book_id);
		String id=Long.toString(id2);
		String query="select * from add_to_cart where book_id="+bookid+" and customer_id='"+id+"' and order_id not like 'ORD%'";
		ResultSet rs2=stmt.executeQuery(query);
		if(rs2.next())
		{
			rs=true;
		}
	}catch(Exception ex)
	{
		System.out.println(ex+" 123");
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
	return rs;
}



public int checkuserincart(String id) throws ClassNotFoundException, SQLException
{
	Connection con=null;
	int x=0;
	try
	{
		//String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			Statement stmt=con.createStatement();
		String query="select * from add_to_cart where customer_id='"+id+"'";
		//con=dataSource.getConnection();
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{
			x++;
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
	return x;
}


public int ordereddetails(String id) throws ClassNotFoundException, SQLException
{
	Connection con=null;
	int x=0;
	try
	{
		//String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			Statement stmt=con.createStatement();
		String query="select * from add_to_cart where customer_id='"+id+"' and order_id like 'ORD%'";
		//con=dataSource.getConnection();
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{
			x++;
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
	return x;
}


}
