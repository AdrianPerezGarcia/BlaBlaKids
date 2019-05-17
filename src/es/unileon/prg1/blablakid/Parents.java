package es.unileon.prg1.blablakid;

/**
 * @author PabloJ
 *
 */
public class Parents {
	/**
	 * @see Parent[]
	 */
	public Parent[] parents;
	
	/**
	 * @see int 
	 */
	private int next;
	
	
	/**
	 *	Create the array which will be managed by Parents
	 * 
	 * @param number of parents
	 */
	
	public Parents(int numberOfParents) {
		this.parents = new Parent[numberOfParents];
		this.next = 0;
		
	}

	/**
	 * 	This method add a parent to a array of Parents
	 * 
	 * @param parent
	 */
	
	public void add(Parent parent)throws ParentException{
		// TODO Auto-generated method stub
		//If the parent is not included add the parent into the first space that has no parent in it
		if (isIncluded(parent)) {
			throw new ParentException("Error, parent is already included");
		}
		else if (this.next >= this.parents.length) {
			
				//If next is equal or bigger than the size of the array , the list of parents is full
				throw new ParentException("Error, the list of parents is full!");
			
		}
		else {
				this.parents[this.next] = parent;
				this.next++;				
			}
		}	
				
	
	/**
	 * 
	 * Method that removes a parents from the arrays of Parents
	 * 
	 * @param parent
	 * 
	 */
	
	public void remove(Parent parent) throws ParentException{
		//If the parent is included take the position and removes the parent of the array
		if (isIncluded(parent)) {
			//Also compacts the array replacing the next parent
			int position = inWhichPosIs(parent);
			compact(position);
			this.next--;
		}
		else {
			//If parent is not founded, throws an exception
			throw new ParentException("Error, the parent is not in the list");
		}
		// TODO Auto-generated method stub
	}
	
	/**
	 * 
	 * 	Getter of the parent at a specific position
	 * 
	 * @param index
	 * @return Parent in the position of the index 
	 */
	
	public Parent get(int index) {
		return this.parents[index];
	}
	
	public int getLength() {
		return this.parents.length;
	}
	

	/**
	 * 
	 * Method that shows in which position of the array is the parent
	 * 
	 * @param parent
	 * @return int of the position of the array 
	 * 
	 */
	
	private int inWhichPosIs(Parent parent){
		int count = 0;
		boolean end = false;
		while(parents[count]!=null && end) {
			if(parents[count].isSame(parent)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	/**
	 *  Method that returns if the parent is included
	 *  
	 *  @param parent
	 *  @return result
	 *  
	 */
	
	public boolean isIncluded(Parent parent) {
		boolean resultado = false;
		//Check in the loop if the parent is in the array, returning true if the parent is included in the array
		for (int i = 0; i < this.next; i++) {
			if (this.parents[i].isSame(parent)) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * 
	 *  Method that search a parent in the array of parents
	 *  
	 *  @param name 
	 *  @return the parent or null if the parent isn't on the array
	 *  
	 */
	
	public Parent search(String name) {
		int count = 0;
		boolean found = false;
		Parent parentOut = null;
		/*The loop check in all the spaces of the array if the parent is included (through his name) */
		while (count < this.next && !found) {
			if (this.parents[count].getName().equals(name)) {
				found = true;
			}
			else {
				count++;
			}
		}
		/* When the parent has been founded the method return the parent */
		if (count != 0) {
			parentOut = this.parents[count];
		}
		/* If the parent is not founded the method returns null */
		
		return parentOut;
		
	}
	/**
	 * 
	 *  Method that remove and compact
	 *  
	 * @param position
	 */
	private void compact(int position){
		int i;
		//I use a loop to travel the array until next
		for (i = position; i < (this.next-1) ; i++ ){ 
			//I make the compaction
			this.parents[i] = this.parents[i+1];
		}
		//Equals to null the last position of the loop
		this.parents[i+1]=null; 
	
	}
	
	/**
	 * Method toString to print the status of the full array
	 */
	
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		for (int i = 0; i < this.next; i++) {
			salida.append(this.parents[i].toString()).append("\n");
		}
		
		return salida.toString();
	}
	



}

