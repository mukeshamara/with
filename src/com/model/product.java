package com.model;

public class product {

	String cat_name;
	Integer cat_id;
	Integer book_id;
	String book_name;
	String language;
	Double price;
	String binding;
	String delivery_time;
	String author_name;
	Integer Quantity;
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(String cat_name, Integer cat_id, Integer book_id,
			String book_name, String language, Double price, String binding,
			String delivery_time, String author_name, Integer quantity) {
		super();
		this.cat_name = cat_name;
		this.cat_id = cat_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.language = language;
		this.price = price;
		this.binding = binding;
		this.delivery_time = delivery_time;
		this.author_name = author_name;
		Quantity = quantity;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "product [cat_name=" + cat_name + ", cat_id=" + cat_id
				+ ", book_id=" + book_id + ", book_name=" + book_name
				+ ", language=" + language + ", price=" + price + ", binding="
				+ binding + ", delivery_time=" + delivery_time
				+ ", author_name=" + author_name + ", Quantity=" + Quantity
				+ "]";
	}
	
	
	
	
}
