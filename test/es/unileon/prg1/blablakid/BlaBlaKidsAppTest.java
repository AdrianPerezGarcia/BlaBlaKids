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
		this.activityStartHour = new Hour(15,05);
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
		this.blablakid.remove(this.parent);
		assertNull(this.blablakid.searchParent("Juan"));
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
	public void testAddActivitiesWrongKid() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julia");
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
		
		Place startPlace = new Place("Palomera");
		Place endPlace = new Place("Casa");
		
		Hour startHour = new Hour(16,00);
		Hour endHour = new Hour(17,00);
		
		this.ride = new Ride(startPlace, endPlace, startHour, endHour);
		
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), this.activityName, this.day);
	}
	
	@Test (expected = ParentException.class)
	public void testAddRideWrongParent() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, "asd" , this.kid.getName(), this.activityName, this.day);
	}
	
	@Test (expected = KidException.class)
	public void testAddRideWrongKid() throws Exception {
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName() , "asd", this.activityName, this.day);
	}
	
	@Test (expected = ActivityException.class)
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
	
	@Test (expected = ParentException.class)
	public void testRemoveRidesWrongParent() throws Exception{
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), this.activityName, this.day);
		this.blablakid.remove("asd", this.day.getNumDay(), this.rideStartPlace.getPlace(), this.rideEndPlace.getPlace());
	}
	
	@Test (expected = RideException.class)
	public void testRemoveRidesWrongRide() throws Exception{
		this.blablakid.add(this.kid);
		this.activity = new Activity("Baloncesto", this.rideStartPlace, this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(this.activity, "Julian");
		this.blablakid.add(this.parent);
		this.ride = new Ride(this.rideStartPlace, this.rideEndPlace, this.rideStartHour, this.rideEndHour);
		this.blablakid.add(this.ride, this.parent.getName(), this.kid.getName(), this.activityName, this.day);
		this.blablakid.remove(this.parent.getName(), this.day.getNumDay(), "asd", this.rideEndPlace.getPlace());
	}
	
	@Test
	public void testSetBeforeRide() throws Exception{
		this.blablakid.add(this.kid);
		
		this.blablakid.add(this.parent);
		
		Place activitySite = new Place("Palomera");
		Place home = new Place("Casa");
		
		Hour beforeRideStartHour = new Hour(14, 00);
		Hour beforeRideEndHour = new Hour(15, 00);
		
		Hour activityStartTime = new Hour(15, 05);
		Hour activityEndTime = new Hour(15, 55);
		
		Hour afterRideStartHour = new Hour(16, 00);
		Hour afterRideEndHour = new Hour(17, 00);
		
		Activity activity = new Activity("Baloncesto", activitySite, this.day, activityStartTime, activityEndTime);
		
		this.blablakid.add(activity, this.kid.getName());
		
		Ride beforeRide = new Ride(home, activitySite, beforeRideStartHour, beforeRideEndHour);
		Ride afterRide = new Ride(activitySite, home, afterRideStartHour, afterRideEndHour);
		
		this.blablakid.add(beforeRide, this.parent.getName(), this.kid.getName(), "Baloncesto", this.day);
		this.blablakid.add(afterRide, this.parent.getName(), this.kid.getName(), "Baloncesto", this.day);
		
		this.blablakid.remove("Baloncesto", kid.getName(), this.day);
	}
	
	@Test
	public void testIsKidIncluded() throws KidException {
		this.blablakid.add(this.kid);
		boolean result = this.blablakid.isIncluded(kid);
		assertTrue(result);
	}
	
	@Test
	public void testGetLength() throws KidException{
		assertEquals(3, this.blablakid.getKidsLength());
	}
	
	@Test
	public void testCheckStatus() throws ActivityException, KidException{
		this.activity = new Activity("Baloncesto", new Place("Palomera") , this.day, this.activityStartHour, this.activityEndHour);
		this.blablakid.add(kid);
		this.blablakid.add(activity, kid.getName());
		assertEquals("Check status: \nJulian: \nNo ride before Baloncesto assigned.\nNo ride after Baloncesto assigned.\n", this.blablakid.checkStatus());
	}
	
	@Test
	public void testToString() throws KidException, ParentException{
		this.blablakid.add(this.kid);
		this.blablakid.add(this.parent);
		assertEquals(("/////////////////////////////\nKIDS:\n****** Julian ******\n\n\nPARENTS:\n###### Juan ######\nKids: \n****** Beatriz ******\n\n\n\n/////////////////////////////"), this.blablakid.toString());
	}
	
}
 