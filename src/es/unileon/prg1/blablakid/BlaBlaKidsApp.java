package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class BlaBlaKidsApp {
	
	/**
	 * 
	 */
	private int numberOfKids;
	/**
	 * 
	 * Number of parents in BlablakidsApp
	 * @see int 
	 * 
	 */
	private int numberOfParents;
	
	/**
	 * 
	 *	Array of kids in BlaBlaKidsApp
	 *	@see Kids
	 *
	 */
	private Kids kids;
	
	/**
	 * 
	 *	 Array of parents in BlaBlaKidsApp
	 * 	 @see Parents
	 * 
	 */
	private Parents parents;
	
	public BlaBlaKidsApp(int numberKids){
		
		this.numberOfKids = numberKids;
		this.numberOfParents = numberKids * 2;
		this.kids = new Kids(this.numberOfKids);
		this.parents = new Parents(this.numberOfParents);
		
		
	}

	/**
	 * @return the numberOfKids
	 */
	public int getNumberOfKids() {
		return numberOfKids;
	}

	/**
	 * @return the numberOfParents
	 */
	public int getNumberOfParents() {
		return numberOfParents;
	}

	/**
	 * @return the kids
	 */
	public Kids getKids() {
		return kids;
	}

	/**
	 * @return the parents
	 */
	public Parents getParents() {
		return parents;
	}

	public void add(Parent parent) throws ParentException{
		this.parents.addParent(parent);
	}
	
	public void add(Kid kid) throws KidException{
			this.kids.add(kid);
	}
	
}

