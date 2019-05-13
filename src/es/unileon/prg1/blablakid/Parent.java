package es.unileon.prg1.blablakid;
/**
 * 	Class that creates a parent managed by Parents
 * @author PabloJ
 *
 */
public class Parent {
	
	/**
	 * Name of the parent, used as his/her identifier
	 * @see String
	 */
	private String Name;
	/**
	 * Number of kids assigned to the parent
	 * @see int
	 */
	private Kids kids;
	/**
	 * Number of rides assigned to the parent
	 * @see int
	 */
	private int Rides;
	
	/**
	 * 
	 * Days of the parent
	 * @see Week
	 * 
	 */
	private Week days;
	
	/**
	 * 
	 * Builder of the object Parent
	 * 
	 * @param name Parent identifier
	 * @param numberofrides Rides that the parent do
	 * @param numberofkids Number of kids assigned to the parent
	 * 
	 */
	public Parent(String name, Kids kids, int numberOfRides){
		this.Name = name;
		this.kids = kids;
		this.Rides = numberOfRides;
		this.days = new Week();
	}
	
	

	/**
	 * @return the numberOfRides
	 */
	public int getRides() {
		return Rides;
	}

	/**
	 * @return the numberOfKids
	 */
	public Kids getKids() {
		return kids;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * 
	 * @return days of the parent
	 * 
	 */

	public Week getDays() {
		return days;
	}
	
	/**
	 * 
	 *  Check if the parent is same parent as the param
	 * @param parent2
	 * @return
	 */
	public boolean isSame(Parent parent2) {
		return (this.Name == parent2.getName());
	}
	
	@Override
	public String toString() {
		return "Parent: "+ this.Name + "Kids: " + this.kids + "Number of rides: "+ this.Rides + "Days of Week: "+ this.days ;
				
	}


}







