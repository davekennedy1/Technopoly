/**
 * 
 */
package g3.technopoly;

/**
 * ENUM containing all startup space properties. (Title, Field, Set required, Price)
 * In order to expand the game's startup spaces, simply add each one as an ENUM value.
 * @author Ismael Florit - 40009944
 *
 */
public enum StartupSpaceName {

	// Properties for each Value.

	WEBDEV1("Artisan Web", "WebDev", 2, 12000), WEBDEV2("Reflex Studios", "WebDev", 2, 12000),
	FINTECH1("Deloitte", "FinTech", 3, 1800), FINTECH2("PWC", "FinTech", 3, 18000),
	FINTECH3("Pearson", "FinTech", 3, 20000), CLOUD1("Rapid7", "Cloud", 3, 26000),
	CLOUD2("Liberty IT", "Cloud", 3, 26000), CLOUD3("Cloud Migration 365", "Cloud", 3, 28000),
	AI1("HAL Robotics", "AI", 2, 32000), AI2("IC Resources", "AI", 2, 35000);

	private final String spaceName;
	private final String spaceField;
	private final int setRequired;
	protected final int price;

	private StartupSpaceName(String spaceName, String spaceField, int setRequired, int price) {
		this.spaceName = spaceName;
		this.spaceField = spaceField;
		this.setRequired = setRequired;
		this.price = price;
	}

	public int getSetRequired() {
		return setRequired;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public String getSpaceField() {
		return spaceField;
	}

}
