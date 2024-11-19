package mist4600;

public class MenuInitializationDatabase {
	
		public static void initializeMenuDatabase() {
			
			new CubanSandwich("SteakCuban", 50, 25, true, 12.99, "Steak");
			new CubanSandwich("ChickenCuban", 50, 25, true, 12.99, "Chicken");
			new CubanSandwich("PorkCuban", 50, 25, true, 12.99, "Pork");
			new CubanSandwich("ChorizoCuban", 50, 25, false, 12.99, "Chorizo");
			new CubanSandwich("VegetarianCuban", 50, 25, true, 12.99, "Vegetarian");
			new CubanSandwich("PastorCuban", 50, 25, true, 12.99, "Pastor");
			new CubanSandwich("CriolloCuban", 50, 25, true, 12.99, "Criollo");
			new CubanSandwich("NinoRichieCuban", 50, 25, true, 7.99, "For Kids");
			new CubanSandwich("OGCuban", 50, 25, true, 8.5, "Original Meat");
			new MenuItem("Queso", 500, 123, true, 8.99);
			new MenuItem("Salsa", 1750, 415, true, 2.99);
			new MenuItem("Coke", 2000, 476, true, 1.99);
			
			
			
			//ez test variable
			new MenuItem("Beef", 50, 24, true, 2.2);
		
		
		}
			
}
