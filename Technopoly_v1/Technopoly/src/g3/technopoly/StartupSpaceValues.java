/**
 * 
 */
package g3.technopoly;

/**
 * ENUM containing all startup space properties. (Name, Field, Set required,
 * Price) This facilitates scalability of a board for future implementations; in
 * order to expand the game's startup space capacity, simply add each one as an
 * extra ENUM value.
 * 
 * @author Ismael Florit
 * @studentNo 40009944
 */
public enum StartupSpaceValues {

	// Properties for each Value.

	WEBDEV1("Artisan Web", "WebDev", 2, 12000, 800, 4000, 10000, 30000, 45000, 60000, 5000),
	WEBDEV2("Reflex Studios", "WebDev", 2, 12000, 800, 4000, 10000, 30000, 45000, 60000, 5000),
	FINTECH1("Deloitte", "FinTech", 3, 18000, 1400, 7000, 20000, 55000, 75000, 95000, 10000),
	FINTECH2("PWC", "FinTech", 3, 18000, 1400, 7000, 20000, 55000, 75000, 95000, 10000),
	FINTECH3("Pearson", "FinTech", 3, 20000, 1600, 8000, 22000, 60000, 80000, 100000, 10000),
	CLOUD1("Rapid7", "Cloud", 3, 26000, 2200, 11000, 33000, 80000, 97500, 115000, 15000),
	CLOUD2("Liberty IT", "Cloud", 3, 26000, 2200, 11000, 30800, 77000, 99000, 121000, 15000),
	CLOUD3("Cloud Migration 365", "Cloud", 3, 28000, 2400, 12000, 36000, 85000, 102500, 120000, 15000),
	AI1("HAL Robotics", "AI", 2, 32000, 2800, 15000, 45000, 100000, 120000, 140000, 20000),
	AI2("IC Resources", "AI", 2, 35000, 3500, 17500, 50000, 110000, 130000, 150000, 20000);

	private final String spaceName;
	private final String spaceField;
	private final int setRequired;
	private final int price;
	private final int site_price;
	private final int staff_1_price;
	private final int staff_2_price;
	private final int staff_3_price;
	private final int staff_4_price;
	private final int CTO_price;
	private final double priceToHireStaff;
 
	private StartupSpaceValues(String spaceName, String spaceField, int setRequired, int price, int site_price,
			int staff_1_price, int staff_2_price, int staff_3_price, int staff_4_price, int CTO_price,
			double priceToHireStaff) {
		this.spaceName = spaceName;
		this.spaceField = spaceField;
		this.setRequired = setRequired;
		this.price = price;
		this.site_price = site_price;
		this.staff_1_price = staff_1_price;
		this.staff_2_price = staff_2_price;
		this.staff_3_price = staff_3_price;
		this.staff_4_price = staff_4_price;
		this.CTO_price = CTO_price;
		this.priceToHireStaff = priceToHireStaff;
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

	public int getSite_price() {
		return site_price;
	}

	public int getStaff_1_price() {
		return staff_1_price;
	}

	public int getStaff_2_price() {
		return staff_2_price;
	}

	public int getStaff_3_price() {
		return staff_3_price;
	}

	public int getStaff_4_price() {
		return staff_4_price;
	}

	public int getCTO_price() {
		return CTO_price;
	}

	public double getPriceToHireStaff() {
		return priceToHireStaff;
	}
}
