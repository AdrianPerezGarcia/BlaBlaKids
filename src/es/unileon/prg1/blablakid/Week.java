package es.unileon.prg1.blablakid;
/**
 * 
 * Class that manage an array of five days
 * 
 * @author Pablo Bayon
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	 * Method that add an object day to an array of days if it's possible
	 * 
	 * @param day
	 * @throws DayException
	 */
/*SOBRA
	public void add(Day day) throws DayException {
		if (isIncluded(day)) {
			throw new DayException("Error: Day already included");
		} else {
			week[this.next] = day;
			this.next++;
		}
	}
*/
	
	/**
	 * Method that removes an object of the array in which it's included
	 * 
	 * @param day
	 * @throws DayException
	 */
/*SOBRA
	public void remove(Day day) throws DayException {
		if (this.isIncluded(day)) {
			int pos = this.getPos(day);
			this.compact(pos);
			this.next--;
		} else {
			throw new DayException("Error: Activity list is full");
		}
	}
*/
	
	/**
	 * Method that compacts the array and removes the object in the position of the
	 * param
	 * 
	 * @param pos
	 */

/*SOBRA
	private void compact(int pos) {
		for (int i = 0; i < (this.next - 1); i++) {
			week[i] = week[i + 1];
		}
		week[this.next - 1] = null;
	}
*/
	
/*SOBRA
	private int getPos(Day day) {
		int count = 0;
		boolean end = false;
		while (week[count] != null && end) {
			if (week[count].isSame(day)) {
				end = true;
			} else {
				count++;
			}
		}
		return count;
	}
*/
	
	/**
	 * Method that checks if an object is included in the array
	 * 
	 * @param day
	 * @return true if the object is included in the array, false if not
	 */

/*Sobra
	private boolean isIncluded(Day day) {
		boolean salida = false;
		boolean end = false;
		int i = 0;
		while (i < MAXDAYS && !end) {
			if (this.week[i].isSame(day)) {
				salida = true;
				end = true;
			}
			i++;
		}
		return salida;
	}
/*
 * 
 */
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
}

