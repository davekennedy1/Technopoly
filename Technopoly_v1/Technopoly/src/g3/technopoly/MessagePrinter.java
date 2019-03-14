package g3.technopoly;

import java.text.NumberFormat;
import java.util.Locale;

public class MessagePrinter {

	/**
	 * Creates a blank canvas for the next set of outputs.
	 */
	public static void pushScreenContent() {
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	/**
	 * Formats a given player's number, location, name and balance. 
	 * @param playerLocation
	 * @param playerNumber
	 * @param name
	 * @param balance
	 */
	public static void printName(String playerLocation, int playerNumber, String name, double balance) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.UK);
		String numberAsString = numberFormat.format(balance);
//		System.out.printf("%20s%s%-10s%-20s", "____________________| Player "+playerNumber+ ":",name,"|Balance: �"+numberAsString+" ____");
		System.out.printf("%20s", "________(ON: " + playerLocation + ")________");
		System.out.print("| Player");
		System.out.print((playerNumber + 1) + ": ");
		System.out.printf("%-10s", name);
		System.out.printf("%s", " |Balance: £ ");
		System.out.print(numberAsString);
		System.out.print(" _________");
		System.out.println("\n");

	}

	/**
	 * Formats printing of the menu.
	 * 
	 */
	public static void printMenuTitle() {
		System.out.printf("\n%5s%-10s%-5s", "______| ", "  M E N U   ", "|______\n");
	}
	
	/**
	 * Formats a startup's name, price, field and staff count.
	 * @param name
	 * @param price
	 * @param field
	 * @param staff
	 */
	public static void printStartupWithStaff(String name, double price, String field, int staff) {
		System.out.printf("%-20s", name);
		System.out.printf("-  £%,.0f  ", price);
		System.out.printf("%s%7s", "- ", field);
		System.out.printf("%18s", " (Current Staff: ");
		System.out.print(staff);
		System.out.print("/4)\n");

	}

}
