package es.unileon.prg1.blablakid;
 /**
  * 
  * Class that create an activity that will be managed by Activities  
  * 
  * @author Pablo Bayon
  *
  **/

 import org.apache.logging.log4j.Logger; 
 import org.apache.logging.log4j.LogManager; 

public class Activity {
	
	 static final Logger logger = LogManager.getLogger(Activity.class.getName());
	
	/**
	 * 
	 * Name of the activity
	 * 
	 */
	private String name;

	/**
	 * 
	 * Where the activity takes place
	 * 
	 */
	private Place place;

	/**
	 * 
	 * Day of the activity
	 * 
	 */
	private Day day;

	/**
	 * 
	 * Hour at which the activity starts
	 * 
	 */
	private Hour startTime;

	/**
	 * 
	 * Hour at which the activity ends
	 * 
	 */
	private Hour endTime;

	/**
	 * 
	 * Ride in which the kid arrives to the activity
	 * 
	 */
	private Ride beforeRide;

	/**
	 * 
	 * Ride in which the kid leaves the activity
	 * 
	 */
	private Ride afterRide;

	/**
	 * 
	 * Creates a activity with its name, place, day and times of start and end
	 * 
	 * @param name Activity identifier
	 * 
	 * @param place
	 * 
	 * @param day
	 * 
	 * @param startTime
	 * 
	 * @param endTime
	 * 
	 */
	public Activity(String name, Place place, Day day, Hour startTime, Hour endTime) {
		this.name = name;
		this.place = place;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * 
	 * Getter of the previous ride to the activity
	 * 
	 * @return Ride previous to the activity
	 * 
	 */
	public Ride getBeforeRide() {
		return beforeRide;
	}

	/**
	 * 
	 * Getter of the ride after to the activity
	 * 
	 * @return Ride later the activity
	 * 
	 */
	public Ride getAfterRide() {
		return afterRide;
	}
	
	/**
	 * 
	 * Method that sets a ride as a afterRide, beforeRide or doesn't set it if it's an invalid one
	 * 
	 * @param ride to 

	 * @return true if the ride is valid, false if not
	 * 
	 * @throws RideException if the ride is not valid in its context
	 * 
	 */
	public boolean setRides(Ride ride) throws RideException{
		boolean set = false;
		if(this.place.isSame(ride.getEndPlace())) {
			//If it is an beforeRide, i check the hours to do not be late
			if(this.startTime.isHigher(ride.getEndTime())) {
				this.beforeRide = ride;
				set = true;
			} else {
				throw new RideException("The ride arrives late to the activity.\n");
			}
		} else if(this.place.isSame(ride.getStartPlace())) {
			//If it is an afterRide, i check the hours because it cannot start before the activity end
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
	 * 
	 * Method that checks if two objects of type Activity are the same
	 * 
	 * @param activity2 to compare if it same
	 * 
	 * @return true if the activity is the same, false if not
	 * 
	 */
	public boolean isSame(Activity activity2) {
		boolean salida = false;
		if (this.name.equals(activity2.getName()) && this.place.isSame(activity2.getPlace())
				&& this.day.isSame(activity2.getDay()) && this.startTime.isSame(activity2.getStartTime())
				&& this.endTime.isSame(activity2.getEndTime())) {
			salida = true;
		}
		return salida;
	}

	/**
	 * 
	 * Getter of the activity identifier
	 * 
	 * @return a String with the name of the activity
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Getter of the place when the activity takes place
	 * 
	 * @return a type place object where the activity takes place
	 * 
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * 
	 * Getter of the day when the activity will take place
	 * 
	 * @return a type day object when the activity will take place
	 * 
	 */
	public Day getDay() {
		return day;
	}

	/**
	 * 
	 * Getter of the start time of the activity
	 * 
	 * @return a type hour object with the hour when the activity start
	 * 
	 */
	public Hour getStartTime() {
		return startTime;
	}

	/**
	 * 
	 * Getter of the end time of the activity
	 * 
	 * @return a type hour object with the hour when the activity end
	 * 
	 */
	public Hour getEndTime() {
		return endTime;
	}

	/**
	 * 
	 * toString version according to the show status option in textUI
	 * 
	 */
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
