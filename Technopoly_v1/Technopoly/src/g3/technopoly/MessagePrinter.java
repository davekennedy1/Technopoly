package g3.technopoly;

public class MessagePrinter {
	
	public static void pushScreenContent() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void printName(String name) {
		
		System.out.printf("%20s%-10s%-20s", "____________________| Player 1: ",name,"|____________________\n");
		System.out.println();


	}
	
	public static void printMenuTitle() {
		System.out.printf("\n%20s%-10s%-20s","____________________| ", "      M E N U       ", "|____________________\n");
	}
	
	public static void main(String[] arg) {
		printMenuTitle();
		printName("Ismael");
	}
	

}
