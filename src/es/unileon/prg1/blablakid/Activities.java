package es.unileon.prg1.blablakid;
/**
 * @author Pablo Bayon
 *
 */
public class Activities {
	
	/**
	 * Array of objects of the type Activity
	 */
	private Activity[] activities;
	
	/**
	 * Integer used in order to control the next position that is going to be filled in the array
	 */
	private int next;
	
	/**
	 * Constant that establish the maximum length of the array
	 */
	private final int MAXACTIVITIES = 3;

	public Activities() {
		this.next = 0;
		this.activities = new Activity[MAXACTIVITIES];	
	}
	

	/**
	 * Method that add an object activity to an array of activities if it is possible
	 * 
	 * @param activity
	 * @throws ActivityException
	 */
	public void add(Activity activity) throws ActivityException {
		if(this.isIncluded(activity)) {
			throw new ActivityException("Error: Activity already included");
		} else if(this.next >= this.MAXACTIVITIES) {
			throw new ActivityException("Error: Activity list is full");
		} else {
			activities[this.next] = activity;
			this.next++;
		}
	}
	
	
	/**
	 * Method that removes an object of the array in which it is included
	 * 
	 * @param activity
	 * @throws ActivityException
	 */
	public void remove(Activity activity) throws ActivityException{
		if(this.isIncluded(activity)) {
			int pos = this.inWhichPosIs(activity);
			this.compact(pos);
			this.next--;
		} else {
			throw new ActivityException("Error: kid wasn't included");
		}
	}
	

	/**
	 * Method that compacts the array and removes the object in the position of the param
	 * 
	 * @param pos
	 */
	private void compact(int pos) {
		for(int i = 0; i < (this.next-1); i++) {
			activities[i] = activities[i+1];
		}
		activities[this.next-1] = null;
	}
	
	
	/**
	 * Method that returns the position of an activity in its array
	 * 
	 * @param activity
	 * @return The position of the object inside the array
	 */
	private int inWhichPosIs(Activity activity){
		int count = 0;
		boolean end = false;
		while(activities[count] != null && end) {
			if(activities[count].isSame(activity)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	
	/**
	 * Method that checks if an activity is included in the array
	 * 
	 * @return true if the activity is included in the array, false if not
	 */
	private boolean isIncluded(Activity activity) {
		boolean salida = false;
		boolean end = false;
		int i=0;
		while(i<this.activities.length && end) {
			if(this.activities[i].isSame(activity)){
				salida = true;
				end = true;
			}
			i++;
		}
		return salida;
	}
	
	/**
	 * Method that returns an object activity using its position in the array
	 * 
	 * @param pos
	 * @return the activity located in the position specified by the param
	 */
	public Activity get(int pos) {
		return this.activities[pos];
	}
	
	
	public Activity search(String name, int day) {
		boolean end = false;
		int i=0;
		while((i < this.next) && (!end)) {
			//TODO este metodo se llama a partir de un search de ninios que devuelve su array de actividades, luego con estas comprobaciones valdria, no?
			if((this.activities[i].getName() == name) && (this.activities[i].getDay().getNumDay() == day)) {
				end = true;
			}else {
				i++;
			}
		}
		if(end) {
			return activities[i];
		}else {
			return null;
		}
	}
	
}

