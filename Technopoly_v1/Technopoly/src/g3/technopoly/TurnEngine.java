package g3.technopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TurnEngine {

	// Instance vars
	protected int currentPlayer;
	private int boardSpaces;
	private int currentPlayerSpace;
	private static final double TAX = 1000;

	// Constructors
	/**
	 * Empty Constructor
	 */
	public TurnEngine() {
	}

	/**
	 * Constructor with args for generating a turn
	 * 
	 * @param currentPlayer      (int)
	 * @param boardSpaces        (int)
	 * @param currentPlayerSpace (int)
	 */
	public TurnEngine(int currentPlayer, int boardSpaces, int currentPlayerSpace) {
		this.currentPlayer = currentPlayer;
		this.boardSpaces = boardSpaces;
		this.currentPlayerSpace = currentPlayerSpace;
	}

	// Getters and setters
	/**
	 * Get the number of the current player
	 * 
	 * @return currentPlayer (int)
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Set the current player number
	 * 
	 * @param currentPlayer (int)
	 */
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Get the number of spaces on the board
	 * 
	 * @return boardSpaces (int)
	 */
	public int getBoardSpaces() {
		return boardSpaces;
	}

	/**
	 * Set the number of spaces on the board
	 * 
	 * @param boardSpaces (int)
	 */
	public void setBoardSpaces(int boardSpaces) {
		this.boardSpaces = boardSpaces;
	}

	/**
	 * Get the position of the current player on the board
	 * 
	 * @return currentPlayerSpace (int)
	 */
	public int getCurrentPlayerSpace() {
		return currentPlayerSpace;
	}

	/**
	 * Set the players position on the board
	 * 
	 * @param currentPlayerSpace (int)
	 */
	public void setCurrentPlayerSpace(int currentPlayerSpace) {
		this.currentPlayerSpace = currentPlayerSpace;
	}

	// Methods
	/**
	 * Method to roll the dice and move the player Validation: check if doubles have
	 * been rolled. Rolling doubles gives the current player another go. However
	 * rolling doubles three times in a row results in a fine for the player.
	 * 
	 * @throws Exception
	 */
	public void rollDice() throws Exception {

		int dice1 = Dice.throwDice();
		int dice2 = Dice.throwDice();
		int moveAmount = dice1 + dice2;

		System.out.println("you were on space " + this.currentPlayerSpace);

		System.out.println("You rolled a " + dice1 + " and a " + dice2 + " giving you " + moveAmount);

		if (dice1 == dice2 && GameAdmin.game.getDoublesCounter() != 2) {
			System.out.println("Because you rolled doubles, you get another turn after this one!");

			GameAdmin.game.setDoublesCounter(true);

			movePlayer(moveAmount);
		} else if (dice1 == dice2 && GameAdmin.game.getDoublesCounter() == 2) {
			System.out.println(
					"Three doubles in a row! Well the good news is wealthy capitalists don't go to jail, they just get a slap on the wrist!");
			System.out.println("You've been fined £" + TAX);
			if (Bank.checkFunds(this.currentPlayer, TAX)) {
				Bank.subtract(this.currentPlayer, TAX);
				GameAdmin.game.setDoublesCounter(false);
				movePlayer(moveAmount);
			} else {
				// NEEDS A METHOD TO TERMINATE THE GAME!!!!!!!!!!!!!!!!!!!!!!!!
				System.out.println("YOU IS BROKE!!! GAME OVER");
				GameAdmin.game.setGameInPlay(false);
			}

		} else {
			GameAdmin.game.setDoublesCounter(false);
			movePlayer(moveAmount);
		}

	}

	/**
	 * Method to move the player the amount of spaces required by passing an amount.
	 * Validation: Check if the player has passed the InvestNI space and work out
	 * the new space that the player has landed on.
	 * 
	 * @param moveAmount (int)
	 */
	public void movePlayer(int moveAmount) {
		int lapBoardBy;

		if ((this.currentPlayerSpace + moveAmount) < boardSpaces) {
			this.currentPlayerSpace += moveAmount;
			GameAdmin.players.get(this.currentPlayer).setPositionInBoard(this.getCurrentPlayerSpace());
			System.out.println("You landed on Space: " + this.currentPlayerSpace + "\n");
		} else {
			lapBoardBy = (this.currentPlayerSpace + moveAmount) - (boardSpaces);
			this.currentPlayerSpace = lapBoardBy;

			GameAdmin.players.get(this.currentPlayer).setPositionInBoard(this.getCurrentPlayerSpace());
			System.out.println("You landed on Space: " + this.currentPlayerSpace);
			if (this.currentPlayerSpace == 0) {
				System.out.println("You landed on InvestNI, you get £" + InvestNI.getInvestmentAmount());
				((InvestNI)GameAdmin.board.getSpaces().get(0)).addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\n\n", GameAdmin.players.get(currentPlayer).getBalanceAmount());
			} else {
				System.out.printf("You passed InvestNI, you get £%,.0f\n", InvestNI.getInvestmentAmount());
				((InvestNI)GameAdmin.board.getSpaces().get(0)).addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\n\n", GameAdmin.players.get(currentPlayer).getBalanceAmount());
			}
		}
	}

	/**
	 * @author bmurtland
	 * 
	 *         method will provide a list of owned startups for the player whose
	 *         turn it is and print this to screen when called For later iterations
	 *         can use a formatter class
	 */

	public void listOwned() {

		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getPlayerOwner() == getCurrentPlayer()) {

					System.out.println("You own: " + s.getName());
				}
			}
		}
	}

	/**
	 * This method lists all spaces owned which can be developed.
	 * 
	 * @author Ismael Florit
	 * @studentno 40009944
	 */
	public void listOwnedAndCanDevelop() {

		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getPlayerOwner() == getCurrentPlayer()
						&& ((StartupSpace) s).getCanBeDeveloped() == true) {

					System.out.println("You own and can develop: " + s.getName());
					// Below would use a formatter.
//					Messenger.printStartup(s.getSpaceName(), ((StartupSpace) s).getRent(),
//							((StartupSpace) s).getStaff());
				}
			}
		}
	}

	/**
	 * Method that checks whether a player can develop any properties. If the player
	 * can, the Space's canBeDeveloped is set to true. Otherwise it remains as
	 * false.
	 * 
	 * @param playerOwner
	 * @return
	 * @author Ismael Florit
	 * @studentName 40009944
	 */
	public boolean checkIfPlayerCanDevelop(int playerOwner) {

		// Populate Map with fields (can't be duplicate, nice!) with available fields.
		Map<String, Integer> uniqueFields = new HashMap<>();

		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				uniqueFields.put(((StartupSpace) s).getSpaceField(), ((StartupSpace) s).getFieldSetRequired());
			}
		}

		// Keep track of how many of a particular set are owned
		int requiredCounter = 0;

		// Loop through every unique field entry
		for (Map.Entry<String, Integer> entry : uniqueFields.entrySet()) {

			// loop through StartupSpaces that match a field
			for (Space s : GameAdmin.spaces) {
				if (s instanceof StartupSpace) {
					// if they are owned by the same player
					if ((((StartupSpace) s).getSpaceField().equals(entry.getKey()))
							&& (((StartupSpace) s).getPlayerOwner() == playerOwner)) {
						requiredCounter++; // add 1 to counter.
					}
				}
			}

			// if the counter found the same amount of owned properties as is needed
			if (requiredCounter == entry.getValue()) {
				for (Space s : GameAdmin.spaces) {
					if (s instanceof StartupSpace) {
						if (((StartupSpace) s).getSpaceField().equals(entry.getKey())) {
							((StartupSpace) s).setCanBeDeveloped(true);
						}
					}

				}
				return true; // Yes! He can!
			} else {
				for (Space s : GameAdmin.spaces) {
					if (s instanceof StartupSpace) {
						if (((StartupSpace) s).getSpaceField().equals(entry.getKey())) {
							((StartupSpace) s).setCanBeDeveloped(false);
						}
					}
				}
			}
			requiredCounter = 0;
		}
		for (Space s : GameAdmin.spaces) {
			System.out.println(s);
		}
		return false;
	}
	
