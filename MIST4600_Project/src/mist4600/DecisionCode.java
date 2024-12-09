package mist4600;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.Scanner;

public class DecisionCode {

	//View Current & Desired Stock Function
	public static void runScenOne(Scanner scnr) {
		
		String scenOneVar = "bleh";

		while (!scenOneVar.equals("Quit")) {
			System.out.println();
			System.out.println("Enter food name or \"Quit\" to exit");	
			
			scenOneVar = scnr.next().toLowerCase();
			
			if (scenOneVar.equalsIgnoreCase("quit")) {
				break;
			}
			
			MenuItem selectedItem = MenuItem.fetchFoodByName(scenOneVar);
			
			
			if(selectedItem != null) {
				System.out.println();
				selectedItem.printCurrentAndDesired(); 
				ChangeLog.changes.add("Current and desired stock values of " + selectedItem.getName() + " was viewed at " + LocalDateTime.now());
			}
			else {
				System.out.println();
				System.out.println("Food item not found");
			}
		}
		
	}
	
	//Change current stock function
	public static void runScenTwo(Scanner scnr) {
		
		String scenTwoVar = "bleh";
		
		while (!scenTwoVar.equals("Quit")) {
		
		System.out.println();
		System.out.println("Enter food name or \"Quit\" to exit");
		
		scenTwoVar = scnr.next().toLowerCase();
		
		if (scenTwoVar.equalsIgnoreCase("quit")) {
			break;
		}
		
		MenuItem selectedItem = MenuItem.fetchFoodByName(scenTwoVar);
		
		
		if(selectedItem != null) {
			System.out.println();
			System.out.println(selectedItem.getName() + "'s current stock is " + selectedItem.getCurrentStockLevel());
			System.out.println("Would you like to update stock? Type \"Y\" to proceed or anything else to go back");
			
			if (scnr.next().equalsIgnoreCase("Y")) {
				int oldStock = selectedItem.getCurrentStockLevel();
				System.out.println();
				System.out.println("Enter updated stock: ");
				int newStock = scnr.nextInt();
				selectedItem.setCurrentStockLevel(newStock);
				
				if (newStock > 0) {
					selectedItem.setInStock(true);
					System.out.println();
					System.out.println(selectedItem.getName() + "'s updated stock is " + selectedItem.getCurrentStockLevel());
					ChangeLog.changes.add("Current stock of " + selectedItem.getName() + " was changed from " + oldStock + " to " + selectedItem.getCurrentStockLevel() + " at " + LocalDateTime.now());
				}
				else if (newStock <= 0) {
					selectedItem.setInStock(false);
					System.out.println();
					System.out.println(selectedItem.getName() + "'s updated stock is " + selectedItem.getCurrentStockLevel() + ", it is now out of stock");
					ChangeLog.changes.add("Current stock of " + selectedItem.getName() + " was changed from " + oldStock + " to " + selectedItem.getCurrentStockLevel() + " at " + LocalDateTime.now() + "\n" + selectedItem.getName() + " is now out of stock.");
					}
				else {}
			}
			else {
				System.out.println();
			}

		}
		else {
			System.out.println("Food item not found");
		}
		
		
			
	}
		
	}
	
	//Change desired stock function
	public static void runScenThree(Scanner scnr) {
		
		String scenThreeVar = "bleh";
		
		while (!scenThreeVar.equals("Quit")) {
			
		System.out.println("Enter food name or \"Quit\" to exit");
		
		scenThreeVar = scnr.next().toLowerCase();
		
		if (scenThreeVar.equalsIgnoreCase("quit")) {
			break;
		}
		
		MenuItem selectedItem = MenuItem.fetchFoodByName(scenThreeVar);
		
		
		if(selectedItem != null) {
			System.out.println(selectedItem.getName() + "'s desired stock as of now is " + selectedItem.getDesiredStockLevel());
			System.out.println("Would you like to update the desired stock level for " + selectedItem.getName() + "? \nType \"Y\" to proceed or anything else to go back");
			
			if (scnr.next().equalsIgnoreCase("Y")) {
				int oldStock = selectedItem.getDesiredStockLevel();
				System.out.println("Enter updated desired stock level: ");
				int newStock = scnr.nextInt();
				scnr.nextLine();
				selectedItem.setDesiredStockLevel(newStock);
				System.out.println(selectedItem.getName() + "'s updated desired stock level is " + selectedItem.getDesiredStockLevel());
				ChangeLog.changes.add("Desired stock levels of " + selectedItem.getName() + " was changed from " + oldStock + " to " + selectedItem.getDesiredStockLevel() + " at " + LocalDateTime.now());
			}
			else {
				System.out.println();
				scnr.nextLine();
			}

		}
		else {
			System.out.println("Food item not found");
		}
		
		
			
	}
		
		
	}
	
