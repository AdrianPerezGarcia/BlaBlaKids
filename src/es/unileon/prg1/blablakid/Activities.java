package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Activities {
	private Activity[] activities;
	private int next;

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
		if(this.isIncluded()) {
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

