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
	private int length;

	/**
	 *Create the array which will be managed by Kids
	 * 
	 * @param number of kids
	 */
	public Kids(int numberOfKids){
		this.kids = new Kid[numberOfKids];
		this.length = numberOfKids;
		next = 0;
	}

	/**  
	 * @param nombre
	 * @return Kid
	 */
	public void add(Kid kid) throws KidException{
		if( isKidIncluded(kid.getName()) ){
			throw new KidException("Error: kid already included");
		}
		else{
			if (this.next >= this.length) {
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
	public void removeKid(Kid kid) throws KidException{
		if( isKidIncluded(kid.getName()) ){
			int pos = inWhichPosIs(kid.getName());
			kids[pos] = null;
			pos++;
			while (kids[pos] != null) {
				kids[(pos -1)] = kids [pos];
			}
			next--;
		}
		else{
			throw new KidException("Error: kid wasn't included");
		}
	}

	/**
	 * @return boolean
	 */
	public boolean isKidIncluded(String nombre){
		return false;
		// TODO Auto-generated method stub
	}
	
	private int inWhichPosIs(String Nombre){
		int count = 0;
		while(kids[count]!=null) {
			
		}
		return count;
	}
	
	public Kid get(int index) {
		index--;
		return this.kids[index];
	}
	
	public int getLenght() {
		return this.length;
	}
	
	public int getSize() {
		return this.kids.length;
	}
	
	public Kid search(String Name) {
		int count = 0;
		while (kids[count]!=null || count!=-1){
			if ( kids[count].getName().equals(Name) ){
				count = -1;
			}
			else {
				count++;
			}
		}
		return kids[count];
	}

}

