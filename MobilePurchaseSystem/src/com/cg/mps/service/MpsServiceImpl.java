package com.cg.mps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.mps.dao.MpsDao;
import com.cg.mps.dao.MpsDaoImpl;
import com.cg.mps.exceptions.MPSException;
import com.cg.mps.model.Mobiles;
import com.cg.mps.model.PurchaseDetails;

public class MpsServiceImpl implements MpsService {

	MpsDao dao = new MpsDaoImpl();
	List<String> list = new ArrayList<>();

	@Override
	public int insertMobileDetails(Mobiles mobiles) throws MPSException {
		// TODO Auto-generated method stub
		return dao.insertMobileDetails(mobiles);
	}

	@Override
	public boolean validateFields(PurchaseDetails details) {

		boolean resultFlag = false;

		if (!checkName(details.getcName())) {

			list.add("Maximum length of Name is 20 and start with uppercase");

		}

		if (!checkMailId(details.getMailId())) {

			list.add("Mail ID must contain characters and '@' symbol");
		}
		if (!checkPhoneNumber(details.getPhoneNumber())) {

			list.add("Phone Number must contain 10 digits and then start with 6|7|8|9");
		}
		if (!checkMobileId(details.getMobileID())) {
			list.add("Mobile ID must contains 4 digits number only ");

		}

		if (!list.isEmpty()) {

			System.out.println(list + "");
		} else {
			resultFlag = true;
		}

		return resultFlag;
	}

	public boolean checkName(String name) {
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{1,19}$";

		return Pattern.matches(nameRegEx, name);

	}

	public boolean checkMailId(String mailId) {

		String mailRegEx = "[a-zA-Z]{1}[a-zA-Z0-9._]*@[A-Za-z]*\\.[a-zA-Z]*";
		return Pattern.matches(mailRegEx, mailId);
	}

	public boolean checkPhoneNumber(Long phoneNumber) {

		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}$";
		return Pattern.matches(phoneRegEx, phoneNumber.toString());
	}

	public boolean checkMobileId(Integer mobileId) {

		String mobileRegEx = "[0-9]{4}$";

		return Pattern.matches(mobileRegEx, mobileId.toString());

	}

	@Override
	public int updateMobileQuantity(PurchaseDetails details) throws MPSException {
		return dao.updateMobileQuantity(details);
	}

	@Override
	public List<Mobiles> selectAllMobiles() throws MPSException {
		return dao.selectAllMobiles();
	}

	@Override
	public int deleteRow(Integer id) throws MPSException {
		return dao.deleteRow(id);
	}

	@Override
	public List<Mobiles> mobileBetweenRange(Double startRange, Double endRange) throws MPSException {
		return dao.mobileBetweenRange(startRange, endRange);
	}

}
