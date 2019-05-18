package es.unileon.prg1.blablakid;


/**
 * @author Hector Castro
 *
 */
public class Rides {
	
	/**
	 * Array composed by Ride objects
	 */
	public Ride[] rides;
	
	/**
	 * First free position in the array
	 */
	public int next;

	/**
	 * 
	 * @param numberOfRides maximun number of rides that defines the arrays lenght
	 */
	public Rides(int numberOfRides){
	 this.rides = new Ride[numberOfRides];
	 this.next = 0;
	}

	/**
	 * 
	 * @param Ride that must be found
	 */
	public Ride search(String startPlace,String endPlace) {
		boolean found = false;
		int count = 0;
		while(!found && count<this.rides.length) {
			if(startPlace.equals(this.rides[count].getStartPlace().getPlace()) && endPlace.equals(this.rides[count].getEndPlace().getPlace())) {
				found = true;
			}
			else {
				count++;
			}
		}
		return this.rides[count];
	}
	
	public void addRide(Ride ride) throws RideException{
		//Checks if the ride is alrede in the array
		if(isIncluded(ride)){
			throw new RideException("Error: Ride already included");
		}
		
		//Adds the ride in the first free position in the array
		else{
			//Thows an exception if the array is full
			if (this.next >= this.rides.length) {
				throw new RideException("Error: Ride list is full");
			}
			else {
				this.rides[this.next] = ride;
				this.next++;
			}
		}
	}
	/**
	 * 
	 * @param activity
	 * @return The position of a Ride in an Rides array
	 */
	private int getPos(Ride ride){
		int count = 0;
		boolean end = false;
		while(this.rides[count]!=null && end) {
			if(this.rides[count].isSame(ride)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Remoces a Ride from an array
	 * @param Ride that must be deleted
	 */
	public void removeRide(Ride ride) {
		if(this.isIncluded(ride)) {
			int pos = this.getPos(ride);
			this.rides[pos]=null;
			this.compact(pos);
			this.next--;
		}
	}

	/**
	 * Checks if a Ride is icluded in an array
	 * @param Ride to be checked
	 */
	private boolean isIncluded(Ride ride) {
		boolean same = false;
		for (int i = 0; i < next; i++) {
			if(this.rides[i].isSame(ride)) {
				same = true;
			}
		}
		return same;
	}
	
	/**
	 * @param pos
	 */
	private void compact(int pos) {
		pos++; 
		// The position is incremented so as to move to the object just behind the one that has been removed
		//When the array finds null the compaction is over
		while(this.rides[pos] != null) { 
			//Guardo en la posicion anterior la posicion en la que me encuentro, es decir, desplazo todas a la izquierda desde el objeto que borro
			// The objects are moved one position to the left
			this.rides[(pos-1)] = this.rides[pos];
			pos++;
		}
	}
}
