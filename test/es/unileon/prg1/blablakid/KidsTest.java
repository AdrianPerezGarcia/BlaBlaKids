package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTest {

	private Kids kids;
	
	@Before
	public void setUp() throws KidException{
		Kid daniel = new Kid("Daniel");
		Kid beatriz = new Kid("Beatriz"); 
		Kid manuel = new Kid("Manuel");
	}
	
	
	@Test
	public void testKid() throws KidException{
		
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
		//kids.remove(daniel);
	}
	
	
}
