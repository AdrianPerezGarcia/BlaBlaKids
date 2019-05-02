package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class TextUI {

	public TextUI() {
		
	}

	/**
	 * @return int
	 */
	public static int displayMenu() {
		// TODO Auto-generated method stub
		int option;

		System.out.println("Select an option:");
		System.out.println("[1] Add kid");
		System.out.println("[2] Remove kid");
		System.out.println("[3] Add parent");
		System.out.println("[4] Remove parent");
		System.out.println("[5] Add activity");
		System.out.println("[6] Remove activity");
		System.out.println("[7] Add ride");
		System.out.println("[8] Remove ride");
		System.out.println("[9] Show summary");
		System.out.println("[10] Check status");
		System.out.println("[0] EXIT");
		option = Teclado.readInteger();
		
		if(option<0 || option>10){
			System.out.println("Opcion invalida");
		}
		return option;
	}
	public static void displayIntro() {
		System.out.print("\t\t\t\t\t\t\t╔====================================================╗\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╗ ██╗      █████╗ ██████╗ ██╗      █████╗   |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██╗██╔══██╗██║     ██╔══██╗  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝██║     ███████║██████╔╝██║     ███████║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██║██╔══██╗██║     ██╔══██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝███████╗██║  ██║██████╔╝███████╗██║  ██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝  |\n");
		System.out.print("\t\t\t\t\t\t\t|                                                    |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╗  ██╗██╗██████╗ ███████╗                       |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██║ ██╔╝██║██╔══██╗██╔════╝                       |\n");
		System.out.print("\t\t\t\t\t\t\t|  █████╔╝ ██║██║  ██║███████╗                       |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔═██╗ ██║██║  ██║╚════██║                       |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██║  ██╗██║██████╔╝███████║                       |\n");
		System.out.print("\t\t\t\t\t\t\t|  ╚═╝  ╚═╝╚═╝╚═════╝ ╚══════╝                       |\n");
		System.out.print("\t\t\t\t\t\t\t╚====================================================╝\n");
		return;
	}
	/**
	 * Reads a Kid's name, creates it and returns a Kid object
	 * @return Kid object with the specified name
	 */
	public Kid askKid() {
		String name =new String();
		
		do {
			System.out.println("Introduce the Kids name: ");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name == null) {
				System.out.println("Please, introduce a valid name");
			}		
		
		}while(name == null);
		
		Kid kid = new Kid(name);
		return kid;
	}
	
	public Parent askParent() {
		String name =new String();
		//TODO pedir kids y demas
		do {
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name == null) {
				System.out.println("Please, introduce a valid name");
			}		
		
		}while(name == null);
		
		Parent parent = new Parent(name, );
	}
	
	public Activity askActivity() {
		//TODO Comprobaciones aqui y se le pasa filtrado al constructor
	}
	
	public Ride askRide() {
		String parent = new String();
		String activity = new String();
		String startPlace = new String();
		String endPlace = new String();
		String startTime = new String();
		String endTime = new String();
		char beforeRide;
		//Gets the parent that makes the ride
		do {
			System.out.println("Intorduce the name of the parent that makes the ride: ");
			parent = Teclado.readString();
			//TODO pedir todo lo demas
		}while()
	}
	
	
}	