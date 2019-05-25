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
		Kid Juan = new Kid("Beatriz");
		Kid Roberto = new Kid("Daniel");
		Kid Hector = new Kid("Manuel");
		parentKids.add(Juan);
		parentKids.add(Roberto);
		parentKids.add(Hector);
		this.parent = new Parent("Pedro", parentKids, 6);
	}

	@Test
	public void testGetName(){
		assertEquals("Pedro", parent.getName());
	}
	
	@Test
	public void testGetRides(){
		assertEquals(6, parent.getNumRides());
	}
	
	@Test
	public void testSearchKids() {
		assertEquals("Beatriz", this.parent.search("Beatriz").getName());
	}
	
	@Test
	public void testSearchKidsWrong() {
		assertNull(this.parent.search("Rodolfo"));
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
		Parent parent2 = new Parent("Pedro", parentKids2, 6);
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
	
	/**
	@Test
	public void testSearchDays() {
		assertEquals(3,this.parent.search(Day ).getDay(2).search());
	}
	**/
	
	@Test
	public void testSearchDaysWrong() {
		
	}
}
