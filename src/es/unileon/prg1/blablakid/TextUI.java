package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Class with the purpose of interacting with the user
 * 
 * @author Hector Castro, Pablo Bayon
 *
 */

public class TextUI {
	private BlaBlaKidsApp blablakid;

	public TextUI(BlaBlaKidsApp blablakid) {
		this.blablakid = blablakid;
	}

	/**
	 * Method in charge of displaying the header and making the menu work
	 */
	public void start() {
		int select;
		this.displayIntro();
		do {
			select = this.displayMenu();

			try {
				switch (select) {
				// Add Kid
				case 1:
					Kid kid = this.askKid();
					this.blablakid.add(kid);
					break;
				// Remove kid
				case 2:
					// TODO falta borrar el kid del array de kids de su parent, si es que estaba
					// incluido en alguno
					Kid kidDelete = this.askKid();
					this.blablakid.remove(kidDelete);
					break;
				// Add Parent
				case 3:
					Parent parent = this.askParent();
					this.blablakid.add(parent);
					break;
				// Remove parent
				case 4:
					this.blablakid.remove(this.askParentRemove());
					break;
				// Add Activity
				case 5:
					Activity activity = this.askActivity();
					String askKid = new String("Name of the kid taking the activity: ");
					String kidName = this.askString(askKid);
					this.blablakid.add(activity, kidName);

					break;
				// Remove Activity
				case 6:
					// TODO
					System.out.println("Not implemented");
					break;
				// Add Ride
				case 7:
					String askParent = "Name of the parent in charge of the ride: ";
					String parentRide = this.askString(askParent);
					String askActivity = "Name of the activity of the ride: ";
					String activityRide = this.askString(askActivity);
					String askKidRide = "Name of the kid taking the activity: ";
					String kidRide = this.askString(askKidRide);
					int numDay = askInt("Insert the number of the day of the week:\n"
							+ "0 - Monday / 1- Tuesday / 2 - Wednesday / 3 - Thursday / 4 - Friday");
					Ride ride = this.askRide();
					this.blablakid.add(ride, parentRide, kidRide, activityRide, numDay);
					break;
				// Remove Ride
				case 8:
					// TODO
					String kidInCharge = askString("Name of the kid taking the activity to remove: ");
					String activityName = askString("Name of the activity to remove: ");
					int dayNum = askInt("Insert the number of the day of the week:\n"
							+ "0 - Monday / 1- Tuesday / 2 - Wednesday / 3 - Thursday / 4 - Friday");
					break;
				case 9:
					System.out.println("/////////////////////////////");
					System.out.println(this.blablakid.toString());
					System.out.println("/////////////////////////////");
					break;
				case 10:
					// TODO
					System.out.println("Not implemented.");
					break;
				case 0:
					System.out.println("Good Bye :)");
					break;
				default:
					System.out.println("Please, select a valid option");
					// TODO Removes
				}
			} catch (Exception e) {
				// Catch all kind of exceptions
				System.out.println(e.getMessage());
			}
		} while (select != 0);
	}

	/**
	 * Prints the apps ASCII Art header
	 */
	private void displayIntro() {
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
	 * Prints the apps menu
	 * 
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

		if (option < 0 || option > 10) {
			System.out.println("Invalid option. Plese select from the menu");
		}
		return option;
	}

	/**
	 * Asks for all the data necesary to create a new kid and creates it.
	 * 
	 * @return Kid whith the given data
	 */
	private Kid askKid() {
		String name = new String();

		do {
			System.out.println("Introduce the name of the kid : ");
			name = Teclado.readString();

			// Checks if the sintax is correct, if not it gives a warning
			if (name.equals("")) {
				System.out.println("Please, introduce a valid name");
			}

		} while (name.equals(""));

		Kid kid = new Kid(name);
		return kid;
	}

	/**
	 * Asks for all the data necesary to create a new Parent and creates it.
	 * 
	 * @return Parent whith the given data
	 */
	private Parent askParent() {
		Parent parent;
		String name = new String();
		int numberOfKids, numberOfRides;
		Kid kid;
		// Asks for its name
		do {
			System.out.println("Introduce the name of the parent to add");
			name = Teclado.readString();

			// Checks if the sintax is correct, if not it gives a warning
			if (name.equals("")) {
				System.out.println("Please, introduce a valid name");
			}
		} while (name.equals(""));

		// Asks for number of kids
		do {
			System.out.println("Introduce the number of kids that " + name + " has");
			numberOfKids = Teclado.readInteger();

			if (numberOfKids < 1 || numberOfKids == Integer.MIN_VALUE || numberOfKids > blablakid.getKidsLength()) {
				System.out.println("Introduce a valid number of kids(Between 1 and" + blablakid.getKidsLength() + ")");
			}
		} while (numberOfKids < 1 || numberOfKids == Integer.MIN_VALUE || numberOfKids > blablakid.getKidsLength());
		Kids kids = new Kids(numberOfKids);

		// Asks for the name of its kids
		for (int i = 1; i <= numberOfKids; i++) {
			System.out.println("Kid number " + i);
			do {
				kid = this.askKid();
				if (this.blablakid.isIncluded(kid) == false) {
					System.out.println("This kid does not exist");
				} else {
					try {
						kids.add(kid);
					} catch (KidException e) {
						System.out.println(e.getMessage());
					}
				}
			} while (blablakid.isIncluded(kid) == false);
		}

		// Asks for the number of rides
		do {
			System.out.println("Introduce the number of rides that the parent will do per day");
			numberOfRides = Teclado.readInteger();
			if (numberOfRides == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number of kids.");
			}
		} while (numberOfRides == Integer.MIN_VALUE);

		parent = new Parent(name, kids, numberOfRides);
		return parent;
	}

