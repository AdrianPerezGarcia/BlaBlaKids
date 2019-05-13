package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	Parent parent;

	@Before
	public void setUp()throws KidException{
		Kids parentKids = new Kids(3);
		Kid Juan = new Kid("Juan");
		Kid Roberto = new Kid("Alberto");
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
	public void testGetKids()throws KidException{
		Kids parentKids2 = new Kids(3);
		Kid Juan2 = new Kid("Juan");
		Kid Roberto2 = new Kid("Roberto");
		Kid Hector2 = new Kid("Hector");
		parentKids2.add(Juan2);
		parentKids2.add(Roberto2);
		parentKids2.add(Hector2);
		assertEquals(parentKids2, this.parent.getKids());
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
	public void testIsSameWrongName()throws KidException{
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
	public void testIsSameWrongKids()throws KidException{
		Kids parentKids2 = new Kids(3);
		Kid Juan2 = new Kid("Juan");
		Kid Roberto2 = new Kid("Robert");
		Kid Hector2 = new Kid("Hector");
		parentKids2.add(Juan2);
		parentKids2.add(Roberto2);
		parentKids2.add(Hector2);
		Parent parent2 = new Parent("Juan",parentKids2, 6);
		assertFalse(this.parent.isSame(parent2));
	}
	
	@Test
	public void testIsSameWrongRides()throws KidException{
		Kids parentKids2 = new Kids(3);
		Kid Juan2 = new Kid("Juan");
		Kid Roberto2 = new Kid("Roberto");
		Kid Hector2 = new Kid("Hector");
		parentKids2.add(Juan2);
		parentKids2.add(Roberto2);
		parentKids2.add(Hector2);
		Parent parent2 = new Parent("Juan",parentKids2, 7);
		assertFalse(this.parent.isSame(parent2));
	}
		
	@Test
	public void testGetDays() {
		Week days = new Week();
		assertEquals(days, this.parent.getDays());
	}
}
