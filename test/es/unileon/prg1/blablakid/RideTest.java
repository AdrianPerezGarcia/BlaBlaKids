package es.unileon.prg1.blablakid;

import org.junit.Before;
import org.junit.Test;

public class RideTest {
	
	private Ride viaje;
	
	@Before	
	public void setUp()throws RideException, HourException, DayException, KidException{
		
		Kids niños = new Kids(2);
		Kid daniel = new Kid("Daniel");
		Kid pablo = new Kid("Pablo");
		niños.add(daniel);
		niños.add(pablo);		
			Parent pedro = new Parent("Pedro",niños, 3);
			Place startPlace = new Place("Palomera");
		Hour startTimeActivity = new Hour(18,00);
		Hour endTimeActivity = new Hour(20,00);
		WeekDays day = WeekDays.MONDAY;
		Day today = new Day(day);
			Activity baloncesto = new Activity("Baloncesto", startPlace, today, startTimeActivity, endTimeActivity);
			Place endPlace = new Place("Casa");
			Hour startTime = new Hour(20,00);
			Hour endTime = new Hour(21,00);
		
		this.viaje = new Ride(pedro,baloncesto,startPlace,endPlace,startTime,endTime,false);
		
	}
	
	@Test
	public void testIsSame() {
		
	}
	
	
}
