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
		if (this.startPlace.getPlace().equals(ride.getStartPlace().getPlace()) && this.endPlace.getPlace().equals(ride.getEndPlace().getPlace()) && 
				this.startTime.isSame(ride.getStartTime()) && this.endTime.isSame(ride.getEndTime()) ) {
			same = true;
		}
		return same;
	}
	public String toString() { 
		StringBuilder out = new StringBuilder();
		out.append(startPlace + " > " + endPlace + " : " + this.getStartTime().toString() + "/" + this.getEndTime().toString() +"\n" );
		return out.toString();
	}
}
