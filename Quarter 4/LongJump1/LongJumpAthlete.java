import java.util.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LongJumpAthlete {
	Scanner scan1 = new Scanner(System.in);
	String name;
	String idnum;
	String school;
	double att1;
	double att2;
	double att3;
	double best;

	int att1feet;
	int att1inches;
	int att2feet;
	int att2inches;
	int att3feet;
	int att3inches;

	LongJumpAthlete() {
		setInfo();
		findBest();
		printInfo();
	}

	public void setInfo() {
		System.out.println("Enter ID Number:");
		idnum = scan1.nextLine();
		try {
			File myObj = new File("StudentStaff.csv");
			Scanner myReader = new Scanner(myObj);
			String data = idnum;
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				//
				String[] result = data.split(",");
				if (result[2].equals(idnum)) {
					name = result[0] + " " + result[1];
					// System.out.println(result[0] + result[1]);
				}

			}
			// System.out.println(data);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			// e.printStackTrace();
		}
		System.out.println("Enter School/Team name");
		school = scan1.nextLine();
		System.out.println("Enter the 1st attempt in feet");
		att1feet = scan1.nextInt();
		System.out.println("Enter the 1st attempt in inches");
		att1inches = scan1.nextInt();
		System.out.println("Enter the 2nd attempt in feet");
		att2feet = scan1.nextInt();
		System.out.println("Enter the 2nd attempt in inches");
		att2inches = scan1.nextInt();
		System.out.println("Enter the 3rd attempt in feet");
		att3feet = scan1.nextInt();
		System.out.println("Enter the 3rd attempt in inches");
		att3inches = scan1.nextInt();
	}

	public void findBest() {
		att1 = att1feet * 12 + att1inches;
		att2 = att2feet * 12 + att2inches;
		att3 = att3feet * 12 + att3inches;

		if (att1 > att2) {
			if (att1 > att3) {
				best = att1;
			}
		}
		if (att2 > att1) {
			if (att2 > att3) {
				best = att2;
			}
		}
		if (att3 > att2) {
			if (att3 > att1) {
				best = att3;
			}
		}
		att1 = att1 / 12;
		att2 = att2 / 12;
		att3 = att3 / 12;
		best = best / 12;
	}

	public void printInfo() {
		System.out.println("Name: " + name + "\nID: " + idnum + "\nSchool/Team: " + school + "\nAttempt 1: " + att1
				+ " feet" + "\nAttempt 2: " + att2 + " feet" + "\nAttempt 3: " + att3 + " feet" + "\nBest: " + best + " feet");
	}

}
