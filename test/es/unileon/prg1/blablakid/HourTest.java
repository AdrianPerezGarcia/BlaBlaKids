package es.unileon.prg1.blablakid;

/**
 * 
 * @author Pablo Bayon
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HourTest {
	Hour hour;
	
	@Before
	public void setUp() throws HourException{
		this.hour = new Hour(18,30);
	}
	
	
	@Test (expected = HourException.class)
	public void testHourInvalidMinuteUpper() throws HourException{
		Hour hour = new Hour(15,89);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidMinuteLower() throws HourException{
		Hour hour = new Hour(15, -25);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpper() throws HourException{
		Hour hour = new Hour(30,25);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLower() throws HourException{
		Hour hour = new Hour(-3,25);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLowerMinuteLower() throws HourException{
		Hour hour = new Hour(-3,-4);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLowerMinuteUpper() throws HourException{
		Hour hour = new Hour(-3,65);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpperMinuteLower() throws HourException{
		Hour hour = new Hour(26,-4);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpperMinuteUpper() throws HourException{
		Hour hour = new Hour(27,70);
	}
	
	@Test
	public void testGetHourAndMinute() {
		assertEquals(18, this.hour.getHour());
		assertEquals(30, this.hour.getMinute());
	}
	
	@Test
	public void testIsHigher() throws HourException{
		Hour hour1 = new Hour(18,00);
		assertTrue(this.hour.isHigher(hour1));
		Hour hour2 = new Hour(19,00);
		assertFalse(this.hour.isHigher(hour2));
		Hour hour3 = new Hour(18,45);
		assertFalse(this.hour.isHigher(hour3));
		Hour hour4 = new Hour(15,00);
		assertTrue(this.hour.isHigher(hour4));	
	}
	
	@Test 
	public void testIsLower() throws HourException{
		Hour hour1 = new Hour(15,00);
		assertTrue(hour1.isLower(this.hour));
		assertFalse(this.hour.isLower(hour1));
		Hour hour2 = new Hour(18,20);
		assertTrue(hour2.isLower(this.hour));
		assertFalse(this.hour.isLower(hour2));
	}
	
	@Test 
	public void testIsSame() throws HourException{
		Hour hour1 = new Hour(18,30);
		assertTrue(this.hour.isSame(hour1)); 
		Hour hour2 = new Hour(18,00);
		assertFalse(this.hour.isSame(hour2));
		Hour hour3 = new Hour(17,30);
		assertFalse(this.hour.isSame(hour3));
	}
	
	@Test
	public void testToString() {
		assertEquals("18:30",this.hour.toString());
	}
}

