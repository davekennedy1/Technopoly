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
	
	public static void main(String[] arg) {
		printMenuTitle();
		printName(1,"Ismael", 150000);
	}
	

}
