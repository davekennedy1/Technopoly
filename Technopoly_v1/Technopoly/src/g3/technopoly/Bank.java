package g3.technopoly;

public class Bank {
	
	private static double currentBalance, newBalance;
	
	public static void add(int playerNumber, double amount) {
		
		currentBalance = gameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance + amount;
		
		gameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	public static void subtract(int playerNumber, double amount) {
		
		currentBalance = gameAdmin.players.get(playerNumber).getBalanceAmount();
		newBalance = currentBalance - amount;
		
		gameAdmin.players.get(playerNumber).setBalanceAmount(newBalance);
	}
	
	public static boolean checkFunds(int playerNumber, double amount) {
		boolean hasFunds;
		if(gameAdmin.players.get(playerNumber).getBalanceAmount()<amount) {
			hasFunds = true;
		}else {
			hasFunds=false;
		}
		return hasFunds;
	}
}