	static String superSale;
	//Scenario 1 Main Code
	public static void runMainScenOne(Scanner scnr) {
		
		String initMainScenOne = "bleh";
		String selectCuban = "";
		
		while (!initMainScenOne.equalsIgnoreCase("Quit")) {
			
			
			
			System.out.println("Welcome to the Cuban Sandwich Ordering System!");
			System.out.println("Type \"1\" to continue, \"2\" to view open days, or \"Quit\" to return");
			
			initMainScenOne = scnr.next().toLowerCase();
			
			if (initMainScenOne.equalsIgnoreCase("Quit")) {
				break;
			}
			
			//Main Path
			if (initMainScenOne.equalsIgnoreCase("1")) {
				System.out.println();
				int numberList = 1;
				
				
					
				if (superSale != null) {
					System.out.println(superSale);
				}
				
				
				for (FoodItem sandwich : FoodItem.getCubanType()) {
					if (sandwich.isInStock()) {
						System.out.println(numberList + ": " + sandwich);
						++numberList;
					}
					else {}
				}
				
				System.out.println();
				System.out.println("Type name of cuban that you would like to order");
				
				selectCuban = scnr.next().toLowerCase();
				
				MenuItem selectedItem = MenuItem.fetchFoodByName(selectCuban);
				
				if(selectedItem != null) {
					System.out.println();
					System.out.println(selectedItem.getName() + " to be ordered\nInput number you would like to order:");
					
					int quantOrdered = 0;
					
					quantOrdered = scnr.nextInt();
					
					
					if (quantOrdered <= selectedItem.getCurrentStockLevel()) {
					System.out.println("Order Processing...");
					System.out.println("Your " + quantOrdered + " " + selectedItem.getName() + " will be ready shortly\nThank you for coming!");
					System.out.println();
					ChangeLog.changes.add(quantOrdered + " units of " + selectedItem.getName() + " were ordered at " + LocalDateTime.now());
					ChangeLog.suggestedChanges.add(quantOrdered + " units of " + selectedItem.getName() + " were ordered at " + LocalDateTime.now());
					break;
					}
					else {
						System.out.println(selectedItem.getName() + " is out of stock, returning to menu");
						System.out.println();
						
					}
					
				}
				else {
					System.out.println();
					System.out.println("Food item not found");
				}
			}
			//Check if open
			else if (initMainScenOne.equals("2")) {
				CheckOpenDay checkOpenDay = new CheckOpenDay();
				checkOpenDay.dayCheck(scnr);
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println("Error: Please input valid option");
			}
			
			
			
		}
		
	}
	
