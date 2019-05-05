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
	
	public void addParent(Parent parent, Kids kids)throws ParentException{
		// TODO Auto-generated method stub
	}
	
	/**
	 * @return boolean
	 * @param parent
	 */
	public boolean removeParent(Parent parent) {
		return false;
		// TODO Auto-generated method stub
	}	

	/**
	 * @return boolean
	 * @par
	 */
	private boolean isIncluded(String name) {
		boolean result =  false;
		
		return result;
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
	 * @param parent
	 * @return
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


}

