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
		assertNotNull(this.blablakid.getKids().search("Beatriz"));
		this.blablakid.remove(kid);
		assertNull(this.blablakid.getKids().search("Beatriz"));
	}
	
	@Test (expected = KidException.class)
	public void testKidsWrongAdd() throws KidException {
		Kid kid = new Kid("Beatriz");
		Kid kid2 = new Kid("Manuel");
		Kid kid3 = new Kid("Daniel");
		Kid kid4 = new Kid("Juan");
		this.blablakid.add(kid);
		this.blablakid.add(kid2);
		this.blablakid.add(kid3);
		this.blablakid.add(kid4);
	}
	
	@Test (expected = KidException.class)
	public void testKidsWrongRemove() throws KidException {
		Kid kid = new Kid("Beatriz");
		this.blablakid.remove(kid);
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
		assertNotNull(this.blablakid.getParents().search("Pedro"));
		this.blablakid.remove(parent);
		assertNull(this.blablakid.getParents().search("Pedro"));
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
	
}
 