	//Scenario 2 Main Code
	public static void runScenFour(Scanner scnr) {
		
		String scenFourVar = "bleh";
		String initScenFourVar = "bleh";
		int sessionChanges = 0;
		
		while (!initScenFourVar.equals("Quit")) {
			
			System.out.println();
			System.out.println("Welcome to your auto inventory updating app! To get started select an option:\n1: Record stock change of menu item\n2: View list of inventory\n3: View order history of session\n4: View stock changes made this session\nType \"Quit\" to exit");
			
			
			initScenFourVar = scnr.next().toLowerCase();
			
			if (initScenFourVar.equalsIgnoreCase("quit")) {
				for (int i = 0; i < sessionChanges; ++i) {
					ChangeLog.delChangesMade();
				}
				
				break;
			}
			
			//Record stock changes of menu item
			if (initScenFourVar.equals("1")) {
				
			System.out.println("Type name of item you would like to record stock change for");
			
			scenFourVar = scnr.next();
			
			MenuItem selectedItem = MenuItem.fetchFoodByName(scenFourVar);
			
			
			if(selectedItem != null) {
				System.out.println(selectedItem.getName() + "'s latest stock value was " + selectedItem.getCurrentStockLevel());
				System.out.println("Would you like to record weekly stock update?\nType \"Y\" to continue or anything else to enter a different food");
				
				if (scnr.next().equalsIgnoreCase("Y")) {
					int oldStock = selectedItem.getCurrentStockLevel();
					System.out.println("Enter amount of " + selectedItem.getName() + " consumed since last record");
					int amtConsumed = scnr.nextInt();
					scnr.nextLine();
					int difference = oldStock - amtConsumed;
					selectedItem.setCurrentStockLevel(difference);
					System.out.println(selectedItem.getName() + "'s updated stock is " + selectedItem.getCurrentStockLevel());
					System.out.println("Amount of new stock of " + selectedItem.getName() + " to be ordered is " + (selectedItem.getDesiredStockLevel() - selectedItem.getCurrentStockLevel()));
					
					if (difference <= 0) {
						selectedItem.setInStock(false);
						System.out.println(selectedItem.getName() + " is now out of stock");
					}
					
					
					ChangeLog.changes.add(selectedItem.getName() + "'s stock was reported to be consumed " + amtConsumed + " units and the system has recommended " + (selectedItem.getDesiredStockLevel() - selectedItem.getCurrentStockLevel()) 
							+ " units be ordered for restock at " + LocalDateTime.now());
					ChangeLog.addChangesMade();
					++sessionChanges;
				}
				else {
					System.out.println();
					scnr.nextLine();
				}

			}
			
			else {
				System.out.println("Food item not found");
			}
			
			
			}
			//View list of inventory
			else if (initScenFourVar.equals("2")) {
				System.out.println("Inventory List");
				
				for (String key : MenuItem.foodDatabase.keySet()) {
					
					MenuItem selectedItem = MenuItem.fetchFoodByName(key);
					System.out.println("[" + selectedItem.getName() + "]" + " Current Stock: " + selectedItem.getCurrentStockLevel() + " Desired Stock: " + selectedItem.getDesiredStockLevel());
					
					
					
				}
			}
			//Prints a history of cuban sand ordered during Scenario 1. (Suggested that these stock adjustments be recorded)
			else if (initScenFourVar.equals("3")) {
				ChangeLog.printSuggestedChangeLog();
			}
			//View stock changes made this session
			else if (initScenFourVar.equals("4")) {
				//System.out.println(sessionChanges);
				//ChangeLog.printNumTempChangesMade();
				ChangeLog.tempPrintChangeLog();
			}
		}
			
		
		
		
		
	}
	
	//View Change log
	public static void runScenFive(Scanner scnr) {
		
		String scenFiveVar = "bleh";
		
		while (!scenFiveVar.equals("Quit")) {
			
		System.out.println("Type anything to view changelog or \"Quit\" to exit");
		
		scenFiveVar = scnr.next().toLowerCase();
		
		if (scenFiveVar.equalsIgnoreCase("quit")) {
			break;
		}
		
		ChangeLog.printChangeLog();
		
		
			
	}
		
		
		
		
	}
	
	//View entire inventory function
	public static void runScenSix(Scanner scnr) {
		
		String scenSixVar = "bleh";
		
		while (!scenSixVar.equals("Quit")) {
			
		System.out.println("Type anything to view inventory or \"Quit\" to exit");
		
		scenSixVar = scnr.next().toLowerCase();
		
		if (scenSixVar.equalsIgnoreCase("quit")) {
			break;
		}
		
	System.out.println("Inventory List");
		
	for (String key : MenuItem.foodDatabase.keySet()) {
		
		MenuItem selectedItem = MenuItem.fetchFoodByName(key);
		System.out.println("[" + selectedItem.getName() + "]" + " Current Stock: " + selectedItem.getCurrentStockLevel() + " Desired Stock: " + selectedItem.getDesiredStockLevel());
		
		
		
	}
	ChangeLog.changes.add("Inventory was viewed at " + LocalDateTime.now());
		
	}

	
	}
	
