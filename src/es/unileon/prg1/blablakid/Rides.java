package es.unileon.prg1.blablakid;
/**
 * 
 * Class that manages an array of Ride objects
 * 
 * @author Hector Castro
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rides {
	
	 static final Logger logger = LogManager.getLogger(Rides.class.getName());

	/**
	 * 
	 * Array composed by Ride objects
	 * 
	 */
	public Ride[] rides;

	/**
	 * 
	 * First free position in the array
	 * 
	 */
	public int next;

	/**
	 * 
	 * Rides constructor
	 * 
	 * @param numberOfRides Maximum number of rides that defines the arrays length.
	 * 
	 */
	public Rides(int numberOfRides) {
		this.rides = new Ride[numberOfRides];
		this.next = 0;
	}

	/**
	 * 
	 * Method to search a Ride object inside a Rides array
	 * 
	 * @param startPlace The start place of the Ride to find
	 * 
	 * @param endPlace   The end place of the Ride to find
	 * 
	 * @return Ride inside the Rides array with the given data or null if there is no Ride found
	 * 
	 *         
	 */
	public Ride search(String startPlace, String endPlace) {
		boolean found = false;
		int count = 0;
		Ride rideOut = null;
		while ((!found) && count < this.next) {
			if (startPlace.equals(this.rides[count].getStartPlace().getPlace())
					&& endPlace.equals(this.rides[count].getEndPlace().getPlace())) {
				found = true;
				rideOut = this.rides[count];
			} else {
				count++;
			}
		}
		return rideOut;
	}

	/**
	 * 
	 * Method to add a Ride to a Rides array
	 * 
	 * @param ride Ride to add
	 * 
	 * @throws RideException throws an exception if the ride is already included or if the array is full
	 * 
	 */
	public void addRide(Ride ride) throws RideException {
		// Checks if the ride is already in the array
		if (isIncluded(ride)) {
			throw new RideException("Error: Ride already included");
		}

		// Adds the ride in the first free position in the array
		else {
			// Throws an exception if the array is full
			if (this.next >= this.rides.length) {
				throw new RideException("Error: Ride list is full");
			} else {
				this.rides[this.next] = ride;
				this.next++;
			}
		}
	}

	/**
	 * 
	 * Method that returns the position on a Rides array of a given Ride
	 * 
	 * @param ride Ride to search
	 * 
	 * @return Position in the array
	 * 
	 */
	private int getPos(Ride ride) {
		int count = 0;
		boolean end = false;
		while (count < this.next && !end) {
			if (this.rides[count].isSame(ride)) {
				end = true;
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * 
	 * Method get the Ride in a given position
	 * 
	 * @param pos Position to retrieve
	 * 
	 * @return Ride in the given position
	 * 
	 */
	public Ride get(int pos) {
		return this.rides[pos];
	}

	/**
	 * 
	 * Method to remove a Ride from a Rides array
	 * 
	 * @param ride Ride wanted to be delete
	 * 
	 * @throws RideException throws an exception if the ride is not included in the array
	 * 
	 */
	public boolean remove(Ride ride) throws RideException {
		boolean removed = false;
		// If the ride is included take the position and removes the ride from the array
		if (this.isIncluded(ride)) {
			// Also compacts the array replacing the next parent
			int pos = getPos(ride);
			this.compact(pos);
			this.next--;
			removed = true;
		} else {
			// If parent is not founded, throws an exception
			throw new RideException("Error, the ride is not in the list");
		}
		return removed;
	}

	/**
	 * 
	 * Methods that determines if a Ride is includes in a Rides array
	 * 
	 * @param ride to search
	 * 
	 * @return true if its included, false if it is not
	 * 
	 */
	private boolean isIncluded(Ride ride) {
		boolean same = false;
		for (int i = 0; i < next; i++) {
			if (this.rides[i].isSame(ride)) {
				same = true;
			}
		}
		return same;
	}

	/**
	 * 
	 * Private method to compact the array after removing
	 * 
	 * @param pos Position of the removed object
	 * 
	 */
	private void compact(int pos) {
		int i;
		// I use a loop to travel the array until next
		for (i = pos; i < (this.next - 1); i++) {
			// I make the compaction
			this.rides[i] = this.rides[i + 1];
		}
		// Equals to null the last position of the loop
		this.rides[this.next - 1] = null;
	}

	/**
	 * 
	 * @return The max length of the Rides array
	 * 
	 */
	public int getLength() {
		return this.rides.length;
	}

	/**
	 * 
	 * Method toString as required in Show Summary option in textUI
	 * 
	 */
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < this.next; i++) {
			out.append(this.get(i).toString()).append("\n");
		}
		return out.toString();
	}
}
