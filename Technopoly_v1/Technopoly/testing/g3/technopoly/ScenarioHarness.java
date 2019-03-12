package g3.technopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ScenarioHarness {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHireStaff() throws Exception {
		
		GameAdmin.board.populateBoard();
		System.out.println("Welcome to Technopoly!\n");
		System.out.println("How many players will be playing?");
		GameAdmin.promptNamesOfPlayers(UserInput.userInputPlayers());
		((StartupSpace)GameAdmin.board.getSpaces().get(1)).setPlayerOwner(0);
		((StartupSpace)GameAdmin.board.getSpaces().get(2)).setPlayerOwner(0);
		GameAdmin.startGame();
		
	}

}
