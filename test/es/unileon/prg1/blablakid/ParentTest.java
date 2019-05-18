package es.unileon.prg1.blablakid;

/**
 * @author Adrian Perez
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	
	private Parent parent;

	@Before
	public void setUp()throws KidException{
		Kids parentKids = new Kids(3);
		Kid Juan = new Kid("Juan");
		Kid Roberto = new Kid("Roberto");
		Kid Hector = new Kid("Hector");
		parentKids.add(Juan);
		parentKids.add(Roberto);
		parentKids.add(Hector);
		this.parent = new Parent("Juan", parentKids, 6);
	}

	@Test
	public void testGetName(){
		assertEquals("Juan", parent.getName());
	}
	
	@Test
	public void testGetRides(){
		assertEquals(6, parent.getRides());
	}
	
	@Test
	public void testGetKids() {
		assertEquals("Roberto", this.parent.getKids().get(1).getName());
	}
	
	@Test
	public void testIsSame()throws KidException{
		Kids parentKids2 = new Kids(3);
		Kid Juan2 = new Kid("Juan");
		Kid Roberto2 = new Kid("Roberto");
		Kid Hector2 = new Kid("Hector");
		parentKids2.add(Juan2);
		parentKids2.add(Roberto2);
		parentKids2.add(Hector2);
		Parent parent2 = new Parent("Juan", parentKids2, 6);
		assertTrue(this.parent.isSame(parent2));
	}
	
	@Test
	public void testIsSameWrong()throws KidException{
		Kids parentKids2 = new Kids(3);
		Kid Juan2 = new Kid("Juan");
		Kid Roberto2 = new Kid("Roberto");
		Kid Hector2 = new Kid("Hector");
		parentKids2.add(Juan2);
		parentKids2.add(Roberto2);
		parentKids2.add(Hector2);
		Parent parent2 = new Parent("Alvaro",parentKids2, 6);
		assertFalse(this.parent.isSame(parent2));
	}
	
	@Test
	public void testGetDays() {
		assertNull(this.parent.getDays().getDay(2));
	}
}
