package es.unileon.prg1.blablakid;
/**
 * 
 * @author Pablo Bayon
 * 
 */

import static org.junit.Assert.*;
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
		this.daniel.add(baloncesto);
		Activities activities = new Activities();
		activities.add(baloncesto);
		assertEquals(baloncesto, this.daniel.search("Baloncesto", 0));
	}
	
	@Test
	public void testIsSame() {
		Kid daniel2 = new Kid("Daniel");
		assertTrue(this.daniel.isSame(daniel2));
	}
	
	@Test
	public void testAddAndRemoveActivity() throws HourException, ActivityException {
		Place place = new Place("Palomera");
		WeekDays day = WeekDays.MONDAY;
		Day today = new Day(day);
		Hour startTime = new Hour(16,00);
		Hour endTime = new Hour(17,30);
		Activity activity = new Activity("Baloncesto", place, today, startTime, endTime);
		this.daniel.add(activity);
		assertEquals(activity.getName(), this.daniel.search("Baloncesto", 0).getName());
		this.daniel.remove(activity);
		assertNull(this.daniel.search("Baloncesto", 0));
	}
	
	@Test
	public void testToString() {
		assertEquals("****** Daniel ******\n", this.daniel.toString());
	}
}
