/**
 * 
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
	
	
	//private boolean gameInPlay = false;
	
	public static ArrayList<Player> players = new ArrayList<Player>(); 
	
	protected static ArrayList<Space> spaces = new ArrayList<Space>(); 
	
	protected static Board board = new Board(spaces);
	
	public static GameEngine game;
	
	public static UserInput userInput = new UserInput();
	
	
	
	
	
	/**
	 * Setup Entire game - prompt player number and player names
	 * @param args
	 */
	public static void Main(String[] args) throws Exception {
		
		board.populateBoard();
		
		promptNamesOfPlayers(userInput.userInputPlayers());
		
		startGame();
		
			
	}
	

//	/**
//	 * Method to setup a new game by changing gameInPlay = true and creating a new board object
//	 */
//	public void setupGame() {
//		
//		//Checks if there is a game in session.  If not, sets new game in session 
//		if (gameInPlay == true) {
//
//			System.out.println("An existing game is already in session - please terminate it before starting a new game.");
//
//		} else {
//			
//			//Changes flag to set new game in session
//			gameInPlay = true;
//			
//			
//			//populates board with spaces
//			board.populateBoard();
//
//		}		
//	}
	

	/**
	 * Method startGame() to initialise the GameEngine object
	 * @throws Exception
	 */
	public static void startGame()throws Exception {
		//Create new GameEngine Object
		game = new GameEngine(spaces.size(), players.size());
		
		game.gameManager();
	}
	
	
	
	/**
	 * Method to prompt for name of Players 
	 */
	public static void promptNamesOfPlayers(int numberOfPlayers) {
		
		
		for(int counter = 1; counter <= numberOfPlayers; counter++) { 
			
			String playerName;
			
			playerName = userInput.userInputNames();
			
			for(int loop = 0; loop < players.size(); loop++) {
				
				if(players.get(loop).getName().equals(playerName)) {
					System.out.println("That name already exists, please pick another one...");
					playerName = userInput.userInputNames();
					
				}else {
					
					players.add(new Player(counter, playerName, 0, 150000));
				}
			}	
			
		}
		
	}
	
	

	/**
	 * Method to assign the player a turn position 
	 * @return
	 */
	public void shufflePlayers(){
		
		//Shuffle the position of the players
		Collections.shuffle(players);
		
	}
	
	
	/**
	 * Method to print the GameRules
	 * @return
	 */
	public void printGameRules() {
		String gameRules;

		// create a file object
		File file = new File("Technopoly_Guide.txt");

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