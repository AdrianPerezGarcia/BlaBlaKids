/**
 * @author Hector Castro
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	private Activity actividad;
	private Ride beforeRide;
	private Ride afterRide;
	private String name;
	private Place palomera;
	private Place casa;
	private Day day;
	private Hour startTime;
	private Hour endTime;
	private Hour beforeRideStart;
	private Hour beforeRideEnd;
	private Hour afterRideStart;
	private Hour afterRideEnd;
	
	
	@Before
	public void setUp()throws ActivityException, DayException, HourException, RideException{
		this.name = new String("Baloncesto");
		this.palomera = new Place("Palomera");
		this.casa = new Place("Casa");
		this.day = new Day(WeekDays.MONDAY);
		this.startTime = new Hour(15,00);
		this.endTime = new Hour(16,00);
		this.beforeRideStart = new Hour(14,30);
		this.beforeRideEnd = new Hour(15,00);
		this.afterRideStart = new Hour (16,00);
		this.afterRideEnd = new Hour(16,30);
		
		this.actividad = new Activity(name,palomera,day,startTime,endTime);
		this.beforeRide = new Ride(casa,palomera,beforeRideStart,beforeRideEnd);
		this.afterRide = new Ride(palomera,casa,afterRideStart,afterRideEnd);
		
	}
	@Test
	public void testSetGetBeforeRide() {
		this.actividad.setBeforeRide(beforeRide);
		assertTrue(this.actividad.getBeforeRide().isSame(beforeRide));
	}

	@Test
	public void testSetGetAfterRide() {
		this.actividad.setAfterRide(afterRide);
		assertTrue(this.actividad.getAfterRide().isSame(afterRide));
	}

	@Test
	public void testIsSame() {
		assertTrue(this.actividad.isSame(this.actividad));
	
	}

	@Test
	public void testGetName() {
		assertTrue(this.actividad.getName().equals("Baloncesto"));
	}

	@Test
	public void testGetPlace() {
		assertTrue(this.actividad.getPlace().getPlace().equals("Palomera"));
	}
	
	@Test
	public void testGetDay() {
		assertEquals(0,this.actividad.getDay().getNumDay());
	}

	@Test
	public void testGetStartTime() {
		assertTrue(this.actividad.getStartTime().isSame(this.startTime));
	}

	@Test
	public void testGetEndTime() {
		assertTrue(this.actividad.getEndTime().isSame(this.endTime));
	}

	@Test
	public void testToString() {
		//TODO
	}
	 
}
