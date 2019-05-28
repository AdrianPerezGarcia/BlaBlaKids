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
	
	@Before
	public void setUp() throws DayException {
		this.week = new Week(1);
		this.day = new Day(WeekDays.MONDAY);
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

}
