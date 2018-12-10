package com.model;
import java.util.*;
public class newuserdetails {

	String name;
	String pass;
	Date date;
	String number;
	String email;
	public newuserdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public newuserdetails(String name, String pass, Date date, String number,
			String email) {
		super();
		this.name = name;
		this.pass = pass;
		this.date = date;
		this.number = number;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
