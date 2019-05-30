package es.unileon.prg1.blablakid;

/**
 * @author Hector Castro
 *
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WeekTest {
	private Week week;
	private Day day;
	private Day day1;
	private Place start = new Place("Palomera");
	private Place end = new Place("Casa");
	private Hour startHour;
	private Hour endHour;
	private Ride ride;
	
	@Before
	public void setUp() throws DayException, HourException, RideException {
		this.startHour = new Hour(10,30);
		this.endHour = new Hour(11,30);
		this.ride = new Ride(this.start,this.end,this.startHour,this.endHour);
		this.week = new Week(1);
		this.day = new Day(WeekDays.MONDAY,1);
		this.day1 = new Day(WeekDays.TUESDAY);
	}
	
	@Test
	public void TestGetDay() throws DayException {
		assertEquals(this.day.getNumDay(),this.week.getDay(0).getNumDay());
	}	
	
	@Test
	public void TestSearch() throws DayException {
		
		assertEquals(this.day1.getNumDay(),this.week.search(1).getNumDay());
	}
	
	@Test
	public void testToString() throws RideException {
		StringBuilder out = new StringBuilder();
		this.day.add(ride);
		out.append(this.day.toString());
		out.append("\n");
		 assertEquals(out.toString(),this.week.toString());
	}

}
