package g3.technopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Testing_TurnEngine {

	
	TurnEngine turnEngine = new TurnEngine();
	int fieldCost = 1000;
	


	@Test
	public void test_HireStaffInIncrementsOfOne() {
		GameAdmin.board.populateBoard();
		GameAdmin.players.add(new Player("player1", 0, 150000));

		turnEngine.hiresStaff(1, 0, fieldCost);
		int expected = 1; 
		int actual = ((StartupSpace)GameAdmin.board.getSpaces().get(1)).getStaff();
		assertEquals(expected, actual);
		
		turnEngine.hiresStaff(1, 0, fieldCost);
		expected = 2;
		actual = ((StartupSpace) GameAdmin.board.getSpaces().get(1)).getStaff();
		assertEquals(expected, actual);
		
		turnEngine.hiresStaff(1, 0, fieldCost);
		expected = 3;
		actual = ((StartupSpace) GameAdmin.board.getSpaces().get(1)).getStaff();
		assertEquals(expected, actual);
		
		turnEngine.hiresStaff(1, 0, fieldCost);
		expected = 4;
		actual = ((StartupSpace) GameAdmin.board.getSpaces().get(1)).getStaff();
		assertEquals(expected, actual);

	}
	
	@Test
	public void test_PlayerDeclareBankrupt() {
		GameAdmin.players.add(new Player("player2", 0, 0));
		turnEngine.setCurrentPlayer(1);
		turnEngine.setCurrentPlayerSpace(1);
		((StartupSpace) GameAdmin.board.getSpaces().get(1)).setPlayerOwner(0);
		turnEngine.paysLicenceFee(500);
		
		boolean expected = false;
		boolean actual = GameAdmin.game.isGameInPlay();
		assertEquals(expected, actual);

	}

}
