package com.jk.entity;

public class Goods {

	private int num;
	private String name;
	private String type;
	private double  price;
	private String date;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double  getPrice() {
		return price;
	}
	public void setPassword(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date= date;
	}
	public Goods(int num, String name, String type, double price, String date) {
		super();
		this.num= num;
		this.name = name;
		this.type = type;
		this.price = price;
		this.date= date;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", type=" + type + ", price=" + price + ", date=" + date
				+ "]";
	}

	
	
	
	
	


}
