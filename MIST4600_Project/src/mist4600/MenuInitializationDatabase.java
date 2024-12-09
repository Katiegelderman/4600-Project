package mist4600;

public class MenuInitializationDatabase {
	
		public static void initializeMenuDatabase() {
			
			new FoodItem("SteakCuban", 50, 8, true, 13.00, "Steak", "cuban");
			new FoodItem("ChickenCuban", 50, 3, true, 13.00, "Chicken", "cuban");
			new FoodItem("PorkCuban", 50, 0, false, 13.00, "Pork", "cuban");
			new FoodItem("ChorizoCuban", 40, 3, true, 13.00, "Chorizo", "cuban");
			new FoodItem("VegetarianCuban", 25, 0, false, 12.00, "Vegetarian", "cuban");
			new FoodItem("LambCuban", 25, 0, false, 12.00, "Lamb", "cuban");
			new FoodItem("PastorCuban", 30, 2, true, 12.00, "Pastor", "cuban");
			new FoodItem("CriolloCuban", 30, 1, true, 12.00, "Criollo", "cuban");
			new FoodItem("NinoRichieCuban", 20, 0, false, 7.00, "For Kids", "cuban");
			new FoodItem("OGCuban", 60, 7, true, 8.00, "Original Meat", "cuban");
			new MenuItem("Queso", 500, 43, true, 9.00);
			new MenuItem("Salsa", 1750, 215, true, 3.00);
			new MenuItem("Coke", 2000, 276, true, 2.00);
			new MenuItem("Pepsi", 1800, 0, false, 2.00);
			new MenuItem("Chips", 10000, 1670, true, 1.00);
			
			//honors option additions
			new FoodItem("SteakQuesadilla", 50, 8, true, 13.00, "Steak", "quesadilla");
			new FoodItem("ChorizoQuesadilla", 30, 4, true, 12.00, "Chorizo", "quesadilla");
			new FoodItem("KidsQuesadilla", 75, 20, true, 7.00, "For Kids", "quesadilla");
			new FoodItem("PorkQuesadilla", 40, 2, true, 13.00, "Pork", "quesadilla");
			new FoodItem("CheeseQuesadilla", 100, 20, true, 11.00, "Vegetarian", "quesadilla");
			new FoodItem("LambQuesadilla", 20, 8, true, 14.00, "Lamb", "quesadilla");
			new FoodItem("ChickenQuesadilla", 100, 43, true, 12.00, "Chicken", "quesadilla");
			
			//used AI to copy class but replace quesadilla with burrito/taco
			new FoodItem("SteakBurrito", 50, 8, true, 13.00, "Steak", "burrito");
			new FoodItem("ChorizoBurrito", 30, 4, true, 12.00, "Chorizo", "burrito");
			new FoodItem("KidsBurrito", 75, 20, true, 7.00, "For Kids", "burrito");
			new FoodItem("PorkBurrito", 40, 2, true, 13.00, "Pork", "burrito");
			new FoodItem("CheeseBurrito", 100, 20, true, 11.00, "Vegetarian", "burrito");
			new FoodItem("LambBurrito", 20, 8, true, 14.00, "Lamb", "burrito");
			new FoodItem("ChickenBurrito", 100, 43, true, 12.00, "Chicken", "burrito");

			new FoodItem("SteakTaco", 50, 8, true, 13.00, "Steak", "taco");
			new FoodItem("ChorizoTaco", 30, 4, true, 12.00, "Chorizo", "taco");
			new FoodItem("KidsTaco", 75, 20, true, 7.00, "For Kids", "taco");
			new FoodItem("PorkTaco", 40, 2, true, 13.00, "Pork", "taco");
			new FoodItem("CheeseTaco", 100, 20, true, 11.00, "Vegetarian", "taco");
			new FoodItem("LambTaco", 20, 8, true, 14.00, "Lamb", "taco");
			new FoodItem("ChickenTaco", 100, 43, true, 12.00, "Chicken", "taco");

		
		}
			
}
