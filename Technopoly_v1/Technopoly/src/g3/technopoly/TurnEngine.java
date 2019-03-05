package g3.technopoly;

public class TurnEngine {

	// instance vars
	private boolean gameInPlay = true;
	protected int currentPlayer = 0;
	private int doublesCount = 0;
	private int lastPlayer, lastSpace;
	private static final double TAX = 1000;

	// getters and setters
	/**
	 * Get the status of the game, in play or not
	 * 
	 * @return the gameInPlay (boolean)
	 */
	public boolean isGameInPlay() {
		return gameInPlay;
	}

	/**
	 * @param Set the status of the game in play (boolean)
	 */
	public void setGameInPlay(boolean gameInPlay) {
		this.gameInPlay = gameInPlay;
	}

	/**
	 * Get the player who's turn it is
	 * 
	 * @return the playerTurn
	 */
	public int getPlayerTurn() {
		return currentPlayer;
	}

	/**
	 * @param Set the next players turn
	 */
	public void setPlayerTurn(int playerTurn) {
		this.currentPlayer = playerTurn;
	}

	/**
	 * Get the number of the last player who had a turn
	 * 
	 * @return the lastPlayer
	 */
	public int getLastPlayer() {
		return lastPlayer;
	}

	/**
	 * Set the player who just had their go
	 * 
	 * @param lastPlayer the lastPlayer to set
	 */
	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}

	/**
	 * Get the last space that a player was on
	 * 
	 * @return the lastSpace
	 */
	public int getLastSpace() {
		return lastSpace;
	}

	/**
	 * Set the last space that a player was on
	 * 
	 * @param lastSpace the lastSpace to set
	 */
	public void setLastSpace(int lastSpace) {
		this.lastSpace = lastSpace;
	}
	//methods
	/**
	 * Method to roll the dice and move the player
	 * Validation: check if the doubles have been rolled
	 * three times in a row and fine the player if so.
	 * @throws Exception
	 */
	public void rollDice() throws Exception {
		
		int dice1 = Dice.throwDice();
		int dice2 = Dice.throwDice();
		int moveAmount = dice1 + dice2;
		
		if(dice1 == dice2) {
			System.out.println("You rolled doubles! You get another turn when this one is over!");
			doublesCount++;
		}else {
			System.out.println("You rolled a " + moveAmount);
			doublesCount = 0;
		}
		if(doublesCount == 3) {
			System.out.println("\nUh oh, three doubles in a row, the taxman wants his dues. You've been fined £"+TAX+"\n");
			Bank.subtract(currentPlayer, TAX);
			doublesCount = 0;
			System.out.println("\nYour new balance is £" + gameAdmin.players.get(playerNumber).getBalanceAmount() + "\n");
		}
		
	}
	

	
	



	
	
}
