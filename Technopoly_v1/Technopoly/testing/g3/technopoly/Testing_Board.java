package g3.technopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class Testing_Board {

	ArrayList<Space> spaces = new ArrayList<Space>();
	Set<String> uniqueFields = new HashSet<>();
	Board board = new Board(spaces);
	int InvestNIIndex = 0;
	int RunwayIndex = 6;

	@Before
	public void setUp() throws Exception {
		// initialise Board
		board.populateBoard();

		// populates uniqueFields Set
		for (Space s : spaces) {
			if (s instanceof StartupSpace) {
				uniqueFields.add(((StartupSpace) s).getSpaceField());
			}
		}
	}

	@Test
	public void test_InvestNI_Is_Present() {

		String expected = "InvestNI";
		String actual = board.getSpaces().get(InvestNIIndex).getName();
		assertEquals(expected, actual);

	}

	@Test
	public void test_Runway_Is_Present() {

		String expected = "Runway";
		String actual = board.getSpaces().get(RunwayIndex).getName();
		assertEquals(expected, actual);
	}

	@Test
	public void test_FourFieldsExist() {
		int expected = 4;
		int actual = uniqueFields.size();
		assertEquals(expected, actual);
	}

	@Test
	public void test_WebDevHasTwoAreas() {
		int counter = 0;
		int expected = 2;
		for (Space s : spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getSpaceField().equals("WebDev")) {
					counter++;
				}
			}
		}
		int actual = counter;
		assertEquals(expected, actual);
	}

	@Test
	public void test_AIHasTwoAreas() {
		int counter = 0;
		int expected = 2;
		for (Space s : spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getSpaceField().equals("AI")) {
					counter++;
				}
			}
		}
		int actual = counter;
		assertEquals(expected, actual);
	}

	@Test
	public void test_FintechHasThreeAreas() {
		int counter = 0;
		int expected = 3;
		for (Space s : spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getSpaceField().equals("FinTech")) {
					counter++;
				}
			}
		}
		int actual = counter;
		assertEquals(expected, actual);
	}

	@Test
	public void test_CloudHasThreeAreas() {
		int counter = 0;
		int expected = 3;
		for (Space s : spaces) {
			if (s instanceof StartupSpace) {
				if (((StartupSpace) s).getSpaceField().equals("Cloud")) {
					counter++;
				}
			}
		}
		int actual = counter;
		assertEquals(expected, actual);
	}

}
