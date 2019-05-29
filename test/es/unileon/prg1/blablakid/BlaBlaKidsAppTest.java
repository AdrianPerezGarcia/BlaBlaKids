package es.unileon.prg1.blablakid;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlaBlaKidsAppTest {

	private BlaBlaKidsApp blablakid;
	
	private Kids parentKids;
	
	private Kid parentKid;
	
	private Parent parent;
	
	private Kid kid;
	
	private Place rideStartPlace;
	
	private Place rideEndPlace;
	
	private Hour rideStartHour;
	
	private Hour rideEndHour;
	
	private Hour activityStartHour;
	
	private Hour activityEndHour;
	
	private String activityName;
	
	private Ride ride;
	
	private Activity activity;
	
	private Day day;
	
	@Before
	public void setUp() throws Exception {
		this.blablakid = new BlaBlaKidsApp(3);
		this.parentKids = new Kids(1);
		this.parentKid = new Kid("Beatriz");
		this.parentKids.add(parentKid);
		this.parent = new Parent("Juan", parentKids, 3);
		this.kid = new Kid("Julian");
		this.rideStartPlace = new Place("Palomera");
		this.rideEndPlace = new Place("Casa");
		this.rideStartHour = new Hour(16,00);
		this.rideEndHour = new Hour(17,30);
		this.activityStartHour = new Hour(15,00);
		this.activityEndHour = new Hour(15,58);
		this.activityName = "Baloncesto";
		this.day = new Day(WeekDays.MONDAY, 5);
	}
	
	@Test(expected = BlaBlaKidException.class)
	public void testWrongConstructor() throws BlaBlaKidException {
		@SuppressWarnings("unused")
		BlaBlaKidsApp app = new BlaBlaKidsApp(-1);
	}
	
	@Test
	public void testKids() throws KidException {
		this.blablakid.add(this.kid);
		assertEquals("Julian", this.blablakid.searchKid(kid.getName()).getName());
		this.blablakid.remove(this.kid);
		assertNull(this.blablakid.searchKid(this.kid.getName()));
	}
	
	@Test (expected = KidException.class)
	public void testKidsWrongRemove() throws KidException {
		this.blablakid.remove(this.kid);
	}
	
	@Test
	public void testParents() throws Exception {
		this.blablakid.add(this.parent);
		assertEquals("Juan", this.blablakid.searchParent("Juan").getName());
		/*
		this.blablakid.remove(this.parent);
		assertNull(this.blablakid.searchParent("Juan"));*/
	}
	
	@Test
	public void testActivities() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity(this.activityName, this.rideEndPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(activity, "Julian");
		assertEquals(this.activity.toString(), this.blablakid.searchKid(kid.getName()).search("Baloncesto", this.day.getNumDay()).toString());
		this.blablakid.remove(this.activityName, this.kid.getName(), this.day);
		assertNull(this.blablakid.searchKid(kid.getName()).search("Baloncesto", this.day.getNumDay()));
	}
	
	@Test (expected = KidException.class)
	public void testRemoveActivitiesWrongKid() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.remove(this.activityName, "asd", this.day);
	}
	
	@Test (expected = ActivityException.class)
	public void testRemoveActivitiesWrongActivity() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.remove("asd", "Julian", this.day);
	}
	
	@Test
	public void testAddRide() throws Exception{
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), this.activityName, this.day);
		assertEquals(this.ride, this.blablakid.searchParent(this.parent.getName()).search(this.rideStartPlace.getPlace(), this.rideEndPlace.getPlace(), this.day));
	}
	
	@Test (expected = BlaBlaKidException.class)
	public void testAddRideWrongParent() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, "asd" , this.kid.getName(), this.activityName, this.day);
	}
	
	@Test (expected = BlaBlaKidException.class)
	public void testAddRideWrongKid() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName() , "asd", this.activityName, this.day);
	}
	
	@Test (expected = BlaBlaKidException.class)
	public void testAddRideWrongActivity() throws Exception{
		this.blablakid.add(this.kid);
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), "asd" , this.day);
	}
	
	@Test
	public void testRemoveRides() throws Exception{
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), this.activityName, this.day);
		this.blablakid.remove(this.parent.getName(), this.day.getNumDay(), this.rideStartPlace.getPlace(), this.rideEndPlace.getPlace());
		assertNull(this.blablakid.searchParent(this.parent.getName()).search(this.rideStartPlace.getPlace(), this.rideEndPlace.getPlace(), this.day));
	}
	/**
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
	
	@Test
	public void testAddRides() throws Exception{
		assertNotNull(this.blablakid.searchParent(parent.getName()).search("Palomera", "Casa", day));
	}
	
	@Test (expected = BlaBlaKidException.class)
	public void testAddRidesWrongParent() throws Exception{
		Kid kid = new Kid("Julian");
		this.blablakid.add(kid);
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		Hour startTime = new Hour(16,00);
		Hour endTime = new Hour(17,30);
		Hour activityStartTime = new Hour(15,00);
		Hour activityEndTime = new Hour(15,58);
		Day day = new Day(WeekDays.MONDAY, 5);
		Activity activity = new Activity("Basketball", startPlace, day, activityStartTime, activityEndTime);
		this.blablakid.add(activity, kid.getName());
		Ride ride = new Ride(startPlace, endPlace, startTime, endTime);
		this.blablakid.add(ride, "parentName", kid.getName(), activity.getName(), day);
	}
	
	
	@Test (expected = BlaBlaKidException.class)
	public void testAddRidesWrongKid() throws Exception{
		Kids parentKids = new Kids(1);
		Kid parentKid = new Kid("Beatriz");
		parentKids.add(parentKid);
		Parent parent = new Parent("Juan", parentKids, 3);
		Kid kid = new Kid("Julian");
		this.blablakid.add(parent);
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		Hour startTime = new Hour(16,00);
		Hour endTime = new Hour(17,30);
		Hour activityStartTime = new Hour(15,00);
		Hour activityEndTime = new Hour(15,58);
		Day day = new Day(WeekDays.MONDAY);
		Activity activity = new Activity("Basketball", startPlace, day, activityStartTime, activityEndTime);
		this.blablakid.add(activity, kid.getName());
		Ride ride = new Ride(startPlace, endPlace, startTime, endTime);
		this.blablakid.add(ride, parent.getName(), kid.getName(), activity.getName(), day);
	}
	**/
	
	
	
}
 