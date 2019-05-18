package es.unileon.prg1.blablakid;

import org.junit.Before;
import org.junit.Test;

public class RidesTest {
	
	private Rides rides;
	private Ride ride1;
	private Ride ride2;
	private Ride ride3;
	
	@Before
	public void setUp() throws HourException, RideException{
		
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		Hour startHour = new Hour(22,00);
		Hour endHour = new Hour(23,00);
		
		ride1 = new Ride(startPlace, endPlace, startHour, endHour);
		
		Place startPlace2 = new Place("Murcia");
		Place endPlace2 = new Place("Piscina de Trobajo");
		Hour startHour2 = new Hour(18,00);
		Hour endHour2 = new Hour(19,00);
		
		ride2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		Place startPlace3 = new Place("La Robla");
		Place endPlace3 = new Place("Universidad de Leon");
		Hour startHour3 = new Hour(11,00);
		Hour endHour3 = new Hour(12,00);
		
		ride3 = new Ride(startPlace3, endPlace3, startHour3, endHour3);
		
		rides = new Rides(3);
		rides.addRide(ride1);
		rides.addRide(ride2);
		rides.addRide(ride3);
			
		
	}
	
	
	@Test
	public void isIncluded() {
		
		assertTrue(this.rides.isIncluded(ride1));
	}
	
	@Test
	public void isNotIncluded() {
		
		
	}
	
	@Test(expected = RideException.class)
	public void testAddIncluded() {
		
		
	}
	
	@Test(expected = RideException.class)
	public void testAddFull() {
		
		
	}
	
	@Test
	public void testAddOk()throws RideException{
		
		
	}
}
