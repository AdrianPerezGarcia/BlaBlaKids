package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RideTest {
	
	private Ride viaje;
	
	@Before	
	public void setUp()throws RideException, HourException{
		
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		Hour startHour = new Hour(22,00);
		Hour endHour = new Hour(23,00);
		
		
		this.viaje = new Ride(startPlace, endPlace, startHour, endHour);
		
	}
	
	@Test
	public void testIsSame() throws HourException, RideException {
		
		Place startPlace2 = new Place("Palomera");
		Place endPlace2 = new Place("Casa");
		Hour startHour2 = new Hour(22,00);
		Hour endHour2 = new Hour(23,00);
		
		
		Ride viaje2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		assertTrue(this.viaje.isSame(viaje2));
	}
	
	@Test
	public void testIsNotSameStartPlace() throws HourException, RideException{
		
		Place startPlace2 = new Place("Poligono");
		Place endPlace2 = new Place("Casa");
		Hour startHour2 = new Hour(22,00);
		Hour endHour2 = new Hour(23,00);
		
		Ride viaje2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		assertFalse(this.viaje.isSame(viaje2));		
		
	}
	
	@Test
	public void testIsNotSameEndPlace() throws HourException, RideException{
		
		Place startPlace2 = new Place("Palomera");
		Place endPlace2 = new Place("Puticlub");
		Hour startHour2 = new Hour(22,00);
		Hour endHour2 = new Hour(23,00);
		
		Ride viaje2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		assertFalse(this.viaje.isSame(viaje2));
		
	}
	
	@Test
	public void testIsNotSameStartHour() throws HourException, RideException{
		
		Place startPlace2 = new Place("Palomera");
		Place endPlace2 = new Place("Casa");
		Hour startHour2 = new Hour(22,30);
		Hour endHour2 = new Hour(23,00);
		
		Ride viaje2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		assertFalse(this.viaje.isSame(viaje2));
		
	}
	
	@Test
	public void testIsNotSameEndHour() throws HourException, RideException{
		
		Place startPlace2 = new Place("Palomera");
		Place endPlace2 = new Place("Casa");
		Hour startHour2 = new Hour(22,00);
		Hour endHour2 = new Hour(23,30);
		
		Ride viaje2 = new Ride(startPlace2, endPlace2, startHour2, endHour2);
		
		assertFalse(this.viaje.isSame(viaje2));
		
		
	}
	
	
	
}
