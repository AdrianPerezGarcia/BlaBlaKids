package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaceTest{
	Place place;

	@Before
	public void setUp(){
		this.place = new Place("Palomera");
	}

	@Test
	public void testPlace(){
		assertEquals("Palomera", place.getPlace());
	}
	
	@Test
	public void testIsSame(){
		Place place2 = new Place("Palomera");
		assertTrue(place.isSame(place2));
	}
	
	@Test
	public void testIsSameWrong(){
		Place place2 = new Place("Crucero");
		assertFalse(place.isSame(place2));
	}
	
	@Test
	public void testToString(){
		assertEquals("Palomera", place.toString());
	}
}
