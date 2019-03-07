/**
 * Colette casey
 */
package g3.technopoly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to oversee the admin of the Technopoly game
 * @author colettecasey
 * @studentNo 9524096
 *      
 */
public class GameAdmin {
	
	/**
	 * Flags if a game is in session
	 */
	private boolean gameInPlay = false;
	
	/**
	 * ArrayList of the players
	 */
	public static ArrayList<Player> players = new ArrayList<Player>(); 
	
	/**
	 * ArrayList of the spaces passed to the Board
	 */
	private static ArrayList<Space> spaces = new ArrayList<Space>(); 
	
	/**
	 * Creates the board Object 
	 */
	protected static Board board = new Board(spaces);
	
	/**
	 * Sets up GameEngine
	 */
	public static GameEngine game;
	
	

	//**************************   Constructors   **************************
	
	/**
	 * Default Constructor
	 */
	public GameAdmin() {
		
	}
	
	/**
	 * Constructor with arguments
	 * @param gameInPlay
	 * @param player
	 * @param spaces
	 * 
	 */
	public GameAdmin(boolean gameInPlay, ArrayList<Player> player, ArrayList<Space> spaces) {
		
		this.gameInPlay = gameInPlay; 
		this.player = player;
		this.spaces = spaces;
		
	}


//**************************   Getters and Setters   **************************
	
	/**
	 * Returns the player
	 * @return 
	 */
	public ArrayList<Player> getPlayer() {
		return player;
	}

	/**
	 * Sets the players
	 * @param player 
	 */
	public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}
	
	/**
	 * Returns the spaces
	 * @return spaces
	 */
	/*public ArrayList<Space> getSpaces() {
		return spaces;
	}*/

	
	

	//**************************   Methods   **************************

	
	
	public static void Main(String[] args) {
		
		
		
		
		
	}
	
	
	
	
	

	/**
	 * Method to setup a new game by changing gameInPlay = true and creating a new board object
	 */
	public void setupGame() {
		
		//Checks if there is a game in session.  If not, sets new game in session 
		if (gameInPlay == true) {

			System.out.println("An existing game is already in session - please terminate it before starting a new game.");

		} else {
			
			//Changes flag to set new game in session
			gameInPlay = true;
			
			
			//populates board with spaces
			board.populateBoard();

		}		
	}
	
	
	

	public static void startGame()throws Exception {
		game = new GameEngine(spaces.size(), players.size());
		game.gameManager();
	}
	
	
	
	/**
	 * Prompts for the number of players playing in this game
	 */
	public void promptNumberOfPlayers() {
		
		//Variable to hold number of players
		
		promptNamesOfPlayers(UserInput.userInputPlayers());
	}
	
	/**
	 * Method to prompt for name of Players 
	 */
	public void promptNamesOfPlayers(int numberOfPlayers) {
		//Variables to hold name and number of players
		
	
		String nameOfPlayers;
		int playerNumbers = numberOfPlayers;
		
		nameOfPlayers = UserInput.userInputNames(); //???Again static ?
		createPlayer(nameOfPlayers, playerNumbers);
		
		
	}
	
	
	/**
	 * Method to create the player objects
	 */
	public void createPlayer(String name, int playerNumber) {
		
		int pNumber = playerNumber;
		String playerName = name;
		int positionInBoard = 0; 
		double balanceAmount = 150000.00;
		
		/*ArrayList<String> nameOfPlayers = new ArrayList<String>();
		nameOfPlayers.add(playerName); *///?????Do we check if names are the same.  Is it too late here?
		
		for(int counter = 0; counter < pNumber; counter++) {  
			// String name = userinputname
			// if(duplicate player arraylist) {
			 // NAME ALREADY TAKEN
			//call userinput
				} else {
					// add player
				}
			//
			//
			//
			player.add(new Player(counter, playerName, positionInBoard, balanceAmount));
			
		}
	}

	/**
	 * Method to assign the player a turn position 
	 * @return
	 */
	public void shufflePlayers(){
		
		//Shuffle the player position
		Collections.shuffle(player);
		
		System.out.println("The player positions after shuffle are: ");
        player.forEach(System.out::println);
	}
	
	
	/**
	 * Method to print the GameRules
	 * @return
	 */
	public void printGameRules() {
		String gameRules;

		// create a file object
		File file = new File("Technopoly_Guide.txt");  // @Tim -  can't locate content??????

		try {
			FileReader fileReader = new FileReader(file.getName());

			BufferedReader bufferReader = new BufferedReader(fileReader);

			gameRules = bufferReader.readLine();

			while (gameRules != null) {
				System.out.println(gameRules);
				gameRules = bufferReader.readLine();

			}

			bufferReader.close();
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
