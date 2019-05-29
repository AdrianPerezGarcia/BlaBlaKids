/**
 * @author Hector Castro
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	private Activity actividad;
	private Activity actividad2;
	private Ride beforeRide;
	private Ride afterRide;
	private String name;
	private String name2;
	private Place palomera;
	private Place casa;
	private Day day;
	private Hour startTime;
	private Hour endTime;
	private Hour beforeRideStart;
	private Hour beforeRideEnd;
	private Hour afterRideStart;
	private Hour afterRideEnd;
	private Hour beforeRideEndLate;
	private Hour afterRideStartEarly;
	private Ride beforeRideLate;
	private Ride afterRideEarly;
	private Ride wrongRide;
	
	
	@Before
	public void setUp()throws ActivityException, DayException, HourException, RideException{
		this.name = new String("Baloncesto");
		this.name2 = new String("Basket");
		this.palomera = new Place("Palomera");
		this.casa = new Place("Casa");
		this.day = new Day(WeekDays.MONDAY);
		this.startTime = new Hour(15,00);
		this.endTime = new Hour(16,00);
		this.beforeRideStart = new Hour(14,30);
		this.beforeRideEnd = new Hour(14,59);
		this.afterRideStart = new Hour (16,01);
		this.afterRideEnd = new Hour(16,30);
		
		this.beforeRideEndLate = new Hour(15,10);
		this.afterRideStartEarly = new Hour (15,50);

		
		this.actividad = new Activity(name,palomera,day,startTime,endTime);
		this.actividad2 = new Activity(name2,palomera,day,startTime,endTime);
		this.beforeRide = new Ride(casa,palomera,beforeRideStart,beforeRideEnd);
		this.afterRide = new Ride(palomera,casa,afterRideStart,afterRideEnd);
		this.beforeRideLate = new Ride(casa,palomera,beforeRideStart,beforeRideEndLate);
		this.afterRideEarly = new Ride(palomera,casa,afterRideStartEarly,afterRideEnd);
		this.wrongRide = new Ride (casa, casa, beforeRideStart,beforeRideEnd);
	}
	@Test
	public void testSetGetBeforeRide() throws RideException {
		this.actividad.setRides(beforeRide);
		assertTrue(this.actividad.getBeforeRide().isSame(beforeRide));
	}

	@Test
	public void testSetGetAfterRide() throws RideException {
		this.actividad.setRides(afterRide);
		assertTrue(this.actividad.getAfterRide().isSame(afterRide));
	}
	
	@Test(expected = RideException.class)
	public void testWrongRide() throws RideException {
		this.actividad.setRides(this.wrongRide);
	}
	
	@Test(expected = RideException.class)
	public void testWrongAfterRides() throws RideException {
		this.actividad.setRides(this.beforeRide);
		this.actividad.setRides(this.afterRideEarly);
	}
	
	@Test(expected = RideException.class)
	public void testWrongBeforeRides() throws RideException {
		this.actividad.setRides(this.beforeRideLate);
	}
	
	@Test
	public void testIsSame() {
		assertTrue(this.actividad.isSame(this.actividad));
	
	}
	
	@Test
	public void testIsSameDifferent() {
		assertFalse(this.actividad.isSame(this.actividad2));
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
	public void testToStringNoRides() {
		StringBuilder out = new StringBuilder();
		out.append(name + " (" + palomera + " - " + day.getNameDay() + ")" + startTime + " > " + endTime+"\n");
		out.append("No ride before "+name+" assigned\n");
		out.append("No ride after "+name+" assigned\n");
		assertTrue(out.toString().equals(this.actividad.toString()));
	}

	@Test
	public void testToStringRides() throws RideException {
		this.actividad.setRides(beforeRide);
		this.actividad.setRides(afterRide);
		StringBuilder out = new StringBuilder();
		out.append(name + " (" + palomera + " - " + day.getNameDay()+ ")" + startTime + " > " + endTime+"\n");
		out.append(beforeRide.getStartPlace() + " > " + beforeRide.getEndPlace() + " : " + beforeRide.getStartTime() + "/" + beforeRide.getEndTime() + "\n");
		out.append(afterRide.getStartPlace() + " > " + afterRide.getEndPlace() + " : " + afterRide.getStartTime()+ "/" + afterRide.getEndTime() + "\n");
		assertEquals(out.toString(),(this.actividad.toString()));
	} 
	
	@Test
	public void testRemoveBeforeRide() throws RideException {
		this.actividad.setRides(beforeRide);
		this.actividad.removeBeforeRide();
		assertNull(this.actividad.getBeforeRide());
	}
	
	@Test
	public void testRemoveAfterRide() throws RideException {
		this.actividad.setRides(afterRide);
		this.actividad.removeAfterRide();
		assertNull(this.actividad.getAfterRide());
	}
}
