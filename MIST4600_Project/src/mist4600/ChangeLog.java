package mist4600;

import java.util.ArrayList;

public class ChangeLog {
	
	public static ArrayList<String> changes = new ArrayList<>();
	
	public static void printChangeLog() {
		System.out.println("Change log: ");
		int changeNumber = 1;
			for (String changeMade : changes) {
				System.out.println(changeNumber + ": " + changeMade);
				++changeNumber;
			}
	}
	
	
	
}
