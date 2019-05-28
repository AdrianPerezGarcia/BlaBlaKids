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

	public Ride getAfterRide() {
		return afterRide;
	}
	
	/**
	 * Method that sets a ride as a afterRide, beforeRide or doesn't set it if it's an invalid one
	 * 
	 * @param ride
	 * @return true if the ride is valid, false if not
	 * @throws RideException
	 */
	public boolean setRides(Ride ride) throws RideException{
		boolean set = false;
		if(this.place.isSame(ride.getEndPlace())) {
			//Se trata de un beforeRide, por lo que compruebo las horas para no llegar tarde
			if(this.startTime.isHigher(ride.getEndTime())) {
				this.beforeRide = ride;
				set = true;
			} else {
				throw new RideException("The ride arrives late to the activity.\n");
			}
		} else if(this.place.isSame(ride.getStartPlace())) {
			//Se trata de un afterRide, compruebo que no salga antes de que acabe la actividad
			if (this.endTime.isLower(ride.getStartTime())) {
				this.afterRide = ride;
				set = true;
			} else {
				throw new RideException("The ride starts before the end of the activity.\n");
			}
		} else {
			throw new RideException("The ride doesn't match the activity.\n");
		}
		return set;
	}


	/**
	 * Method that checks if two objects of type Activity are the same
	 * 
	 * @param activity
	 * @return true if the activity is the same, false if not
	 */
	public boolean isSame(Activity activity) {
		boolean salida = false;
		if (this.name.equals(activity.getName()) && this.place.isSame(activity.getPlace())
				&& this.day.isSame(activity.getDay()) && this.startTime.isSame(activity.getStartTime())
				&& this.endTime.isSame(activity.getEndTime())) {
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
		out.append(name + " (" + place + " - " + day + ")" + startTime + " > " + endTime + "\n");
		if (beforeRide != null) {
			out.append(this.getBeforeRide().toString());
		} else {
			out.append("No ride before " + name + " assigned\n");
		}
		if (afterRide != null) {
			out.append(this.getAfterRide().toString());
		} else {
			out.append("No ride after " + name + " assigned\n");
		}
		return out.toString();
	}

}
