package es.unileon.prg1.blablakid;

/**
 * @author Pablo Bayon
 *
 */
public class Activity {

	/**
	 * Name of the activity
	 */
	private String name;

	/**
	 * Where the activity takes place
	 */
	private Place place;

	/**
	 * Day of the activity
	 */
	private Day day;

	/**
	 * Hour at which the activity starts
	 */
	private Hour startTime;

	/**
	 * Hour at which the activity ends
	 */
	private Hour endTime;

	/**
	 * Ride in which the kid arrives to the activity
	 */
	private Ride beforeRide;

	/**
	 * Ride in which the kid leaves the activity
	 */
	private Ride afterRide;

	/**
	 * Constructor que recibe como parametros el nombre de la actividad, el lugar,
	 * el dia, ninyo, y la hora a la que empieza y acaba la actividad
	 * 
	 * @param name
	 * @param place
	 * @param day
	 * @param kid
	 * @param startTime
	 * @param endTime
	 */
	public Activity(String name, Place place, Day day, Hour startTime, Hour endTime) {
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
	 * Method that checks if two objects of type Activity are the same
	 * 
	 * @param activity
	 * @return true if the activity is the same, false if not
	 */
	public boolean isSame(Activity activity) {
		boolean salida = false;
		if (this.name.equals(activity.getName()) && this.place.isSame(activity.getPlace()) && this.day.isSame(activity.getDay()) 
				&& this.startTime.isSame(activity.getStartTime())  && this.endTime.isSame(activity.getEndTime())) {
			salida = true;
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

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(name + " (" + place + " - " + day + ")" + startTime + " > " + endTime+"\n");
		if(beforeRide!=null) {
			out.append(beforeRide.getStartPlace() + " > " + beforeRide.getEndPlace() + " : " + beforeRide.getStartTime() + "/" + beforeRide.getEndTime() + "\n");
		}else {
			out.append("No ride before "+name+" assigned\n");
		}
		if(afterRide!=null) {
			out.append(afterRide.getStartPlace() + " > " + afterRide.getEndPlace() + " : " + afterRide.getStartTime()+ "/" + beforeRide.getEndTime() + "\n");
		}else {
			out.append("No ride after "+name+" assigned\n");
		}
		return out.toString();
	}

}
