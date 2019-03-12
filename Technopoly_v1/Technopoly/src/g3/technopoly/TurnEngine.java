package g3.technopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TurnEngine {

	// Instance vars
	protected int currentPlayer;
	private int boardSpaces;
	private int currentPlayerSpace;
	private static final double TAX = 1000;
	private int terminatingPlayer;

	// constants for the staff pricing
	private final int FIELD_ONE_STAFF_PRICE = 5000;
	private final int FIELD_TWO_STAFF_PRICE = 10000;
	private final int FIELD_THREE_STAFF_PRICE = 15000;
	private final int FIELD_FOUR_STAFF_PRICE = 20000;

	//// array list for menu
	static ArrayList<Integer> menuList = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1));

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

		System.out.println("you were on " + GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() + "\n");

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
			System.out.println("You landed on " + GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() + "\n");
			landedStartupSpace();
		} else {
			lapBoardBy = (this.currentPlayerSpace + moveAmount) - (boardSpaces);
			this.currentPlayerSpace = lapBoardBy;

			System.out.println("You landed on " + GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() + "\n");

			if (this.currentPlayerSpace == 0) {
				System.out.printf("You get £%,.0f\n", InvestNI.getInvestmentAmount());
				((InvestNI) GameAdmin.board.getSpaces().get(0)).addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\n\n", GameAdmin.players.get(currentPlayer).getBalanceAmount());
			} else {
				System.out.printf("Because you passed InvestNI, you get £%,.0f\n", InvestNI.getInvestmentAmount());
				((InvestNI) GameAdmin.board.getSpaces().get(0)).addInvestment(this.currentPlayer);
				System.out.printf("New Balance: £%,.0f\n\n", GameAdmin.players.get(currentPlayer).getBalanceAmount());
			}

			GameAdmin.players.get(this.currentPlayer).setPositionInBoard(this.getCurrentPlayerSpace());
			// System.out.println("You landed on " +
			// GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() + "\n");
			landedStartupSpace();

		}
	}

	/**
	 * @author bmurtland
	 * @studentNumber 40246862 method - Tells you what space you landed on (name)
	 *                checks if startup is owned? if true - calls pay licence fee
	 *                Else if not owned calls menu to give option to buy
	 */

	public void landedStartupSpace() {

		// Check if player has landed on Runway or InvestNI and ignore
		if (GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() == "Runway"
				|| GameAdmin.board.getSpaces().get(currentPlayerSpace).getName() == "InvestNI") {
			
			menuList.set(0, 0);
			viewsMenu();
		} else {

			if (((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).isOwned()
					&& ((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace()))
							.getPlayerOwner() == currentPlayer) {

				System.out.println("You already own this Startup");
				System.out.println("Would you like to do anything else?");
				menuList.set(0, 0);
				viewsMenu();

			} else if (((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).isOwned()
					&& ((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace()))
							.getPlayerOwner() != currentPlayer) {

				System.out.println((GameAdmin.players
						.get(((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getPlayerOwner())
						.getName()) + " owns this space\n\n");

				// call paysLicenceFee and pass the amount of rent to be paid
				paysLicenceFee(((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getRent());

			} else if (!((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).isOwned()) {

				System.out.printf("%s is not owned. It costs £%,.0f\n\n",
						((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getName(),
						((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getPrice());
				menuList.set(0, 1);
				viewsMenu();
			}
		}

	}

	/**
	 * @author bmurtland
	 * @studentNumber 40246862 Purchase startup method: Get the the space landed on
	 *                Get the price Get the player balance New balance = balance �
	 *                price add the player as player owner of that space Print out
	 *                "you now own � array list of players spaces" and player
	 *                balance
	 */

	public void purchaseStartup() {

		// need an temporary variable to store the price and pass into Bank
		double propertyPrice;

		// check player wants to purchase
		System.out.println("Are you sure you want to purchase "
				+ ((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getName());

		// call scanner and validation
		String uInput = UserInput.userInputValidation();

		if (uInput.equalsIgnoreCase("Y")) {
			propertyPrice = ((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getPrice();

			// calculate the new balance
			Bank.subtract(currentPlayer, propertyPrice);

			// print out new balance and array list of players owned spaces
			System.out.printf("New Balance: £%,.0f\n\n", GameAdmin.players.get(getCurrentPlayer()).getBalanceAmount());

			// add the start up to the players array list of startups
			((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).setPlayerOwner(currentPlayer);

			// display all that players' startups
			listOwned();
			// add line for spacing
			System.out.println();
			menuList.set(0, 0);
			System.out.println("What else would you like to do?");
			viewsMenu();

			// if player selects N return to the menu
		} else if (uInput.equalsIgnoreCase("N")) {

			viewsMenu();

		}
	}

	/**
	 * @author bmurtland
	 * @studentNumber 40246862
	 * 
	 *                method will provide a list of owned startups for the player
	 *                whose turn it is and print this to screen when called For
	 *                later iterations can use a formatter class
	 */

	public void listOwned() {
		System.out.println(GameAdmin.players.get(currentPlayer).getName() + " owns: ");
		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getPlayerOwner() == getCurrentPlayer()) {

					System.out.println(s.getName());
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
		checkIfPlayerCanDevelop(getCurrentPlayer());
		ArrayList<Integer> startupIndex = new ArrayList<Integer>();
		int menuNumbers = 1;

		System.out.println("You own and can develop: \n");
		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getPlayerOwner() == getCurrentPlayer()
						&& ((StartupSpace) s).getCanBeDeveloped() == true && ((StartupSpace) s).getStaff() < 4) {
					int startupPosition = GameAdmin.spaces.indexOf(s);
					startupIndex.add(startupPosition);
					System.out.println(menuNumbers + ". " + s.getName());
					menuNumbers++;
				}
			}
		}

		System.out.println("Select a startup:");
		int userInput = UserInput.userInputMenu(menuNumbers - 1);
		double fieldCost = ((StartupSpace) GameAdmin.board.getSpaces().get(userInput)).getPriceOfStaff();
		// send input to hire staff
		hiresStaff(startupIndex.get(userInput - 1), getCurrentPlayer(), fieldCost);
		// add line for spacing
		System.out.println();
//		menuList.set(0, 0);
		System.out.println("What else would you like to do?");
		menuList.set(1, 0);
		viewsMenu();
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
		boolean canDevelop = false;

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
				for (Space s : GameAdmin.spaces) { // set the properties that can be developed to true;
					if (s instanceof StartupSpace) {
						if (((StartupSpace) s).getSpaceField().equals(entry.getKey())) {
							((StartupSpace) s).setCanBeDeveloped(true);
						}
					}

				}
				canDevelop = true; // Yes! He can!
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

		// loop through all owned properties and if all of them have staff < 4 not true,
		// canDevelop = false;
		boolean foundone = false;
		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				// if you don't find one, set foundnone to false
				if (((StartupSpace) s).getPlayerOwner() == playerOwner && ((StartupSpace) s).getStaff() < 4 && ((StartupSpace)s).getCanBeDeveloped()==true) {
					foundone = true;
				} 
			}
		}

		if (!foundone) {
			canDevelop = false;
			menuList.set(1, 0);
		}

		return canDevelop;
	}

	/**
	 * method to check if staff can be hired in a space Business rules: Staff must
	 * be hired uniformly across start-ups in a field
	 * 
	 */
	public void hiresStaff(int startUpPosition, int playerNumber, double fieldCost) {

		int staffOnSpace = ((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).getStaff();
		String spaceName = GameAdmin.board.getSpaces().get(startUpPosition).getName();
		switch (staffOnSpace) {

		case 0:
			((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).increaseStaff();
			staffOnSpace = ((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).getStaff();
			System.out.println("You have hired a Software Developer. You now have " + staffOnSpace
					+ " member of staff.(" + spaceName + ")");
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 1:
			((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).increaseStaff();
			staffOnSpace = ((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).getStaff();
			System.out.println("You have hired a Software Developer. You now have " + staffOnSpace
					+ " members of staff.(" + spaceName + ")");
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 2:
			((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).increaseStaff();
			staffOnSpace = ((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).getStaff();
			System.out.println("You have hired a Software Developer. You now have " + staffOnSpace
					+ " members of staff.(" + spaceName + ")");
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			break;
		case 3:
			((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).increaseStaff();
			staffOnSpace = ((StartupSpace) GameAdmin.board.getSpaces().get(startUpPosition)).getStaff();
			System.out.println("You have hired a CTO. You now have the maximum number of staff(" + staffOnSpace + ").("
					+ spaceName + ")");
			Bank.subtract(playerNumber, fieldCost);
			System.out.println("�" + fieldCost + " has been deducted from your account");
			menuList.set(1,0);
			break;

		default:
			System.out.println("You already have the maximum number of staff");

		}

	}

////////////////////////////////VIEWS MENU METHOD ////////////////////////////////////////

	public void viewsMenu() {
		// Before displaying the menu, check to see if the player has the ability to
		// hire staff and
		// set the menu options as required
		checkForTakeOver();
		if (checkIfPlayerCanDevelop(currentPlayer)) {
			menuList.set(1, 1);
		} else {
			menuList.set(1, 0);
		}
		
		
		System.out.println();
		System.out.println("###### ###### ####### ARRAY BEFORE LOADING MENU IS: " +menuList.toString());
		System.out.println();
		
		System.out.println("________________" + GameAdmin.players.get(currentPlayer).getName() + "__________________");
		System.out.println("Please select one of the following options. ");
		
		
		
		if ((menuList.get(0) == 1) && (menuList.get(1) == 1) && (menuList.get(2) == 1)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.PURCHASE.getMenuOptions()
					+ "\n 2. " + MenuOptions.HIRE.getMenuOptions() + "\n 3. " + MenuOptions.TAKEOVER.getMenuOptions()
					+ "\n 4. " + MenuOptions.END.getMenuOptions() + "\n 5. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(5);

			switch (returnedInput) {

			case 1:
				purchaseStartup();
				break;
			case 2:
				listOwnedAndCanDevelop();
				break;
			case 3:
				takesOverStartup();
				break;
			case 4:
				endTurn();

			case 5:
				terminatesGame();
				break;
			}

		} else if ((menuList.get(0) == 1) && (menuList.get(1) == 1) && (menuList.get(2) == 0)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.PURCHASE.getMenuOptions()
					+ "\n 2. " + MenuOptions.HIRE.getMenuOptions() + "\n 3. " + MenuOptions.END.getMenuOptions()
					+ "\n 4. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(4);

			switch (returnedInput) {

			case 1:
				purchaseStartup();
				break;
			case 2:
				listOwnedAndCanDevelop();
				break;
			case 3:
				endTurn();
				break;
			case 4:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 1) && (menuList.get(1) == 0) && (menuList.get(2) == 1)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.PURCHASE.getMenuOptions()
					+ "\n 2. " + MenuOptions.TAKEOVER.getMenuOptions() + "\n 3. " + MenuOptions.END.getMenuOptions()
					+ "\n 4. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(4);

			switch (returnedInput) {

			case 1:
				purchaseStartup();
				break;
			case 2:
				takesOverStartup();
				break;
			case 3:
				endTurn();
				break;
			case 4:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 1) && (menuList.get(1) == 0) && (menuList.get(2) == 0)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.PURCHASE.getMenuOptions()
					+ "\n 2. " + MenuOptions.END.getMenuOptions() + "\n 3. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(3);

			switch (returnedInput) {

			case 1:
				purchaseStartup();
				break;
			case 2:
				endTurn();
				break;
			case 3:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 0) && (menuList.get(1) == 1) && (menuList.get(2) == 1)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.HIRE.getMenuOptions()
					+ "\n 2. " + MenuOptions.TAKEOVER.getMenuOptions() + "\n 3. " + MenuOptions.END.getMenuOptions()
					+ "\n 4. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(4);

			switch (returnedInput) {

			case 1:
				listOwnedAndCanDevelop();
				break;
			case 2:
				takesOverStartup();
				break;
			case 3:
				endTurn();
				break;
			case 4:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 0) && (menuList.get(1) == 1) && (menuList.get(2) == 0)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.HIRE.getMenuOptions()
					+ "\n 2. " + MenuOptions.END.getMenuOptions() + "\n 3. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(3);

			switch (returnedInput) {

			case 1:
				listOwnedAndCanDevelop();
				break;
			case 2:
				endTurn();
				break;
			case 3:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 0) && (menuList.get(1) == 0) && (menuList.get(2) == 1)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.TAKEOVER.getMenuOptions()
					+ "\n 2. " + MenuOptions.END.getMenuOptions() + "\n 3. " + MenuOptions.TERMINATE.getMenuOptions());

			// System.out.println("\n \nPlease select one of the following options. ");
			int returnedInput = UserInput.userInputMenu(3);
			
			switch (returnedInput) {
			
			case 1:
				takesOverStartup();
				break;
			case 2:
				endTurn();
				break;
			case 3:
				terminatesGame();
				break;
			}
		} else if ((menuList.get(0) == 0) && (menuList.get(1) == 0) && (menuList.get(2) == 0)) {
			System.out.printf("________________MENU__________________\n 1. " + MenuOptions.END.getMenuOptions()
					+ "\n 2. " + MenuOptions.TERMINATE.getMenuOptions());

			int returnedInput = UserInput.userInputMenu(2);

			switch (returnedInput) {

			case 1:
				endTurn();
				break;
			case 2:
				terminatesGame();
				break;
			}
		}
	}

	/**
	 * Method to end the current players turn
	 * 
	 * @author Dave Kennedy
	 * @studentno 13072064
	 */
	public void endTurn() {
		System.out.println("Are you sure you want to end your turn?");
		if (UserInput.userInputValidation().equalsIgnoreCase("y")) {
			// this will end the turn and give an extra line in the console
			System.out.println("\n");
		} else {
			viewsMenu();
		}

	}

	/**
	 * Method to terminate the game and declare winner
	 * 
	 * @author Dave Kennedy
	 * @studentno 13072064
	 */
	public void terminatesGame() {
		System.out.println("Are you sure you want to Terminate the game?");
		System.out.println(
				"As the Quitter, (yeah that's right, I called you a quitter) your score will be ignored and you cannot win the game. ");
		if (UserInput.userInputValidation().equalsIgnoreCase("y")) {
			// this will end the game
			System.out.println("\nPffft, bloody communists!");
			terminatingPlayer = currentPlayer;
			GameAdmin.game.setGameInPlay(false);
			declareWinner();
		} else {
			viewsMenu();
		}
	}

	/**
	 * Lists all the available startup spaces for take over.
	 * 
	 * @author Ismael Florit
	 * @studentno 40009944
	 */
	public void takesOverStartup() {

		// array to store the startups that can be bought.
		ArrayList<Integer> availableStartups = new ArrayList<Integer>();

		// store all startups that are available in availableStartups
		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				// if startup is owned && startup owner is not the current player
				if (((StartupSpace) s).isOwned() && !(((StartupSpace) s).getPlayerOwner() == getCurrentPlayer())) {
					// get the index of each startup and set it to availableStartups.
					availableStartups.add(GameAdmin.spaces.indexOf(s));
				}
			}
		}

		System.out.println("You can attempt to take over these startups:\n");
		
		// loop through the available takeover startups
		int list = 1;
		for (Integer index : availableStartups) {
			String spaceName = GameAdmin.spaces.get(index).getName();
			int startupOwnerIndex = ((StartupSpace) GameAdmin.spaces.get(index)).getPlayerOwner();
			String startupOwnerName = GameAdmin.players.get(startupOwnerIndex).getName();
			System.out.println(list + ". " + spaceName + " �"+ ((StartupSpace) GameAdmin.spaces.get(index)).getPrice() + " (Owner: " + startupOwnerName + ").");
			list++;
		}
		
		
		
		// ask for user input in number
		int userInput = UserInput.userInputMenu(availableStartups.size());
		// access content in array of given userinput
		
		int indexAccesor = userInput - 1;
//		System.out.println(indexAccesor);
		int indexOfStartupSpace = availableStartups.get(indexAccesor);
//		System.out.println(indexOfStartupSpace);
		String propertyName = GameAdmin.board.getSpaces().get(indexOfStartupSpace).getName();
		
		// 
		
		int startupOwnerIndex = ((StartupSpace) GameAdmin.spaces.get(indexOfStartupSpace)).getPlayerOwner();
		String startupOwnerName = GameAdmin.players.get(startupOwnerIndex).getName();
		double startupPrice = ((StartupSpace) GameAdmin.spaces.get(indexOfStartupSpace)).getPrice();

		// the owner of startup is sent a message to confirm he will allow the takeover
		System.out.println(
				"TAKEOVER! " + startupOwnerName + ", someone is attempting to take over " + propertyName + "!");
		System.out.println("If you accept the deal, you would gain � " + startupPrice);
		System.out.printf("Do you accept the offer? - ");

		// owner response
		String response = UserInput.userInputValidation();

		// if true, set owner to current player.
		if (response.equalsIgnoreCase("Y")) {

			((StartupSpace) GameAdmin.spaces.get(indexOfStartupSpace)).setPlayerOwner(getCurrentPlayer());
			// update balances
			Bank.subtract(getCurrentPlayer(), startupPrice);
			Bank.add(startupOwnerIndex, startupPrice);
			System.out.println(GameAdmin.players.get(getCurrentPlayer()).getName() +", your new balance is: �" + GameAdmin.players.get(getCurrentPlayer()).getBalanceAmount());
			System.out.println();
			System.out.println(GameAdmin.players.get(startupOwnerIndex).getName() + ", your new balance is: �" + GameAdmin.players.get(startupOwnerIndex).getBalanceAmount());
		} else {
			System.out.println(startupOwnerName + " decided to not proceed. Your take over was rejected.");
		}
		viewsMenu();

	}
	
	/**
	 * Check if any startups are available for 'takeover'. 
	 * Startup cannot be owned by the current player.
	 * @return boolean
	 */
	public void checkForTakeOver() {
		menuList.set(2, 0);
		for (Space s : GameAdmin.spaces) {
			if (s instanceof StartupSpace) {
				// if startup is owned && startup owner is not the current player
				if (((StartupSpace) s).isOwned() && !(((StartupSpace) s).getPlayerOwner() == getCurrentPlayer())) {
					menuList.set(2, 1);
				}
				
			}
		}
	}

	/**
	 * Method to subtract the licence fee from currentPlayer and credit the balance
	 * of playerOwner
	 * 
	 * @author Colette Casey
	 * @studentno 9524096
	 *
	 * @param rent
	 */
	public void paysLicenceFee(double rent) {

		double licenceFee = rent;
		int currentPlayer = getCurrentPlayer();
		int playerOwner = ((StartupSpace) GameAdmin.board.getSpaces().get(getCurrentPlayerSpace())).getPlayerOwner();

		// Check if current player has the balance to pay licence fee

		if (Bank.checkFunds(currentPlayer, licenceFee)) {

			System.out.printf("The licence fee £%,.0f has been debited from your account.\n\n", licenceFee);
			Bank.subtract(this.currentPlayer, licenceFee);

			Bank.add(playerOwner, licenceFee);
			System.out.printf("Current Balance: £%,.0f\n\n",
					GameAdmin.players.get(getCurrentPlayer()).getBalanceAmount());

			menuList.set(0, 0);
			System.out.println("Would you like to do anything else?");
			viewsMenu();
		} else {
			System.out
					.println("You do not have insufficient funds to continue playing.  You've been declared bankrupt!");
			GameAdmin.game.setGameInPlay(false);
			declareWinner();
		}

	}

	/**
	 * Method to declare a winner. Winner is the player with the biggest cash
	 * balance + total property value. The player that terminates the game cannot be
	 * declared the winner
	 */
	public void declareWinner() {
		ArrayList<Double> playersVal = new ArrayList<Double>();
		double playerBal;
		double playerPropVal = 0;
		double totalPlayerValue;

		for (int outter = 0; outter < GameAdmin.players.size(); outter++) {
			playerBal = GameAdmin.players.get(outter).getBalanceAmount();
			for (int inner = 0; inner < GameAdmin.board.getSpaces().size(); inner++) {
				// if a startup has a non-bank owner
				if (GameAdmin.spaces.get(inner) instanceof StartupSpace
						&& ((StartupSpace) GameAdmin.spaces.get(inner)).getPlayerOwner() != -1) {
					// calculate value of all startups owned by players
					if (((StartupSpace) GameAdmin.board.getSpaces().get(inner)).getPlayerOwner() == outter) {
						playerPropVal += ((StartupSpace) GameAdmin.board.getSpaces().get(inner)).getPrice();
					}

				}

			}
			totalPlayerValue = playerBal + playerPropVal;
			playersVal.add(outter, totalPlayerValue);
			GameAdmin.players.get(outter).setPlayerWorth(totalPlayerValue);
			playerPropVal = 0;
		}

		Collections.sort(playersVal);
		Collections.reverse(playersVal);

		System.out.println("\n______________Winner/s______________");

		// Declare winner
		if (playersVal.get(0) != GameAdmin.players.get(currentPlayer).getPlayerWorth()) {
			for (int loop = 0; loop < GameAdmin.players.size(); loop++) {
				if (playersVal.get(0) == GameAdmin.players.get(loop).getPlayerWorth()
						&& GameAdmin.players.get(loop) != GameAdmin.players.get(currentPlayer)) {
					System.out.printf("%s with a total worth of £%,.0f\n", GameAdmin.players.get(loop).getName(),
							playersVal.get(0));
				}
			}

		} else {
			for (int loop = 0; loop < GameAdmin.players.size(); loop++) {
				if (playersVal.get(1) == GameAdmin.players.get(loop).getPlayerWorth()
						&& GameAdmin.players.get(loop) != GameAdmin.players.get(currentPlayer)) {
					System.out.printf("%s with a total worth of £%,.0f\n", GameAdmin.players.get(loop).getName(),
							playersVal.get(1));
				}
			}
		}
	}
	
	

}
