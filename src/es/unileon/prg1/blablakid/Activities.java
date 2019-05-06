package es.unileon.prg1.blablakid;
/**
 * @author Pablo Bayon
 *
 */
public class Activities {
	private Activity[] activities;
	private int next;
	private final int MAXACTIVITIES = 3;

	public Activities() {
		this.next = 0;
		this.activities = new Activity[MAXACTIVITIES];	
	}

	/**
	 * Method that add an object activity to an array of activities if it's possible
	 * 
	 * @param activity
	 * @return true if it's possible to add the object, false if not
	 */
	public boolean add(Activity activity) throws ActivityException {
		boolean salida = true;
		if(isIncluded(activity)) {
			salida = false;
			throw new ActivityException("Error: Activity already included");
		}else {
			if(this.next >= this.size) {
				throw new ActivityException("Error: Activity list is full");
			}else {
				activities[this.next] = activity;
				this.next++;
			}
		}
		return salida;
	}
	
	
	/**
	 * Method that removes an object of the array in which it's included
	 * 
	 * @param activity
	 * @return true if its possible to remove it, false if not
	 */
	public boolean remove(Activity activity) {
		// TODO Auto-generated method stub
		boolean salida = false;
		if(this.isIncluded(activity)) {
			int pos = this.inWhichPosIs(activity);
			activities[pos]=null;
			this.compact(pos);
			this.next--;
		}
		return salida;
	}
	

	/**
	 * Method that compacts the array when an object is removed from it
	 * 
	 * @param pos
	 */
	private void compact(int pos) {
		pos++; 
		// The position is incremented so as to move to the object just behind the one that has been removed
		//When the array finds null the compaction is over
		while(activities[pos] != null) { 
			// The objects are moved one position to the left
			activities[(pos-1)] = activities[pos];
			pos++;
		}
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
		while(activities[count]!=null && end) {
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
	 * @return true if the activity is included in the array, false if not
	 */
	private boolean isIncluded(Activity activity) {
		// TODO Auto-generated method stub
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
			//TODO me falta incluir la comprobacion del ninyo que tiene esa actividad pero no se como hacerlo
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

