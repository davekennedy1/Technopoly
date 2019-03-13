package g3.technopoly;

public class Bank {
	
	private static double currentBalance, newBalance;
	
	public static void add(int playerNumber, double amount) {
		
		currentBalance = GameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance + amount;
		
		GameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	public static void subtract(int playerNumber, double amount) {
		
		currentBalance = GameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance - amount;
		
		GameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	public static boolean checkFunds(int playerNumber, double amount) {
		boolean hasFunds;
		if(GameAdmin.players.get(playerNumber).getBalanceAmount()>=amount) {
			hasFunds = true;
		}else {
			hasFunds=false;
		}
		return hasFunds;
	}
	
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
