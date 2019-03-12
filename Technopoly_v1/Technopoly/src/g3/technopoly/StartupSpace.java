package g3.technopoly;

/**
 * StartupSpace represents a square on the Technopoly board. Each startup is 
 * initially owned by the banker (bankOwner = -1). Players may buy the Startup
 * from the bank if it is not currently owned by another player (player 0-3),
 * nominally known as players 1-4.
 * It must be paid for before assigning a new owner as the price increases
 * with the first owner of the Startup to reflect business good will. 
 * 
 * @author Dave Kennedy
 * @studentNo 13072064
 */

public class StartupSpace extends Space {
	
	/**
	 * minRent and minPrice are set to 0 in case of future free trade iteration
	 * of the game.
	 */
	//constants
	private final int minStaff =0;
	private final int maxStaff =4;
	private final double minRent =0;
	private final double minPrice =0;
	private static final int BANK_OWNER = -1;
	
	//instance vars
	private boolean canBeDeveloped, isOwned;
	private double price, rent, priceOfStaff, licenceFee1Staff, licenceFee2Staff, licenceFee3Staff, licenceFee4Staff;
	private int playerOwner, staff;
	private String spaceField;
	private int fieldSetRequired;  
	
	//constructors
	/**
	 * Default Constructor
	 */
	

	/**
	 * Constructor to be used when starting the default game where no
	 * Startup is owned by a player.
	 * @param name
	 * @param spaceNumber
	 * @param canBeDeveloped
	 * @param isOwned
	 * @param price
	 * @param rent
	 * @param staff
	 * @param spaceField
	 * @param fieldRequired
	 * @param priceOfStaff
	 * @param licenceFee1Staff
	 * @param licenceFee2Staff
	 * @param licenceFee3Staff
	 * @param licenceFee4Staff
	 */
	public StartupSpace(String name, boolean canBeDeveloped, 
			boolean isOwned, double price, double rent, int staff, String spaceField, int fieldSetRequired, double priceOfStaff, double licenceFee1Staff, double licenceFee2Staff, double licenceFee3Staff, double licenceFee4Staff) {
		super(name);
		this.setCanBeDeveloped(canBeDeveloped);
		this.setOwned(isOwned);
		this.setPrice(price);
		this.setRent(rent);
		this.playerOwner = BANK_OWNER;
		this.setStaff(staff);
		this.setSpaceField(spaceField);
		this.setFieldSpaceRequired(fieldSetRequired);
		this.priceOfStaff = priceOfStaff;
		this.licenceFee1Staff = licenceFee1Staff;
		this.licenceFee2Staff = licenceFee2Staff;
		this.licenceFee3Staff = licenceFee3Staff;
		this.licenceFee4Staff = licenceFee4Staff;
		
	}
	
	/**
	 * @param name
	 */
	public StartupSpace(String name) {
		super(name);
	}

	/**
	 * Constructor to be used when starting a quick game where Startups 
	 * may be assigned to players.
	 * @param name
	 * @param playerOwner
	 * @param spaceNumber
	 * @param canBeDeveloped
	 * @param isOwned
	 * @param price
	 * @param rent
	 * @param staff
	 * @param spaceField
	 * @param fieldRequired
	 * @param priceOfStaff
	 * @param licenceFee1Staff
	 * @param licenceFee2Staff
	 * @param licenceFee3Staff
	 * @param licenceFee4Staff
	 */
	public StartupSpace(String name, int playerOwner, boolean canBeDeveloped, 
			boolean isOwned, double price, double rent, int staff, String spaceField, int fieldSetRequired, double priceOfStaff, double licenceFee1Staff, double licenceFee2Staff, double licenceFee3Staff, double licenceFee4Staff) {
		super(name);
		this.setCanBeDeveloped(canBeDeveloped);
		this.setOwned(isOwned);
		this.setPrice(price);
		this.setRent(rent);
		this.setPlayerOwner(playerOwner);
		this.setStaff(staff);
		this.setSpaceField(spaceField);
		this.setFieldSpaceRequired(fieldSetRequired);
		this.priceOfStaff = priceOfStaff;
		this.licenceFee1Staff = licenceFee1Staff;
		this.licenceFee2Staff = licenceFee2Staff;
		this.licenceFee3Staff = licenceFee3Staff;
		this.licenceFee4Staff = licenceFee4Staff;
	}

	//getters and setters
	/**
	 * Get the current Development status
	 * @return the canBeDeveloped (boolean)
	 */
	public boolean getCanBeDeveloped() {
		return canBeDeveloped;
	}

	/**
	 * Set the current development status
	 * @param set the canBeDeveloped (boolean)
	 */
	public void setCanBeDeveloped(boolean canBeDeveloped) {
		this.canBeDeveloped = canBeDeveloped;
	}

	/**
	 * Get the current ownership status
	 * @return the isOwned (boolean)
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/**
	 * Set the current ownership status
	 * @param set the isOwned (boolean)
	 */
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	/**
	 * Get the price to buy of the StartupSpace
	 * @return the price (double)
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price to buy of the StartupSpace
	 * Validation: price cannot be set below the minPrice constant var 
	 * @param set the price (double)
	 */
	public void setPrice(double price) {
		if(price >= minPrice) {
			this.price = price;
		}else {
			throw new IllegalArgumentException("Invalid price set for Space");
		}
	}

	/**
	 * Get the price of rent on this StartupSpace
	 * @return the rent (double)
	 */
	public double getRent() {
		return rent;
	}

