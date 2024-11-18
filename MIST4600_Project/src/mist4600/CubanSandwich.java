package mist4600;

import java.util.HashSet;

public class CubanSandwich extends MenuItem {
	 private String meatType;
	 
	 private static HashSet<CubanSandwich> cubanType = new HashSet<>();
	 
	 public CubanSandwich(String name, int desiredStockLevel, int currentStockLevel, boolean inStock, double price, String meatType) {
	     super(name, desiredStockLevel, currentStockLevel, inStock, price);
	     this.setMeatType(meatType);
	     
	     cubanType.add(this);
	 }

	public String getMeatType() { return meatType; }

	public void setMeatType(String meatType) { this.meatType = meatType; }
	
	public static HashSet<CubanSandwich> getCubanType() { return cubanType; }

	@Override
	public String toString() {
		return getName() + " | " + "Meat Type: " + getMeatType() + " | Price: " + getPrice() ;
	}
	
	
	public static CubanSandwich fetchFoodByName(String name) {
		return (CubanSandwich) foodDatabase.get(name.toLowerCase());
	}



}