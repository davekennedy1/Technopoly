package g3.technopoly;

/**
 * Object that represents the starting space of the game. Holds an addInvestment
 * method to add £20000 to the current players balance amount.
 * @author dave
 * @studentNo 13072064
 */
public class InvestNI extends Space {

	//constants
	private static final String NAME = "InvestNI";
	private static final double INVESTMENTAMOUNT = 20000;

	// constructors
	/**
	 * Default Constructor
	 */
	public InvestNI() {
		super(NAME);
	}

	/**
	 * Constructor with args
	 * @param name (String)
	 */
	public InvestNI(String name) {
		super(name);
	}
	
	/**
	 * Get the amount of investment
	 * @return (double)
	 */
	public static double getInvestmentAmount() {
		return INVESTMENTAMOUNT;
	}

	// methods
	/**
	 * Method to pass the investment amount and player, who
	 * should have the investment amount added to their balance, 
	 * to the Bank.
	 * @param playerNumber
	 */
	public void addInvestment(int playerNumber) {
		Bank.add(playerNumber, INVESTMENTAMOUNT);
	}

}
