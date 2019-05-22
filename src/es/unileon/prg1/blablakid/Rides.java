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
	 * @param numberOfRides maximum number of rides that defines the arrays length
	 */
	public Rides(int numberOfRides){
	 this.rides = new Ride[numberOfRides];
	 this.next = 0;
	}


	public Ride search(String startPlace,String endPlace) {
		boolean found = false;
		int count = 0;
		Ride rideOut = null;
		while((!found) && count<this.next) {
			if(startPlace.equals(this.rides[count].getStartPlace().getPlace()) && endPlace.equals(this.rides[count].getEndPlace().getPlace())) {
				found = true;
				rideOut = this.rides[count];
			}
			else {
				count++;
			}
		}
		return rideOut;
	}
	
	public void addRide(Ride ride) throws RideException{
		//Checks if the ride is already in the array
		if(isIncluded(ride)){
			throw new RideException("Error: Ride already included");
		}
		
		//Adds the ride in the first free position in the array
		else{
			//Throws an exception if the array is full
			if (this.next >= this.rides.length) {
				throw new RideException("Error: Ride list is full");
			}
			else {
				this.rides[this.next] = ride;
				this.next++;
			}
		}
	}

	private int getPos(Ride ride){
		int count = 0;
		boolean end = false;
		while(count < this.next && !end) {
			if(this.rides[count].isSame(ride)) {
				end = true;
			}
			else {
				count++;
			}
		}
		return count;
	}
	
	public Ride get(int pos) {
		return this.rides[pos];
	}
	
	
	public void remove(Ride ride) throws RideException {
		//If the ride is included take the position and removes the ride from the array
		if (this.isIncluded(ride)) {
			//Also compacts the array replacing the next parent
			int pos = getPos(ride);
			this.compact(pos);
			this.next--;
		}
		else {
			//If parent is not founded, throws an exception
			throw new RideException("Error, the ride is not in the list");
		}
	}
			
	private boolean isIncluded(Ride ride) {
		boolean same = false;
		for (int i = 0; i < next; i++) {
			if(this.rides[i].isSame(ride)) {
				same = true;
			}
		}
		return same;
	}
	
	private void compact(int pos) {
		int i;
		//I use a loop to travel the array until next
		for (i = pos; i < (this.next-1) ; i++ ){ 
			//I make the compaction
			this.rides[i] = this.rides[i+1];
		}
		//Equals to null the last position of the loop
		this.rides[this.next-1]=null; 
	}
	
	public int getLength() {
		return this.rides.length;
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i<this.next; i++) {
			out.append(this.get(i).toString()).append("\n");
		}
		return out.toString();
	}
}
