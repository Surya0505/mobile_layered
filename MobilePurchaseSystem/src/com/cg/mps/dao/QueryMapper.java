package com.cg.mps.dao;

public interface QueryMapper {

	public static final String insertQuery = "insert into mobiles values(?,?,?,?)";
	public static final String checkMobileId = "select * from mobiles";
	public static final String updateQuantity = "update mobiles set quantity=? where mobile_id=?";
	public static final String insertPurchaseDetails = "insert into purchasedetails values( purchase_id_seq.nextval,?,?,?,sysdate,?)";
	public static final String selectAllMobiles = "select * from mobiles";
	public static final String DeleteRow = "delete from mobiles where mobile_id=?";
	public static final String mobileBetweenRange = "select * from mobiles where price between ? and ?";

}
