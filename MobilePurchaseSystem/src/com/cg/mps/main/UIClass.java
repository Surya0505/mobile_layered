package com.cg.mps.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.mps.exceptions.MPSException;
import com.cg.mps.model.Mobiles;
import com.cg.mps.model.PurchaseDetails;
import com.cg.mps.service.MpsService;
import com.cg.mps.service.MpsServiceImpl;

public class UIClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MpsService service = new MpsServiceImpl();
		List<Mobiles> list = new ArrayList<>();
//		boolean flag = false;
		int choice;
		do {
			System.out.println("===== Mobile Purchase System =====");
			System.out.println("1. Insert Mobile Details");
			System.out.println("2. Add Purchase Details");
			System.out.println("3. List of all Mobiles");
			System.out.println("4. Delete Mobile based on Mobile Id");
			System.out.println("5. View Mobiles based on Price Range");
			System.out.println("6. Exit");

			System.out.println("Enter your choice:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
//				flag = true;
		
				System.out.println("Enter mobile id");
				Integer mobileId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter brand name of the mobile");
				String name = scanner.nextLine();
				System.out.println("Enter price of the mobile");
				Double price = scanner.nextDouble();
				System.out.println("Enter quantity");
				Integer quantity = scanner.nextInt();

				if (quantity > 0) {
					Mobiles mobiles = new Mobiles();
					mobiles.setMobileId(mobileId);
					mobiles.setName(name);
					mobiles.setPrice(price);
					mobiles.setQuantity(quantity);

					try {
						int result = service.insertMobileDetails(mobiles);
						System.out.println(result + "Inserted");
					} catch (MPSException e) {
						System.out.println(e.getMessage());
					}

				} else {
					System.out.println("Quantity mustbe greater than zero");
				}
				
				break;

			case 2:
//				flag = true;
				scanner.nextLine();
				System.out.println("Enter customer name:");
				String cName = scanner.nextLine();
				System.out.println("Enter mail id:");
				String mailId = scanner.nextLine();
				System.out.println("Enter phone number:");
				Long phoneNumber = scanner.nextLong();
				System.out.println("Enter mobile id:");
				Integer mobileID = scanner.nextInt();

				PurchaseDetails details = new PurchaseDetails();
				details.setcName(cName);
				details.setMailId(mailId);
				details.setMobileID(mobileID);
				details.setPhoneNumber(phoneNumber);

				boolean validateFlag = service.validateFields(details);
				System.out.println(validateFlag);
				if (validateFlag) {
					try {
						int update = service.updateMobileQuantity(details);
						System.out.println(update + " row updated");
					} catch (MPSException e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 3:
//				flag = true;
				try {
					list = service.selectAllMobiles();
					System.out.println("Mobile Id" + "      " + "Mobile Name"
							+ "     " + "Price" + "      " + "Quantity");

					for (Mobiles mobiles : list) {
						System.out.println(mobiles.getMobileId() + "        "
								+ mobiles.getName() + "       "
								+ mobiles.getPrice() + "          "
								+ mobiles.getQuantity());
					}
				} catch (MPSException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 4:
//				flag = true;
				System.out.println("Enter ID to be deleted:");
				Integer id = scanner.nextInt();
				try {
					int result = service.deleteRow(id);
					System.out.println(result + "  row deleted");
				} catch (MPSException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 5:
//				flag = true;
				System.out.println("Enter the price range");
				Double startRange,
				endRange;
				startRange = scanner.nextDouble();
				endRange = scanner.nextDouble();
				try {
					list = service.mobileBetweenRange(startRange, endRange);
					System.out.println("Mobile Id" + "      " + "Mobile Name"
							+ "     " + "Price" + "      " + "Quantity");

					for (Mobiles mobiles : list) {
						System.out.println(mobiles.getMobileId() + "        "
								+ mobiles.getName() + "       "
								+ mobiles.getPrice() + "          "
								+ mobiles.getQuantity());
					}

				} catch (MPSException e) {
					System.out.println(e.getMessage());
				}

				break;
			
			case 6:
				
				return;
			default:
				System.out.println("Wrong Input  \nEnter again");
				break;
			}

		} while (choice!=0);

	}

}
