package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Kid {
	private String Name;

	public Kid() {
		
	}

	/**
	 * @param name Kid identifier
	 */
	public Kid newKid(String name) {
		this.Name = name;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}

	@Override
	public String toString() {
		return this.Name;
	}
}

