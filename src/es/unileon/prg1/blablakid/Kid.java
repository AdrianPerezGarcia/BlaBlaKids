package es.unileon.prg1.blablakid;
/**
 * Class that creates the children that will manage the kids class
 * 
 * @author Adrian Perez
 *
 */
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
	 *Creates the kid object with its name (identifier)
	 * 
	 * @param name Kid identifier
	 */
	public Kid (String name){
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


	public Activity search(String activityName, int numDay) {
		// TODO Auto-generated method stub
		return this.activities.search(activityName, numDay);
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

