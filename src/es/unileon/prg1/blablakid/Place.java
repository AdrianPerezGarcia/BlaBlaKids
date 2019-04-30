package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Place {
	/**
	 * 
	 */
	private String place;

	public Place(String place) {
		this.place = place;
	}


	public String getPlace() {
		return place;
	}


	@Override
	public String toString() {
		return "Place [" + (place != null ? "place=" + place : "") + "]";
	}
	

}

