package es.unileon.prg1.blablakid;

import java.util.Arrays;
/**
 * @author Adrian Perez
 *
 */
public class Kids {
	/**
	 * Array composed of kids
	 * 
	 * @see Kid[]
	 */
	public Kid[] kids;
	
	/**
	 * Indicator of the first position free int the array
	 * 
	 * @see int
	 */
	private int next;
	
	/**
	 * Total size of the array
	 * 
	 * @see size
	 */
	private int size;

	/**
	 * Constructor of the class, initializes the array and set the next at 0 and the size at the param numberOfKids
	 * 
	 * @param numberOfKids
	 */
	public Kids(int numberOfKids){
		this.kids = new Kid[numberOfKids];
		this.size = numberOfKids;
		next = 0;
	}

	/**
	 * Getter of the kid at a specific position
	 * 
	 * @param position of the array that you want to get the kid
	 * 
	 * @return the kid at the specific position
	 */
	public Kid get(int index) {
		return this.kids[index];
	}

	/**
	 * Getter of the full size of the array
	 * 
	 * @return the size (Max number of kids)
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Getter of the length
	 * 
	 * @return the length of the array
	 */
	public int getLength() {
		return this.kids.length;
	}

	/**
	 * Method to add a kid from the array
	 * 
	 * @param kid to add
	 * 
	 * @throws KidException if the kid was also included or if the array is full
	 * 
	 */
	public void add(Kid kid) throws KidException{
		if( isIncluded(kid) ){
			throw new KidException("Error: kid already included");
		}
		else{
			if (this.next >= this.size) {
				throw new KidException("Error: kid list is full");
			}
			else {
				kids[this.next] = kid;
				this.next++;
			}
		}
	}

	/**
	 * Method to remove a kid from the array
	 * 
	 * @param kid to remove
	 * 
	 * @throws KidException if the kid wasn't included in the array
	 * 
	 */
	public void remove(Kid kid) throws KidException{
		if( isIncluded(kid) ){
			int pos = inWhichPosIs(kid);
			removeAndCompact(pos);
			next--;
		}
		else{
			throw new KidException("Error: kid wasn't included");
		}
	}

	/**
	 * Method to check if a kid is included in the array
	 * 
	 * @param kid to search
	 * 
	 * @return boolean who change its status if the kid is included or not
	 */
	public boolean isIncluded(Kid kid){
		boolean result = false;
		for (int i = 0; i < kids.length; i++) {
			if (kids[i].isSame(kid)) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Method who return in which position of the array is one Kid
	 * 
	 * @param kid who wants to know the position
	 * 
	 * @return int that contains the position
	 */
	private int inWhichPosIs(Kid kid){
		int count = 0;
		boolean end = false;
		while(this.kids[count]!=null && !end) {
			if(this.kids[count].isSame(kid)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Private method to compact the array after deleting a kid
	 * 
	 * @param position of the deleted kid
	 */
	private void removeAndCompact(int position) {
		int i;
		//I use a loop to travel the array until next
		for (i = position; i < (this.next-1) ; i++ ) { 
			//I make the compaction
			kids[i] = kids[i+1];
		}
		//Equals to null the last position of the loop
		kids[i+1]=null; 
	}
	
	/**
	 * Method to search if there is a kid named like the param in the array
	 * 
	 * @param Name to search in the array
	 * 
	 * @return The kid if there is anyone named like the param or null
	 */
	public Kid searchKid(String Name) {
		int count = 0;
		boolean end = false;
		//I search in the array for a kid named as the param
		while (count < kids.length  && !end) {
			if ( this.kids[count].getName().equals(Name) ){
				//If i found it i set a mark (count) in that spot and i finish with the boolean end
				end = true;
			}
			else {
				count++;
			}
		}
		//If end is different than the original value there is a kid named like the param in position count
		if (end) {
			return kids[count];
		}
		else {
			return null;
		}
	}

	/**
	 * Method toString to print the status of the full array
	 */
	@Override
	public String toString() {
		return "Kids [kids=" + Arrays.toString(kids) + "]";
	}
	
	

}

