package mist4600;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuInitializationDatabase.initializeMenuDatabase();
		
		Scanner scnr = new Scanner(System.in);	
		
		while (true) {
		
			
			
		String initDecisionVar;
		
		System.out.println("Choose a following option:");
		System.out.println("1: Scenario 1");
		System.out.println("2: Scenario 2");
		System.out.println("3: Extra functions");
		System.out.println("Type \"Quit\" to exit");
		
		initDecisionVar = scnr.next();
		
		if (initDecisionVar.equalsIgnoreCase("Quit")) {
			break;
		}
		
		if (initDecisionVar.equals("1")) {
			//
		}
		else if (initDecisionVar.equals("2")) {
			DecisionCode.runScenFour(scnr);
		}
		else if (initDecisionVar.equals("3")) {
			
			while (true) {
			
			System.out.println();
			System.out.println("Choose a following option:");
			System.out.println("1: View current stock/desired stock values");
			System.out.println("2: Update current stock");
			System.out.println("3: Adjust foods' desired stock values");
			System.out.println("4: View session's changelog");
			System.out.println("5: View overall inventory");
			System.out.println("Type \"Quit\" to exit");
		
			String decisionVar;
		
			

		
			decisionVar = scnr.next();
			
			if (decisionVar.equalsIgnoreCase("Quit")) {
				break;
			}
			
				
				if (decisionVar.equals("1")) {
					
					DecisionCode.runScenOne(scnr);
			
				}
				else if (decisionVar.equals("2")) {
						
						
					DecisionCode.runScenTwo(scnr);	
										
						
				}
				else if (decisionVar.equals("3")) {
			
					DecisionCode.runScenThree(scnr);
			
				}
				else if (decisionVar.equals("4")) {
					
					DecisionCode.runScenFive(scnr);
				}
				else if (decisionVar.equals("5")) {
					
					DecisionCode.runScenSix(scnr);
					
				}
				else if (decisionVar.equals("7")) {
					
					DecisionCode.runScenSev(scnr);
					
				}
				else {
			
					System.out.println("Please input a valid option");
			
				}
				
				

		
		}
			
		}
			
			
			
			
		}

		
	}
		

}





