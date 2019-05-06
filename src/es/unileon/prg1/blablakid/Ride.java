package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class Ride{
	private Parent parent;
	private Activity activity;
	private Place startPlace;
	private Place endPlace;
	private Hour startTime;
	private Hour endTime;
	private boolean beforeRide;
	
	
	/**
	 * 
	 * @param parent
	 * @param activity
	 * @param startPlace
	 * @param endPlace
	 * @param startTime
	 * @param endTime
	 * @param beforeRide
	 * @throws RideException
	 */
	public Ride(Parent parent, Activity activity, Place startPlace, Place endPlace, Hour startTime, Hour endTime, boolean beforeRide) throws RideException {
		this.parent = parent;	
		this.activity = activity;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		
		//Check that the ride isn't late. Must begin before the activity and arrive just on time.
		if (beforeRide) {
			
			if ( (startTime.isLower(activity.getStartTime()))  && (endTime.isSame(activity.getStartTime())) ) {
				this.startTime = startTime;
				this.endTime = endTime;
			}
			else {
				throw new RideException("Invalid hours for this activity, the ride arrives late.");
			}
		}
		
		//Check that the ride isn't late. Must begin just when the activity ends and end after.
		else {
			if( (startTime.isSame(activity.getEndTime() ) ) && (endTime.isHigher(activity.getEndTime() ) ) ) {
				this.startTime = startTime;
				this.endTime = endTime;
			}
			else {
				throw new RideException("Invalid hours for this activity, the ride arrives late.");
			}
		}

	}
	/**
	 * @return the parent that does the ride
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @return the start place
	 */
	public Place getStartPlace() {
		return startPlace;
	}

	/**
	 * @return the end place
	 */
	public Place getEndPlace() {
		return endPlace;
	}

	/**
	 * @return the start time
	 */
	public Hour getStartTime() {
		return startTime;
	}

	/**
	 * @return the end time
	 */
	public Hour getEndTime() {
		return endTime;
	}

	/**
	 * @return true if the ride is the one before the Activity or false if it isn't
	 */
	public boolean isBeforeRide() {
		return beforeRide;
	}

}
