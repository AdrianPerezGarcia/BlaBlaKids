package es.unileon.prg1.blablakid;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * 	Class that creates a parent managed by Parents
 * @author PabloJ
 *
 */
public class Parent {
	
	/**
	 * Name of the parent, used as his/her identifier
	 */
	private String name;
	/**
	 * Number of kids assigned to the parent
	 */
	private Kids kids;
	/**
	 * Number of rides assigned to the parent
	 */
	private int rides;
	
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
		this.rides = numberOfRides;
		this.days = new Week(numberOfRides);
	}
	
	

	/**
	 * @return the numberOfRides
	 */
	public int getNumRides() {
		return rides;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * Check if the parent is same parent as the parameter
	 * 
	 * @param parent2 Another parent to compare
	 * 
	 * @return Boolean with true if the hours are equals
	 */
	public boolean isSame(Parent parent2) {
		boolean isSame = false;
		
		if (this.name.equals(parent2.getName())) {
				
					isSame = true;		
		}
		
		return isSame;

	}
	
	/*
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
	
	/*
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
	
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		
		salida.append(this.name + "\n");
		salida.append(this.kids.toString());		
		salida.append(this.days.toString());
			
		return salida.toString();
	}


}