	/**
	 * Set the price of rent on this StartupSpace
	 * Validation: Minimum amount for rent should not be below the set minRent
	 * @param set the rent (double)
	 */
	public void setRent(double rent) {
		if(rent >= minRent) {
			this.rent = rent;
		}else {
			throw new IllegalArgumentException("Invalid amount indicated for rent");
		}
		
	}

	/**
	 * Get the player number of the current owner
	 * @return the playerOwner (int)
	 */
	public int getPlayerOwner() {
		return playerOwner;
	}

	/**
	 * Set the current owner to a player number
	 * Validation: Checks if the Startup has been previously owned and if not
	 * increases the value of the property to reflect business good will of the new
	 * owner - any startup that has been owned by another player is more valuable.
	 * Or so capitalism would like us to think!
	 * @param set the playerOwner (int)
	 */
	public void setPlayerOwner(int playerOwner) {
		if(this.playerOwner == BANK_OWNER) {
			this.playerOwner = playerOwner;
			this.isOwned = true;
			increasePrice();
		}else {
			this.playerOwner = playerOwner;
		}
	}

	/**
	 * Get the number of staff employed at Startup
	 * @return the staff (int)
	 */
	public int getStaff() {
		return staff;
	}

	/**
	 * Set the number of staff employed at Startup
	 * Validation: There cannot be more than the  maxStaff employed at any one startup
	 * @param set the staff (int)
	 */
	public void setStaff(int staff) {
		this.staff = staff;
		
	}
	
	/**
	 * Gets the amount of spaces in the field the player is required to own
	 * before being allowed to develop the space
	 * @return fieldSetRequired (int)
	 */
	public int getFieldSetRequired() {
		return fieldSetRequired;
	}

	/**
	 * Set the amount of spaces in the space field, the player is required is own
	 * before being allowed to develop the space
	 * @param fieldSetRequired(int);
	 */
	public void setFieldSpaceRequired(int fieldSetRequired) {
		this.fieldSetRequired = fieldSetRequired;	
	}
	
	
	/**
	 * Get the field type of this space
	 * @return (String)
	 */
	public String getSpaceField() {
		return spaceField;
	}

	/**
	 * Set the price to buy of the StartupSpace
	 * Validation: price cannot be set below the minPrice constant var 
	 * @param set the price (double)
	 */
	public void setSpaceField(String spaceField) {
		this.spaceField = spaceField;
	}
	
	/**
	 * Get the price of the first staff member for this starup
	 * @return priceOfStaff1 (double)
	 */
	public double getPriceOfStaff() {
		return this.priceOfStaff;
	}

	/**
	 * Set the price of a staff member for this startup
	 * @param priceOfStaff1 (double)
	 */
	public void setPriceOfStaff(double priceOfStaff) {
		this.priceOfStaff = priceOfStaff;
	}
	
	/**
	 * Get the licence fee for the startup with 1 member of staff
	 * @return licenceFee1Staff (double)
	 */
	public double getLicenceFee1Staff() {
		return this.licenceFee1Staff;
	}

	/**
	 * Set the licence fee for the startup with 1 member of staff
	 * @param licenceFee1Staff (double)
	 */
	public void setLicenceFee1Staff(double licenceFee1Staff) {
		this.licenceFee1Staff = licenceFee1Staff;
	}
	
	/**
	 * Get the licence fee for the startup with 2 member of staff
	 * @return licenceFee2Staff (double)
	 */
	public double getLicenceFee2Staff() {
		return this.licenceFee2Staff;
	}

	/**
	 * Set the licence fee for the startup with 2 member of staff
	 * @param licenceFee2Staff (double)
	 */
	public void setLicenceFee2Staff(double licenceFee2Staff) {
		this.licenceFee2Staff = licenceFee2Staff;
	}
	
	/**
	 * Get the licence fee for the startup with 3 member of staff
	 * @return licenceFee3Staff (double)
	 */
	public double getLicenceFee3Staff() {
		return this.licenceFee3Staff;
	}

	/**
	 * Set the licence fee for the startup with 3 member of staff
	 * @param licenceFee3Staff (double)
	 */
	public void setLicenceFee3Staff(double licenceFee3Staff) {
		this.licenceFee3Staff = licenceFee3Staff;
	}
	
	/**
	 * Get the licence fee for the startup with 4 member of staff
	 * @return licenceFee4Staff (double)
	 */
	public double getLicenceFee4Staff() {
		return this.licenceFee4Staff;
	}

	/**
	 * Set the licence fee for the startup with 4 member of staff
	 * @param licenceFee4Staff (double)
	 */
	public void setLicenceFee4Staff(double licenceFee4Staff) {
		this.licenceFee4Staff = licenceFee4Staff;
	}
	
	
	//other methods
	/**
	 * Add 20% to the value of the Startup to reflect business good will
	 */
	public void increasePrice() {
		this.price += (price/100) * 20;
	}
	
	/**
	 * Method to increase the number of staff working at the Startup
	 * Validation: No more than the maxStaff constant var is allowed
	 */
	public void increaseStaff() {
		if(this.staff < this.maxStaff ) {
			this.staff++;
			switch(this.staff) {
			case 1:
				setPrice(licenceFee1Staff);
			break;
			case 2:
				setPrice(licenceFee2Staff);
			break;
			case 3:
				setPrice(licenceFee3Staff);
			break;
			case 4:
				setPrice(licenceFee4Staff);
			break; 
			}
		}else { 
			throw new AssertionError("Max limit of staff reached");
		}
	}
	
	
	

}

