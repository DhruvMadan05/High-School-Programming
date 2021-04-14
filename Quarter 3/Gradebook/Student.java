import java.util.*;
import java.lang.*; 
import java.io.*;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


class Student{
	//Define all student specific variables
	//Define the Array list that will hold all the grades
	private ArrayList<Integer> studentGrades = new ArrayList<Integer>();
	//define the grade dependent variables
	private double mean;
	private int median;
	private int mode;
	private int max;
	private int min;
	//define student dependent variables
	private String fullName;
	private String firstName;
	private String lastName;
	static Scanner scan1 = new Scanner(System.in);
	//-------------------------------------------------------------
	//-------------------------------------------------------------
	//Set student student
	void setName(){
    System.out.println("Enter Full Name(First and last w/ space): ");
    fullName = scan1.nextLine();
    //Split Full Name at space
    //define temporary storage
    String[] temp1;
    //Define what character needs to be split and removed
    String delimiter = " ";
    //Split Name
    temp1 = fullName.split(delimiter);
    //Save 2 halves first and last name
    firstName = temp1[0];
    lastName = temp1[1];
  }
	//----------------------------------------------------------------
	//Find mean
	double setMean(){
    //Define temp storage for all added grades
    double tempMean = 0;
    for(int j = 0; j < 5; j++) {
      //Assign temp storage and add all students grades
      tempMean += studentGrades.get(j);
      //Divide by number of grades and assign to correct point in array
    }
    mean = (tempMean / 5);
    return mean;
  }
	//---------------------------------------------------------------
	//find median
	int setMedian(){
    int tempMedian = 0;
		int [] temp1dArray = new int[5];
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = studentGrades.get(j);
    }
    //Sort the temp array
    Arrays.sort(temp1dArray);
    //Assign the median grade to temp storage
    median = temp1dArray[2];
    return median;
  }
	//--------------------------------------------------------------
	//find mode
	int[] setMode(){
    //Mode of all grades
    mode = -1;
    int tempcounter = 1;
    int modeFreq = 1;

		int [] temp1dArray = new int[5];
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = studentGrades.get(j);
    }
		Arrays.sort(temp1dArray);
    for(int k = 0; k < 4; k++){
      //compares each number wiht the one next to it
      if(temp1dArray[k] == temp1dArray[k + 1]) {
        //every time the first number it = to the one next ot it temp counter = 1
        tempcounter++;
        mode = temp1dArray[k + 1];
        //if temp counter is greater than the modefreq then add one to mode freq and make the mode the number that appears the most
        if(modeFreq < tempcounter){
          modeFreq++;
          mode = temp1dArray[k];
        }
      } else {
          //if that isnt true reset the counter then go to the next number
          tempcounter = 1;
      }
    }   
    return new int[] {mode, modeFreq};
	}
	//--------------------------------------------------------------
	//Find max grade
	int setMax() {
		int [] temp1dArray = new int[5];
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = studentGrades.get(j);
    }
		Arrays.sort(temp1dArray);

		max = temp1dArray[4];
		return max;
	}
	//--------------------------------------------------------------
	//Find min grade
	int setMin() {

		int [] temp1dArray = new int[5];
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = studentGrades.get(j);
    }
		Arrays.sort(temp1dArray);

		min = temp1dArray[0];
		return min;
	}
	//----------------------------------------------------------------
	//Submit all grades entered by the user
	void addGrade(int newGrade) {
		studentGrades.add(newGrade);
	}
	//--------------------------------------------------------------
	//Add name
	void addName(String studentName){
		fullName = studentName;
	}
	//---------------------------------------------------------------
	//Get student name for printing and adding grades
	String getName() {
		return fullName;
	}
	//---------------------------------------------------------------
	//Get grades from student
	int getGrades(int gradeNumber) {
		return studentGrades.get(gradeNumber);
	}
	//--------------------------------------------------------------
	//formatting method for printing names
	String rightPadding(String input, char ch, int L) { 
    String result = String.format("%" + (-L) + "s", input).replace(' ', ch); 
    return result;
  }
	//------------------------------------------------------------
	//Print student grades, mean, median, mode, min, max
	void printGrades() {
		//Set formatting parameters for Printing
		int nameLen = fullName.length();
		String str = fullName; 
		char ch = ' '; 
		int format = (17 - nameLen);
		int L = (nameLen + format); 
		//print Formatted name
		System.out.print(rightPadding(str, ch, L)); 

		//print grades
		System.out.print(String.format("%3d", studentGrades.get(0)));
    for(int i = 1; i < 5; i++){
  		System.out.print(String.format("%8d", studentGrades.get(i)));
    }

		//printmean
		mean = setMean();
		System.out.print(String.format("%9s", String.valueOf(mean)));

		//print median
		median = setMedian();
    System.out.print(String.format("%7s", String.valueOf(median)));

		//print Mode
		int result[] = setMode();
    if(result[0] == -1) {
      System.out.print(String.format("%8s", "N/A"));
    } else {
      System.out.print("\t" + result[0] + " " + result[1] + "x");
    }

		//print min
		min = setMin();
		System.out.print(String.format("%7s", String.valueOf(min)));

		//print max
		max = setMax();
		System.out.print(String.format("%7s", String.valueOf(max)));
	}
	//--------------------------------------------------------------
	//Save student info to file
}