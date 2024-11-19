package mist4600;

import java.util.Scanner;

public class CheckOpenDay {
	private static final String[] openDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	public boolean isOpenDay(String day) {
		for (String openDay : openDays) {
           if (openDay.equalsIgnoreCase(day)) {
               return true;
           }
       }
       return false;
   }
	//Scenario 1: Option 2
   public void dayCheck(Scanner scnr) {
       System.out.println("Enter the day: ");
       String inputDay = "";
       inputDay = scnr.next();
       
       if (isOpenDay(inputDay)) {
           System.out.println("Cali N Titos is open on " + inputDay + "!");
       }
       else {
           System.out.println("Cali N Titos is not open on " + inputDay);
       }
       
       
   }
}
