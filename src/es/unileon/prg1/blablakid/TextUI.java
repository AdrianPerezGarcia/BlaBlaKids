package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class TextUI {
	private BlaBlaKidsApp blablakid;

	
	public TextUI(BlaBlaKidsApp blablakid) {
		this.blablakid = blablakid;
	}

	
	public void start() {
		int select;
		
		this.displayIntro();
		do {
			select = this.displayMenu();
			switch(select) {
				//Add Kid
				case 1:
					Kid kid = this.askKid();
					try {
						this.blablakid.add(kid);
					} catch (KidException e) {
						System.out.println(e.getMessage());
					}
					break;
				//Remove kid
				case 2:
					System.out.println("Not implemented");
					break;
				//Add Parent
				case 3:
					Parent parent = this.askParent();
					//TODO blablakid.add(parent);
					break;
				//Remove parent
				case 4:
					System.out.println("Not implemented");
					break;
				//Add Activity
				case 5:
					Activity activity = this.askActivity();
					//TODO blablakid.add(activity);
					break;
				//Remove Activity
				case 6:
					System.out.println("Not implemented");
					break;
				//Add Ride
				case 7:
					System.out.println("Not implemented");
					break;
				//Remove Ride
				case 8:
					System.out.println("Not implemented");
					break;
				case 9:
					System.out.println("Not implemented");
					System.out.println(this.blablakid.getKids().toString());
					this.blablakid.getKids().toString();
					break;
				case 0:
					System.out.println("Good Bye :)");
					break;
				default:
					System.out.println("Please, select a valid option");
				//TODO Removes 
			}
		}while(select!=0);
	}
	
	/**
	 * Prints the apps menu
	 * @return the option selected as an </CODE>int</CODE>
	 */
	private int displayMenu() {
		int option;
		System.out.println();
		System.out.println("	### Select an option ###");
		System.out.println("	# [1] Add kid          #");
		System.out.println("	# [2] Remove kid       #");
		System.out.println("	# [3] Add parent       #");
		System.out.println("	# [4] Remove parent    #");
		System.out.println("	# [5] Add activity     #");
		System.out.println("	# [6] Remove activity  #");
		System.out.println("	# [7] Add ride         #");
		System.out.println("	# [8] Remove ride      #");
		System.out.println("	# [9] Show summary     #");
		System.out.println("	# [10] Check status    #");
		System.out.println("	# [0] EXIT             #");
		System.out.println("	########################");
		System.out.println();
		option = Teclado.readInteger();
		
		if(option<0 || option>10){
			System.out.println("Invalid option. Plese select from the menu");
		}
		return option;
	}
	
	/**
	 * Prints the apps ASCII Art header
	 */
	public void displayIntro() {
		System.out.print("\t\t\t\t\t\t\t╔====================================================╗\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╗ ██╗      █████╗ ██████╗ ██╗      █████╗   |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██╗██╔══██╗██║     ██╔══██╗  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝██║     ███████║██████╔╝██║     ███████║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██║██╔══██╗██║     ██╔══██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝███████╗██║  ██║██████╔╝███████╗██║  ██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝  |\n");
		System.out.print("\t\t\t\t\t\t\t|                                                    |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██╗  ██╗██╗██████╗                 |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██║ ██╔╝██║██╔══██╗                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 █████╔╝ ██║██║  ██║                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██╔═██╗ ██║██║  ██║                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██║  ██╗██║██████╔╝                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ╚═╝  ╚═╝╚═╝╚═════╝                 |\n");
		System.out.print("\t\t\t\t\t\t\t╚====================================================╝\n");
		return;
	}

	
	/**
	 * Asks for all the data necesary to create a new kid and creates it.
	 * @return Kid whith the given data
	 */
	private Kid askKid() {
		String name =new String();
		
		do {
			System.out.println("Introduce the name of the kid to add: ");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name.equals("")) {
				System.out.println("Please, introduce a valid name");
			}		
		
		}while(name.equals(""));
		
		Kid kid = new Kid(name);
		return kid;
	}
	
	
	private Parent askParent() {
		Parent parent;
		String name =new String();
		int numberOfKids, numberOfRides;
		Kid kid;
		//Asks for its name
		do {
			System.out.println("Introduce the name of the parent to add");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name.equals("")){
				System.out.println("Please, introduce a valid name");
			}		
		}while(name.equals(""));
		
		//Asks for number of kids
		do {
			System.out.println("Introduce the number of kids that "+name+" has");
			numberOfKids = Teclado.readInteger();
			
			if(numberOfKids<1 || numberOfKids==Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number of kids, at least 1");
			}
		}while(numberOfKids<1 || numberOfKids==Integer.MIN_VALUE);
		Kids kids = new Kids(numberOfKids);
		
		//Asks for the name of its kids
		for(int i=1; i<=numberOfKids; i++) {
			System.out.println("Kid number "+i);
			kid = this.askKid();
			try {
				kids.add(kid);
			} catch (KidException e) {
				System.out.println(e.getMessage());
			}
		}

		//Asks for the number of rides
		do {
			System.out.println("Introduce the number of rides that the parent will do per day");
			numberOfRides = Teclado.readInteger();
			if (numberOfRides == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number of kids.");
			}
		}while(numberOfRides == Integer.MIN_VALUE); 
		
		parent = new Parent(name,kids,numberOfRides);
		return parent;
	}
	
	
	private Activity askActivity() {
		Activity activity = null;
		String name;
		Day day = null;
		Hour startTime, endTime;
		Place place;
		
		
		//Asks for the name
		do {
			System.out.println("Introduce a name for the activity: ");
			name = Teclado.readString();	
		}while(name.equals(""));
		
		//Asks for the place
		place = this.askPlace();
		
		// Asks for the day
		day = this.askDay();
		
		//Asks for the start time
		System.out.println("Start Time");
		startTime = this.askHour();
		
		//Asks for the end time
		System.out.println("End Time");
		endTime = this.askHour();
		
		activity = new Activity(name,place,day,startTime,endTime);
		return activity;
	}
	
	/*TODO
	private Ride askRide() {
		String parent = new String();
		String activity = new String();
		String startPlace = new String();
		String endPlace = new String();
		Hour startTime, endTime;
		boolean beforeRide;
		//Gets the parent that makes the ride
		do {
			System.out.println("Intorduce the name of the parent that makes the ride: ");
			parent = Teclado.readString();
		}while(parent.equals(""));
	
		
		//TODO pedir lo demas
		Ride ride = new Ride(parent,activity,startPlace,endPlace,startTime,endTime);
		return ride;
	}
   */
	
	private Hour askHour() {
		Hour hour = null;
		int hours,minutes;
		//Asks for the hours
		do {
			System.out.println("Introduce a hour from 0 to 23");
			hours = Teclado.readInteger();
			if(hours == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		}while(hours == Integer.MIN_VALUE);
		
		do {
			System.out.println("Introduce a minute from 0 to 59");
			minutes = Teclado.readInteger();
			if(minutes == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		}while(minutes == Integer.MIN_VALUE);
		
		try {
			hour = new Hour(hours,minutes);
		} catch (HourException e) {
			System.out.println(e.getMessage());
		}
		return hour;
	}
	
	private Place askPlace() {
		String name =new String();
		
		do {
			System.out.println("Introduce the name of the place to add: ");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name.equals("")) {
				System.out.println("Please, introduce a valid name");
			}		
		
		}while(name.equals(""));
		
		Place place = new Place(name);
		return place;
	}
	
	
	private Day askDay() {
		int numday;
		do {
			System.out.println("Introduce the number of the day from 0 to 4 (Monday to Friday)");
			numday = Teclado.readInteger();
			if (numday == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		}while(numday == Integer.MIN_VALUE);
		
		WeekDays wday;
		Day day = null;
		
		try{
		
			switch (numday) {
			case 0:
				wday = WeekDays.MONDAY;
				day = new Day(wday);
				break; 
			case 1:
				 wday = WeekDays.TUESDAY;
				 day = new Day(wday);
				break;
			case 2:
				 wday = WeekDays.WEDNESDAY;
				 day = new Day(wday);
				break;
			case 3:
				 wday = WeekDays.THURSDAY;
				 day = new Day(wday);
				break;
			case 4:
				 wday = WeekDays.FRIDAY;
				 day = new Day(wday);
				break;
			}
		} catch (DayException e) {
			System.out.println(e.getMessage());
		}
	return day;	
	}
	
		
}