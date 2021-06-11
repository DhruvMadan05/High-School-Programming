import java.util.*;
import java.lang.*; 
import java.io.*; 

class Student{
  Scanner scan1 = new Scanner(System.in);

  String firstName;
  String lastName;
  int nameLen;
  int [] grades = new int[5];
  //Define Temp 1d array
  int [] temp1dArray = new int[5];


  Student(){
    setName();
    setGrades();
  }
//------------------------------------------------------------------
  void setName(){
    System.out.println("Enter Full Name: ");
    String fullName = scan1.nextLine();
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
    nameLen = fullName.length();
  } 
//-------------------------------------------------------------------
  void setGrades(){
    for(int i = 0; i<5; i++) {
      grades[i] = ((int)(Math.random()*101));
    }
  }
//--------------------------------------------------------------------
  double meanGrades(){
    //Define temp storage for all added grades
    double tempMean = 0;
    for(int j = 0; j < 5; j++) {
      //Assign temp storage and add all students grades
      tempMean += grades[j];
      //Divide by number of grades and assign to correct point in array
    }
    tempMean = (tempMean / 5);
    return tempMean;
  }
//--------------------------------------------------------------------
  int medianGrades(){
    int tempMedian = 0;
    for(int j = 0; j < 5; j++) {
      //Assign random grades in array to temp storage
      temp1dArray[j] = grades[j];
    }
    //Sort the temp array
    Arrays.sort(temp1dArray);
    //Assign the median grade to temp storage
    tempMedian = temp1dArray[2];
    return tempMedian;
  }
//--------------------------------------------------------------------
  int[] modeGrades(){
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
//---------------------------------------------------------------------
//formatting method
  String rightPadding(String input, char ch, int L) { 
    String result = String.format("%" + (-L) + "s", input).replace(' ', ch); 
    return result;
  }
//-------------------------------------------------------------------
  void printData(){
    //Set formatting parameters for Printing
    String str = (firstName + " " + lastName); 
    char ch = ' '; 
    int format = (17 - nameLen);
    int L = (nameLen + format); 

    System.out.print(rightPadding(str, ch, L)); 
  
    System.out.print(String.format("%3d", grades[0]));
    for(int i = 1; i < 5; i++){
      System.out.print(String.format("%8d", grades[i]));
    }
    //get mean
    double tempMean = meanGrades();
    String strMean = String.valueOf(tempMean);  
    System.out.print(String.format("%9s", strMean));

    //get median
    int tempMedian = medianGrades();
    System.out.print(String.format("%7d", tempMedian));

    //get mode 
    int result[] = modeGrades();
    if(result[0] == -1) {
      System.out.print(String.format("%8s", "N/A"));
    } else {
      System.out.print("\t" + result[0] + " Appearing " + result[1] + " Times");
    }
  }
}
  