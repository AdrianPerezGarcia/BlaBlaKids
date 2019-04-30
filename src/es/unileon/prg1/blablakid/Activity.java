package es.unileon.prg1.blablakid;
/**
 * @author Pablo Bayon
 *
 */
public class Activity {
	public String name;
	public Place place;
	public Day day;
	public Kid kid;
	public Hour startTime;
	public Hour endTime;

	
	/**
	 * Constructor que recibe como parametros el nombre de la actividad, el lugar, el dia, ninyo, y la hora a la que empieza y acaba la actividad
	 * 
	 * @param name
	 * @param place
	 * @param day
	 * @param kid
	 * @param startTime
	 * @param endTime
	 */
	public Activity(String name, Place place, Day day, Kid kid, Hour startTime, Hour endTime) {
		this.name = name;
		this.place = place;
		this.day = day;
		this.kid = kid;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	
	public String getName() {
		return name;
	}


	public Place getPlace() {
		return place;
	}


	public Day getDay() {
		return day;
	}


	public Kid getKid() {
		return kid;
	}


	public Hour getStartTime() {
		return startTime;
	}


	public Hour getEndTime() {
		return endTime;
	}
	
}

