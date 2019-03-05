package g3.technopoly;

/**
 * @author Dave Kennedy
 * @studentNo 13072064
 */

public abstract class Space {

	//instance vars
	private String name;
	private int spaceNumber;
	
	//constructors
	/**
	 * Default Constructor
	 */
	public Space() {
	}

	/**
	 * Constructor with args
	 * @param name (String)
	 * @param squareNumber (int)
	 * @param field (String)
	 */
	public Space(String name, int spaceNumber) {
		this.setName(name);
		this.setSpaceNumber(spaceNumber);
	}

	//getters & setters
	/**
	 * Get the name of the space
	 * @return the name (String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the space
	 * Validation: name cannot be null or an empty String
	 * @param name the name to set (String)
	 */
	public void setName(String name) {
		if(name != null && name != ""){
			this.name = name;
		}else {
			throw new IllegalArgumentException("Invalid or null String provided for name");
		}
	}

	/**
	 * Get the space number
	 * @return the spaceNumber (int)
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * Set the space number
	 * Validation: space number cannot be below 0.
	 * @param the spaceNumber to set (int)
	 */
	public void setSpaceNumber(int spaceNumber) {
		if(spaceNumber >= 0) {
			this.spaceNumber = spaceNumber;
		}else {
			throw new IllegalArgumentException("Invalid space number provided");
		}
	}

	
}

