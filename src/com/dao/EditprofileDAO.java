package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.model.newuserdetails;

import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
public class EditprofileDAO {
	//@Resource(lookup = "java:comp/env/jdbc/mfrppro")

    //private static DataSource dataSource;
	public int editprofile(String or_id,String name,String dob,String number,String email) throws ClassNotFoundException, SQLException, ParseException
	{
		Connection con=null;
		int rs=0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date d=sdf.parse(dob);
		try
		{
			String url="jdbc:mysql://localhost:3306/mfrpproject";   //last jdbc is database which we created
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfrpproject","root","root");
				//String url="jdbc:mysql://localhost:3306/mfrp";   //last jdbc is database which we created
			//con=dataSource.getConnection();
			
				String query="update customer_registration set name=?,date_of_birth=?,contact_number=?,email_address=? where customer_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1,name);
		
				ps.setDate(2, new java.sql.Date(d.getTime()));
				ps.setString(3,number);
				ps.setString(4,email);
				ps.setString(5,or_id);
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
	
}
