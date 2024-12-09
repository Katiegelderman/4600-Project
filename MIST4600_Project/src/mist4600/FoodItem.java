package mist4600;

import java.util.HashSet;

public class FoodItem extends MenuItem {
	 private String meatType;
	 private String itemType;
	 
	 private static HashSet<FoodItem> cubanSandwich = new HashSet<>();
	 private static HashSet<FoodItem> quesadilla = new HashSet<>();
	 private static HashSet<FoodItem> burrito = new HashSet<>();
	 private static HashSet<FoodItem> taco = new HashSet<>();
	 
	 public FoodItem(String name, int desiredStockLevel, int currentStockLevel, boolean inStock, double price, String meatType, String itemType) {
	     super(name, desiredStockLevel, currentStockLevel, inStock, price);
	     this.setMeatType(meatType);
	     this.setItemType(itemType);
	     
	     if (itemType.equals("cuban")) {
	    	 cubanSandwich.add(this);
	     }
	     else if (itemType.equals("quesadilla")) {
	    	 quesadilla.add(this);
	     }
	     else if (itemType.equals("burrito")) {
	    	 burrito.add(this);
	     }
	     else if (itemType.equals("taco")) {
	    	 taco.add(this);
	     }
	    	 
	 }

	public String getMeatType() { return meatType; }

	public void setMeatType(String meatType) { this.meatType = meatType; }
	
	public String getItemType() { return itemType; }

	public void setItemType(String itemType) { this.itemType = itemType; }
	

	
	public static HashSet<FoodItem> getCubanType() { return cubanSandwich; }
	public static HashSet<FoodItem> getFoodItems() 
		{ 
		HashSet<FoodItem> allFoodItems = new HashSet<>();
		allFoodItems.addAll(cubanSandwich);
		allFoodItems.addAll(quesadilla);
		allFoodItems.addAll(burrito);
		allFoodItems.addAll(taco);
		return allFoodItems;
		}

	boolean cubanInStock = true;
	
	@Override
	public String toString() {

		String inStockResult = "Yes";
		if (cubanInStock = isInStock()) {
			
		}
		else {
			inStockResult = "No";
		}
		
		return getName() + " | " + "Meat Type: " + getMeatType() + " | Price: $" + getPrice() + " | In Stock?: " + inStockResult;
					
	}
	
	
	
	public static FoodItem fetchFoodByName(String name) {
		return (FoodItem) foodDatabase.get(name.toLowerCase());
	}
	




}