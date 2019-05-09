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

	
	/*
	public void add(Parent parent, Kids kids) {
		for (int i = 0; i < kids.getSize(); i++) {
			kid = this.kids.search(Kids.get(i).getŃame()) == null;
				if (kid == null) {
					//Exception
				}else {
					parent.add(kid);
				}
				this.parents.add(parent);
			}
		}
	}
	*/
}

