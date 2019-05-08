package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HourTest {
	Hour hour;
	
	@Before
	public void setUp() throws HourException{
		this.hour = new Hour(30,18);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidMinuteUpper() throws HourException{
		Hour hour = new Hour(89,15);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidMinuteLower() throws HourException{
		Hour hour = new Hour(-25,15);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpper() throws HourException{
		Hour hour = new Hour(25,30);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLower() throws HourException{
		Hour hour = new Hour(25,-3);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLowerMinuteLower() throws HourException{
		Hour hour = new Hour(-4,-3);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourLowerMinuteUpper() throws HourException{
		Hour hour = new Hour(65,-3);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpperMinuteLower() throws HourException{
		Hour hour = new Hour(-4,26);
	}
	
	@Test (expected = HourException.class)
	public void testHourInvalidHourUpperMinuteUpper() throws HourException{
		Hour hour = new Hour(70,27);
	}
}
