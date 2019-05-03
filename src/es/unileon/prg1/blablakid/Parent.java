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
	private Kids numberKids;
	/**
	 * Number of rides assigned to the parent
	 * @see int
	 */
	private int Rides;
	
	/**
	 * 
	 * @param name Parent identifier
	 * @param numberofrides Rides that the parent do
	 * @param firstkid The First son of the parent
	 * @param numberofkids Number of kids assigned to the parent
	 * 
	 */
	public Parent(String name, Kids kids, int numberOfRides) {
		this.Name = name;
		this.numberKids = kids;
		this.Rides = numberOfRides;
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
	public Kids getNumberKids() {
		return numberKids;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	@Override
	public String toString() {
		return "Parent [" + (Name != null ? "Name=" + Name + ", " : "")
				+ (numberKids != null ? "numberKids=" + numberKids + ", " : "") + "Rides=" + Rides + "]";
	}

	}









