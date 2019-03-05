/**
 * 
 */
package g3.technopoly;

/**
 * ENUM containing all startup space properties. (Name, Field, Set required,
 * Price) 
 * This facilitates scalability of a board for future implementations; in order to expand 
 * the game's startup space capacity, simply add each one as an extra ENUM value.
 * 
 * @author Ismael Florit
 * @studentNo 40009944
 */
public enum StartupSpaceValues {

	// Properties for each Value.

	WEBDEV1("Artisan Web", "WebDev", 2, 12000, 800), WEBDEV2("Reflex Studios", "WebDev", 2, 12000, 800),
	FINTECH1("Deloitte", "FinTech", 3, 1800, 1400), FINTECH2("PWC", "FinTech", 3, 18000, 1400),
	FINTECH3("Pearson", "FinTech", 3, 20000, 1600), CLOUD1("Rapid7", "Cloud", 3, 26000, 2200),
	CLOUD2("Liberty IT", "Cloud", 3, 26000, 2200), CLOUD3("Cloud Migration 365", "Cloud", 3, 28000, 2400),
	AI1("HAL Robotics", "AI", 2, 32000, 2800), AI2("IC Resources", "AI", 2, 35000, 3500);

	private final String spaceName;
	private final String spaceField;
	private final int setRequired;
	private final int price;
	private final int rent;

	private StartupSpaceValues(String spaceName, String spaceField, int setRequired, int price, int rent) {
		this.spaceName = spaceName;
		this.spaceField = spaceField;
		this.setRequired = setRequired;
		this.price = price;
		this.rent = rent;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public String getSpaceField() {
		return spaceField;
	}

	public int getSetRequired() {
		return setRequired;
	}

	public int getPrice() {
		return price;
	}

	public int getRent() {
		return rent;
	}

}
