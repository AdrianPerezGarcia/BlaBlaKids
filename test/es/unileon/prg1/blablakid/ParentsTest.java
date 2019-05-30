package es.unileon.prg1.blablakid;
/**
 * 
 * @author Adrian Perez
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTest {
	
	private Parents parents;
	private Parent parent1;
	private Parent parent2;
	private Parent parent3;
	
	@Before
	public void setUp() throws KidException, ParentException {
		Kids kids = new Kids(2);
		Kid kid1 = new Kid("Pablo");
		Kid kid2 = new Kid("Juan");
		kids.add(kid1);
		kids.add(kid2);
		
		Kids kids2 = new Kids(1);
		Kid kid21 = new Kid("Luis");
		kids2.add(kid21);
		
		Kids kids3 = new Kids(3);
		Kid kid31 = new Kid("Fran");
		Kid kid32 = new Kid("Alvaro");
		Kid kid33 = new Kid("Hector");
		kids3.add(kid31);
		kids3.add(kid32);
		kids3.add(kid33);
		
		parents = new Parents(3);
		parent1 = new Parent("Juan", kids, 6);
		parent2 = new Parent("Alvaro", kids2, 3);
		parent3 = new Parent("Jose", kids3, 4);
		parents.add(parent1);
		parents.add(parent2);
		parents.add(parent3);
	}

	@Test(expected = ParentException.class)
	public void testAddIncluded() throws ParentException, KidException {
		this.parents.remove(parent2);
		Kids kids = new Kids(2);
		Kid kid = new Kid("Daniel");
		Kid kid2 = new Kid("Pablito");
		kids.add(kid);
		kids.add(kid2);
		Parent parent = new Parent("Jose", kids, 1);
		this.parents.add(parent);
	}

	@Test(expected = ParentException.class)
	public void testAddFull() throws ParentException, KidException {
		Kids kids = new Kids(2);
		Kid kid = new Kid("Ezequiel");
		Kid kid2 = new Kid("Antonio");
		kids.add(kid);
		kids.add(kid2);
		Parent parent = new Parent("Joaquin", kids, 1);
		this.parents.add(parent);
	}

	@Test
	public void testAddOk() throws ParentException, KidException {
		this.parents.remove(parent2);
		Kids kids = new Kids(2);
		Kid kid = new Kid("David");
		Kid kid2 = new Kid("Angel");
		kids.add(kid);
		kids.add(kid2);
		Parent parent = new Parent("Federico", kids, 1);
		this.parents.add(parent);
	}
	
	@Test
	public void testGet() {
		assertEquals(parent1, this.parents.get(0));
	}
	
	@Test
	public void testGetLength() {
		assertEquals(3, this.parents.getLength());
	}
	
	@Test
	public void testRemoveAndGetPos() throws ParentException {
		//Cause it is a private method, i cover it launching a method that calls him
		this.parents.remove(parent1);
		assertNull(this.parents.search("Juan"));
	}
	
	@Test(expected = ParentException.class)
	public void testRemoveFail() throws KidException, ParentException {
		Kids kids = new Kids(2);
		Kid kid = new Kid("Juan");
		Kid kid2 = new Kid("Alvaro");
		kids.add(kid);
		kids.add(kid2);
		Parent parent = new Parent("Miguel", kids, 1);
		this.parents.remove(parent);
	}
	
	@Test
	public void testRemoveRide() throws HourException, RideException, DayException {
		Place end = new Place("Palomera");
		Place start = new Place("Casa");
		Day day = new Day(WeekDays.MONDAY, 3);
		Hour startRide = new Hour(17,00);
		Hour endRide = new Hour(17, 59);
		Ride ride = new Ride(start, end, startRide, endRide);
		this.parent2.add(ride, day);
		this.parents.remove(ride, day);
	}
	
	@Test
	public void testSearchOk() {
		assertEquals(parent1, this.parents.search("Juan"));
	}

	@Test
	public void testSearchFail() {
		assertNull(this.parents.search("Francisco"));
	}
	
	@Test
	public void testToString() {
		StringBuilder expected = new StringBuilder();
		expected.append(this.parent1.toString()).append("\n");
		expected.append(this.parent2.toString()).append("\n");
		expected.append(this.parent3.toString()).append("\n");
        assertEquals(expected.toString(), this.parents.toString());
	}

}
