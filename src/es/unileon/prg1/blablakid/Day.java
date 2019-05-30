package es.unileon.prg1.blablakid;
 

import org.apache.logging.log4j.Logger;


import org.apache.logging.log4j.LogManager; 

/**
 * 
 * Class that creates a day
 * 
 * @author Pablo Bayon
 *
 */
public class Day {

	 static final Logger logger = LogManager.getLogger(Day.class.getName());
	
	/**
	 * 
	 * Number that establish the day of the week
	 * 
	 */
	private WeekDays day;
	
	/**
	 * 
	 * Object that holds the array that the parent has on that day
	 * 
	 */
	private Rides rides;

	/**
	 * 
	 * Constructor of the class to the parent rides
	 * 
	 * @param day 
	 * 
	 */
	public Day(WeekDays day, int maxRides) {
		this.day = day;
		this.rides = new Rides(maxRides);
	}
	
	/**
	 * 
	 * Constructor of the class to the activities
	 * 
	 * @param wDay
	 * 
	 */
	public Day(WeekDays wDay) {
		this.day = wDay;
	}
	

	/**
	 * 
	 * Method to search a Ride in the array
	 * 
	 * @param startPlace of the ride
	 * 
	 * @param endPlace of the ride
	 * 
	 * @return the ride founded or null
	 * 
	 */
	public Ride search(String startPlace, String endPlace) {
		return this.rides.search(startPlace, endPlace);
	}

	/**
	 * 
	 * Method to add a Ride in the Ride Array
	 * 
	 * @param ride that want to be added
	 * 
	 * @throws RideException if the ride cannot be added
	 * 
	 */
	public void add(Ride ride) throws RideException{
		this.rides.addRide(ride);
	}
	
	/**
	 * 
	 * Method to remove a Ride from the Rides Array
	 * 
	 * @param ride to be deleted
	 * 
	 * @throws RideException if the ride cannot be deleted cause it does not exist
	 * 
	 */
	public boolean remove(Ride ride) throws RideException {
		boolean removed = false;
		removed = this.rides.remove(ride);
		return removed;
	}
	
	/**
	 * 
	 * Method that checks if two days are the same
	 * 
	 * @param day2 another day to compare
	 * 
	 * @return true if two days are the same, false if not
	 * 
	 */
	public boolean isSame(Day day2) {
		boolean salida = false;
		if (this.getNumDay() == day2.getNumDay()) { 
			salida = true;
		}
		return salida;
	}
	
	/**
	 * 
	 * Method that removes the int ordinal of the day
	 * 
	 * @return the ordinal value of the day
	 * 
	 */
	public int getNumDay() {
		return day.ordinal();
	}
	
	/**
	 * Method that returns the object String of the name of the day
	 * 
	 * @return the String name of the day
	 */
	public String getNameDay() {
		return day.name();
	}
	
	/**
	 * 
	 * toString version according to the show summary option in textUI
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		if(this.rides.getLength() > 0) {
			out.append(this.day.name()+"\n");
			out.append(this.rides.toString());
		}
		return out.toString();
	}

}
