package mist4600;

import java.util.HashMap;

//Base class for all menu items
public class MenuItem {
	private String name;
	private int desiredStockLevel;
	private int currentStockLevel;
	private boolean inStock;
	private double price;
	
	public static HashMap<String, MenuItem> foodDatabase = new HashMap<>();
 
	public MenuItem(String name, int desiredStockLevel, int currentStockLevel, boolean inStock, double price) {
		this.name = name;
		this.desiredStockLevel = desiredStockLevel;
		this.currentStockLevel = currentStockLevel;
		this.inStock = inStock;
		this.price = price;
		
		foodDatabase.put(name.toLowerCase(), this);
	}
 
	//Getters
	public String getName() { return name; }
	public int getDesiredStockLevel() { return desiredStockLevel; }
	public int getCurrentStockLevel() { return currentStockLevel; }
	public boolean isInStock() { return inStock; }
	public double getPrice() { return price; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setDesiredStockLevel(int desiredStockLevel) { this.desiredStockLevel = desiredStockLevel; }
	public void setCurrentStockLevel(int currentStockLevel) { this.currentStockLevel = currentStockLevel; }
	public void setInStock(boolean inStock) { this.inStock = inStock; }
	public void setPrice(double price) {this.price = price; }

	
	public static MenuItem fetchFoodByName(String name) {
		return foodDatabase.get(name.toLowerCase());
	}
	
	public void printCurrentAndDesired() {
		
		System.out.println("Item: " + name);
		System.out.print("Desired Stock " + desiredStockLevel + " || ");
		System.out.println("Current Stock " + currentStockLevel);
		System.out.println("Difference = " + (desiredStockLevel - currentStockLevel));
	
	}
	 // Abstract method that subclasses must implement
	//public String getDescription();
	
	public String toString() {
		return getName() + " | " + "Price: " + getPrice();
	}
}
	

	 
	//@Override
	// public String getDescription() {
	 //    return getName() + " - " + meatType;
	 //}
	//}
	
	/*(Specific Cuban sandwich types
	class SteakCuban extends CubanSandwich {
	 public SteakCuban() {
	     super("STK Cuban", true, 12.99, "Steak");
	 }
	}
	
	class ChickenCuban extends CubanSandwich {
	 public ChickenCuban() {
	     super("CK Cuban", true, 12.99, "Chicken");
	 }
	}
	
	class PorkCuban extends CubanSandwich {
	 public PorkCuban() {
	     super("PK Cuban", true, 12.99, "Pork");
	 }
	}
	
	class ChorizoCuban extends CubanSandwich {
	 public ChorizoCuban() {
	     super("CHO Cuban", true, 12.99, "Chorizo");
	 }
	}
	
	class VegetarianCuban extends CubanSandwich {
	 public VegetarianCuban() {
	     super("VG Cuban", true, 10.99, "Vegetarian");
	 }
	}
	
	class PastorCuban extends CubanSandwich {
	 public PastorCuban() {
	     super("Pastor Cuban", true, 12.99, "Pastor");
	 }
	}
	
	class CriolloCuban extends CubanSandwich {
	 public CriolloCuban() {
	     super("Criollo Cuban", true, 12.99, "Criollo");
	 }
	}
	
	class NinoRichieCuban extends CubanSandwich {
	 public NinoRichieCuban() {
	     super("Nino Richie Cuban", true, 7.99, "Kids");
	 }
	}
	
	class OriginalCuban extends CubanSandwich {
	 public OriginalCuban() {
	     super("OG Cuban", true, 12.99, "Original");
	 }
	}
	 */