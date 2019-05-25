package es.unileon.prg1.blablakid;
 /**
 * 
 * @author Pablo Bayon
 *
 **/

public class Day {

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
	 * Constructor of the method to the parent rides
	 * 
	 * @param day 
	 * 
	 */
	public Day(WeekDays day, int maxRides) {
		this.day = day;
		this.rides = new Rides(3);
	}
	
	/**
	 * 
	 * Constructor of the method to the activities
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
	public void add(Ride ride) throws RideException {
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
	public void remove(Ride ride) throws RideException {
		this.rides.remove(ride);
	}
	
	/**
	 * 
	 * Method that checks if two days are the same
	 * 
	 * @param day
	 * 
	 * @return true if two days are the same, false if not
	 * 
	 */
	public boolean isSame(Day day) {
		boolean salida = false;
		if (this.getNumDay() == day.getNumDay()) { 
			salida = true;
		}
		return salida;
	}
	
	/**
	 * 
	 * Method to get the ordinal of the Day object
	 * 
	 * @return Integer with the ordinal valor
	 * 
	 */
	public int getNumDay() {
		return day.ordinal();
	}
	
	/**
	 * 
	 * Method toString with the name of the Day
	 * 
	 */
	@Override
	public String toString() {
		return this.day.name();
	}
	
}
