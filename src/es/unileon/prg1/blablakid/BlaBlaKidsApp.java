package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class BlaBlaKidsApp {
	
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
	
	public BlaBlaKidsApp(int numberOfKids){
		this.kids = new Kids(numberOfKids);
		this.parents = new Parents(numberOfKids*2);
		
		
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
	
	public void add(Activity activity, String kidName) throws ActivityException{
		this.kids.searchKid(kidName).getActivities().add(activity);
	}
}

