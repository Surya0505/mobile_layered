package com.cg.mps.dao.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mps.dao.MpsDao;
import com.cg.mps.dao.MpsDaoImpl;
import com.cg.mps.exceptions.MPSException;
import com.cg.mps.model.Mobiles;
import com.cg.mps.model.PurchaseDetails;

public class MpsDaoImplTest {

	MpsDao dao = null;
	ResultSet ResultSet = null;

	@Before
	public void setUp() throws Exception {
		dao = new MpsDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testInsertMobileDetails() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		purchaseDetails.setcName("Surya");
		purchaseDetails.setMailId("surya@gmail.com");
		purchaseDetails.setPhoneNumber(9655032993l);
		purchaseDetails.setMobileID(1001);
		int dupRecord = 0;

		try {
			dupRecord = dao.updateMobileQuantity(purchaseDetails);
		} catch (MPSException e) {
			e.printStackTrace();
		}
		assertEquals(1, dupRecord);

	}

	@Test
	public void testMobileBetweenRange() {
		List<Mobiles> list = new ArrayList<>();
		try {
			list =dao.mobileBetweenRange(5000d, 10000d);
		} catch (MPSException e) {
			e.printStackTrace();
		}
		int dupRecord=0;
		if (list.size()>0) {
			dupRecord=1;
		}
		assertEquals(1, dupRecord);
	}

}
