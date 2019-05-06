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
	 * @see int  Size of the array
	 */
	private int size;
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
		this.size = numberOfParents;
		next = 0;
		
	}

	/**
	 * This method return if the parent can be added to the array
	 * 
	 * @return boolean
	 * @param parent
	 */
	
	public boolean addParent(Parent parent)throws ParentException{
		// TODO Auto-generated method stub
		boolean added = false;
		if (isIncluded(parent)) {
			throw new ParentException("Error, parent is already included");
		}
		else {
			if (this.next >= this.size) {
				throw new ParentException("Error, the list of parents is full!");
			}
			else {
				this.parents[this.next] = parent;
				this.next++;
				added = true;
			}
		}		
		return added;
	}
	
	/**
	 * @return boolean
	 * @param parent
	 */
	public boolean removeParent(Parent parent) throws ParentException{
		boolean removed = false;
		
		if (isIncluded(parent)) {
			
			int position = inWhichPosIs(parent);
			parents[position] = null;
			position++;
			
			while (parents[position] != null) {
				parents[(position -1)] = parents [position];
				position++;
			}
			parents[position-1]=null;
			next--;
		}
		else {
			throw new ParentException("Error, the parent is not in the list");
		}
		return removed;
		// TODO Auto-generated method stub
	}

	/**
	 * @return the length
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * @return the size
	 */
	public int getLength() {		
		return parents.length;
	}
	
	/**
	 * @return the next
	 */
	public int getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param index
	 * @return Parent in the position of the index 
	 */
	public Parent get(int index) {
		return this.parents[index];
	}
	
	/**
	 * 
	 * Method that shows in which position of the array is the parent
	 * 
	 * @param parent
	 * @return the position of the array 
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
		
		for (int i = 0; i < this.parents.length; i++) {
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
	
	public Parent searchParent(String name) {
		int count = 0;
		boolean found = false;
		
		while (count < this.parents.length && !found) {
			if (this.parents[count].getName().equals(name)) {
				found = true;
			}
			else {
				count++;
			}
		}
		
		if (found == true) {
			return this.parents[count];
		}
		else {
			return null;
		}
		
	}


}

