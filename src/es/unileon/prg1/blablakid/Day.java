package es.unileon.prg1.blablakid;


/**
 * @author Pablo Bayon
 *
 */
public class Day {
	public int numday;

	
	/**
	 * @param day
	 * @throws DateException
	 */
	public Day(int numday) throws DayException {
		if(numday>=0 && numday <=6){
			this.numday = numday;
		}else {
			throw new DayException("Invalid day. Day must be between 0 and 6.");
		}
	}
	
	
	public boolean isSame(Day day) {
		boolean salida = false;
		if(this.numday==day.numday) {
			salida=true;
		}	
		return salida;
	}

	public int getDay() {
		return numday;
	}
	
}
