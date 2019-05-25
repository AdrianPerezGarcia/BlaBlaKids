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
	public void testKids() throws KidException {
		Kid kid = new Kid("Beatriz");
		this.blablakid.add(kid);
		assertSame("Beatriz", this.blablakid.searchKid(kid.getName()).getName());
		this.blablakid.remove(kid);
		assertNull(this.blablakid.searchKid(kid.getName()));
	}
	
	@Test
	public void testParents() throws KidException, ParentException {
		Kids kidsParents = new Kids(2);
		Kid kidParent = new Kid("Beatriz");
		Kid kidParent2 = new Kid("Manuel");
		kidsParents.add(kidParent);
		kidsParents.add(kidParent2);
		Parent parent = new Parent("Pedro", kidsParents, 3);
		this.blablakid.add(parent);
		assertEquals("Pedro", this.blablakid.searchParent("Pedro").getName());
		this.blablakid.remove(parent);
		assertNull(this.blablakid.searchParent("Pedro"));
	}
	
	@Test (expected = ParentException.class)
	public void testParentWrongAdd() throws KidException, ParentException {
		Kids kidsParents = new Kids(2);
		Kid kidParent = new Kid("Beatriz");
		Kid kidParent2 = new Kid("Manuel");
		kidsParents.add(kidParent);
		kidsParents.add(kidParent2);
		Parent parent = new Parent("Pedro", kidsParents, 3);
		this.blablakid.add(parent);
		Parent parent2 = new Parent("Pedro", kidsParents, 6);
		this.blablakid.add(parent2);
	}
	
	@Test (expected = ParentException.class)
	public void testParentWrongRemove() throws KidException, ParentException {
		Kids kidsParents = new Kids(1);
		Kid kidParent = new Kid("Beatriz");
		kidsParents.add(kidParent);
		Parent parent = new Parent("Pedro", kidsParents, 7);	
		this.blablakid.remove(parent);
	}
	
	@Test
	public void testAddActivities() throws DayException, HourException, KidException, ActivityException {
		Kid kid = new Kid("Beatriz");
		this.blablakid.add(kid);
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(10, 05);
		Activity activity = new Activity("Baloncesto", place, day, startHour, endHour);
		this.blablakid.add(activity, "Beatriz");
	}
	
	@Test (expected = KidException.class)
	public void testAddActivitiesWrongKid() throws DayException, HourException, KidException, ActivityException {
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay, 0);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(10, 05);
		Activity activity = new Activity("Baloncesto", place, day, startHour, endHour);
		this.blablakid.add(activity, "Beatriz");
	}
	
	@Test
	public void testRemoveActivities() throws DayException, HourException, KidException, ActivityException {
		Kid kid = new Kid("Beatriz");
		this.blablakid.add(kid);
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay, 0);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(10, 05);
		Activity activity = new Activity("Baloncesto", place, day, startHour, endHour);
		this.blablakid.add(activity, kid.getName());
		this.blablakid.remove(activity, "Beatriz");
	}
	
	@Test (expected = KidException.class)
	public void testRemoveActivitiesWrongKid() throws DayException, HourException, KidException, ActivityException {
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay, 0);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(10, 05);
		Activity activity = new Activity("Baloncesto", place, day, startHour, endHour);
		this.blablakid.remove(activity, "Beatriz");
	}
	
	@Test (expected = KidException.class)
	public void testRemoveActivitiesWrongActivity() throws DayException, HourException, KidException, ActivityException {
		Kid kid = new Kid("Beatriz");
		this.blablakid.add(kid);
		Place place = new Place("Biblioteca");
		WeekDays wDay = WeekDays.MONDAY;
		Day day = new Day(wDay, 0);
		Hour startHour = new Hour(8, 00);
		Hour endHour = new Hour(10, 05);
		Activity activity = new Activity("Baloncesto", place, day, startHour, endHour);
		this.blablakid.remove(activity, "Beatriz");
	}
	
	
	
	
}
 