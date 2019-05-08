package es.unileon.prg1.blablakid;


/**
 * @author Pablo Bayon
 *
 */
public class Day {
	
	/**
	 * Number that establish the day of the week
	 */
	private int numday;

	
	/**
	 * @param day
	 * @throws DayException
	 */
	public Day(int numday) throws DayException {
		if(numday>=0 && numday <=4){
			this.numday = numday;
		}else {
			throw new DayException("Invalid day. Day must be between 0 and 6.");
		}
	}
	
	/**
	 * Method that checks if two days are the same
	 * 
	 * @param day
	 * @return true if two days are the same, false if not
	 */
	public boolean isSame(Day day) {
		boolean salida = false;
		if(this.numday==day.numday) {
			salida=true;
		}	
		return salida;
	}

	public int getNumDay() {
		return numday;
	}
	
}
