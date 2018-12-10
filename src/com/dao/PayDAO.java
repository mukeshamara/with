package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.model.newuserdetails;
import com.view.*;

public class PayDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

    //private static DataSource dataSource;
	public int checkincart(String id,String or_id,double pr,String accno,String bankname,String ifsccode,double totalamount) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			 //con = dataSource.getConnection();
			String query="insert into order_payment_screen values(?,?,?,?,?,?,?,now())";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, or_id);
			ps.setDouble(3,pr);
			ps.setString(4, accno);
			ps.setString(5, bankname);
			ps.setString(6,ifsccode);
			ps.setDouble(7,totalamount);
			
		rs=ps.executeUpdate();
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

	
	public String orderid() throws ClassNotFoundException, SQLException
	{
		newuserdetails u1=null;
		Connection con=null;
		String num="";
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con = dataSource.getConnection();
		
			String query="select order_id from order_payment_screen order by 1 desc";
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery(query);
			
			
	if(rs1.next())
	{
		String num1=rs1.getString(1);
		String a[]=num1.split("-");
		int r=Integer.parseInt(a[1]);
		r++;
		num=a[0]+"-"+Integer.toString(r);
		
	}
	else
	{
		num="ORD-1000";
	}
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"not here");
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
		
		return num;
	}
	
	public int updateincart(String or_id,int bo_id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		int rs=0;
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con = dataSource.getConnection();
			
			String query="update add_to_cart set order_id=? where book_id=? and order_id not like 'ORD%'";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, or_id);
			ps.setInt(2, bo_id);
		rs=ps.executeUpdate();
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
	
	public List<Integer> incart(String id) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		List<Integer> rs=new ArrayList<>();
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con = dataSource.getConnection();
			
			String query="select book_id from add_to_cart where price_per_book>0 and customer_id='"+id+"' and order_id not like 'ORD%'";
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery(query);
			while(rs1.next())
			{
				rs.add(rs1.getInt(1));
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
	
}
