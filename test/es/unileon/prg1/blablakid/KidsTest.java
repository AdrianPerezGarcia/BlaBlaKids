package es.unileon.prg1.blablakid;

/**
 * 
 * @author Pablo Bayon
 * 
 */
import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

public class KidsTest {

	private Kids kids;
	private Kid daniel;
	private Kid beatriz;
	private Kid manuel;

	@Before
	public void setUp() throws KidException {
		this.kids = new Kids(3);
		this.daniel = new Kid("Daniel");
		this.kids.add(this.daniel);
		this.beatriz = new Kid("Beatriz");
		this.kids.add(beatriz);
		this.manuel = new Kid("Manuel");
		this.kids.add(manuel);
	}

	@Test
	public void testisIncluded() throws KidException {
		assertTrue(this.kids.isIncluded(daniel));
		Kid carlos = new Kid("carlos");
		assertFalse(this.kids.isIncluded(carlos));
	}

	@Test(expected = KidException.class)
	public void testAddIncluded() throws KidException {
		this.kids.remove(beatriz);
		Kid kid = new Kid("Daniel");
		this.kids.add(kid);
	}

	@Test(expected = KidException.class)
	public void testAddFull() throws KidException {
		Kid kid = new Kid("Pablo");
		kids.add(kid);
	}

	@Test
	public void testAddOk() throws KidException {
		assertEquals(3, this.kids.getNumberOfKids());
		this.kids.remove(daniel);
		assertEquals(2, this.kids.getNumberOfKids());
		Kid pablo = new Kid("Pablo");
		this.kids.add(pablo);
		assertEquals(3, this.kids.getNumberOfKids());
	}

	@Test
	public void testGet() {
		assertEquals(daniel, this.kids.get(0));
	}

	@Test 
	public void testRemove() throws KidException{
		this.kids.remove(manuel);
	}
	
	@Test 
	public void testRemoveRide() throws RideException, HourException, ActivityException{
		Place end = new Place("Palomera");
		Place start = new Place("Casa");
		Day day = new Day(WeekDays.MONDAY, 3);
		Hour startTime = new Hour(18,00);
		Hour endTime = new Hour(19,00);
		Hour startRide = new Hour(17,00);
		Hour endRide = new Hour(17, 59);
		Hour otherStart = new Hour(19, 01);
		Hour otherEnd = new Hour(20, 00);
		Activity activity = new Activity("Basket", end, day, startTime, endTime);
		Ride ride = new Ride(start, end, startRide, endRide);
		Ride otherRide = new Ride(end, start, otherStart, otherEnd);
		activity.setRides(otherRide);
		activity.setRides(ride);
		this.beatriz.add(activity);
		this.kids.remove(ride);

	}
	
	@Test(expected = KidException.class)
	public void testRemoveFail() throws KidException {
		Kid kid = new Kid("Pablo");
		this.kids.remove(kid);
	}

	@Test
	public void testInWhichPosIs() throws KidException {
		// Cause it is a private method, i cover the test launching another method
		this.kids.remove(beatriz);
	}

	@Test
	public void testSearchOk() {
		assertEquals(beatriz, this.kids.search("Beatriz"));
	}

	@Test
	public void testSearchFail() {
		assertNull(this.kids.search("Martin"));
	}
	
	@Test
	public void testGetLength() {
		assertEquals(3, this.kids.getLength());
	}

}
