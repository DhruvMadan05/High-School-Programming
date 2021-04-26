import java.util.*;
import java.lang.*; 
import java.io.*; 
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

class Gradebook {
	
	private Student [] Student = new Student[4];
	
	Scanner scan = new Scanner(System.in); 
	int maxTest = 5;
	private double testMean;
	private double testMedian;
	private int testMode;
	private int testMax;
	private int testMin;

	Gradebook() {
		for(int i = 0; i < 4; i++) {
			Student[i] = new Student();
		}
	}
//-------------------------------------------------------------------------------------
//set name for each student
void setStudentName(){
	for(int i = 0; i < 4; i++){
		Student[i].setName();
	}
}
//-------------------------------------------------------------------------------
//set grades for ech student
	void setTestGrades() {
		int counter = 1;
		int submitGrade;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 4; j++) {
				System.out.println("Enter Grade " + (i + 1) + " for " + Student[j].getName());
				submitGrade = Integer.parseInt(scan.nextLine());
				Student[j].addGrade(submitGrade);
			}
		}
	}
//-------------------------------------------------------------------------------------
//get mean for each test
	double testMean(int testNumber) {
		
		//Define temp storage for all added grades
    double tempMean = 0;
    for(int j = 0; j < 4; j++) {
      //Assign temp storage and add all students grades
      tempMean += Student[j].getGrades(testNumber);
      //Divide by number of grades and assign to correct point in array
    }
    testMean = (tempMean / 4);
    return testMean;
	}
//-------------------------------------------------------------------------
//get mdian for each test
	double testMedian(int testNumber) {
		int [] temp1dArray = new int[4];
    for(int j = 0; j < 4; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = Student[j].getGrades(testNumber);
    }
    //Sort the temp array
    Arrays.sort(temp1dArray);
    //Assign the median grade to temp storage
    testMedian = (temp1dArray[1] + temp1dArray[2]) / 2;
    return testMedian;
	}
//-----------------------------------------------------------------------
//get mode for each test
	int[] testMode(int testNumber) {
		//Mode of all grades
    testMode = -1;
    int tempcounter = 1;
    int modeFreq = 1;

		int [] temp1dArray = new int[4];
    for(int j = 0; j < 4; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = Student[j].getGrades(testNumber);
    }

    for(int k = 0; k < 3; k++){
      //compares each number wiht the one next to it
      if(temp1dArray[k] == temp1dArray[k + 1]) {
        //every time the first number it = to the one next ot it temp counter = 1
        tempcounter++;
        testMode = temp1dArray[k + 1];
        //if temp counter is greater than the modefreq then add one to mode freq and make the mode the number that appears the most
        if(modeFreq < tempcounter){
          modeFreq++;
          testMode = temp1dArray[k];
        }
      } else {
          //if that isnt true reset the counter then go to the next number
          tempcounter = 1;
      }
    }   
    return new int[] {testMode, modeFreq};
	}
//-----------------------------------------------------------------
//get max of setTest
	int testMax(int testNumber) {

		int [] temp1dArray = new int[4];
    for(int j = 0; j < 4; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = Student[j].getGrades(testNumber);
    }
		Arrays.sort(temp1dArray);

		testMax = temp1dArray[3];
		return testMax;

	}
//----------------------------------------------------------------
	int testMin(int testNumber) {

		int [] temp1dArray = new int[4];
    for(int j = 0; j < 4; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = Student[j].getGrades(testNumber);
    }
		Arrays.sort(temp1dArray);

		testMin = temp1dArray[0];
		return testMin;

	}
//-----------------------------------------------------------------
//print all data for grade book
	void printGradebook(){
		//set top row names
		System.out.println("\n\n");

		String[] topRow = {"Student Name\t", "Grade 1\t", "Grade 2\t", "Grade 3\t", "Grade 4\t", "Grade 5\t", "Average\t", "Median\t", "Mode\t", "Min\t", "Max\t"};

    //Print first column header
    System.out.print(topRow[0]);
    for(int k = 1; k < 11; k++) {
      //Print rest of the column headers
      System.out.print(topRow[k]);
    }
    //New line for table start
    System.out.println("\n--------------------------------------------------------------");

		//stat printing student individual grades
		for(int i = 0; i < 4; i++) {
			Student[i].printGrades();
			System.out.print("\n");
		}
		System.out.println("--------------------------------------------------------------");

		//print test specific data
		//print mean
		System.out.print("Test Averages:");
		testMean = testMean(0);
		System.out.print(String.format("%7s", String.valueOf(testMean)));
		for(int j = 1; j < 5; j++) {
			testMean = testMean(j);
			System.out.print(String.format("%8s", String.valueOf(testMean)));
		}
		System.out.println("\n");

		//print median
		System.out.print("Test Median:");
		testMean = testMedian(0);
		System.out.print(String.format("%7s", String.valueOf(testMedian)));
		for(int j = 1; j < 5; j++) {
			testMedian = testMedian(j);
			System.out.print(String.format("%8s", String.valueOf(testMedian)));
		}
		System.out.println("\n");

		//print mode
		System.out.print("Test Mode:");

		int result[] = testMode(0);
    if(result[0] == -1) {
      System.out.print(String.format("%7s", "N/A"));
    } else {
      System.out.print("\t" + result[0] + " " + result[1] + "x");
    }

		for(int j = 1; j < 5; j++) {
			int result1[] = testMode(j);
			if(result1[0] == -1) {
				System.out.print(String.format("%8s", "N/A"));
			} else {
				System.out.print("\t" + result1[0] + " " + result1[1] + "x");
			}
		}
		System.out.println("\n");
		
		//get min
		System.out.print("Test Minimum:");
		testMin = testMin(0);
		System.out.print(String.format("%7s", String.valueOf(testMin)));
		for(int j = 1; j < 5; j++) {
			testMin = testMin(j);
			System.out.print(String.format("%8s", String.valueOf(testMin)));
		}
		System.out.println("\n");

		//get max
		System.out.print("Test Maximum:");
		testMax = testMax(0);
		System.out.print(String.format("%7s", String.valueOf(testMax)));
		for(int j = 1; j < 5; j++) {
			testMax = testMax(j);
			System.out.print(String.format("%8s", String.valueOf(testMax)));
		}
		System.out.println("\n");

	}
//------------------------------------------------------------
//save grades to Gradebook
	void saveGrades(int saveNumber) {
		try {
			FileWriter myWriter = new FileWriter("Gradebook" + saveNumber + ".csv");

			for(int i = 0; i < 4; i++) {
				//start writing grades and other stuff to file
				//write name
				myWriter.append(Student[i].getName());
				myWriter.append(",");
				//write grades
				for(int j = 0; j < 5; j++) {
					myWriter.append(String.valueOf(Student[i].getGrades(j)));
					myWriter.append(",");
				}
				myWriter.append("\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
//------------------------------------------------------------
//read grades from file
	void readGrades(int saveNumber) {

		try {
      		File myObj = new File("Gradebook" + saveNumber + ".csv");
      		Scanner myReader = new Scanner(myObj);
			int i = 0;
      		while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
        		String[] temp1;
				String delimiter = ",";
    			//Split data
    			temp1 = data.split(delimiter);

				//Start sending grades to each student
				Student[i].addName(temp1[0]);
				for(int j = 1; j < 6; j++) {
					int submitGrade = Integer.parseInt(temp1[j]);
					Student[i].addGrade(submitGrade);
				}
				i++;
      		}
      		myReader.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
	}
}