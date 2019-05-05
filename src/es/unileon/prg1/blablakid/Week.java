package es.unileon.prg1.blablakid;
/**
 * @author Pablo Bayon
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
	 * Method that add an object day to an array of days if it's possible
	 * 
	 * @param day
	 * @return true if it's possible to add the object, false if not
	 */
	public boolean add(Day day) throws DayException{
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
	 * Method that removes an object of the array in which it's included
	 * 
	 * @param day
	 * @return true if it's possible to remove the object, false if not
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
	 * 
	 * @param pos
	 */
	private void compact(int pos) {
		pos++; 
		// The position is incremented so as to move to the object just behind the one that has been removed
		//When the array finds null the compaction is over
		while(week[pos] != null) { 
			// The objects are moved one position to the left
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

	/**
	 * Method that checks if an object is included in the arraya
	 * 
	 * @param day
	 * @return true if the object is included in the array, false if not
	 */
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
	
	/**
	 * Method that returns an object day using its position in the array
	 * 
	 * @param pos
	 * @return the kid located in the position specified by the param
	 */
	public Day get(int pos) {
		return this.week[pos];
	}
}

