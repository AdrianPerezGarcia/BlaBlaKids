package es.unileon.prg1.blablakid;

/**
 * @author PabloJ
 *
 */

import static org.junit.Assert.*;

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
	
	@Test(expected = RideException.class)
	public void testAddIncluded() throws HourException, RideException{
		
		this.rides.remove(ride2);
		
		Place startPlace = new Place("La Robla");
		Place endPlace = new Place("Universidad de Leon");
		Hour startHour = new Hour(11,00);
		Hour endHour = new Hour(12,00);
		
		Ride ride = new Ride(startPlace, endPlace, startHour, endHour);
		
		this.rides.addRide(ride);
	}
	
	@Test(expected = RideException.class)
	public void testAddFull() throws HourException, RideException{
		
		Place startPlace = new Place("Mercadona");
		Place endPlace = new Place("La Lastra");
		Hour startHour = new Hour(16,00);
		Hour endHour = new Hour(17,00);
		
		Ride ride = new Ride (startPlace, endPlace, startHour, endHour);
		
		this.rides.addRide(ride);
		
	}
	
	@Test
	public void testAddOk()throws RideException, HourException{
		
		this.rides.remove(ride2);
		
		Place startPlace = new Place("Murcia");
		Place endPlace = new Place("Piscina de Trobajo");
		Hour startHour = new Hour(18,00);
		Hour endHour = new Hour(19,00);
		
		Ride ride = new Ride(startPlace, endPlace, startHour, endHour);
		
		this.rides.addRide(ride);
		
	}
	
	@Test
	public void testGet() throws RideException {
		
		assertEquals(ride1, this.rides.get(0));
	}
	
	@Test
	public void testGetLength() {
		
		assertEquals(3, this.rides.getLength());
	}
	
	@Test(expected = RideException.class)
	public void testRemoveFail() throws HourException, RideException {
		
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Lidl");
		Hour startHour = new Hour(12,00);
		Hour endHour = new Hour(13,00);
		
		Ride ride = new Ride(startPlace, endPlace, startHour, endHour);
		
		this.rides.remove(ride);
		
	}
	
	@Test
	public void getPos() throws RideException {
		//With this method I don't miss any branch in remove from Rides
		this.rides.remove(ride1);
		
	}
	
	@Test
	public void searchOk() {
		
		assertEquals(ride1, this.rides.search("Palomera", "Casa"));
	}
	
	@Test
	public void searchFail() {
		
		assertNull(this.rides.search("Pamplona","Colegio"));
	}
	
	@Test
	public void testToString() {
		
		StringBuilder expect = new StringBuilder();
		
		expect.append(this.ride1.toString()).append("\n");
		expect.append(this.ride2.toString()).append("\n");
		expect.append(this.ride3.toString()).append("\n");
		
		assertEquals(expect.toString(), this.rides.toString());
	}
	
	
	
	
}
