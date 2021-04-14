import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.File;
import java.io.IOException;

class Main {
	static int numberGradebooks;
	public static Scanner scan = new Scanner(System.in);

	// -------------------------------------------------
	// see how many gradebooks exist already
	public static int fileNumber() {
		int counter = 0;

		String cont = "y";

		while (cont == "y") {

			try {
				File myObj = new File("Gradebook" + (counter + 1) + ".csv");
				if (myObj.createNewFile()) {

					myObj.delete();
					cont = "n";

				} else {
					
					counter++;
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}

		return counter;

	}

	// -------------------------------------------------------------------
	// main menu
	public static void mainMenu() {
		numberGradebooks = fileNumber();
		System.out.println("\n");
		System.out.println("MAIN MENU\n");
		System.out.println("Please choose an option below");
		System.out.println("Type 1 to veiw an existing gradebook. There are currently: " + numberGradebooks + " active gradebooks.");
		System.out.println("Type 2 to create a new gradebook");
		System.out.println("Type 3 to exit the program");

		String choice = scan.nextLine();
		if (choice.equals("1")) {
			viewGradebook();
		} else if (choice.equals("2")) {

			try {
				File myObj = new File("Gradebook" + (numberGradebooks + 1) + ".csv");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			openEmptyGradebook(numberGradebooks + 1);

		} else if (choice.equals("3")) {
			
		} else {
			System.out.println("That is not a vaild option");
			System.out.println("program exiting.....");
			

		}

	}

	// -------------------------------------------------------------------
	// method to view an existing gradebook
	public static void viewGradebook() {
		numberGradebooks = fileNumber();
		System.out.println("\n\n\n");
		System.out.println("You have chosen to view an existing gradebook.");
		System.out.println("If you would like to go back to the main menu please press 0");
		for (int i = 1; i < numberGradebooks + 1; i++) {
			System.out.println("Type " + i + " to view Gradebook " + i + ".");
		}
		String choice = scan.nextLine();

		if (choice.equals("0")) {
			mainMenu();
		}

		for (int j = 1; j < numberGradebooks + 1; j++) {
			if (choice.equals(String.valueOf(j))) {
				File myObj = new File("Gradebook" + j + ".csv");

				if(myObj.length() < 4){
					openEmptyGradebook(j);
				} else {
					openFullGradebook(j);
				}

			}
		}

	}
	//------------------------------------------------------------------
	//open new/ empty gradebook
	public static void openEmptyGradebook(int gradebookNumber){
		System.out.println("\n\n\n");
		System.out.println("There is currently no data in this gradebook");
		System.out.println("Please input information in before viewing.");
		Gradebook openGradebook = new Gradebook();
		openGradebook.setStudentName();
		openGradebook.setTestGrades();
		openGradebook.printGradebook();
		openGradebook.saveGrades(gradebookNumber);

		System.out.println("\n\n\nPress 1 to edit gradebook");
		System.out.println("Press 2 to go back to main menu");
		System.out.println("Press 3 to exit program");

		String choice = scan.nextLine();

		if(choice.equals("1")){
			editGradebook(gradebookNumber);
		} else if(choice.equals("2")) {
			mainMenu();
		} else if(choice.equals("3")) {
			System.out.println("program exiting.....");
		} else {
			System.out.println("That is not a valid option");
			System.out.println("program exiting.....");
			
		}

	}
	//------------------------------------------------------------------
	//open full gradebook
	public static void openFullGradebook(int gradebookNumber) {
		System.out.println("\n\n\n\n");
		System.out.println("Gradebook " + gradebookNumber + ":");

		Gradebook openGradebook = new Gradebook();
		openGradebook.readGrades(gradebookNumber);
		openGradebook.printGradebook();

		System.out.println("\n\nPress 1 to edit gradebook");
		System.out.println("Press 2 to go back to main menu");
		System.out.println("Press 3 to exit program");

		String choice = scan.nextLine();

		if(choice.equals("1")){
			editGradebook(gradebookNumber);
		} else if(choice.equals("2")) {
			mainMenu();
		} else if(choice.equals("3")) {
			
		} else {
			System.out.println("That is not a valid option");
			System.out.println("program exiting.....");
			
		}


	}
	//------------------------------------------------------------------
	public static void editGradebook(int gradebookNumber) {
		System.out.println("Editing gradebook:");
		Gradebook openGradebook = new Gradebook();
		System.out.println("Press 1 to edit both grades and names");
		System.out.println("Press 2 to return to main menu");
		System.out.println("Press 3 to exit program");

		String choice = scan.nextLine();

		if(choice.equals("1")) {
			openGradebook.setStudentName();
			openGradebook.setTestGrades();
			openGradebook.printGradebook();
			openGradebook.saveGrades(gradebookNumber);
			mainMenu();
		} else if(choice.equals("2")) {
			mainMenu();
		} else if(choice.equals("3")) {
			System.out.println("program exiting.....");
			
		} else {
			System.out.println("that is not a valid option");
			System.out.println("program exiting.....");
			
		}

	}
	//-------------------------------------------------------------------
	public static void main(String[] args) {
		mainMenu();
	}
}