package com.cg.mps.model;

public class Mobiles {
	private Integer mobileId;
	private String name;
	private Double price;
	private Integer quantity;
	
	public Mobiles() {
		// TODO Auto-generated constructor stub
	}

	public Mobiles(Integer mobileId, String name, Double price, Integer quantity) {
		super();
		this.mobileId = mobileId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
