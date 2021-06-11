import java.util.*;
class Main {
  static int [] myGrades = new int[10];
//---------------------------------------------------------------------------------
  public static void randomNumbers() {
    // Start the array with 10 different numbers
    for(int i = 0; i < 10; i++) {
      //Get random grades for each number in the Array
      myGrades[i] = ((int)(Math.random()*10));
    }
  }
//---------------------------------------------------------------------------------
  public static void originalArray() {
    System.out.println("Original Array of Grades:");
    for(int j = 0; j < 10; j++) {
      System.out.print(myGrades[j] + "\t");
    }
  }
//---------------------------------------------------------------------------------
  public static void acendingOrder() {
    //sort grades into acending order
    //Use built in sorter
    Arrays.sort(myGrades);
    //tell user the ssorted grades
    System.out.println("\n\nSorted Array of grades in Aecending order");
    for(int j = 0; j < 10; j++) {
      System.out.print(myGrades[j] + "\t");
    }
  }
//----------------------------------------------------------------------------------
  public static void decendingOrder() {
    //sort grades in descending order
    //Turn all number into negative integers
    for(int j = 0; j < 10; j++) {
      myGrades[j] *= (-1);
    }
    //Sort grade using built in
    Arrays.sort(myGrades);
    System.out.println("\n\nSorted Array of grades in Decending order");
    //Switch all rades back to poitive integers and tell user
    for(int j = 0; j < 10; j++) {
      myGrades[j] *= (-1);
      System.out.print(myGrades[j] + "\t");
    }
  }
//---------------------------------------------------------------------------------
  public static void medianNumbers() {
    //Find Median of the set of numbers
    //Take the 5th and 6th numbers in the array
    double medianGrade = myGrades[4] + myGrades[5];
    medianGrade = medianGrade / 2;
    System.out.println("\n\nMedian Grade:");
    System.out.print(medianGrade);
  }
//-----------------------------------------------------------------------------------
  public static void meanNumbers() {
    //Find mean of the set of numbers 
    double meanGrades = 0;
    //take all numbers in the array and add them to a temp location
    for (int j = 0; j < 10; j++) {
      meanGrades += myGrades[j];
    }
    //divide storge location by 10
    meanGrades = meanGrades / 10;
    //Tell user result
    System.out.println("\n\nMean of all Grades");
    System.out.print(meanGrades);
  }
//------------------------------------------------------------------------------------
  public static void modeNumbers() {
    //Mode of all grades
    int mode = -1;
    int modefreq = 1;
    int tempcounter = 1;
    int tempmode = 0;
    System.out.println("\n\nModes:");
    for(int i = 0; i < 9;i++){
      //compares each number wiht the one next to it
      if(myGrades[i] == myGrades[i + 1]){
        //every time the first number it = to the one next ot it temp counter = 1
        tempcounter++;
        tempmode = myGrades[i + 1];
        //if temp counter is greater than the modefreq then add one to mode freq and make the mode the number that appears the most
        if(modefreq < tempcounter){
          modefreq++;
          mode = myGrades[i];
        }
      } else {
          //if that isnt true reset the counter then go to the next number
          tempcounter = 1;
      }
    }   
    //if there is no mode pirnts no mode
    if(mode == -1){
    System.out.println("No Mode" );
    } else {
      //prints mode and how many times it appears
      System.out.println(mode +" Appears " + modefreq + " times " );  
    }
  }
//-----------------------------------------------------------------------------------------
  public static void main(String[] args) {

    randomNumbers();
    originalArray();
    acendingOrder();
    decendingOrder();
    medianNumbers();
    meanNumbers();
    modeNumbers();
  }
}
