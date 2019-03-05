package g3.technopoly;

import java.security.SecureRandom;

/**
 * Class to return the value of a single dice roll
 * @author colettecasey
 *
 */
public class Dice {

	// create secure random number generator for use in method rollDice
	// My comment: secureRandom is now used to prevent cheats determining result
	// instead of Random ***
	// My comment: There is a heavier performance, not sure if this needs to be
	// tested? ***

	private static final SecureRandom diceFace = new SecureRandom();

	// Constants to set the range of dice values between 1 and 6
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 6;

	/**
	 * Method to throw dice and return the result
	 * @return
	 */
	public static int throwDice() throws Exception {
		// Roll dice to generate random value
		int playerDice = MIN_VALUE + diceFace.nextInt(MAX_VALUE);

		// Set condition that the dice value must be between MIN_VALUE and MAX_VALUE
		if ((playerDice <= MIN_VALUE) && (playerDice >= MAX_VALUE)) {
			throw new Exception("Dice roll is out of range");

		} else {

			return playerDice;
		}

	}

}
