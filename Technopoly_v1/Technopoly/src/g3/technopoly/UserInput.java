package g3.technopoly;

/**
 * 
 */


import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *  UserInput class - Version 1
 *  @author T.Lewis 
 *  Date: 4/3/19
 */
//notes
//remove static from methods and make all lower case first word. 
public class UserInput {
	
	//constants
	 private static final String YES = "Y";
	 private static final String NO = "N";
	
	// open scanner
	static Scanner sc1 = new Scanner(System.in);

	// constructor
	/**
	 * default constructor
	 */
	public UserInput() {
	}

	// methods
	/**
	 * method to return user input as int for number of players
	 * Business rule: The number of players must be between 2 and 4. 
	 * @param input
	 */
	public static int userInputPlayers() {
		boolean valid = false;
		int players = 0;
		do {
			try {
			System.out.println("Hint: Please choose between 2 - 4 players");
			players = sc1.nextInt();
			
			} catch (InputMismatchException e) {
				sc1.next();
			}
			
			// now validate - TEST
			valid = validateUserPlayers(players);
		// other go again
		} while (!valid);
		return players;
	}
	/**
	 * method to check the validation rules for the UserInputPlayers method.
	 * Business rule: The number of players must be between 2 and 4. 
	 * @param userInput
	 * @return
	 */
	protected static boolean validateUserPlayers(int userInput) {
		
		if (userInput>1 && userInput<5) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * method to get user input as String for usernames
	 * Validation: Names cannot be empty strings or null values.
	 * @param input
	 */
	public static String userInputNames() {
		boolean valid = false;
		String userName = "";
		
		do {
			try {
			System.out.println("Hint: Empty names are not allowed");
				userName = sc1.nextLine();

			} catch (NullPointerException e) {
				sc1.next();
			}
			
			valid = validateUserNames(userName);
			}while(!valid);
		return userName;
		
}
		/**
		 * method to check the validation rules of the userInputNames method. 
		 * Validation: Names cannot be empty strings or null values.
		 * @param userInput
		 * @return
		 */
	protected static boolean validateUserNames(String userInput) {
		
	if ((userInput.trim().equals("")) || (userInput.trim().equals(null))) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * method to verify user input as String - for choice verification
	 * Validation: Input cannot be empty strings or null values.
	 * @param input
	 */
	public static String userInputValidation() {
		boolean valid = false;
		String userInput = "";
		
		do {
			try {
				System.out.println("Please choose Yes(Y) or No (N)");
				userInput = sc1.nextLine();
			} catch (NullPointerException e) {
				sc1.next();
			}
			valid = validateUserValidation(userInput);

		}while(!valid);
		
	
		return userInput;

	}
	
	/**
	 *  method to check the validation rules of the userInputValidation method. 
	 * Validation: Input cannot be empty strings or null values.
	 * @return
	 */
	protected static boolean validateUserValidation(String userInput) {
		
		if((userInput.trim().equalsIgnoreCase(YES)) || (userInput.trim().equalsIgnoreCase(NO))) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * THIS METHOD NEEDS TO BE REDONE TO FIT AIDANS EXAMPLE BUT IT SHOULD WORK AS IT IS
	 *  
	 * method to get user input as int for the menu
	 * Validation: User must input a number between 1 - 5, depending on how many options are provided to them. 
	 * @param numberOfChoices
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int userInputMenu(int numberOfChoices) throws IllegalArgumentException {

		int userInput = 0;

		switch (numberOfChoices) {

		case 3:
			while ((userInput < 1) || (userInput > 3)) {
				try {
					System.out.println("Please choose one of the following options using the numbers provided");
					userInput = sc1.nextInt();

				} catch (InputMismatchException e) {

					sc1.next();
				}
			}
			break;

		case 4:
			while ((userInput < 1) || (userInput > 4)) {
				try {
					System.out.println("Please choose one of the following options using the numbers provided");
					userInput = sc1.nextInt();

				} catch (InputMismatchException e) {

					sc1.next();
				}
			}
			break;

		case 5:
			while ((userInput < 1) || (userInput > 5)) {
				try {
					System.out.println("Please choose one of the following options using the numbers provided");
					userInput = sc1.nextInt();

				} catch (InputMismatchException e) {

					sc1.next();
				}
			}
			break;

		default:
			throw new InputMismatchException("Menu options not valid");
		}

		return userInput;

	}
	
	
	

	}