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
}

