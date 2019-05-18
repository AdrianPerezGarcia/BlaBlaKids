/**
 * @author Hector Castro
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	private Activity actividad;
	@Before
	public void setUp()throws ActivityException, DayException, HourException{
		String name = new String("Baloncesto");
		Place place = new Place("Palomera");
		Day day = new Day(WeekDays.MONDAY);
		Hour startTime = new Hour(15,00);
		Hour endTime = new Hour(16,30);
	}
	@Test
	void testSetBeforeRide() {
	}
	
	@Test
	void testGetBeforeRide() {

	}


	@Test
	void testGetAfterRide() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAfterRide() {
		fail("Not yet implemented");
	}

	@Test
	void testIsSame() {
		fail("Not yet implemented");
	}

	@Test
	void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlace() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDay() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStartTime() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEndTime() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
