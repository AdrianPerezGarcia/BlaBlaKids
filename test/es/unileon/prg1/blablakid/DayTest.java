package es.unileon.prg1.blablakid;
/**
 * 
 * @author Adrian Perez
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayTest {

	Day day;
	
	@Before
	public void setUp() throws DayException{
		WeekDays wDay = WeekDays.MONDAY;
		day = new Day(wDay, 3);
	}
	
	@Test
	public void testGetRides() throws Exception{
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		Hour startHour = new Hour(16, 15);
		Hour endHour = new Hour(17, 30);
		Ride ride = new Ride(startPlace, endPlace, startHour, endHour);
		this.day.add(ride);
		assertEquals(ride.getStartPlace(), this.day.search("Palomera", "Casa").getStartPlace());
	}
	
	@Test
	public void testIsSame() throws DayException{
		WeekDays wDay2 = WeekDays.MONDAY;
		Day day2 = new Day(wDay2);
		assertTrue(day.isSame(day2));
	}
	
	@Test
	public void testIsSameWrong() throws DayException{
		WeekDays wDay2 = WeekDays.TUESDAY;
		Day day2 = new Day(wDay2);
		assertFalse(day.isSame(day2));
	}
	
	@Test
	public void testGetNumDay() throws DayException {
		WeekDays wDay2 = WeekDays.MONDAY;
		Day day2 = new Day(wDay2);
		assertEquals(0, day2.getNumDay());
	}
	
	@Test
	public void testToString() throws DayException {
		WeekDays wDay2 = WeekDays.MONDAY;
		Day day2 = new Day(wDay2);
		assertEquals("MONDAY", day2.toString());
	}
}
