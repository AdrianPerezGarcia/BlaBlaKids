package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Week {
	public Day[] week;
	int next;
	final int tam = 7;
	
	public Week() {
		this.next = 0;
		this.week = new Day[tam];
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean addDay(Day day) {
		// TODO Auto-generated method stub
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

