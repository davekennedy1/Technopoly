package g3.technopoly;

import java.util.ArrayList;

/**
 * This class represents the physical board on which the Technopoly game is played.
 * 
 * @author Ismael Florit
 * @studentNo 40009944
 *
 */
public class Board {

	private ArrayList<Space> spaces = new ArrayList<Space>();

	public Board(ArrayList<Space> spaces) {
		this.spaces = spaces;
	}

	public ArrayList<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(ArrayList<Space> spaces) {
		this.spaces = spaces;
	}

	/**
	 * This method populates the spaces ArrayList with Startup spaces and Action spaces.
	 * Whatever is currently held in the StartupSpaceValues enum will be used first.
	 * Action spaces need to be manually inserted into their correct location.
	 * 
	 */
	public void populateBoard() {

		for (StartupSpaceValues space : StartupSpaceValues.values()) {

			spaces.add(new StartupSpace(space.getSpaceName(), false, false, space.getPrice(), space.getSite_price(), 0, space.getSpaceField(), space.getSetRequired()));
		}

		spaces.add(0, new InvestNI());
		spaces.add(6, new Runway());

	}

}
