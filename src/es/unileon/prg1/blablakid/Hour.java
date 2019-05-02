package es.unileon.prg1.blablakid;
/**
 * @author Adrian Perez
 *
 */
public class Hour {
	/**
	 * hours of the Hour
	 * 
	 * @see int
	 */
	public int hour;
	
	/**
	 * minutes of the Hour
	 * 
	 * @see int
	 */
	public int minute;

	/**
	*Creates the hour with it hours and minutes
	*
	*@param minutes of the Hour
	*@param hours of the Hour
	*
	*@throws HourException if the hour can´t be created with the params
	*
	**/
	public Hour(int minute, int hour) throws HourException{
		//I throw exception if the time is not valid
		if ((hour < 0) || (hour > 24)) {
			throw new HourException("Invalid hour (" +hour+ "). Hour must be in a 0-23 range.");
		}
		else {
			hour = this.hour;
		}
        //I also check the minutes to generate a correct time
		if ((minute < 0) || (minute > 59)) {
			throw new HourException("Invalid minute (" +minute+ ").Minute must be in a 0-59 range.");
		}
		else {
			minute = this.minute;
		}
	}
	
	/**
	 * 
	 * @return hours of the Hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * 
	 * @return minutes of the Hour
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * 
	 * @param Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isHigher(Hour hour2){
		boolean result = false;
		if(this.hour > hour2.getHour()) {
			result = true;
		}
		if (this.hour == hour2.getHour()) {
			if (this.minute > hour2.getMinute()) {
				result = true;
			}	
		}
		return result;
	}
	
	/**
	 * 
	 * @param Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isSame(Hour hour2) {
		boolean result = false;
		if ((this.hour == hour2.getHour()) && (this.minute == hour2.getMinute())) {
			result = true;
		}
		return result;
	}
	
	/**
	 * 
	 * @param Another hour to compare
	 * 
	 * @return Boolean that returns true if the method name is true
	 */
	public boolean isLower(Hour hour2){
		boolean result = false;
		if(this.hour < hour2.getHour()) {
			result = true;
		}
		if (this.hour == hour2.getHour()) {
			if (this.minute < hour2.getMinute()) {
				result = true;
			}	
		}
		return result;
	}

	/**
	 * 
	 * @return Hour version in the classic format
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.hour).append(":").append(this.minute);
		return result.toString();
	}
	
	
}

	

