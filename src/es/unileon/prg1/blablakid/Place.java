package es.unileon.prg1.blablakid;
/**
 * Class that creates a place 
 * @author PabloJ
 *
 */
public class Place {
	/**
	 * Name of the place 
	 */
	private String place;
	/**
	 * Builder
	 * @param place   name of the place
	 */
	public Place(String place) {
		this.place = place;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	
	public boolean isSame(Place place2){ 
		return (this.place.equals(place2.getPlace()));
	}

	@Override
	public String toString() {
		return "Place: "+ this.place;
	}
	

}

