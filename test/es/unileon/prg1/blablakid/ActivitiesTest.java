package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivitiesTest {
	private Activities actividades;
	private Activity actividad;
	private Activity actividad2;
	private Activity actividad3;
	private Activity actividad4;
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
	
	@Before
	public void setUp() throws DayException, HourException, RideException {
		this.name = new String("Baloncesto");
		this.name2 = new String("Basket");
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
		this.actividades = new Activities();
		this.actividad2 = new Activity(name2,palomera,day,startTime,endTime);
		this.actividad3 = new Activity("Badminton",palomera,day,startTime,endTime);
		this.actividad4 = new Activity("Futbol",palomera,day,startTime,endTime);
	}
	
	@Test
	public void testAddGet() throws ActivityException {
		this.actividades.add(this.actividad);
		assertTrue(this.actividades.get(0).isSame(actividad));
	}

	@Test(expected = ActivityException.class)
	public void testAddMax() throws ActivityException {
		this.actividades.add(actividad);
		this.actividades.add(actividad2);
		this.actividades.add(actividad3);
		this.actividades.add(actividad4);
	}
	
	@Test(expected = ActivityException.class)
	public void testAddSame() throws ActivityException {
		this.actividades.add(actividad);
		this.actividades.add(actividad);
	}
	
	@Test
	public void testSearchRemove() throws ActivityException {
		this.actividades.add(actividad);
		this.actividades.remove(actividades.search(name,this.actividad.getDay().getNumDay()));
		assertNull(this.actividades.get(0));
	}
	
	@Test(expected = ActivityException.class)
	public void testRemoveNotIncluded() throws ActivityException {
		this.actividades.remove(actividad2);
	}
	@Test
	public void testGetLength() throws ActivityException {
		assertEquals(3,this.actividades.getLength());
	}

	@Test
	public void testToString() throws ActivityException {
		this.actividades.add(actividad);
		this.actividad.setBeforeRide(beforeRide);
		this.actividad.setAfterRide(afterRide);
		StringBuilder out = new StringBuilder();
		out.append(name + " (" + palomera + " - " + day + ")" + startTime + " > " + endTime+"\n");
		out.append(beforeRide.getStartPlace() + " > " + beforeRide.getEndPlace() + " : " + beforeRide.getStartTime() + "/" + beforeRide.getEndTime() + "\n");
		out.append(afterRide.getStartPlace() + " > " + afterRide.getEndPlace() + " : " + afterRide.getStartTime()+ "/" + afterRide.getEndTime() + "\n");
		assertEquals(out.toString(),(this.actividades.toString()));
	}

}