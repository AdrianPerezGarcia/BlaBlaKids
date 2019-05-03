package es.unileon.prg1.blablakid;
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
	private int next;
	private int size;

	/**
	 *Create the array which will be managed by Kids
	 * 
	 * @param number of kids
	 */
	public Kids(int numberOfKids){
		this.kids = new Kid[numberOfKids];
		this.size = numberOfKids;
		next = 0;
	}

	/**  
	 * @param nombre
	 * @return Kid
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
	 * @return void
	 */
	public void remove(Kid kid) throws KidException{
		if( isIncluded(kid) ){
			int pos = inWhichPosIs(kid);
			kids[pos] = null;
			pos++;
			while (kids[pos] != null) {
				kids[(pos -1)] = kids [pos];
				pos++;
			}
			kids[pos-1]=null;
			next--;
		}
		else{
			throw new KidException("Error: kid wasn't included");
		}
	}

	/**
	 * @return boolean
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
	
	private int inWhichPosIs(Kid kid){
		int count = 0, end = 0;
		while(kids[count]!=null && end!=1) {
			if(kids[count].isSame(kid)) {
				end = 1;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	public Kid get(int index) {
		index--;
		return this.kids[index];
	}
	
	public int getLenght() {
		return this.size;
	}
	
	public int getSize() {
		return this.kids.length;
	}
	
	public Kid searchKid(String Name) {
		int count = 0;
		//I search in the array for a kid named like the param
		for (int i = 0; i < kids.length; i++) {
			if ( kids[i].getName().equals(Name) ){
				//If i found it i set a mark (count) in that spot
				count = i;
				i = kids.length - 1;
			}
		}
		//If count is different than the original valor there is a kid named like the param in position count
		if (count != 0) {
			return kids[count];
		}
		else {
			return null;
		}
	}

}

