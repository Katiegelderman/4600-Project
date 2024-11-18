package mist4600;

import java.time.LocalDateTime;
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
				System.out.println();
				System.out.println(selectedItem.getName() + "'s updated stock is " + selectedItem.getCurrentStockLevel());
				ChangeLog.changes.add("Current stock of " + selectedItem.getName() + " was changed from " + oldStock + " to " + selectedItem.getCurrentStockLevel() + " at " + LocalDateTime.now());
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
	
	
	
	//Scenario 2 Main Code
	public static void runScenFour(Scanner scnr) {
		
		String scenFourVar = "bleh";
		String initScenFourVar = "bleh";
		int sessionChanges = 0;
		
		while (!initScenFourVar.equals("Quit")) {
			
			System.out.println();
			System.out.println("Welcome to your auto inventory updating app! To get started select an option:\n1: Record stock change of menu item\n2: View list of inventory\n3: View stock changes made this session\n4: \"Quit\" to exit");
			
			
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
							+ " amount of units be ordered for restock at " + LocalDateTime.now());
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
				//
			}
			//View stock changes made this session
			else if (initScenFourVar.equals("3")) {
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
			
		System.out.println("Type anything to view inventory or \"Quit\" to exit");
		
		scenSevVar = scnr.next().toLowerCase();
		
		if (scenSevVar.equalsIgnoreCase("quit")) {
			break;
		}
	
		for (CubanSandwich sandwich : CubanSandwich.getCubanType()) {
			System.out.println(sandwich);
		}

		
	
	ChangeLog.changes.add("Inventory was viewed at " + LocalDateTime.now());
		
	}

	
	}
	
	
}


			
			