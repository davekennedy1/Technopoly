package game;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the value of the dice is between range 1 and 6
 * @author colettecasey
 *
 */
public class DiceTest {

	/**
	 * Method to setUp test data
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Method to test the dice value is between 1-6
	 * @throws Exception
	 */
	@Test
	public void testThrowDice() throws Exception {
		// asserts as true the dice value is between 1 and 6
		assertTrue((Dice.throwDice() >= 1) && (Dice.throwDice() <= 6));

	}

}
