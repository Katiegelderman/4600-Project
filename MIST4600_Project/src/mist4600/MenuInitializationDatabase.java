package mist4600;

public class MenuInitializationDatabase {
	
		public static void initializeMenuDatabase() {
			
			new CubanSandwich("SteakCuban", 50, 8, true, 12.99, "Steak");
			new CubanSandwich("ChickenCuban", 50, 3, true, 12.99, "Chicken");
			new CubanSandwich("PorkCuban", 50, 0, false, 12.99, "Pork");
			new CubanSandwich("ChorizoCuban", 40, 3, true, 12.99, "Chorizo");
			new CubanSandwich("VegetarianCuban", 25, 0, false, 12.99, "Vegetarian");
			new CubanSandwich("PastorCuban", 30, 2, true, 12.99, "Pastor");
			new CubanSandwich("CriolloCuban", 30, 1, true, 12.99, "Criollo");
			new CubanSandwich("NinoRichieCuban", 20, 0, false, 7.99, "For Kids");
			new CubanSandwich("OGCuban", 60, 7, true, 8.50, "Original Meat");
			new MenuItem("Queso", 500, 43, true, 8.99);
			new MenuItem("Salsa", 1750, 215, true, 2.99);
			new MenuItem("Coke", 2000, 276, true, 1.99);
			new MenuItem("Pepsi", 1800, 0, false, 1.99);
			new MenuItem("Chips", 10000, 1670, true, 0.99);
			
			

		
		
		}
			
}