	//Test scenario (Return cuban sandwich hashset)
	public static void runScenSev(Scanner scnr) {
		
		String scenSevVar = "bleh";
		
		while (!scenSevVar.equals("Quit")) {
			
		System.out.println("Type anything to view list of Cuban subs or \"Quit\" to exit");
		
		scenSevVar = scnr.next().toLowerCase();
		
		if (scenSevVar.equalsIgnoreCase("quit")) {
			break;
		}
	
		for (FoodItem sandwich : FoodItem.getCubanType()) {
			System.out.println(sandwich);
		}

		
	
	ChangeLog.changes.add("Inventory was viewed at " + LocalDateTime.now());
		}
	}

		
		//Honors Scenario
		public static void runScenHonors(Scanner scnr) {
			
			String scenEightVar = "bleh";
			
			while (!scenEightVar.equals("Quit")) {
				
			System.out.println("Type \"1\" to proceed with current date, \"2\" to manually enter a date, or \"Quit\" to exit");
			
			scenEightVar = scnr.next().toLowerCase();
			
			if (scenEightVar.equalsIgnoreCase("quit")) {
				break;
			}
			
			String specialItem = "bleh";
			String specialItemType = "bleh";
			String specialMeat = "bleh";
			
			//Uses Current Computer Date
			if (scenEightVar.equals("1")) {
		
				var currDate = MonthDay.now();
				
				String week1 = "01|02|03|04|05|06|07";
				String week2 = "08|09|10|11|12|13|14";
				String week3 = "15|16|17|18|19|20|21|22";
				String week4 = "23|24|25|26|27|28|29|30";
				String thirtyFirstSpecial = "31";
				
			
				
				
				if(currDate.toString().substring(5).matches(week1)) {

					specialItem = "Quesadillas";
					specialItemType = "quesadilla";
				}
				else if(currDate.toString().substring(5).matches(week2)) {

					specialItem = "Cuban Sandwiches";
					specialItemType = "cuban";
					
				}
				else if(currDate.toString().substring(5).matches(week3)) {

					specialItem = "Burritos";
					specialItemType = "burrito";
				}
				else if(currDate.toString().substring(5).matches(week4)) {

					specialItem = "Tacos";
					specialItemType = "taco";
				}
				else if(currDate.toString().substring(5).matches(thirtyFirstSpecial)) {
					System.out.println("Today is the 31st Bottomless Chips and Queso Special!");
					System.out.println("Enjoy both our classic queso and chips for half off!");
					MenuItem bottomlessQueso = MenuItem.fetchFoodByName("Queso");
					MenuItem bottomlessChips = MenuItem.fetchFoodByName("Chips");
					
					if (bottomlessChips.getPrice() != 0.50) {
					try {
						Thread.sleep(1000);
						System.out.println("---------------------------------------");
						System.out.println("SYSTEM MESSAGE: Activating Bottomless Chips/Queso Special");
						Thread.sleep(500);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.println("...");
						Thread.sleep(1000);
						

						bottomlessQueso.setPrice(bottomlessQueso.getPrice() - (bottomlessQueso.getPrice()*.5));
						bottomlessChips.setPrice(bottomlessChips.getPrice() - (bottomlessChips.getPrice()*.5));
						
						System.out.println("Price Successfully Updated!");
						Thread.sleep(500);
						System.out.print("Updating Menu Message for Customers: \"");
						Thread.sleep(1000);
						System.out.println("Enjoy our bottomless " + bottomlessChips.getName() + " and " + bottomlessQueso.getName() + " super sale, only on every 31st!");
						System.out.println("Both are half off! Get your Queso now for only $" + bottomlessQueso.getPrice() + " and your chips for $" + bottomlessChips.getPrice() + "!");
						System.out.println("---------------------------------------\n");
						Thread.sleep(1000);
						ChangeLog.changes.add("Bottomless Chips and Queso Super Sale Activated! Both items' prices have been halved for today at " + LocalDateTime.now());
						break;
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else if (bottomlessChips.getPrice() == 0.50) {
						System.out.println("Bottomless Chips and Queso Special Already Activated! Returning to main menu...\n");
						break;
					}
				}
				
				
				
				System.out.println("This week's special item are " + specialItem + "! (All " + specialItem + " are 5% off!)");
				
				System.out.println("Activate specials' sale?\nType \"Activate\" To Proceed or \"Quit\" to Return to Scenario Selection");
				String specialSale = "bleh";
				specialSale = scnr.next();
				if (specialSale.equalsIgnoreCase("Activate")) {
				System.out.println("SYSTEM MESSAGE: Reducing price of all " + specialItem + " by 5%");
				
				for (FoodItem specialType : FoodItem.getFoodItems()) {
					if (specialType.getItemType().equals(specialItemType)) {
						
						specialType.setPrice(specialType.getPrice() - (specialType.getPrice()*.05));
						
					}
					else {}
				}
				try {
					System.out.print("...");
					Thread.sleep(1000);
					System.out.print("...");
					Thread.sleep(1000);
					System.out.print("...");
					Thread.sleep(1000);
					System.out.println("...");
					Thread.sleep(1000);
					System.out.println("Prices successfully updated!");
					ChangeLog.changes.add("Weekly Sale activated, prices of " + specialItem + " have been reduced by 5% at " + LocalDateTime.now());
					Thread.sleep(2000);
					System.out.println();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				else if (specialSale.equalsIgnoreCase("Quit")) {
					System.out.println("Returning...");
					break;
				}
				else {
					System.out.println("Input valid option\n");
				}

				
				var currDay = DayOfWeek.from(LocalDate.now());
			
		
				
				if (currDay.toString().equalsIgnoreCase("Monday")) {
					System.out.print("Monday's Super Special is the ");
					specialMeat = "Steak";
				}
				else if (currDay.toString().equalsIgnoreCase("Tuesday")) {
					System.out.print("Tuesday's Super Special is the ");
					specialMeat = "Chorizo";
				}
				else if (currDay.toString().equalsIgnoreCase("Wednesday")) {
					System.out.print("Wednesday's Super Special is the ");
					specialMeat = "For Kids";
				}
				else if (currDay.toString().equalsIgnoreCase("Thursday")) {
					System.out.print("Thursday's Super Special is the ");
					specialMeat = "Pork";
				}
				else if (currDay.toString().equalsIgnoreCase("Friday")) {
					System.out.print("Friday's Super Special is the ");
					specialMeat = "Vegetarian";
				}
				else if (currDay.toString().equalsIgnoreCase("Saturday")) {
					System.out.print("Saturday's Super Special is the ");
					specialMeat = "Lamb";
				}
				else if (currDay.toString().equalsIgnoreCase("Sunday")) {
					System.out.print("Sunday's Super Special is the ");
					specialMeat = "Chicken";
				}
				else {
					System.out.println("error...");
				}
								
				for (FoodItem special : FoodItem.getFoodItems()) {
					if (special.getItemType().equals(specialItemType) && special.getMeatType().equals(specialMeat)) {
						System.out.println(special.getName());
					}
				}
				
				System.out.println("Activate The Daily Super Special? (20% discount)\nType \"Activate\" To Proceed or \"Quit\" to Return");
				String superSpecialSale = "bleh";
				superSpecialSale = scnr.next();
						
				if (superSpecialSale.equalsIgnoreCase("Activate")) {
				
					for (FoodItem special : FoodItem.getFoodItems()) {
						if (special.getItemType().equals(specialItemType) && special.getMeatType().equals(specialMeat)) {
							
							try {
								System.out.println("Activating " + special.getName() + " Super Sale!");
								special.setPrice(special.getPrice()/.95);
								special.setPrice(special.getPrice() - (special.getPrice()*.2));
								Thread.sleep(1000);
								System.out.println("SYSTEM MESSAGE: Reducing price of " + special.getName() + " by 20%");
								Thread.sleep(1000);
								System.out.print("...");
								Thread.sleep(200);
								System.out.print("...");
								Thread.sleep(200);
								System.out.print("...");
								Thread.sleep(200);
								System.out.println("...");
								Thread.sleep(1000);
								System.out.println("Price is successfully updated!");
								ChangeLog.changes.add("Daily Super Sale activated, price of " + special.getName() + " has been reduced by 20% at " + LocalDateTime.now());
								Thread.sleep(1000);
								

								
								System.out.print("Updating Menu Message for Customers: \"");
								Thread.sleep(1000);
								System.out.print("The " + special.getName() + " is on a super sale today for $");
								System.out.printf("%.2f", special.getPrice());
								System.out.println("!\"");
								superSale = "The " + special.getName() + " is on a super sale today for $" + special.getPrice() + "!";
								special.setName(special.getName() + "(20% Super Sale)");
								
								
								Thread.sleep(1000);
								System.out.println();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
								
									
							
						}
					
				
			}
				
			}
			else if(superSpecialSale.equalsIgnoreCase("Quit")) {
				System.out.println("Returning...\n");
				
			}
			else {
				System.out.println("Input valid response");
			}
				
			}
			//Input Specific Date
			else if (scenEightVar.equals("2")) {
			
				
				String week1 = "01|02|03|04|05|06|07|1|2|3|4|5|6|7";
				String week2 = "08|8|09|9|10|11|12|13|14";
				String week3 = "15|16|17|18|19|20|21|22";
				String week4 = "23|24|25|26|27|28|29|30";
				String thirtyFirstSpecial = "31";
				
				System.out.println("Enter a date (DD) and its corresponding day as two seperate entries");
				String userEnteredDate = scnr.next();
				String currDay = scnr.next();

				
				if(userEnteredDate.matches(week1)) {
					

					specialItem = "Quesadillas";
					specialItemType = "quesadilla";
				}
				else if(userEnteredDate.matches(week2)) {
					
					
					specialItem = "Cuban Sandwiches";
					specialItemType = "cuban";
				}
				else if(userEnteredDate.matches(week3)) {
					
					
					specialItem = "Burritos";
					specialItemType = "burrito";
				}
				else if(userEnteredDate.matches(week4)) {
					
					specialItem = "Tacos";
					specialItemType = "taco";
				}
				else if(userEnteredDate.matches(thirtyFirstSpecial)) {
					System.out.println("Today is the 31st Bottomless Chips and Queso Special!");
					System.out.println("Enjoy both our classic queso and chips for half off!");
					MenuItem bottomlessQueso = MenuItem.fetchFoodByName("Queso");
					MenuItem bottomlessChips = MenuItem.fetchFoodByName("Chips");
					
					if (bottomlessChips.getPrice() != 0.50) {
					try {
						Thread.sleep(1000);
						System.out.println("---------------------------------------");
						System.out.println("SYSTEM MESSAGE: Activating Bottomless Chips/Queso Special");
						Thread.sleep(500);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.print("...");
						Thread.sleep(1000);
						System.out.println("...");
						Thread.sleep(1000);
						

						bottomlessQueso.setPrice(bottomlessQueso.getPrice() - (bottomlessQueso.getPrice()*.5));
						bottomlessChips.setPrice(bottomlessChips.getPrice() - (bottomlessChips.getPrice()*.5));
						
						System.out.println("Price Successfully Updated!");
						Thread.sleep(500);
						System.out.print("Updating Menu Message for Customers: \"");
						Thread.sleep(1000);
						System.out.println("Enjoy our bottomless " + bottomlessChips.getName() + " and " + bottomlessQueso.getName() + " super sale, only on every 31st!");
						System.out.println("Both are half off! Get your Queso now for only $" + bottomlessQueso.getPrice() + " and your chips for $" + bottomlessChips.getPrice() + "!");
						System.out.println("---------------------------------------\n");
						ChangeLog.changes.add("Bottomless Chips and Queso Super Sale Activated! Both items' prices have been halved for today at " + LocalDateTime.now());
						Thread.sleep(1000);
						break;
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else if (bottomlessChips.getPrice() == 0.50) {
						System.out.println("Bottomless Chips and Queso Special Already Activated! Returning to main menu...\n");
						break;
					}
				}
				System.out.println("This week's special item are " + specialItem + "! (All " + specialItem + " are 5% off!)");
				
				System.out.println("Activate specials' sale?\nType \"Activate\" To Proceed or \"Quit\" to Return to Scenario Selection");
				String specialSale = "bleh";
				specialSale = scnr.next();
				if (specialSale.equalsIgnoreCase("Activate")) {
				System.out.println("SYSTEM MESSAGE: Reducing price of all " + specialItem + " by 5%");
				
				for (FoodItem specialType : FoodItem.getFoodItems()) {
					if (specialType.getItemType().equals(specialItemType)) {
						
						specialType.setPrice(specialType.getPrice() - (specialType.getPrice()*.05));
						
					}
					else {}
				}
				try {
					System.out.print("...");
					Thread.sleep(1000);
					System.out.print("...");
					Thread.sleep(1000);
					System.out.print("...");
					Thread.sleep(1000);
					System.out.println("...");
					Thread.sleep(1000);
					System.out.println("Prices successfully updated!");
					ChangeLog.changes.add("Weekly Sale activated, prices of " + specialItem + " have been reduced by 5% at " + LocalDateTime.now());
					Thread.sleep(2000);
					System.out.println();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				else if (specialSale.equalsIgnoreCase("Quit")) {
					System.out.println("Returning...");
					break;
				}
				else {
					System.out.println("Input valid option\n");
				}
			
		
				
				if (currDay.equalsIgnoreCase("Monday")) {
					System.out.print("Monday's Super Special is the ");
					specialMeat = "Steak";
				}
				else if (currDay.equalsIgnoreCase("Tuesday")) {
					System.out.print("Tuesday's Super Special is the ");
					specialMeat = "Chorizo";
				}
				else if (currDay.equalsIgnoreCase("Wednesday")) {
					System.out.print("Wednesday's Super Special is the ");
					specialMeat = "For Kids";
				}
				else if (currDay.equalsIgnoreCase("Thursday")) {
					System.out.print("Thursday's Super Special is the ");
					specialMeat = "Pork";
				}
				else if (currDay.equalsIgnoreCase("Friday")) {
					System.out.print("Friday's Super Special is the ");
					specialMeat = "Vegetarian";
				}
				else if (currDay.equalsIgnoreCase("Saturday")) {
					System.out.print("Saturday's Super Special is the ");
					specialMeat = "Lamb";
				}
				else if (currDay.equalsIgnoreCase("Sunday")) {
					System.out.print("Sunday's Super Special is the ");
					specialMeat = "Chicken";
				}
				else {
					System.out.println("error...");
				}
								
				for (FoodItem special : FoodItem.getFoodItems()) {
					if (special.getItemType().equals(specialItemType) && special.getMeatType().equals(specialMeat)) {
						System.out.println(special.getName());
					}
				}
				
				System.out.println("Activate The Daily Super Special? (20% discount)\nType \"Activate\" To Proceed or \"Quit\" to Return");
				String superSpecialSale = "bleh";
				superSpecialSale = scnr.next();
						
				if (superSpecialSale.equalsIgnoreCase("Activate")) {
				
					for (FoodItem special : FoodItem.getFoodItems()) {
						if (special.getItemType().equals(specialItemType) && special.getMeatType().equals(specialMeat)) {
							
							try {
								System.out.println("Activating " + special.getName() + " Super Sale!");
								special.setPrice(special.getPrice()/.95);
								special.setPrice(special.getPrice() - (special.getPrice()*.2));
								
								Thread.sleep(1000);
								System.out.println("SYSTEM MESSAGE: Reducing price of " + special.getName() + " by 20%");
								Thread.sleep(1000);
								System.out.print("...");
								Thread.sleep(200);
								System.out.print("...");
								Thread.sleep(200);
								System.out.print("...");
								Thread.sleep(200);
								System.out.println("...");
								Thread.sleep(1000);
								System.out.println("Price is successfully updated!");
								ChangeLog.changes.add("Daily Super Sale activated, price of " + special.getName() + " has been reduced by 20% at " + LocalDateTime.now());
								Thread.sleep(1000);
								

								
								System.out.print("Updating Menu Message for Customers: \"");
								Thread.sleep(1000);
								
								
								System.out.print("The " + special.getName() + " is on a super sale today for $");
								System.out.printf("%.2f", special.getPrice());
								System.out.println("!\"");
								superSale = "The " + special.getName() + " is on a super sale today for $" + special.getPrice() + "!";
								special.setName(special.getName() + "(20% Super Sale)");
								
								Thread.sleep(1000);
								System.out.println();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
								
									
							
						}
					
				
			}
					
			}
				
			}
			else {
				System.out.println("Please input valid option");
				System.out.println();
			}
			
			
			
		}
	
	}
	

	
	public static void initMenu() {
		System.out.println("Choose a following option:");
		System.out.println("1: Scenario 1");
		System.out.println("2: Scenario 2");
		System.out.println("3: Scenario 3 (Honors Option Scenario)");
		System.out.println("4: Extra functions");
		System.out.println("Type \"Quit\" to exit");
	}
	
	public static void extraMenu() {
		System.out.println();
		System.out.println("Choose a following option:");
		System.out.println("1: View current stock/desired stock values");
		System.out.println("2: Update current stock");
		System.out.println("3: Adjust foods' desired stock values");
		System.out.println("4: View session's changelog");
		System.out.println("5: View overall inventory");
		System.out.println("Type \"Quit\" to exit");
	}
}


			
			