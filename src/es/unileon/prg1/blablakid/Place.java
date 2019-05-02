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


	@Override
	public String toString() {
		return "Place [" + (place != null ? "place=" + place : "") + "]";
	}
	

}

