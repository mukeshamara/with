package com.model;

public class cancelmenu {

	Integer book_id;
	Integer quantity;
	String book_name;
	public cancelmenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cancelmenu(Integer book_id, Integer quantity, String book_name) {
		super();
		this.book_id = book_id;
		this.quantity = quantity;
		this.book_name = book_name;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	
}
