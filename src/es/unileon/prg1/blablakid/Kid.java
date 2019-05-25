package es.unileon.prg1.blablakid;
 /**
 * 
 * Class that creates the children that will manage the kids class
 * 
 * @author Adrian Perez
 *
 **/

/*Logs libraries 
 import org.apache.logging.log4j.Logger; import
 org.apache.logging.log4j.LogManager; */

public class Kid {
	/**
	 * Name of the kid, used as his/her identifier
	 * 
	 */
	private String name;

	/**
	 * Activities of each kid
	 * 
	 */
	private Activities activities;

	/**
	 * Creates the kid object with its name (identifier)
	 * 
	 * @param name Kid identifier
	 */
	public Kid(String name) {
		this.name = name;
		this.activities = new Activities();
	}

	/**
	 * Getter of the kid name
	 * 
	 * @return name of kid
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method that check is two kid object are equal
	 * 
	 * @param kid2 to check if is same
	 * 
	 * @return boolean that is true if kids are same or false if not
	 */
	public boolean isSame(Kid kid2) {
		return (this.name.equals(kid2.getName()));
	}

	/**
	 * 
	 * Method that search a Activity in the kid array
	 * 
	 * @param activityName
	 * 
	 * @param numDay
	 * 
	 * @return the activity founded or NULL
	 */
	public Activity search(String activityName, int numDay) {
		return this.activities.search(activityName, numDay);
	}

	/**
	 * 
	 * Method to add an activity in the kid array
	 * 
	 * @param activity to add in his/her array
	 * 
	 * @throws ActivityException if the activity cannot be added
	 */
	public void add(Activity activity) throws ActivityException {
		this.activities.add(activity);
	}
	
	/**
	 * 
	 * Method to remove an activity in the kid array
	 * 
	 * @param activity to remove of his/her array
	 * 
	 * @throws ActivityException If the activity cannot be deleted
	 */
	public void remove(Activity activity) throws ActivityException {
		this.activities.remove(activity);
	}

	/**
	 * Method toString as requested in the Show Summary option
	 * 
	 * @return String version with the name of the kid
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		salida.append("****** ").append(this.name).append(" ******");
		salida.append(this.activities.toString());
		return salida.toString();
	}

}

