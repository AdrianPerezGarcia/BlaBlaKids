package es.unileon.prg1.blablakid;
 /**
 * 
 * Class that creates a parent managed by Parents
 * 
 * @author PabloJ
 *
 **/

 /*Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;*/

public class Parent {
	/**
	 * 
	 * Name of the parent, used as his/her identifier
	 * 
	 */
	private String name;
	
	/**
	 * 
	 * Number of kids assigned to the parent
	 * 
	 */
	private Kids kids;
	
	/**
	 * 
	 * Number of rides assigned to the parent
	 * 
	 */
	private int numberOfRides;
	
	/**
	 * 
	 * Days of the parent
	 * 
	 */
	private Week days;
	
	/**
	 * 
	 * Builder of the object Parent
	 * 
	 * @param name Parent identifier
	 * @param kids Rides that the parent do
	 * @param numberOfRides Number of kids assigned to the parent
	 * 
	 */
	public Parent(String name, Kids kids, int numberOfRides){
		this.name = name;
		this.kids = kids;
		this.numberOfRides = numberOfRides;
		this.days = new Week(numberOfRides);
	}
	
	

	/**
	 * 
	 * Getter of the number of rides of the parent
	 * 
	 * @return integer with the numberOfRides
	 * 
	 */
	public int getNumRides() {
		return this.numberOfRides;
	}

	/**
	 * 
	 * Getter of the parent name
	 * 
	 * @return string with the name
	 * 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * Check if the parent is same parent as the parameter
	 * 
	 * @param parent2 Another parent to compare
	 * 
	 * @return Boolean with true if the hours are equals
	 * 
	 */
	public boolean isSame(Parent parent2) {
		boolean isSame = false;
		
		if (this.name.equals(parent2.getName())) {
				
					isSame = true;		
		}
		
		return isSame;

	}
	
	/**
	 * Search a day in the array of days
	 * 
	 * @param numDay number of the day
	 * 
	 * @return Day  Object day 
	 * 
	 */
	
	public Day search(int numDay) {
		
		return this.days.search(numDay);
			
	}
	
	/**
	 * 
	 * Search a kid in the array of kids
	 * 
	 * @param Kidname String of the name of the kid
	 * 
	 * @return Kid The kid of the array
	 * 
	 */
	public Kid search(String Kidname) {
		return this.kids.search(Kidname);
	}
	
	/**
	 * 
	 * Method that removes a kid in the array of kids
	 * 
	 * @param Kid that wants to be deleted
	 * 
	 * @throws KidException if the kid does not exist in the array
	 * 
	 */
	public void remove(Kid kid) throws KidException {
		this.kids.remove(kid);
	}
	
	public Ride search(String rideStartPlace, String rideEndPlace, Day day) throws DayException {
		if (day == null) {
			throw new DayException("Error: Day not valid");
		} else {
			return day.search(rideStartPlace, rideEndPlace);
		}
	}
	
	public void add(Ride ride, Day day) throws RideException, DayException {
		if (day == null) {
			throw new DayException("Error: Day not valid");
		} else {
			day.add(ride); 
		}
	}
	
	public void remove(Ride ride, Day day) throws RideException, DayException {
		if (day == null) {
			throw new DayException("Error: Day not valid");
		} else {
			day.remove(ride); 
		}
	}
	
	/**
	 * 
	 * Method to String of the parents and his/her kid
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		
		salida.append(this.name + "\n");
		salida.append(this.kids.toString());		
		salida.append(this.days.toString());
			
		return salida.toString();
	}


}







