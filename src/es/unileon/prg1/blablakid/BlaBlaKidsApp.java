package es.unileon.prg1.blablakid;
/**
 * 
 * Class that manages the app
 * 
 * @author Pablo Bayon
 *
 */

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 * import es.unileon.prg1.blablakid.Activity;
 * import es.unileon.prg1.blablakid.Activities;
 * import es.unileon.prg1.blablakid.Ride;
 * import es.unileon.prg1.blablakid.Rides;
 * import es.unileon.prg1.blablakid.Kid;
 * import es.unileon.prg1.blablakid.Kids;
 * import es.unileon.prg1.blablakid.Parent;
 * import es.unileon.prg1.blablakid.Parents;
 * import es.unileon.prg1.blablakid.Hour;
 * import es.unileon.prg1.blablakid.Place;
 * import es.unileon.prg1.blablakid.Day;
 * import es.unileon.prg1.blablakid.Week;
 * import es.unileon.prg1.blablakid.TextUI
 * 
 * ?????
 */

public class BlaBlaKidsApp {
	
	// Define a static logger variable so that it references the
	// Logger instance named "MyApp".
	private static final Logger logger = LogManager.getLogger(BlaBlaKidsApp.class);
	
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
	 * @throws RideException if the ride cannot be removed
	 * 
	 */
	public void remove(String activityName, String kidName, int numDay)
			throws KidException, ActivityException, RideException {
		Activity activity = this.kids.search(kidName).search(activityName, numDay);
		if (this.kids.search(kidName) == null) {
			throw new KidException("Error: The kid " + kidName + " doesn't exist");
		} else if (this.kids.search(kidName).search(activity.getName(), activity.getDay().getNumDay()) == null) {
			throw new KidException("Error: The kid " + kidName + " doesn't have the activity " + activity.getName()
					+ " on " + activity.getDay().toString());
		} else {
			this.kids.search(kidName).remove(activity);
			for (int i = 0; i < this.parents.getLength(); i++) {
				if (this.parents.get(i).search(numDay).search(activity.getAfterRide().getStartPlace().getPlace(),
						activity.getAfterRide().getEndPlace().getPlace()) != null) {
					Ride ride = this.parents.get(i).search(numDay).search(
							activity.getAfterRide().getStartPlace().getPlace(),
							activity.getAfterRide().getEndPlace().getPlace());
					this.parents.get(i).search(numDay).remove(ride);
				}
				
				if(this.parents.get(i).search(numDay).search(activity.getBeforeRide().getStartPlace().getPlace(),
						activity.getBeforeRide().getEndPlace().getPlace()) != null) {
					Ride ride = this.parents.get(i).search(numDay).search(
							activity.getBeforeRide().getStartPlace().getPlace(),
							activity.getBeforeRide().getEndPlace().getPlace());
					this.parents.get(i).search(numDay).remove(ride);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param ride
	 * @param parentName
	 * @param kidName
	 * @param activityName
	 * @param numDay
	 * @throws Exception
	 */
	public void add(Ride ride, String parentName, String kidName, String activityName, int numDay) throws Exception {
		StringBuilder out = new StringBuilder();
		if (this.parents.search(parentName) == null) {
			out.append("The parent " + parentName + " does not exist.\n");
		}
		if (this.kids.search(kidName) == null) {
			out.append("The kid " + kidName + " does not exist.\n");
		} else if (this.kids.search(kidName).search(activityName, numDay) == null) {
			out.append("The kid " + kidName + " does not have the activity " + activityName);
		}

		if (out.length() > 0) {
			throw new BlaBlaKidException(out.toString());
		} else {
			this.kids.search(kidName).search(activityName, numDay).setRides(ride);
			if (this.kids.search(kidName).search(activityName, numDay).setRides(ride)) {
				this.parents.search(parentName).search(numDay).add(ride);
			}
		}
	}

	public void remove(String parentName, int numDay, String startPlace, String endPlace) throws ParentException, RideException{
		StringBuilder out = new StringBuilder();
		if (this.parents.search(parentName) == null) {
			out.append("The parent " + parentName + " does not exist.\n");
		}
		
		Ride ride = this.parents.search(parentName).search(numDay).search(startPlace, endPlace);
		this.parents.search(parentName).search(numDay).remove(ride);
		
		//TODO falta borrar los rides de la acctividad, es posible que necesite metodos auxiliares
		
	}
	
	public int getKidsLength() {
		return this.kids.getLength();
	}


	public boolean isIncluded(Kid kid) {
		return this.kids.isIncluded(kid);
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("KIDS:\n").append(this.kids.toString()).append("\n");
		out.append("PARENTS:\n").append(this.parents.toString()).append("\n");
		return out.toString();
	}


}
