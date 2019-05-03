package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Activities {
	private Activity[] activities;
	private int next;
	private int size;

	public Activities(int size) {
		this.next = 0;
		this.size = size;
		this.activities = new Activity[size];	
	}

	/**
	 * @param activity
	 * @return boolean
	 */
	public boolean addActivity(Activity activity) throws ActivityException {
		// TODO Auto-generated method stub
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
	 * @return boolean
	 */
	public boolean remove() {
		// TODO Auto-generated method stub
		boolean salida = false;
		return salida;
	}

	/**
	 * @return boolean
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

}

