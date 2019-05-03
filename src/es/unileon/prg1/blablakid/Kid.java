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
	 * @see String
	 */
	private String Name;
	
	/**
	 *Creates the kid object with its name (identifier)
	 * 
	 * @param name Kid identifier
	 */
	public Kid (String name){
		this.Name = name;
	}
	
	/**
	 * 
	 * @return name of kid
	 */
	public String getName() {
		return this.Name;
	}
	
	public boolean isSame(Kid kid2) {
		return (this.Name == kid2.getName());
	}
	
	/**
	 * 
	 * @return String version with the name of the kid
	 */
	@Override
	public String toString() {
		return this.Name;
	}
}

