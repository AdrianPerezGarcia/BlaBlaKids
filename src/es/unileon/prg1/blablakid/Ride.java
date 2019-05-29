package es.unileon.prg1.blablakid;
/**
 * 
 * Class that creates a ride for an activity
 * 
 * @author Hector Castro
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ride {
	
	 static final Logger logger = LogManager.getLogger(Ride.class.getName());

	private Place startPlace;
	private Place endPlace;
	private Hour startTime;
	private Hour endTime;

	/**
	 * 
	 * @param startPlace
	 * @param endPlace
	 * @param startTime
	 * @param endTime
	 * @throws RideException
	 */
	public Ride(Place startPlace, Place endPlace, Hour startTime, Hour endTime) throws RideException {
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Method that returns the start place of the ride as a Place object
	 * 
	 * @return start place of the ride as a Place object
	 */
	public Place getStartPlace() {
		return startPlace;
	}

	/**
	 * Method that returns the start place of the ride as a Place object
	 * 
	 * @return end place of the ride as a Place object
	 */
	public Place getEndPlace() {
		return endPlace;
	}

	/**
	 * Method that returns the start hour of the ride as a Hour object
	 * 
	 * @return start hour of the ride as a Hour object
	 */
	public Hour getStartTime() {
		return startTime;
	}

	/**
	 * Method that returns the end hour of the ride as a Hour object
	 * 
	 * @return end hour of the ride as a Hour object
	 */
	public Hour getEndTime() {
		return endTime;
	}

	/**
	 * Method to compare two rides
	 * 
	 * @return true if their are the same, false if not.
	 */
	public boolean isSame(Ride ride) {
		boolean same = false;
		if (this.startPlace.getPlace().equals(ride.getStartPlace().getPlace())
				&& this.endPlace.getPlace().equals(ride.getEndPlace().getPlace())
				&& this.startTime.isSame(ride.getStartTime()) && this.endTime.isSame(ride.getEndTime())) {
			same = true;
		}
		return same;
	}

	/**
	 * Returns a summary of all the info of the Ride as text
	 */
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(startPlace + " > " + endPlace + " : " + this.getStartTime().toString() + "/"
				+ this.getEndTime().toString() + "\n");
		return out.toString();
	}
}
