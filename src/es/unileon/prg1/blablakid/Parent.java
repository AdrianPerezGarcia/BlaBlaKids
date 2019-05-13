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
	private String name;
	/**
	 * Number of kids assigned to the parent
	 * @see int
	 */
	private Kids kids;
	/**
	 * Number of rides assigned to the parent
	 * @see int
	 */
	private int rides;
	
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
		this.name = name;
		this.kids = kids;
		this.rides = numberOfRides;
		this.days = new Week();
	}
	
	

	/**
	 * @return the numberOfRides
	 */
	public int getRides() {
		return rides;
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
		return name;
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
		return (this.name.equals(parent2.getName()));
	}
	
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		
		salida.append("######").append(this.name).append("######\n");
		salida.append("Kids: \n").append(this.kids.toString()).append("\n");		
		salida.append("Rides: \n").append(this.days.toString()).append("\n");
			
		return salida.toString();
	}


}







