package es.unileon.prg1.blablakid;
/**
 * 
 * Class that creates a place 
 * 
 * @author PabloJ
 *
 */

public class Place {
	/**
	 * 
	 * Name of the place 
	 * 
	 */
	private String place;
	
	/**
	 * 
	 * Constructor of the class with its place as identifier
	 * 
	 * @param place name of the place
	 * 
	 */
	public Place(String place) {
		this.place = place;
	}

	/**
	 * 
	 * Getter of the place
	 * 
	 * @return its identifier
	 * 
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * 
	 * Method isSame to compare if two places are the same place
	 * 
	 * @param place2 to compare
	 * 
	 * @return Boolean true if the place are equals and false if not
	 * 
	 */
	public boolean isSame(Place place2){ 
		return (this.place.equals(place2.getPlace()));
	}

	/**
	 * 
	 * Method toString to print the place as required in other methods
	 * 
	 */
	@Override
	public String toString() {
		return "Place: "+ this.place;
	}
	

}

