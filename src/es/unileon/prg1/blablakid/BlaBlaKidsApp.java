package es.unileon.prg1.blablakid;

/**
 * @author Pablo Bayon
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
	 * .
	 */
	public Kid searchKid(String kidName) {
		return this.kids.search(kidName);
	}

	/**
	 * @return the parents
	 */
	public Parent searchParent(String parentName) {
		return this.parents.search(parentName);
	}

	public void add(Parent parent) throws ParentException {
			this.parents.add(parent);
	}

	public void add(Kid kid) throws KidException {
			this.kids.add(kid);
	}
		
	public void add(Activity activity, String kidName) throws ActivityException, KidException {
		if(this.kids.search(kidName) == null) {
			throw new KidException("The kid " + kidName + " doesn't exist.");
		} else {
			this.kids.search(kidName).addActivity(activity);
		}
	}
	
	public void remove(Parent parent)throws ParentException {
			this.parents.remove(parent);
	}
	
	public void remove(Kid kid)throws KidException {
			this.kids.remove(kid);
	}

	public void add(Ride ride, String parentName, String kidName, String activityName, int numDay)
			throws ParentException, KidException, ActivityException, DayException, RideException {
		//TODO  revisar
		if (this.parents.search(parentName) == null) {
			throw new ParentException(parentName + " doesn't exist.");
		} else if (this.kids.search(kidName) == null) {
			throw new KidException(kidName + " doesn't exist.");
		} else if (this.kids.search(kidName).search(activityName, numDay) == null) {
			throw new ActivityException(kidName + " doesn't have the activity " + activityName);
			//TODO como gestionar beforeRide y afterRide para hacer comprobaciones
		} else if(!(this.kids.search(kidName).getActivities().search(activityName, numDay).getPlace().isSame(ride.getStartPlace()))) {
			throw new RideException("The activity is not on that place.");
		}else {
			this.kids.search(kidName).getActivities().search(activityName, numDay);
			this.parents.search(parentName).getDays().search(numDay).getRides().addRide(ride);
		}
	}
}
