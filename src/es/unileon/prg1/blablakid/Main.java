package es.unileon.prg1.blablakid;
/**
 * 
 * Main made to checks the parameters and start the application
 * 
 * @author Adrian Perez
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	 static final Logger logger = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args){
		int numberOfKids;
			//I check if the arguments are not correct
			if(args.length != 1){
				System.out.println("Error: Invalid Arguments.");
			}
			else{
				try {
					//I check than the argument is a number
					numberOfKids = Integer.parseInt(args[0]);
					BlaBlaKidsApp blablakid = new BlaBlaKidsApp(numberOfKids);
					TextUI textUI = new TextUI(blablakid);
					textUI.start();
				}catch(Exception e) {
					//The application is launched if everything is correct
					System.out.println(e.getMessage());
				}
				
			}
	}
	
}