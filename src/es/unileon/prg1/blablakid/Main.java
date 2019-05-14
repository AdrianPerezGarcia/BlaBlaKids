package es.unileon.prg1.blablakid;
/**
 * @author Adrian Perez
 *
 */
public class Main {
	/**
	 * Metodo principal de la aplicacion que comprueba los parametros e inicia la aplicacion
	 */
	public static void main(String[] args){
		int numberOfKids;
			if(args.length != 1){
				System.out.println("Error: Invalid Arguments.");
			}
			else{
				try {
					numberOfKids = Integer.parseInt(args[0]);
					BlaBlaKidsApp blablakid = new BlaBlaKidsApp(numberOfKids);
					TextUI textUI = new TextUI(blablakid);
					textUI.start();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
	}
}