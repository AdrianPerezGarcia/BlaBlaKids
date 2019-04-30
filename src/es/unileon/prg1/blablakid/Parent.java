package es.unileon.prg1.blablakid;
/**
 * @author PabloJ
 *
 */
public class Parent {
	
	/**
	 * 
	 */
	private String Name;
	private Kid firstKid;
	private int numberOfKids;
	private Ride numberOfRides;
	
	public Parent(String name,Ride numberofrides, Kid firstkid, int numberofkids) {
		this.Name = name;
		this.firstKid = firstkid;
		this.numberOfKids = numberofkids;
		this.numberOfRides = numberofrides;
	}

	/**
	 * @return the numberOfRides
	 */
	public Ride getNumberOfRides() {
		return numberOfRides;
	}

	/**
	 * @return the numberOfKids
	 */
	public int getNumberOfKids() {
		return numberOfKids;
	}

	/**
	 * @return the firstKid
	 */
	public Kid getFirstKid() {
		return firstKid;
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
				+ (firstKid != null ? "firstKid=" + firstKid + ", " : "") + "numberOfKids=" + numberOfKids + ", "
				+ (numberOfRides != null ? "numberOfRides=" + numberOfRides : "") + "]";
	}
	


	}









