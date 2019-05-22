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
		this.week = new Week();
		this.day = new Day(WeekDays.MONDAY);
		this.day1 = new Day(WeekDays.TUESDAY);
	}
	
	@Test
	public void TestAddGet() throws DayException {
		this.week.add(day);
		assertEquals(this.day.getNumDay(),this.week.getDay(0).getNumDay());
	}
	
	@Test (expected = DayException.class )
	public void TestAddSame() throws DayException {
		this.week.add(day);
		this.week.add(day);
	}

	@Test
	public void TestRemove() throws DayException {
		this.week.remove(this.week.search(this.day.getNumDay()));
	}		
}
