package es.unileon.prg1.blablakid;
/**
 * 
 * Class that manages the app
 * 
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
	 * 
	 * Method to search an kid in the kids array
	 * 
	 * @param kidName
	 * 
	 * @return the kid founded or null
	 * 
	 */
	public Kid searchKid(String kidName) {
		return this.kids.search(kidName);
	}

	
	/**
	 * 
	 * Method to add a kid in the kids array
	 * 
	 * @param kid that want to be added
	 * 
	 * @throws KidException if the kid cannot be added
	 * 
	 */
	public void add(Kid kid) throws KidException {
			this.kids.add(kid);
	}


	/**
	 * 
	 * Method to remove a kid from the kids array
	 * 
	 * @param kid that wants to be deleted
	 * 
	 * @throws KidException if the kid cannot be removed cause he do not exist
	 * 
	 */
	public void remove(Kid kid)throws KidException {
			this.kids.remove(kid);
	}


	/**
	 * 
	 * Method to search a parent in the parents array
	 * 
	 * @param parentName
	 * 
	 * @return the parent founded or null
	 * 
	 */
	public Parent searchParent(String parentName) {
		return this.parents.search(parentName);
	}

	/**
	 * 
	 * Method to add a parent in the parents array
	 * 
	 * @param parent that want to be added
	 * 
	 * @throws ParentException if the parent cannot be added
	 * 
	 */
	public void add(Parent parent) throws ParentException {
			this.parents.add(parent);
	}

	/**
	 * 
	 * Method to remove a parent from the parent array
	 * 
	 * @param parent that wants to be deleted
	 * 
	 * @throws ParentException if the parent does not exist
	 * 
	 */
	public void remove(Parent parent)throws ParentException {
			this.parents.remove(parent);
	}


	/**
	 * 
	 * Method to add an activity in a kid
	 * 
	 * @param activity that wants to be included
	 * 
	 * @param kidName of the kid that the user want to add the activity
	 * 
	 * @throws ActivityException if the activity cannot be added
	 * 
	 * @throws KidException if the kid does not exist
	 * 
	 */
	public void add(Activity activity, String kidName) throws KidException, ActivityException {
		if(this.kids.search(kidName) == null) {
			throw new KidException("Error: The kid " + kidName + " doesn't exist.");
		} else {
			this.kids.search(kidName).add(activity);
		}
	}
	
	/**
	 * 
	 * Method to remove an activity of a kid
	 * 
	 * @param activity that wants to be removed
	 * 
	 * @param kidName of the kid that the user want to remove the activity
	 * 
	 * @throws KidException if the kid does not exist
	 * 
	 * @throws ActivityException if the activity cannot be deleted
	 * 
	 */
	public void remove(Activity activity, String kidName) throws KidException, ActivityException {
		if (this.kids.search(kidName) == null) {
			throw new KidException("Error: The kid " + kidName + " doesn't exist");
		} else if (this.kids.search(kidName).search(activity.getName(), activity.getDay().getNumDay()) == null) {
			throw new KidException("Error: The kid " + kidName + " doesn't have the activity " + activity.getName()
					+ " on " + activity.getDay().toString());
		} else {
			this.kids.search(kidName).remove(activity);
		}
	}
	
	public void add(Ride ride, String parentName, String kidName, String activityName, int numDay)
			throws ParentException, KidException, ActivityException, DayException, RideException {
		/**
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
		**/
	}
}
