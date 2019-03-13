package g3.technopoly;

import java.text.NumberFormat;
import java.util.Locale;

public class MessagePrinter {
	
	public static void pushScreenContent() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void printName(int playerNumber, String name, double balance) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.UK);
		String numberAsString = numberFormat.format(balance);
//		System.out.printf("%20s%s%-10s%-20s", "____________________| Player "+playerNumber+ ":",name,"|Balance: £"+numberAsString+" ____");
		System.out.printf("%20s","____________________| Player ");
		System.out.print((playerNumber+1)+": ");
		System.out.printf("%-10s",name);
		System.out.printf("%s", "|Balance: £ ");
		System.out.print(numberAsString);
		System.out.print(" ___");
		System.out.println("\n");


	}
	
	public static void printMenuTitle() {
		System.out.printf("\n%20s%-10s%-20s","____________________| ", "      M E N U       ", "|______________________\n");
	}
	
	public static void printStartupWithStaff(String name, String field, int staff) {
		System.out.printf("%-20s",name);
		System.out.printf("%s%7s","- ",field);
		System.out.printf("%18s"," (Current Staff: ");
		System.out.print(staff);
		System.out.print("/4)\n");
		
	}
	
	public static void main(String[] arg) {
		
		printStartupWithStaff("Artisan Web", "WebDev", 1);
		System.out.println();
		printStartupWithStaff("Hal Robotics Web", "AI", 1);
		System.out.println();
		printStartupWithStaff("Cloud Migration 365", "WebDev", 1);
		

//		System.out.printf("%-20s","Artisan Web");
//		System.out.printf("%2s","- WebDev");
//		System.out.print(" (Current Staff:");
//		System.out.print(1);
//		System.out.print("/4)");
//		
//		
//		System.out.println();
//		
//		System.out.printf("%-20s","Reflex Studios");
//		System.out.printf("%2s","- WebDev");
//		System.out.print(" (Current Staff:");
//		System.out.print(1);
//		System.out.print("/4)");
	}
	

}
