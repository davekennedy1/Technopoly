package technopoly.v1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
	
public class StartupSpaceTest {

	//Test data
	int validLowSpaceNo, validHighSpaceNo, invalidSpaceNo, 
	playerNo1, playerNo2, playerNo0, invalidHighStaffNo, 
	invalidLowStaffNo, validLowStaffNO, validHighStaffNO;
	String validString, invalidString, nullString;
	boolean validTrueBool, validFalseBool;
	double validLowPrice, validMiddlePrice, validHighPrice, invalidLowPrice;
	
	StartupSpace s1, s2;
	
	@Before
	public void setUp() throws Exception {
		validHighSpaceNo = 10;
		validLowSpaceNo = 0;
		invalidSpaceNo = -1;
		validString = "Valid String";
		invalidString = "";
		nullString = null;
		validTrueBool = true;
		validFalseBool = false;
		validLowPrice = 0;
		validMiddlePrice = 1000;
		validHighPrice = 24000.56;
		invalidLowPrice = -.01;
		playerNo0 = -1;
		playerNo1 = 1;
		playerNo2 = 2;
		invalidHighStaffNo = 5;
		invalidLowStaffNo = -1;
		validLowStaffNO = 0;
		validHighStaffNO = 4;
		s1 = new StartupSpace();
	}

	@Test
	public void testStartupSpaceDefaultConstructor() {
		assertNotNull(s1);
		}

	@Test
	public void testStartupSpaceStringIntBooleanBooleanDoubleDoubleIntInt() {
		s2 = new StartupSpace(validString, playerNo0, validLowSpaceNo, validFalseBool, validFalseBool, validHighPrice, validLowPrice, validLowStaffNO);
		assertNotNull(s2);
	}

	@Test
	public void testGetSetCanBeDevelopedTrue() {
		s1.setCanBeDeveloped(validTrueBool);
		assertEquals(true, s1.getCanBeDeveloped());
	}
	
	@Test
	public void testGetSetCanBeDevelopedFalse() {
		s1.setCanBeDeveloped(validFalseBool);
		assertEquals(false, s1.getCanBeDeveloped());
	}

	@Test
	public void testGetSetOwnedTrue() {
		s1.setOwned(validTrueBool);
		assertEquals(true, s1.isOwned());
	}
	
	@Test
	public void testGetSetOwnedFalse() {
		s1.setOwned(validFalseBool);
		assertEquals(false, s1.isOwned());
	}

	@Test
	public void testGetSetValidMinPrice() {
		s1.setPrice(validLowPrice);
		assertEquals(validLowPrice, s1.getPrice(),.01);
	}
	
	@Test
	public void testGetSetValidHighPrice() {
		s1.setPrice(validHighPrice);
		assertEquals(validHighPrice, s1.getPrice(),.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetSetinvalidPrice() {
		s1.setPrice(invalidLowPrice);
	}

	@Test
	public void testGetSetRentLow() {
		s1.setRent(validLowPrice);
		assertEquals(validLowPrice, s1.getRent(), .01);
	}
	
	@Test
	public void testGetSetRentHigh() {
		s1.setRent(validHighPrice);
		assertEquals(validHighPrice, s1.getRent(), .01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetSetinvalidRent() {
		s1.setRent(invalidLowPrice);
	}

	@Test
	public void testGetSetPlayerOwner() {
		s1.setPlayerOwner(playerNo0);
		assertEquals(playerNo0, s1.getPlayerOwner());
	}
	

	@Test
	public void testGetSetvalidLowStaff() {
		s1.setStaff(validLowStaffNO);
		assertEquals(validLowStaffNO, s1.getStaff());
	}
	
	@Test
	public void testGetSetvalidHighStaff() {
		s1.setStaff(validHighStaffNO);
		assertEquals(validHighStaffNO, s1.getStaff());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetSetinvalidLowStaff() {
		s1.setStaff(invalidLowStaffNo);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetSetinvalidHighStaff() {
		s1.setStaff(invalidHighStaffNo);
	}

	@Test
	public void testIncreasePrice() {
		s1.setPrice(validMiddlePrice);
		s1.increasePrice();
		assertEquals(1200, s1.getPrice(),.0);
	}

	@Test
	public void testValidIncreaseStaff() throws Exception{
		s1.setStaff(validLowStaffNO);
		s1.increaseStaff();
		assertEquals((validLowStaffNO+1), s1.getStaff());
	}
	
	@Test (expected = AssertionError.class)
	public void testInvalidIncreaseStaff() {
		s1.setStaff(validHighStaffNO);
		s1.increaseStaff();
	}
	
	@Test
	public void testGetSetPlayerOwner1() {
		s2 = new StartupSpace(validString, playerNo0, validLowSpaceNo, validFalseBool, validFalseBool, validMiddlePrice, validLowPrice, validLowStaffNO);
		s2.setPlayerOwner(playerNo1);
		assertEquals(playerNo1, s2.getPlayerOwner());
		assertEquals(1200,s2.getPrice(), 0);
	}

}
