package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class BlaBlaKidsApp {
	public int numberOfKids;

	
	/**
	 * Metodo principal de la aplicacion
	 *
	 */
	public static void main(String[] args){
		TextUI.displayIntro();
		
		int option;
		do {
			option = TextUI.displayMenu();
			switch(option){
			case 1:
				System.out.println("Test 1");
				break;
			case 2:
				System.out.println("Test 2");
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 0:
				break;
			}
		}while(option!=0);
		
		
	}

}

