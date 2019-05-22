package es.unileon.prg1.blablakid;

/**
 * @author Adrian Perez
 *
 */
public class Kids {
    /**
     * Array composed of kids
     */
    public Kid[] kids;
   
    /**
     * Indicator of the first position free on the array
     */
    private int next;
   
   
    /**
     * Constructor of the class, initializes the array and set the next at 0
     * @param numberOfKids
     */
    public Kids(int numberOfKids){
        this.kids = new Kid[numberOfKids];
        this.next = 0;
    }
 
    /**
	 * Getter of the first free position of the array
	 *
	 * @return the number of kids included in the array
	 */
	public int getNumberOfKids() {
	    return this.next;
	}

	/**
     * Getter of the kid at a specific position
     *
     * @param index of the array that you want to get the kid
     *
     * @return the kid at the specific position
     */
    public Kid get(int index) {
        return this.kids[index];
    }
    
 
    /**
	 * Method who return in which position of the array is one Kid
	 *
	 * @param kid who wants to know the position
	 *
	 * @return int that contains the position (0 - length-1)
	 */
	private int getPos(Kid kid){
	    int count = 0;
	    boolean end = false;
	    while( count < this.next && !end) {
	    	if(this.kids[count].isSame(kid)) {
	            end = true;
	        } else {
	        	count ++;
	        }
	    }
	    return count;
	}
	
	/**
	 * Getter of the full length of the array
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
        else if (this.next >= this.kids.length) {
            throw new KidException("Error: kid list is full");
        }
        else {
            kids[this.next] = kid;
            this.next++;
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
            int pos = getPos(kid);
            compact(pos);
            next--;
        }
        else{
            throw new KidException("Error: kid isn't included, so it can't be removed.");
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
        for (int i = 0; i < this.next; i++) {
            if (kids[i].isSame(kid)) {
                result = true;
            }
        }
        return result;
    }
   
    /**
     * Private method to compact the array after deleting a kid
     *
     * @param position of the kid to be deleted
     */
    private void compact(int position) {
        //I use a loop to travel the array until next
        for (int i = position; i < (this.next-1) ; i++ ) {
            //I make the compaction
            kids[i] = kids[i+1];
        }
        //Equals to null the last position of the loop
        kids[this.next - 1]=null;
    }
   
    /**
     * Method to search if there is a kid named like the parameter in the array
     *
     * @param Name to search in the array
     *
     * @return The kid if there is anyone named like the parameter or null
     */
    public Kid search(String Name) {
        int count = 0;
        boolean end = false;
        Kid found =  null;
        //I search in the array for a kid named as the parameter
        while( (count < this.next) && (!end) ) {
            if ( this.kids[count].getName().equals(Name) ){
                //If i found it i set the kid valor to found and i finish the loop
            	found = kids[count];
                end = true;
            }else {
                count++;
            }
        }
       return found;
    }
    
    
    /**
     * Method toString to print the full array of kids as solicited in Show Summary Option
     */
    @Override
    public String toString() {
    	StringBuilder salida = new StringBuilder();
        for (int i = 0; i < this.next; i++) {
			salida.append(this.kids[i].toString()).append("\n");
		}
        return salida.toString();
    }
   
}