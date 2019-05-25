package es.unileon.prg1.blablakid;
 /**
 * 
 * Class to manage the Hour of the rides or activities
 * 
 * @author Adrian Perez
 *
 **/

public class Hour {
	/**
	 * Hours of the Hour
	 */
	public int hours;

	/**
	 * Minutes of the Hour
	 */
	public int minutes;

	/**
	 * Creates the hour with it hours and minutes
	 *
	 * @param hour   representing minutes of the Hour
	 * @param minute representing hours of the Hour
	 *
	 * @throws HourException if the hour or the minutes is not correct
	 *
	 **/
	public Hour(int hours, int minute) throws HourException {
		StringBuilder out = new StringBuilder();
		// I throw exception if the time is not valid
		if ((hours < 0) || (hours > 24)) {
			out.append("Invalid hour (").append(hours).append("). Hour must be in a 0-23 range.\n");
		}
		if ((minute < 0) || (minute > 59)) {
			out.append("Invalid minute (").append(minute).append("). Hour must be in a 0-59 range.\n");
		}

		if (out.length() > 0) {
			throw new HourException(out.toString());
		} else {
			this.hours = hours;
			this.minutes = minute;
		}
	}

	/**
	 * Getter of the hour valor
	 * 
	 * @return hours of the Hour
	 */
	public int getHour() {
		return hours;
	}

	/**
	 * Getter of the minute valor
	 * 
	 * @return minutes of the Hour
	 */
	public int getMinute() {
		return minutes;
	}

	/**
	 * Method to check is one hour is higher than other
	 * 
	 * @param hour2 Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isHigher(Hour hour2) {
		boolean result = false;
		if (this.hours > hour2.getHour()) {
			result = true;
		}
		if (this.hours == hour2.getHour()) {
			if (this.minutes > hour2.getMinute()) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Method to check if two hours are equals
	 * 
	 * @param hour2 Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isSame(Hour hour2) {
		boolean result = false;
		if ((this.hours == hour2.getHour()) && (this.minutes == hour2.getMinute())) {
			result = true;
		}
		return result;
	}

	/**
	 * Method to check if one hour is lower than other
	 * 
	 * @param hour2 Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isLower(Hour hour2) {
		boolean result = false;
		if (this.hours < hour2.getHour()) {
			result = true;
		}
		if (this.hours == hour2.getHour()) {
			if (this.minutes < hour2.getMinute()) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Method who returns the classic version of an hour (hour:minutes)
	 * 
	 * @return Hour version in the classic format
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%02d", this.hours)).append(":").append(String.format("%02d", this.minutes));
		return result.toString();
	}

}

	

