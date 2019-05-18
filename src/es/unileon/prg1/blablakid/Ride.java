package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class Ride{
	private Place startPlace;
	private Place endPlace;
	private Hour startTime;
	private Hour endTime;
	
	/**
	 * 
	 * @param startPlace
	 * @param endPlace
	 * @param startTime
	 * @param endTime
	 * @throws RideException
	 */
	public Ride(Place startPlace,Place endPlace,Hour startTime,Hour endTime) throws RideException {
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.startTime = startTime;
		this.endTime = endTime;
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
	 * 
	 * @param ride
	 * @return
	 */
	public boolean isSame(Ride ride) {
		boolean same = false;
		if (this.startPlace.equals(getStartPlace()) && this.endPlace.equals(ride.getEndPlace())
				&& this.startTime.isSame(ride.getStartTime()) && this.endTime.isSame(ride.getEndTime())) {
			same = true;
		}
		return same;
	}

}
