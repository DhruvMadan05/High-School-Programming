import java.util.*;
class Main {
  //Set the global variable for all the grades, averages, medians, modes
  static int[][] arr = new int[4][8];
  //Set global temp variable for mean

  //Set global variable for student names
  static String[] studentNames = {"Student 1","Student 2","Student 3","Student 4"};
  //Set global Variable for column headers
  static String[] topRow = {"Student Name\t", "Grade 1\t", "Grade 2\t", "Grade 3\t", "Grade 4\t", "Grade 5\t", "Average\t", "Median\t", "Mode\t"};
  //--------------------
  //Set temporary global variables for meadian, mode
  //Temp 1d array for students grades
  static int [] temp1dArray = new int[5];
  //Temp 1d array for all students medians 
  static int [] temp1d2Array = new int[4];
//----------------------------------------------------------------------------------  
  //Get random grades for each student and assignment
  public static void randomNumbers() {
    for(int i = 0; i<4; i++) {
      for(int j = 0; j<5; j++) {
        arr[i][j] = ((int)(Math.random()*101));
      }
    }
  }
//-----------------------------------------------------------------------------
  //Mean of each students grades
  public static double meanStudents(int i) {
    //Define temp storage for all added grades
    double tempMean = 0;
    for(int j = 0; j < 5; j++) {
      //Assign temp storage and add all students grades
      tempMean += arr[i][j];
      //Divide by number of grades and assign to correct point in array
    }
    tempMean = (tempMean / 5);
    return tempMean;
  }
//-----------------------------------------------------------------
  //Median of each students grades
  public static int medianStudents(int i) {
    int tempMedian = 0;
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = arr[i][j];
    }
    //Sort the temp array
    Arrays.sort(temp1dArray);
    //Assign the median grade to temp storage
    tempMedian = temp1dArray[2];
    return tempMedian;
  }
//------------------------------------------------------------------
  //Mode of each students grades
  public static int[] modeStudents() {
    //Mode of all grades
    int mode = -1;
    int modefreq = 1;
    int tempcounter = 1;
    int tempmode = 0;
    int tempModes = 0;
    int tempFreq = 0;
    for(int k = 0; k < 4; k++){
      //compares each number wiht the one next to it
      if(temp1dArray[k] == temp1dArray[k + 1]) {
        //every time the first number it = to the one next ot it temp counter = 1
        tempcounter++;
        tempmode = temp1dArray[k + 1];
        //if temp counter is greater than the modefreq then add one to mode freq and make the mode the number that appears the most
        if(modefreq < tempcounter){
          modefreq++;
          mode = temp1dArray[k];
        }
      } else {
          //if that isnt true reset the counter then go to the next number
          tempcounter = 1;
      }
    }   
    //if there is no mode pirnts no mode
    if(mode == -1){
      tempModes = mode;
    } else {
      //prints mode and how many times it appears
      tempModes = mode;
      tempFreq = modefreq;
    }
    return new int[] {tempModes, tempFreq};
  }  
//-----------------------------------------------------------------------------------
  //Print all original grades and mean, median, and mode
  public static void print(){
    //Print first column header
    System.out.print(topRow[0]);
    for(int k = 1; k < 9; k++) {
      //Print rest of the column headers
      System.out.print(topRow[k]);
    }
    //New line for table start
    System.out.println("\n");
    for(int i = 0; i<4; i++) { 
      //Print the first student name
      System.out.print(studentNames[i]);
      //print first grade for students with formatting
      System.out.print(String.format("%11d", arr[i][0]));
      for(int j = 1; j<5; j++) {
        //Print rest of grades for student with formatting
        System.out.print(String.format("%8d", arr[i][j]));
      }
      //get mean
      double tempMean = meanStudents(i);
      String strMean = String.valueOf(tempMean);  
      //System.out.print(strMean);
      System.out.print(String.format("%9s", strMean));
      //get median
      int tempMedian = medianStudents(i);
      System.out.print(String.format("%7d", tempMedian));
      //get mode 
      int result[] = modeStudents();
      if(result[0] == -1) {
        System.out.print(String.format("%8s", "N/A"));
      } else {
        System.out.print("\t" + result[0] + " Appearing " + result[1] + " Times");
      }
      
      //Spacing new line
      System.out.println("\n");
    }
  }
//----------------------------------------------------------------------------------
  public static void main(String[] args) {
    //Run methods
    randomNumbers();
    print();
  }
}