package es.unileon.prg1.blablakid;
/**
 * @author Pablo Bayon
 *
 */
public class Activity {
	private String name;
	private Place place;
	private Day day;
	private Hour startTime;
	private Hour endTime;
	private Ride beforeRide;
	private Ride afterRide;
	

	
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
		this.startTime = startTime;
		this.endTime = endTime;
	}

	
	public Ride getBeforeRide() {
		return beforeRide;
	}


	public void setBeforeRide(Ride beforeRide) {
		this.beforeRide = beforeRide;
	}


	public Ride getAfterRide() {
		return afterRide;
	}


	public void setAfterRide(Ride afterRide) {
		this.afterRide = afterRide;
	}


	/**
	 * Method that chek if two objects of type Activity are the same
	 * 
	 * @param activity
	 * @return true if the activity is the same, false if not
	 */
	public boolean isSame(Activity activity) {
		boolean salida = false;
		if(this.name==activity.name && this.place==activity.place && this.day==activity.day && this.startTime==activity.startTime && this.endTime==activity.endTime) {
			salida=true;
		}	
		return salida;
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


	public Hour getStartTime() {
		return startTime;
	}


	public Hour getEndTime() {
		return endTime;
	}
	
}
