import java.security.SecureRandom;

/**
 * @author colettecasey
 *
 */
public class Dice_Technopoly {

	// create secure random number generator for use in method rollDice
	// My comment: secureRandom is now used to prevent cheats determining results instead of Random ***
	// My comment: There is a heavier performance, not sure if this needs to be tested? ***
	private static final SecureRandom diceFace = new SecureRandom();

	/**
	 * Call rollDice();
	 * @param args
	 */
	public static void main(String[] args) {
		//call the rollDice() method
		int moveSpaces = throwDice();
		
		//The number of spaces to pass on to ?Board? to move the player 
		System.out.printf("(Value passed to next method to move player on %d spaces...)", moveSpaces);
	}

	/**
	 * Method to roll dice and print/return the result
	 * @return
	 */
	public static int throwDice() {
		// pick random die values
		int playerDice1 = 1 + diceFace.nextInt(6); // first die roll
		int playerDice2 = 1 + diceFace.nextInt(6); // second die roll

		int sum = playerDice1 + playerDice2; // sum of die values

		// Check for doubles and print Player results 
		if(playerDice1 == playerDice2) {
			System.out.printf("You rolled doubles: %d & %d.  Miss a turn!\n", playerDice1, playerDice2);
		} else {
			System.out.printf("Player rolled %d + %d.  Move on %d spaces.\n", playerDice1, playerDice2, sum);
		}
		
		return sum;
	}
	


}
