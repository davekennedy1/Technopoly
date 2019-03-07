/**
 * 
 */
package g3.technopoly;

import java.util.ArrayList;

/**
 * @author bmurtland
 *
 */
public class Player {

	/**
	 * Constants for Player Class setting min and max points not set as static as
	 * possiblity to increase in later iterations
	 */
	private final int minBoardPosition = 0;
	private final int maxBoardPosition = 11;
	private final int minplayerNumber = 0;
	private final int maxplayerNumber = 3;

	/**
	 * Declaration of all instance vars
	 */
	private int playerNumber;
	private String name;
	private int positionInBoard;
	private double balanceAmount;


	/**
	 * Default Constructor
	 */
	public Player() {

	}

//	/**
//	 * Future proof of the game.
//	 * Possible future iteration would include a quick game mode
//	 * this would include a random number of spaces/startups being assigned to players
//	 * at the start of the game 
//	 * 
//	 * @param playerNumber
//	 * @param name
//	 * @param positionInBoard
//	 * @param balanceAmount
//	 * @param ownedStartups
//	 */
//	public Player(int playerNumber, String name, int positionInBoard, int balanceAmount,
//			ArrayList<Space> ownedStartups) {
//		this.setPlayerNumber(playerNumber);
//		this.setName(name);
//		this.setPositionInBoard(positionInBoard);
//		this.setBalanceAmount(balanceAmount);
//		this.setOwnedStartups(ownedStartups);
//	}

	/**
	 * CURRENT GAME ITERATION CONSTUCTOR - no startups owned at the start thus no
	 * need for the space array list to be included
	 * 
	 * @param playerNumber
	 * @param name
	 * @param positionInBoard
	 * @param balanceAmount
	 */

	public Player(int playerNumber, String name, int positionInBoard, double balanceAmount) {
		this.setPlayerNumber(playerNumber);
		this.setName(name);
		this.setPositionInBoard(positionInBoard);
		this.setBalanceAmount(balanceAmount);

	}

	/**
	 * Player number getter
	 * 
	 * @return player num between 2 and 4 inclusive
	 */

	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * player num setter
	 * 
	 * @param playerNumber validation int 2-4 inclusive
	 */
	public void setPlayerNumber(int playerNumber) {
		if ((playerNumber >= minplayerNumber) && (playerNumber <= maxplayerNumber)) {
			this.playerNumber = playerNumber;
		} else {
			throw new IllegalArgumentException("ERROR: Invalid player number");
		}

	}

	/**
	 * getter for player name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for player name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for position on board
	 * 
	 * @return
	 */
	public int getPositionInBoard() {
		return positionInBoard;
	}

	/**
	 * setter for position on board
	 * 
	 * @param positionInBoard validation must be int greater than or = 1 and less
	 *                        than or = to 12
	 */
	public void setPositionInBoard(int positionInBoard) {

		if ((positionInBoard >= minBoardPosition) && (positionInBoard <= maxBoardPosition)) {
			this.positionInBoard = positionInBoard;
		} else {
			throw new IllegalArgumentException("ERROR: Invalid position on the board");
		}

	}

	/**
	 * getter for balance
	 * 
	 * @return
	 */
	public double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * Setter for balance
	 * 
	 * @param balanceAmount
	 */
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	

	/**
	 * display all method will run at start of each players turn and display the
	 * info from this class
	 */
	public void displayAll() {
		System.err.println("***Player " + playerNumber + " - " + name + "***");
		System.out.println("Current Position " + positionInBoard + " Balance: " + balanceAmount);
		System.out.println("You own: " + ownedStartups);

	}

}


