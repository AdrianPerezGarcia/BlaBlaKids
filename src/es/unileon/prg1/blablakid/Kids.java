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
	private int next;
	private int size;


	public Kids(int numberOfKids){
		this.kids = new Kid[numberOfKids];
		this.size = numberOfKids;
		next = 0;
	}


	public Kid get(int index) {
		return this.kids[index];
	}


	public int getLenght() {
		return this.size;
	}


	public int getSize() {
		return this.kids.length;
	}


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
		int count = 0;
		boolean end = false;
		while(kids[count]!=null && end) {
			if(kids[count].isSame(kid)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	public Kid searchKid(String Name) {
		int count = 0;
		boolean end = false;
		//I search in the array for a kid named like the param
		while (count < kids.length  && end) {
			if ( kids[count].getName().equals(Name) ){
				//If i found it i set a mark (count) in that spot and i finish with the boolean end
				end = true;
			}
			else {
				count++;
			}
		}
		//If end is different than the original valor there is a kid named like the param in position count
		if (end) {
			return kids[count];
		}
		else {
			return null;
		}
	}


	@Override
	public String toString() {
		return "Kids [kids=" + Arrays.toString(kids) + "]";
	}
	
	

}

