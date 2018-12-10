package com.dao;
import java.sql.*;

import com.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.model.User;
import com.model.product;
public class CancelDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

   // private static DataSource dataSource;
	public int cancellation(String or_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
				
			
			String query="delete from order_payment_screen where order_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,or_id);
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
	
	
	public int deletefromcart(String or_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			//con=dataSource.getConnection();
			
			String query="delete from add_to_cart where order_id=? and price_per_book>0";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,or_id);
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
	
	public int update(int c,int book_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
			//con=dataSource.getConnection();
			
			String query="update product set quantity=quantity+? where book_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,c);
			ps.setInt(2,book_id);
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
	
	public List<cancelmenu> search(String or_id)
	{
		List<cancelmenu> searchlist=new ArrayList<>();
		Connection con=null;
		cancelmenu u1=null;
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
				Statement stmt=con.createStatement();
				
		
			String query="select quantity_needed,book_id from add_to_cart where order_id='"+or_id+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int quantity=rs.getInt(1);
				int book_id=rs.getInt(2);
				String book_name=CancelDAO.searchbook(book_id);
				u1=new cancelmenu(book_id, quantity, book_name);
				searchlist.add(u1);
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
	
	public int search(String or_id,String cus_id)
	{
		
		Connection con=null;
		int u1=0;
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				Statement stmt=con.createStatement();
				
		
			String query="select * from order_payment_screen where order_id='"+or_id+"' and customer_id='"+cus_id+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				u1=4;
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
		return u1;
	}
	
	public static String searchbook(int bo_id)
	{
		
		Connection con=null;
		String u1="";
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				Statement stmt=con.createStatement();
				
		
			String query="select book_name from product where book_id="+bo_id;
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				u1=rs.getString(1);
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
		return u1;
	}
	
	public int checktheorder(String cus_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int x=0;
		String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
				
			
			String query="select * from order_payment_screen where customer_id='"+cus_id+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				x=4;
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
	
	public int checktime(String or_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int z=0;
		int y=0;
		int t=48*6;
		String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
		try
		{
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
				
			
			String query="select timestampdiff(Minute,orderedDate,now()) from order_payment_screen where order_id='"+or_id+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				y=rs.getInt(1);
				System.out.println(y);
				if(y<t)
				{
					z=4;
				}
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
		return z;
	}
	
}
