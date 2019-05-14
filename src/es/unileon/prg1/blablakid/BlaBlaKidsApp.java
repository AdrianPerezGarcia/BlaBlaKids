package es.unileon.prg1.blablakid;

/**
 * @author
 *
 */
public class BlaBlaKidsApp {

	/**
	 * 
	 * Array of kids in BlaBlaKidsApp
	 * 
	 * @see Kids
	 *
	 */
	private Kids kids;

	/**
	 * 
	 * Array of parents in BlaBlaKidsApp
	 * 
	 * @see Parents
	 * 
	 */
	private Parents parents;

	public BlaBlaKidsApp(int numberOfKids) throws BlaBlaKidException {
		if (numberOfKids < 1) {
			throw new BlaBlaKidException("Error: The maximum number of children must be at least one.");
		} else {
			this.kids = new Kids(numberOfKids);
			this.parents = new Parents(numberOfKids * 2);
		}
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

	public void add(Parent parent) throws ParentException {
		this.parents.addParent(parent);
	}

	public void add(Kid kid) throws KidException {
		this.kids.add(kid);
	}
		
	public void add(Activity activity, String kidName) throws ActivityException, KidException {
		if(this.kids.searchKid(kidName) == null) {
			throw new KidException("The kid " + kidName + " doesn't exist.");
		} else {
			this.kids.searchKid(kidName).getActivities().add(activity);
		}
	}


	public void add(Ride ride, String parentName, String kidName, String activityName, int numDay)
			throws ParentException, KidException, ActivityException, DayException, RideException {
		if (this.parents.search(parentName) == null) {
			throw new ParentException(parentName + " doesn't exist.");
		} else if (this.parents.search(parentName).getDays().search(numDay) == null) {
			throw new ParentException(parentName + " doesn't have any activity on that day.");
		} else if (this.kids.searchKid(kidName) == null) {
			throw new KidException(kidName + " doesn't exist.");
		} else if (this.kids.searchKid(kidName).getActivities().search(activityName, numDay) == null) {
			throw new ActivityException(kidName + " doesn't have the activity " + activityName);
		} else {
			this.kids.searchKid(kidName).getActivities().search(activityName, numDay);
			this.parents.search(parentName).getDays().search(numDay).getRides().addRide(ride);
		}
	}
}
