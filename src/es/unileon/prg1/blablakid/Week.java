package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Week {
	public Day[] week;
	int next;
	final int size = 7;
	
	public Week() {
		this.next = 0;
		this.week = new Day[size];
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean addDay(Day day) throws DayException{
		// TODO Auto-generated method stub
		boolean salida = true;
		if(isIncluded(day)) {
			salida = false;
			throw new DayException("Error: Day already included");
		}else {
			if(this.next >= this.size) {
				throw new DayException("Error: Day list is full");
			}else {
				week[this.next] = day;
				this.next++;
			}
		}
			return salida;
	}

	
	/**
	 * @return boolean
	 */
	public boolean remove() {
		// TODO Auto-generated method stub
	}

	/**
	 * @return boolean
	 */
	private boolean isDayRight() {
		// TODO Auto-generated method stub
	}
	

	private boolean isIncluded(Day day) {
		// TODO Auto-generated method stub
		boolean salida = false;
		boolean end = false;
		int i=0;
		while(i<this.week.length && end) {
			if(this.week[i].isSame(day)){
				salida = true;
				end = true;
			}
			i++;
		}
		return salida;
	}
}

