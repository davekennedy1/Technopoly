package g3.technopoly;

public class TurnEngine {
	
	private boolean gameInPlay =true;
	protected int playerTurn = 0; 
	private int lastPlayer, lastSpace;
	
	/**
	 * Get the status of the game, in play or not
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
	 * @return the playerTurn
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * @param Set the next players turn
	 */
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	/**
	 * Get the number of the last player who had a turn
	 * @return the lastPlayer
	 */
	public int getLastPlayer() {
		return lastPlayer;
	}

	/**
	 * Set the player who just had their go
	 * @param lastPlayer the lastPlayer to set
	 */
	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}

	/**
	 * Get the last space that a player was on
	 * @return the lastSpace
	 */
	public int getLastSpace() {
		return lastSpace;
	}

	/**
	 * Set the last space that a player was on
	 * @param lastSpace the lastSpace to set
	 */
	public void setLastSpace(int lastSpace) {
		this.lastSpace = lastSpace;
	}
	
	



	
	
}
