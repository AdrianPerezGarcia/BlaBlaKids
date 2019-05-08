package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTest {

	private Kids kids;
	private Kid daniel;
	private Kid beatriz;
	private Kid manuel;
	
	@Before
	public void setUp() throws KidException{
		daniel = new Kid("Daniel");
		kids = new Kids(3);
		this.kids.add(daniel);
		beatriz = new Kid("Beatriz");
		this.kids.add(beatriz);
		manuel = new Kid("Manuel");
		this.kids.add(manuel);
	}
	
	
	@Test
	public void testKids() throws KidException{
		
	}
	
	@Test (expected = KidException.class)
	public void testAddInluded() throws KidException{
		Kid kid = new Kid("Daniel");
		kids.add(kid);
	}
	
	@Test (expected = KidException.class)
	public void testAddFull() throws KidException{
		Kid kid = new Kid("Pablo");
		kids.add(kid);
	}
	
	@Test 
	public void testAddOk() throws KidException{
		assertEquals(3,this.kids.getLength());
		kids.remove(daniel);
		assertEquals(2,this.kids.getLength());
		Kid pablo = new Kid("Pablo");
		this.kids.add(pablo);
		assertEquals(3,this.kids.getLength());
	}
	
	
}
