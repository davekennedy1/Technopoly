package g3.technopoly;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

/**
 * Test case for the userInput.java class
 * @author tgl16
 *
 */
public class TestUserInput {
	//test data 
		int playerNumberValid, playerNumberInvalidLow, playerNumberInvalidHigh, menuOptionValid, menuOptionInvalidLow, menuOptionInvalidHigh, menuSizeExample;
		String playerNameValid, playerNameInvalidEmpty, playerNameInvalidNull, validationValid, validationInvalidEmpty, validationInvalidNull;
		UserInput ui;
		
	@Before
	public void setUp() throws Exception {
		//test data
		playerNumberValid = 3;
		playerNumberInvalidLow =1;
		playerNumberInvalidHigh =5;
		
		playerNameValid = "Valid Player Name";
		playerNameInvalidEmpty = "";
		playerNameInvalidNull = null;
		
		validationValid = "Y";
		validationInvalidEmpty = "";
		validationInvalidNull = null;
		
		menuSizeExample = 4;
		menuOptionValid = 4;
		menuOptionInvalidHigh = 5;
		menuOptionInvalidLow = 0;
	}

	/**
	 * Test on default constructor
	 */
	@Test
	public void testUserInput() {
		ui = new UserInput();
		assertNotNull(ui);
		
	}

	/**
	 * Test for the validateUserPlayers method - Valid input
	 */
	@Test
	public void testValidateUserPlayersValid() {
		int myInput = playerNumberValid;
		boolean actual = UserInput.validateUserPlayers(myInput);	
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	
	/**
	 * Test for the validateUserPlayers method - Invalid lower input
	 */
	@Test
	public void testValidateUserPlayersInvalidLow() {
		int myInput = playerNumberInvalidLow;
		boolean actual = UserInput.validateUserPlayers(myInput);	
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for the validateUserPlayers method - Invalid higher input
	 */
	@Test
	public void testValidateUserPlayersInvalidHigh() {
		int myInput = playerNumberInvalidHigh;
		boolean actual = UserInput.validateUserPlayers(myInput);	
		boolean expected = false;
		
		assertEquals(expected, actual);
	}


	/**
	 * Test for the validateUserNames method - Valid input
	 */
	@Test
	public void testValidateUserNamesValid() {
		String myInput = playerNameValid;
		boolean actual = UserInput.validateUserNames(myInput);
		boolean expected = true;
		
		assertEquals(expected, actual);

	}
	
	/**
	 * Test for the validateUserNames method - Invalid empty input
	 */
	@Test
	public void testValidateUserNamesEmpty() {

		String myInput = playerNameInvalidEmpty;
		boolean actual = UserInput.validateUserNames(myInput);
		boolean expected = false;
		
		assertEquals(expected, actual);

	}
	
	/**
	 * Test for the validateUserNames method - Invalid null input
	 */
	@Test (expected = NullPointerException.class)
	public void testValidateUserNamesNull() {

		String myInput = playerNameInvalidNull;
	    UserInput.validateUserNames(myInput);
	    
	    
	
	}

	/**
	 * Test for the userInputValidation method - Valid input
	 */
	@Test
	public void testUserInputValidationValid() {
		String myInput = validationValid;
		boolean expected = true;
		boolean actual = UserInput.validateUserValidation(myInput);
		
		assertEquals(expected, actual);
	}

	/**
	 * Test for the userInputValidation method - Invalid empty input
	 */
	@Test
	public void testUserInputValidationEmpty() {
		String myInput = validationInvalidEmpty;
		boolean expected = false;
		boolean actual = UserInput.validateUserValidation(myInput);
		
		assertEquals(expected, actual);
	}

	/**
	 * Test for the userInputValidation method - Invalid null input
	 */
	@Test (expected = NullPointerException.class)
		public void testUserInputValidationNull() {
		String myInput = validationInvalidNull;
		UserInput.validateUserValidation(myInput);
	}
	
	/**
	 * Test for the validateUserMenu method - Valid input
	 */
	@Test
	public void testValidateUserMenuValid() {
		int myInput = menuOptionValid;
		int menuSize = menuSizeExample;
		boolean actual = UserInput.validateUserMenu(myInput, menuSize);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for the validateUserMenu method - Invalid lower input
	 */
	@Test
	public void testValidateUserMenuValidInvalidLow() {
		int myInput = menuOptionInvalidLow;
		int menuSize = menuSizeExample;
		boolean actual = UserInput.validateUserMenu(myInput, menuSize);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for the validateUserMenu method - invalid higher input
	 */
	@Test
	public void testValidateUserMenuInvalidHigh() {
		int myInput = menuOptionInvalidHigh;
		int menuSize = menuSizeExample;
		boolean actual = UserInput.validateUserMenu(myInput, menuSize);
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
}
