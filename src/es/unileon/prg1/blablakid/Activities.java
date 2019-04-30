package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Activities {
	public Activity[] activities;
	int next;

	public Activities(int tam) {
		this.next = 0;
		this.activities = new Activity[tam];		
	}

	/**
	 * @param activity
	 * @return boolean
	 */
	public boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		boolean salida = true;
		if(this.isActivityIncluded()) {
			salida = false;
		}
		return salida;
	}

	/**
	 * @return boolean
	 */
	public boolean remove() {
		// TODO Auto-generated method stub
	}

	/**
	 * @return boolean
	 */
	private boolean isActivityIncluded() {
		// TODO Auto-generated method stub
	}

}