/////////////////////////hires staff methods//////////////////////////////////////////////////
//constants for the staff pricing 
	private final int FIELD_ONE_STAFF_PRICE = 5000;
	private final int FIELD_TWO_STAFF_PRICE = 10000;
	private final int FIELD_THREE_STAFF_PRICE = 15000;
	private final int FIELD_FOUR_STAFF_PRICE = 20000;

	/**
	 * method to assign the cost of each staff member to the field
	 * 
	 * @param field
	 * @return
	 */
	public int fieldCostStaffSpecification(int field) {

		int fieldCost = 0;

		switch (field) {

		case 1:
			fieldCost = FIELD_ONE_STAFF_PRICE;
			break;
		case 2:
			fieldCost = FIELD_TWO_STAFF_PRICE;
			break;
		case 3:
			fieldCost = FIELD_THREE_STAFF_PRICE;
			break;
		case 4:
			fieldCost = FIELD_FOUR_STAFF_PRICE;
			break;
		}
		return fieldCost;
	}

	/**
	 * method to check if staff can be hired in a space Business rules: Staff must
	 * be hired uniformly across start-ups in a field
	 * 
	 */
	public void hiresStaff(int startUpPosition, int playerNumber, int fieldCost) {

//this one line needs to be completed.
//int staffOnSpace = (StartupSpace)GameAdmin.board.getSpaces().

		switch (staffOnSpace) {

		case 0:
			staffOnSpace++;
			System.out.println("You have hired a Software Developer. You now have one member of staff.");
//priceOfStaffSubtract(playerNumber);
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 1:
			staffOnSpace++;
			System.out.println("You have hired a Software Developer. You now have two members of staff.");
//	priceOfStaffSubtract(playerNumber);
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 2:
			staffOnSpace++;
			System.out.println("You have hired a Software Developer. You now have three members of staff.");
//	priceOfStaffSubtract(playerNumber);
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 3:
			staffOnSpace++;
			System.out.println("You have hired a CTO. You now have the maximum number of staff.");
//priceOfStaffSubtract(playerNumber);
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;

		default:
			System.out.println("You already have the maximum number of staff");

		}

}

}
