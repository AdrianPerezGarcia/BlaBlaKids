package es.unileon.prg1.blablakid;

/**
 * @author Pablo Bayon
 *
 */
public class Day {

	/**
	 * Number that establish the day of the week
	 */
	private WeekDays day;
	
	/**
	 * Object that holds the array that the parent has on that day
	 */
	private Rides rides;

	/**
	 * @param day
	 * @throws DayException
	 */
	public Day(WeekDays day) throws DayException {
		/**
		if (day.ordinal() >= 0 && day.ordinal() <= 4) {
			this.day = day;
		} else {
			throw new DayException("Invalid day. Day must be between 0 and 4.");
		}
		**/
		this.day = day;
		this.rides = new Rides(3);
	}

	/**
	 * Method that checks if two days are the same
	 * 
	 * @param day
	 * @return true if two days are the same, false if not
	 */
	public boolean isSame(Day day) {
		boolean salida = false;
		if (this.getNumDay() == day.getNumDay()) { 
			salida = true;
		}
		return salida;
	}

	public int getNumDay() {
		return day.ordinal();
	}
	
	public Rides getRides() {
		return this.rides;
	}

	@Override
	public String toString() {
		return this.day.name();
	}
	
	

}
