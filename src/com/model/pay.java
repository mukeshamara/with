package com.model;

public class pay {

	String acc_no;
	String bakname;
	String ifsc_code;
	Double amount;
	public pay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pay(String acc_no, String bakname, String ifsc_code, Double amount) {
		super();
		this.acc_no = acc_no;
		this.bakname = bakname;
		this.ifsc_code = ifsc_code;
		this.amount = amount;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getBakname() {
		return bakname;
	}
	public void setBakname(String bakname) {
		this.bakname = bakname;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
}
