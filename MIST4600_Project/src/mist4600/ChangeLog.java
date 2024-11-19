package mist4600;

import java.util.ArrayList;

public class ChangeLog {
	
	static int numTempChangesMade;
	
	public static ArrayList<String> changes = new ArrayList<>();
	
	public static void printChangeLog() {
		System.out.println("Change log: ");
		int changeNumber = 1;
			for (String changeMade : changes) {
				System.out.println(changeNumber + ": " + changeMade);
				++changeNumber;
			}
	}
	
	public static ArrayList<String> suggestedChanges = new ArrayList<>();
	
	public static void printSuggestedChangeLog() {
		System.out.println("Stock ordered: ");
		int changeNumber = 1;
			for (String changeMade : suggestedChanges) {
				System.out.println(changeNumber + ": " + changeMade);
				++changeNumber;
			}
	}
	
	
	public static void addChangesMade() {
		++numTempChangesMade;
	}
	
	public static void delChangesMade() {
		--numTempChangesMade;
	}
	
	public static void printNumTempChangesMade() {
		System.out.println(numTempChangesMade);
	}
	
	public static void tempPrintChangeLog() {
		System.out.println("This Session's Stock Consumption Record:");
		int changeNumber = 1;
			for (int i = changes.size() - numTempChangesMade; i < changes.size(); ++i) {
				System.out.println(changeNumber + ": " + changes.get(i));
				++changeNumber;
			}
	}
	

	
}
