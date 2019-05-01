package es.unileon.prg1.blablakid;
/**
 * @author Adrian Perez
 *
 */
public class Hour {
	public int hour;
	public int minute;

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
	
	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

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
	
	public boolean isSame(Hour hour2) {
		boolean result = false;
		if ((this.hour == hour2.getHour()) && (this.minute == hour2.getMinute())) {
			result = true;
		}
		return result;
	}
	
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

	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.hour).append(":").append(this.minute);
		return result.toString();
	}
	
	
}

	

