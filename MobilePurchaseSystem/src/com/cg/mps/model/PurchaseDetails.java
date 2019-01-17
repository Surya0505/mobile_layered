package com.cg.mps.model;

import java.util.Date;

public class PurchaseDetails {
	
	private Integer purchaseId;
	private String cName;
	private String mailId;
	private Long phoneNumber;
	private Date purchaseDate;
	private Integer mobileID; 
	
	public PurchaseDetails() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseDetails(Integer purchaseId, String cName, String mailId, Long phoneNumber, Date purchaseDate,
			Integer mobileID) {
		super();
		this.purchaseId = purchaseId;
		this.cName = cName;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.purchaseDate = purchaseDate;
		this.mobileID = mobileID;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getMobileID() {
		return mobileID;
	}

	public void setMobileID(Integer mobileID) {
		this.mobileID = mobileID;
	}
	
	
}
