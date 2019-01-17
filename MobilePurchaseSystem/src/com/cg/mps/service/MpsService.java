package com.cg.mps.service;

import java.util.List;

import com.cg.mps.exceptions.MPSException;
import com.cg.mps.model.Mobiles;
import com.cg.mps.model.PurchaseDetails;

public interface MpsService {

	int insertMobileDetails(Mobiles mobiles) throws MPSException;

	boolean validateFields(PurchaseDetails details);

	int updateMobileQuantity(PurchaseDetails details) throws MPSException;

	List<Mobiles> selectAllMobiles() throws MPSException;

	int deleteRow(Integer id)throws MPSException;

	List<Mobiles> mobileBetweenRange(Double startRange, Double endRange) throws MPSException;

}
