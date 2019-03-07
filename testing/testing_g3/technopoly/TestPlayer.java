package technopoly;

/**
 * @author bmurtland
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
	
	//Declare test items

	int playerNumberValid, playerNumberInValid, positionInBoardValid, positionOnBoardInvalid;
	String nameValid, nameInValid;
	double balanceAmountValid, balanceAmountInvalid;

	

	@Before
	public void setUp() throws Exception {

		//assign valid and invalid values
		
		playerNumberValid = 3;
		playerNumberInValid = 1;
		nameValid = "ValidName";
		nameInValid = "a";
		positionInBoardValid = 1;
		positionOnBoardInvalid = 13;
		balanceAmountValid = 1000.00;
		balanceAmountInvalid = 123456789.00;

	}
	
	/**
	 * Test Default constructor
	 */

	@Test
	public void testPlayer() {
		Player player1 = new Player();
//		assertNotNull(player1);
	}
	
//	/**
//	 * Test constructor with Arguments
//	 */
//
//	@Test
//	public void testPlayerConstructorWithArgs() {
//		Player player1 = new Player(playerNumberInValid, nameInValid, positionInBoardValid, balanceAmountValid);
//		assertNotNull(player1);
//		assertEquals(playerNumberValid, player1.getPlayerNumber());
//		assertEquals(nameValid, player1.getName());
//		assertEquals(positionInBoardValid, player1.getPositionInBoard());
//		assertEquals(balanceAmountValid, player1.getBalanceAmount(), 0.2);
//
//	}
//	
//	/**
//	 * Test player number both valid and invalid tests
//	 */
//
//	@Test
//	public void testGetSetPlayerNumberValid() {
//		Player player1 = new Player();
//		player1.setPlayerNumber(playerNumberValid);
//		assertEquals(playerNumberValid, player1.getPlayerNumber());
//
//	}
//	
//	@Test (expected = IllegalArgumentException.class)
//	public void testGetSetPlayerNumberInValid() {
//		Player player1 = new Player();
//		player1.setPlayerNumber(playerNumberInValid);
//
//	}
//	
//	/**
//	 * Test player name both invalid and valid tests
//	 */
//
//	@Test
//	public void testGetSetNameValid() {
//		Player player1 = new Player();
//		player1.setName(nameValid);
//		assertEquals(nameValid, player1.getName());
//	}
//	
//	@Test (expected = IllegalArgumentException.class)
//	public void testGetSetNameInValid() {
//		Player player1 = new Player();
//		player1.setName(nameInValid);
//	
//	}
//	
//	/**
//	 * Test position on board - valid and invalid
//	 */
//
//	@Test
//	public void testGetSetPositionInBoardValid() {
//		Player player1 = new Player();
//		player1.setPositionInBoard(positionInBoardValid);
//		assertEquals(positionInBoardValid, player1.getPositionInBoard());
//	}
//	
//	@Test (expected = IllegalArgumentException.class)
//	public void testGetSetPositionInBoardInValid() {
//		Player player1 = new Player();
//		player1.setPositionInBoard(positionOnBoardInvalid);
//		
//	}
//	
//	/**
//	 * Test balance - valid and invalid
//	 */
//
//	@Test
//	public void testGetSetBalanceAmountValid() {
//		Player player1 = new Player();
//		player1.setBalanceAmount(balanceAmountValid);
//		assertEquals(balanceAmountValid, player1.getBalanceAmount(), 0.2);
//	}
//	
//	@Test (expected = IllegalArgumentException.class)
//	public void testGetSetBalanceAmountInValid() {
//		Player player1 = new Player();
//		player1.setBalanceAmount(balanceAmountInvalid);
//	
//	}
//	
//	/**
//	 * Test valid print method
//	 */
//
//	@Test
//	public void testDisplayAll() {
//		Player player1 = new Player(playerNumberInValid, nameInValid, positionInBoardValid, balanceAmountValid);
//		assertNotNull(player1);
//		assertEquals(playerNumberValid, player1.getPlayerNumber());
//		assertEquals(nameValid, player1.getName());
//		assertEquals(positionInBoardValid, player1.getPositionInBoard());
//		assertEquals(balanceAmountValid, player1.getBalanceAmount(), 0.2);
//	}
//
}
