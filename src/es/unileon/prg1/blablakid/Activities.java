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
	 * @return boolean
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
	 */
	private void compact(int pos) {
		pos++; //Actualizo la posicion para moverme al objeto que esta justo despues del que borro
		//Cuando encuentro null paro, se acabo el array
		while(activities[pos] != null) { 
			//Guardo en la posicion anterior la posicion en la que me encuentro, es decir, desplazo todas a la izquierda desde el objeto que borro
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

