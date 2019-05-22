package es.unileon.prg1.blablakid;

/**
 * @author Pablo Bayon
 *
 */
public class Week {

	/**
	 * Array of objects of the type Day
	 */
	private Day[] week;

	/**
	 * Integer used in order to control the next position that is going to be filled
	 * in the array
	 */
	private int next;

	/**
	 * Constant that establish the maximum length of the array
	 */
	private final int MAXDAYS = 5;

	public Week() {
		this.next = 0;
		this.week = new Day[MAXDAYS];
	}

	/**
	 * Method that add an object day to an array of days if it's possible
	 * 
	 * @param day
	 * @throws DayException
	 */
	public void add(Day day) throws DayException {
		if (isIncluded(day)) {
			throw new DayException("Error: Day already included");
		} else {
			week[this.next] = day;
			this.next++;
		}
	}

	/**
	 * Method that removes an object of the array in which it's included
	 * 
	 * @param day
	 * @throws DayException
	 */
	public void remove(Day day) throws DayException {
		if (this.isIncluded(day)) {
			int pos = this.getPos(day);
			this.compact(pos);
			this.next--;
		} else {
			throw new DayException("Error: Activity list is full");
		}
	}

	/**
	 * Method that compacts the array and removes the object in the position of the
	 * param
	 * 
	 * @param pos
	 */
	private void compact(int pos) {
		for (int i = 0; i < (this.next - 1); i++) {
			week[i] = week[i + 1];
		}
		week[this.next - 1] = null;
	}

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

	/**
	 * Method that checks if an object is included in the array
	 * 
	 * @param day
	 * @return true if the object is included in the array, false if not
	 */
	private boolean isIncluded(Day day) {
		boolean salida = false;
		boolean end = false;
		int i = 0;
		while (i < this.next && !end) {
			if (this.week[i].isSame(day)) {
				salida = true;
				end = true;
			}
			i++;
		}
		return salida;
	}

	/**
	 * Method that returns an object day using its position in the array
	 * 
	 * @param pos
	 * @return the kid located in the position specified by the param
	 */
	public Day getDay(int pos) {
		return this.week[pos];
	}

	/**
	 * Method that look for an object Day in an array of days
	 * 
	 * @param numDay
	 * @return a kid is found, null if is not
	 */
	public Day search(int numDay) {
		Day founDay = null;
		boolean end = false;
		int i = 0;
		while ((i < this.next) && (!end)) {
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

