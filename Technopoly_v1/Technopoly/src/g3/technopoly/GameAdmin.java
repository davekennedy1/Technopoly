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
	public static ArrayList<String> playerNames = new ArrayList<String>();

	
	protected static ArrayList<Space> spaces = new ArrayList<Space>(); 
	
	protected static Board board = new Board(spaces);
	
	public static GameEngine game = new GameEngine();
	
	public static UserInput userInput = new UserInput();
	
	
	
	
	
	/**
	 * Setup Entire game - prompt player number and player names
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		board.populateBoard();
		System.out.println("Welcome to Technopoly!\n");
		System.out.println("How many players will be playing?:");
		promptNamesOfPlayers(UserInput.userInputPlayers());
		//shufflePlayers();
		startGame();
		
			 
	}
	
	

	/**
	 * Method startGame() to initialise the GameEngine object
	 * @throws Exception
	 */
	public static void startGame()throws Exception {
		//Create new GameEngine Object
		game = new GameEngine(spaces.size(), players.size());
		
		game.gameManager();
	}
	
		
	
	public static void promptNamesOfPlayers(int number) {

		ArrayList<String> playerNames = new ArrayList<String>();
		
		int players = number;
		int counter = 1;
		do {
			System.out.println("Please enter a name for player " +counter );
			String givenname = UserInput.userInputNames();
			
			if (playerNames.contains(givenname.toLowerCase())) {
				System.out.println("\nWoops! That name already exists. Please enter a unique name.");
			} else {
				playerNames.add(givenname.toLowerCase());
				GameAdmin.players.add(new Player(givenname, 0, 150000));
				players--;
				counter++;
			}
			
			
		} while (players>0);
		
		for(Player p : GameAdmin.players) {
			System.out.println(p.getName());
		}
	}
	

	/**
	 * Method to assign the player a turn position 
	 * @return
	 */
	public static void shufflePlayers(){
		
		//Shuffle the position of the players
		Collections.shuffle(players);
		for(int loop = 0; loop < players.size(); loop++ ) {
			players.get(loop).setPlayerNumber(loop+1);
		}
		
		
		
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
