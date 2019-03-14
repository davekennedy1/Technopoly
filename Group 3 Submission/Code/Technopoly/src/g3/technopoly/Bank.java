package g3.technopoly;
/**
 * The Bank class performs any addition, subtraction and check balance actions.
 * @author dave
 * @studentNumber 13072064
 */
public class Bank {
	
	private static double currentBalance, newBalance;
	
	/**
	 * Method to add an amount to the given players balance
	 * @param playerNumber (int)
	 * @param amount (double)
	 */
	public static void add(int playerNumber, double amount) {
		
		currentBalance = GameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance + amount;
		
		GameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	/**
	 * Method to subtract an amount from the given playres balance
	 * @param playerNumber (int)
	 * @param amount (double)
	 */
	public static void subtract(int playerNumber, double amount) {
		
		currentBalance = GameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance - amount;
		
		GameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	/**
	 * Method to check if the funds available in a given players balance are enough to perform an action
	 * @param playerNumber (int)
	 * @param amount (double)
	 * @return
	 */
	public static boolean checkFunds(int playerNumber, double amount) {
		boolean hasFunds;
		if(GameAdmin.players.get(playerNumber).getBalanceAmount()>=amount) {
			hasFunds = true;
		}else {
			hasFunds=false;
		}
		return hasFunds;
	}
	
	/**
	 * Method to check if a player can afford to hire staff on a startup
	 * @param playerNumber (int)
	 * @return (boolean)
	 */
	public static boolean canAffordToHire(int playerNumber) {
		
		boolean canAfford = false;
		
		for(Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				if (checkFunds(playerNumber, ((StartupSpace) s).getPriceOfStaff())) {
					canAfford = true;
				}
			}
		}
		
		return canAfford;
		
	}
}
