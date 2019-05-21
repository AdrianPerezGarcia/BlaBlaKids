package es.unileon.prg1.blablakid;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlaBlaKidsAppTest {

	private BlaBlaKidsApp blablakid;
	
	@Before
	public void setUp() throws BlaBlaKidException {
		this.blablakid = new BlaBlaKidsApp(3);
	}
	
	@Test(expected = BlaBlaKidException.class)
	public void testWrongConstructor() throws BlaBlaKidException {
		@SuppressWarnings("unused")
		BlaBlaKidsApp app = new BlaBlaKidsApp(-1);
	}
	
	@Test
	public void testGetAndAddKids() throws KidException {
		Kid kid = new Kid("Naiara");
		blablakid.add(kid);
		assertEquals("Naiara", this.blablakid.getKids().get(0).getName());
	}
	
	@Test
	public void testGetAndAddParents() throws KidException, ParentException {
		Kids kidsParents = new Kids(2);
		Kid kidParent = new Kid("Adoracion");
		Kid kidParent2 = new Kid("Camino");
		kidsParents.add(kidParent);
		kidsParents.add(kidParent2);
		Parent parent = new Parent("Argimiro", kidsParents, 3);
		blablakid.add(parent);
		assertEquals("Argimiro", blablakid.getParents().get(0).getName());
	}
	
	@Test
	public void testAddActivities() throws DayException, HourException, KidException, ActivityException {
		Kid kid = new Kid("Adrian");
		this.blablakid.add(kid);
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(23, 59);
		Activity activity = new Activity("Programar", place, day, startHour, endHour);
		this.blablakid.add(activity, "Adrian");
	}
	
	@Test (expected = KidException.class)
	public void testAddActivitiesWrong() throws DayException, HourException, KidException, ActivityException {
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(23, 59);
		Activity activity = new Activity("Programar", place, day, startHour, endHour);
		this.blablakid.add(activity, "Adrian");
	}
	
	@Test
	public void testRemoveKid() throws KidException {
		Kid kid = new Kid("Daniel");
		this.blablakid.add(kid);
		this.blablakid.remove(kid);
	}
	
	@Test
	public void testRemoveKidWrong() throws KidException {
		Kid kid = new Kid("Daniel");
		this.blablakid.remove(kid);
	}
	
}
 