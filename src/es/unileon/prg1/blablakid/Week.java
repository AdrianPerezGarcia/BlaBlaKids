package es.unileon.prg1.blablakid;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Class that manage an array of five days
 * 
 * @author Pablo Bayon
 *
 */

public class Week {
	
	 static final Logger logger = LogManager.getLogger(Week.class.getName());

	/**
	 * 
	 * Array of objects of the type Day
	 * 
	 */
	private Day[] week;

	/**
	 * 
	 * Integer used in order to control the next position that is going to be filled in the array
	 * 
	 */
	private int next;

	/**
	 * 
	 * Constant that establish the maximum length of the array
	 * 
	 */
	private final int MAXDAYS = 5;

	/**
	 * 
	 * Constructor of the class that initialize all the days
	 * 
	 * @param maxRides that a parent can do per day
	 * 
	 */
	public Week(int maxRides) {
		this.week = new Day[MAXDAYS];
		this.week[0] = new Day(WeekDays.MONDAY, maxRides);
		this.week[1] = new Day(WeekDays.TUESDAY, maxRides);
		this.week[2] = new Day(WeekDays.WEDNESDAY, maxRides);
		this.week[3] = new Day(WeekDays.THURSDAY, maxRides);
		this.week[4] = new Day(WeekDays.FRIDAY, maxRides);
	}

	/**
	 * 
	 * Method that returns an object day using its position in the array
	 * 
	 * @param pos of the day wanted
	 * 
	 * @return the day located in the position specified by the parameter
	 * 
	 */
	public Day getDay(int pos) {
		return this.week[pos];
	}

	/**
	 * 
	 * Method that look for an object Day in an the array
	 * 
	 * @param numDay
	 * 
	 * @return a kid is found, null if is not
	 * 
	 */
	public Day search(int numDay) {
		Day founDay = null;
		boolean end = false;
		int i = 0;
		while ((i < this.MAXDAYS) && (!end)) {
			if (week[i].getNumDay() == numDay) {
				end = true;
				founDay = week[i];
			} else {
				i++;
			}
		}
		return founDay;
	}
	
	/**
	 * 
	 * Method that removes a Ride from a Day in the array 
	 * 
	 * @param ride
	 * @param numDay
	 * @return
	 * @throws RideException
	 */
	public boolean remove(Ride ride, Day numDay) throws RideException{
		boolean removed = false;
		removed = this.week[numDay.getNumDay()].remove(ride);
		return removed;
	}
	 /**
	  * 
	  * Method toString of Week
	  * 
	  * 
	  */
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		for(int i = 0; i < MAXDAYS; i++) {
			out.append(this.week[i].toString());
		}
		
		return out.toString();
	}
}

