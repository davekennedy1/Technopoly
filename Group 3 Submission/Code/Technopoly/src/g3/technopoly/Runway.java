package g3.technopoly;

/**
 * Object that offers no action in the first iteration
 * of the game. Just a resting space. Named to signify
 * searching for runway investment.
 * @author dave
 * @studentNo 13072064
 */
public class Runway extends Space {

	//constants
	private static final String name = "Runway";
	
	//constructors
	/**
	 * Default constructor
	 * Names the space Runway and gives the default space number
	 */
	public Runway() {
		super(name);
	}

	/**
	 * Constructor with args
	 * @param name (String)
	 * @param spaceNumber (int)
	 */
	public Runway(String name, int spaceNumber) {
		super(name);
	}
	
	

}
