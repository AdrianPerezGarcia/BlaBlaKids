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
	public void testGetKids() throws KidException {
		Kid kid = new Kid("Naiara");
		blablakid.add(kid);
		assertEquals("Naiara", this.blablakid.getKids().get(0).getName());
	}
	
	@Test
	public void testGetParents() throws KidException, ParentException {
		Kids kidsParents = new Kids(2);
		Kid kidParent = new Kid("Adoracion");
		Kid kidParent2 = new Kid("Camino");
		kidsParents.add(kidParent);
		kidsParents.add(kidParent2);
		Parent parent = new Parent("Argimiro", kidsParents, 3);
		blablakid.add(parent);
		assertEquals("Argimiro", blablakid.getParents().get(0).getName());
	}
	
}
 