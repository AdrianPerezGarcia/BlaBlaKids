package es.unileon.prg1.blablakid;

/**
 * 
 * @author Pablo Bayon
 * 
 */
import static org.junit.Assert.*;

import java.sql.Time;
import java.time.DayOfWeek;

import org.junit.Before;
import org.junit.Test;

public class KidTest {
	private Kid daniel;

	@Before
	public void setUp() throws KidException {
		this.daniel = new Kid("Daniel");
	}

	@Test
	public void testGetActivities() throws HourException, DayException, ActivityException {
		Place palomera = new Place("Palomera");
		Hour startTime = new Hour(18, 00);
		Hour endTime = new Hour(20, 00);
		WeekDays day = WeekDays.MONDAY;
		Day today = new Day(day);
		Activity baloncesto = new Activity("Baloncesto", palomera, today, startTime, endTime);
		this.daniel.getActivities().add(baloncesto);
		Activities activities = new Activities();
		activities.add(baloncesto);
		assertEquals(baloncesto, this.daniel.getActivities().get(0));
	}
}
