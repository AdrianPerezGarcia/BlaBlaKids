package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class BlaBlaKidsApp {
	/**
	 * Metodo principal de la aplicacion que comprueba los parametros e inicia la aplicacion
	 */
	public static void main(String[] args){
		int numberOfKids;
			if(args.length() != 1){
				System.out.println("Error: Argumentos incorrectos");
			}
			else{
				try {
					numberOfKids = Integer.parseInt(args[0]);
				}catch(NumberFormatException e) {
					System.out.println("Error: Caracter introducido como argumento no valido");
				}
				
			}
	}

}