	/**
	 * Asks for all the data necesary to delete a Parent and creates it.
	 * 
	 * @return Parent whith the given data
	 */
	private Parent askParentRemove() {
		String name = new String();

		do {
			System.out.println("Introduce the name of the parent : ");
			name = Teclado.readString();

			// Checks if the sintax is correct, if not it gives a warning
			if (name.equals("")) {
				System.out.println("Please, introduce a valid name.");
			}

		} while (name.equals(""));

		return this.blablakid.searchParent(name);
	}

	/**
	 * Asks for all the data necesary to create a new Activity and creates it.
	 * 
	 * @return Activity whith the given data
	 */
	private Activity askActivity() {
		Activity activity = null;
		String name;
		Day day = null;
		Hour startTime = null;
		Hour endTime = null;
		Place place = null;

		// Asks for the name
		do {
			System.out.println("Introduce a name for the activity: ");
			name = Teclado.readString();
		} while (name.equals(""));

		// Asks for the place
		place = this.askPlace();

		// Asks for the day
		do {
			day = this.askDay();
		} while (day == null);

		do {
			do {
				// Asks for the start time
				System.out.println("Start Time");
				startTime = this.askHour();
			} while (startTime == null);

			do {
				// Asks for the end time
				System.out.println("End Time");
				endTime = this.askHour();
			} while (endTime == null);
			if (!startTime.isLower(endTime)) {
				System.out.println("Activity end time must be higher than start time");
			}
		} while (!startTime.isLower(endTime));

		activity = new Activity(name, place, day, startTime, endTime);
		return activity;
	}

	/**
	 * Asks for all the data necesary to create a new Ride and creates it.
	 * 
	 * @return Parent whith the given data
	 */
	private Ride askRide() {
		String startPlaceString = new String();
		Place startPlace = null;
		String endPlaceString = new String();
		Place endPlace = null;
		Hour startTime = null;
		Hour endTime = null;

		Ride ride = null;

		do {
			System.out.println("Where does the ride start? ");
			startPlaceString = Teclado.readString();
		} while (startPlaceString.equals(""));

		startPlace = new Place(startPlaceString);

		do {
			System.out.println("Where does the ride end? ");
			endPlaceString = Teclado.readString();
		} while (endPlaceString.equals(""));

		endPlace = new Place(endPlaceString);

		do {
			do {
				// Asks for the start time
				System.out.println("When does the ride start?");
				startTime = this.askHour();
			} while (startTime == null);

			do {
				// Asks for the end time
				System.out.println("When does the ride end?");
				endTime = this.askHour();
			} while (endTime == null);
			if (!startTime.isLower(endTime)) {
				System.out.println("Activity end time must be higher than start time");
			}
		} while (!startTime.isLower(endTime));
		try {
			ride = new Ride(startPlace, endPlace, startTime, endTime);
		} catch (RideException e) {
			System.out.println(e.getMessage());
		}

		return ride;
	}

	/**
	 * Asks for all the data necesary to create a new Hour and creates it.
	 * 
	 * @return Hour whith the given data
	 */
	private Hour askHour() {
		// TODO pensar como adaptar los cambios
		Hour hour = null;
		int hours, minutes;
		// Asks for the hours
		do {
			System.out.println("Introduce a hour from 0 to 23");
			hours = Teclado.readInteger();
			if (hours == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		} while (hours == Integer.MIN_VALUE);

		do {
			System.out.println("Introduce a minute from 0 to 59");
			minutes = Teclado.readInteger();
			if (minutes == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		} while (minutes == Integer.MIN_VALUE);

		try {
			hour = new Hour(hours, minutes);
		} catch (HourException e) {
			System.out.println(e.getMessage());
		}
		return hour;
	}

	/**
	 * Asks for all the data necesary to create a new Place and creates it.
	 * 
	 * @return Place whith the given data
	 */
	private Place askPlace() {
		String name = new String();

		do {
			System.out.println("Introduce the name of the place to add: ");
			name = Teclado.readString();

			// Checks if the sintax is correct, if not it gives a warning
			if (name.equals("")) {
				System.out.println("Please, introduce a valid name");
			}

		} while (name.equals(""));

		Place place = new Place(name);
		return place;
	}

	/**
	 * Asks for all the data necesary to create a new Day and creates it.
	 * 
	 * @return Day whith the given data
	 */
	private Day askDay() {
		int numday;
		do {
			System.out.println("Introduce the number of the day from 0 to 4 (Monday to Friday)");
			numday = Teclado.readInteger();
			if (numday == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}
		} while (numday == Integer.MIN_VALUE);

		WeekDays wday;
		Day day = null;

		try {

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
			default:
				throw new DayException("Invalid day. Day must be between 0 and 4.");
			}
		} catch (DayException e) {
			System.out.println(e.getMessage());
		}
		return day;
	}

	/**
	 * Asks for a String
	 * 
	 * @param question String that will be displayed as a question before getting
	 *                 the String
	 * @return Introduced String
	 */
	private String askString(String question) {
		String output;
		do {
			System.out.println(question);
			output = Teclado.readString();
		} while (output.equals(""));

		return output;
	}

	/**
	 * Asks for an int
	 * 
	 * @param question String that will be displayed as a question before getting
	 *                 the int
	 * @return Introduced int
	 */
	private int askInt(String question) {
		int out;
		do {
			System.out.println(question);
			out = Teclado.readInteger();

			if (out == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number");
			}

		} while (out == Integer.MIN_VALUE);

		return out;
	}
}