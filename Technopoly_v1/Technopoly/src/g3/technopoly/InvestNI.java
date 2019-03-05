package g3.technopoly;

/**
 * Object that represents the starting space of the game. Holds an addInvestment
 * method to add £20000 to the current players balance amount.
 * @author dave
 * @studentNo 13072064
 */
public class InvestNI extends Space {

	//constants
	private static final String name = "InvestNI";
	private static final double investmentAmount = 20000;

	// constructors
	/**
	 * Default Constructor
	 */
	public InvestNI() {
		super(name);
	}

	/**
	 * Constructor with args
	 * @param name (String)
	 * @param spaceNumber (int)
	 */
	public InvestNI(String name) {
		super(name);
	}

	// methods
	/**
	 * Method to pass the investment amount and player, who
	 * should have the investment amount added to their balance, 
	 * to the Bank.
	 * @param playerNumber
	 */
	public void addInvestment(int playerNumber) {
		Bank.add(playerNumber, investmentAmount);
	}

}
