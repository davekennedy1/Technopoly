package g3.technopoly;

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
	 * @return currentPlayer (int)
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Set the current player number
	 * @param currentPlayer (int)
	 */
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Get the number of spaces on the board
	 * @return boardSpaces (int)
	 */
	public int getBoardSpaces() {
		return boardSpaces;
	}

	/**
	 * Set the number of spaces on the board
	 * @param boardSpaces (int)
	 */
	public void setBoardSpaces(int boardSpaces) {
		this.boardSpaces = boardSpaces;
	}

	/**
	 * Get the position of the current player on the board
	 * @return currentPlayerSpace (int)
	 */
	public int getCurrentPlayerSpace() {
		return currentPlayerSpace;
	}

	/**
	 * Set the players position on the board
	 * @param currentPlayerSpace (int)
	 */
	public void setCurrentPlayerSpace(int currentPlayerSpace) {
		this.currentPlayerSpace = currentPlayerSpace;
	}


	// Methods
	/**
	 * Method to roll the dice and move the player 
	 * Validation: check if doubles have been rolled.
	 * Rolling doubles gives the current player another go.
	 * However rolling doubles three times in a row results 
	 * in a fine for the player.
	 * 
	 * @throws Exception
	 */
	public void rollDice() throws Exception {

		int dice1 = Dice.throwDice();
		int dice2 = Dice.throwDice();
		int moveAmount = dice1 + dice2;

		System.out.println("you were on space " + this.currentPlayerSpace);
		
		System.out.println("You rolled a " + dice1 + " and a " + dice2 + " giving you " + moveAmount);
		
		if (dice1 == dice2 && Driver.game.getDoublesCounter()!= 2) {
			System.out.println("Because you rolled doubles, you get another turn after this one!");
			
			Driver.game.setDoublesCounter(true);
			
			movePlayer(moveAmount);
		}else if(dice1 == dice2 && Driver.game.getDoublesCounter()== 2) {
			System.out.println("Three doubles in a row! Well the good news is wealthy capitalists don't go to jail, they just get a slap on the wrist!");
			System.out.println("You've been fined £" + TAX);
			if(Bank.checkFunds(this.currentPlayer, TAX)) {
				Bank.subtract(this.currentPlayer, TAX);
				Driver.game.setDoublesCounter(false);
				movePlayer(moveAmount);
			}else {
				//NEEDS A METHOD TO TERMINATE THE GAME!!!!!!!!!!!!!!!!!!!!!!!!
				System.out.println("YOU IS BROKE!!! GAME OVER");
				Driver.game.setGameInPlay(false);
			}
			
		}else {
			Driver.game.setDoublesCounter(false);
			movePlayer(moveAmount);
		}
		
		

	}

	/**
	 * Method to move the player the amount of spaces required by passing an amount.
	 * Validation: Check if the player has passed the InvestNI space and 
	 * work out the new space that the player has landed on.
	 * 
	 * @param moveAmount (int)
	 */
	public void movePlayer(int moveAmount) {
		int lapBoardBy;
		
		if((this.currentPlayerSpace + moveAmount)<boardSpaces) {
			this.currentPlayerSpace += moveAmount;
			Driver.players.get(this.currentPlayer).setPositionInBoard(this.getCurrentPlayerSpace());
			System.out.println("You landed on Space: " + this.currentPlayerSpace +"\n");
		}else{
			lapBoardBy = (this.currentPlayerSpace + moveAmount) - (boardSpaces);
			this.currentPlayerSpace = lapBoardBy;
			
			Driver.players.get(this.currentPlayer).setPositionInBoard(this.getCurrentPlayerSpace());
			System.out.println("You landed on Space: " + this.currentPlayerSpace);
			if(this.currentPlayerSpace == 0) {
				System.out.println("You landed on InvestNI, you get £" + InvestNI.getInvestmentAmount());
				Driver.investNI.addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\\n\n", Driver.players.get(currentPlayer).getBalanceAmount());
			}else {
				System.out.printf("You passed InvestNI, you get £%,.0f\n", InvestNI.getInvestmentAmount());
				Driver.investNI.addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\n\n", Driver.players.get(currentPlayer).getBalanceAmount());
			}
		}
	}

}
