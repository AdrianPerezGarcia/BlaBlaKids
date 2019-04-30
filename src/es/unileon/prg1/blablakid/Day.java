package es.unileon.prg1.blablakid;


/**
 * @author
 *
 */
public class Day {
	public int day;

	
	/**
	 * @param day
	 * @throws DateException
	 */
	public Day(int day) throws DayException {
		if(day>=0 && day <=6){
			this.day = day;
		}else {
			throw new DayException("Dia no valido. El dia debe estar comprendido entre 0 y 6.");
		}
	}


	public int getDay() {
		return day;
	}
	
	
}

