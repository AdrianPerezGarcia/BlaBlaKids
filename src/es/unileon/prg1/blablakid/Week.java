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
	public boolean remove(Day day) {
		// TODO Auto-generated method stub
		boolean salida = false;
		if(this.isIncluded(day)) {
			int pos = this.inWhichPosIs(day);
			week[pos]=null;
			this.compact(pos);
			this.next--;
		}
		return salida;
	}
	
	/**
	 * Method that compacts the array when an object is removed from it
	 */
	private void compact(int pos) {
		pos++; 
		//Actualizo la posicion para moverme al objeto que esta justo despues del que borro
		//Cuando encuentro null paro, se acabo el array
		while(week[pos] != null) { 
			//Guardo en la posicion anterior la posicion en la que me encuentro, es decir, desplazo todas a la izquierda desde el objeto que borro
			week[(pos-1)] = week[pos];
			pos++;
		}
	}
	
	/**
	 * Method that returns the position of an activity in its array
	 * 
	 * @param activity
	 * @return The position of the object inside the array
	 */
	private int inWhichPosIs(Day day){
		int count = 0;
		boolean end = false;
		while(week[count]!=null && end) {
			if(week[count].isSame(day)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}

	private boolean isIncluded(Day day) {
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

