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
   public void dayCheck() {
       Scanner scnr = new Scanner(System.in);
       System.out.print("Enter a day: ");
       String inputDay = scnr.nextLine();
       if (isOpenDay(inputDay)) {
           System.out.println("Cali N Titos is open on " + inputDay);
       }
       else {
           System.out.println("Cali N Titos is not open on " + inputDay);
           scnr.close();
       }
   }
}
