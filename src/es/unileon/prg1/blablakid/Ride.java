package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class Ride{
	public Parent parent;
	public Activity activity;
	public Place startPlace;
	public Place endPlace;
	public Hour startTime;
	public Hour endTime;

	public Ride(Parent parent, Activity activity, Place startPlace, Place endPlace, Hour startTime, Hour endTime) {
		this.parent = parent;	
		this.activity = activity;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		//TODO Falta comprobar si son validas
		this.startTime = startTime;
		this.endTime = endTime;
		
	}

	public Hour getStartTime() {
		return startTime;
	}

	public Hour getEndTime() {
		return endTime;
	}

	public Parent getParent() {
		return parent;
	}

	public Activity getActivity() {
		return activity;
	}

	public Place getStartPlace() {
		return startPlace;
	}

	public Place getEndPlace() {
		return endPlace;
	}

}

