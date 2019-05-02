package es.unileon.prg1.blablakid;
/**
 * @author Adrian Perez
 *
 */
public class Kids {
	/**
	 * Array composed of kids
	 * 
	 * @see Kid[]
	 */
	public Kid[] kids;

	/**
	 *Creates the kid object with its name (identifier)
	 * 
	 * @param name Kid identifier
	 */
	public Kids(int numberOfKids){
		this.kids = new Kid[numberOfKids];
	}

	/**  
	 * @param nombre
	 * @return Kid
	 */
	public void addKid(String nombre) throws KidException{
		// TODO Auto-generated method stub
	}

	/**
	 * @return void
	 */
	public void removeKid(String nombre) throws KidException{
		// TODO Auto-generated method stub
	}

	/**
	 * @return boolean
	 */
	private boolean isKidIncluded() {
		return false;
		// TODO Auto-generated method stub
	}

}

