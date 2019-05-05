package es.unileon.prg1.blablakid;
/**
 * @author PabloJ
 *
 */
public class Parents {
	public Parent[] parents;
	private int size;
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
	public int getLength() {
		return size;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {		
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
	 * @param kid
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


}

