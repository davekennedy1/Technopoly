package g3.technopoly;

import java.text.NumberFormat;
import java.util.Locale;

public class MessagePrinter {
	
	public static void pushScreenContent() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void printName(String playerLocation, int playerNumber, String name, double balance) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.UK);
		String numberAsString = numberFormat.format(balance);
//		System.out.printf("%20s%s%-10s%-20s", "____________________| Player "+playerNumber+ ":",name,"|Balance: £"+numberAsString+" ____");
		System.out.printf("%20s","___(ON: "+ playerLocation+")___");
		System.out.print("| Player");
		System.out.print((playerNumber+1)+": ");
		System.out.printf("%-10s",name);
		System.out.printf("%s", " |Balance: £ ");
		System.out.print(numberAsString);
		System.out.print(" ___");
		System.out.println("\n");


	}
	
	public static void printMenuTitle() {
		System.out.printf("\n%20s%-10s%-20s","____________________| ", "      M E N U       ", "|________________________\n");
	}
	
	public static void printStartupWithStaff(String name, String field, int staff) {
		System.out.printf("%-20s",name);
		System.out.printf("%s%7s","- ",field);
		System.out.printf("%18s"," (Current Staff: ");
		System.out.print(staff);
		System.out.print("/4)\n");
		
	}
	
	public static void main(String[] arg) {
		
	printName("InvestNI", 3, "Ismael", 1500000);
	printMenuTitle();
	}
	

}
