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
	 * This is the First son of the parent
	 * @see Kid
	 */
	private Kid FKid;
	/**
	 * Number of kids assigned to the parent
	 * @see int
	 */
	private int numberKids;
	/**
	 * Number of rides assigned to the parent
	 * @see int
	 */
	private Ride Rides;
	
	/**
	 * 
	 * @param name Parent identifier
	 * @param numberofrides Rides that the parent do
	 * @param firstkid The First son of the parent
	 * @param numberofkids Number of kids assigned to the parent
	 * 
	 */
	public Parent(String name,Ride numberofrides, Kid firstkid, int numberofkids) {
		this.Name = name;
		this.FKid = firstkid;
		this.numberKids = numberofkids;
		this.Rides = numberofrides;
	}

	/**
	 * @return the numberOfRides
	 */
	public Ride getRides() {
		return Rides;
	}

	/**
	 * @return the numberOfKids
	 */
	public int getNumberKids() {
		return numberKids;
	}

	/**
	 * @return the firstKid
	 */
	public Kid getFirstKid() {
		return FKid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	@Override
	public String toString() {
		return "Parent [" + (Name != null ? "Name=" + Name + ", " : "") + (FKid != null ? "FKid=" + FKid + ", " : "")
				+ "numberKids=" + numberKids + ", " + (Rides != null ? "Rides=" + Rides : "") + "]";
	}


	}









