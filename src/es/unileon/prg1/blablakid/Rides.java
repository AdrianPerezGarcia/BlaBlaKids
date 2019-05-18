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
	
	public Ride get(int pos) throws RideException {
		Ride ride = null;
		if(pos<0 || pos>=this.next) {
			throw new RideException("Position out of range");
			
		}
		else {
			ride = this.rides[pos];
		}
		return ride;
	}
	
	
	/**
	 * Remoces a Ride from an array
	 * @param Ride that must be deleted
	 * @throws RideException 
	 */
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
}
