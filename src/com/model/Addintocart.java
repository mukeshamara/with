package com.model;

public class Addintocart {

	Long quantity;
	Long book_id;
	String cus_id;
	String ord_id;
	Double price;
	public Addintocart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	public String getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(String ord_id) {
		this.ord_id = ord_id;
	}

	public Addintocart(Long quantity, Long book_id, String cus_id,
			String ord_id, Double price) {
		super();
		this.quantity = quantity;
		this.book_id = book_id;
		this.cus_id = cus_id;
		this.ord_id = ord_id;
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	
	
}
