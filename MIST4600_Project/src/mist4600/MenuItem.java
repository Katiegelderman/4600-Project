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

	
	//Allows user to dynamically access different MenuItems by searching up their key "A string that is the same as the name of the MenuItem"
	public static MenuItem fetchFoodByName(String name) {
		return foodDatabase.get(name.toLowerCase());
	}
	
	public void printCurrentAndDesired() {
		
		System.out.println("Item: " + name);
		System.out.print("Desired Stock " + desiredStockLevel + " || ");
		System.out.println("Current Stock " + currentStockLevel);
		System.out.println("Difference = " + (desiredStockLevel - currentStockLevel));
	
	}

	
	public String toString() {
		return getName() + " | " + "Price: " + getPrice();
	}
}
	