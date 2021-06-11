import java.util.*;
import java.lang.*; 
import java.io.*; 
import java.util.ArrayList;

class Tests{
  int [] tempGrades = new int[5];
  static int tempNumber = 0;
  static int [] allGrades = new int[20];
  int [] tempOps = new int[4];
  int [] temp1dArray = new int[5];

//---------------------------------------------------------------
  int[] setInitGrades() {
    for(int i = 0; i<5; i++) {
      tempGrades[i] = ((int)(Math.random()*10));
      allGrades[tempNumber] = tempGrades[i];
      tempNumber = tempNumber + 1;
      //System.out.println(tempNumber);
    }
    return tempGrades;
  }
//-------------------------------------------------------------
  double testMean(int j) {
    int temp = 0;
    for(int k = j; k < 20;){
      tempOps[temp] = allGrades[k];
      temp++;
      k = k+5;
    }
    //Define temp storage for all added grades
    double tempMean = 0;
    for(int m = 0; m < 4; m++) {
      //Assign temp storage and add all students grades
      tempMean += tempOps[m];
      //Divide by number of grades and assign to correct point in array
    }
    tempMean = (tempMean / 4);
    return tempMean;
  }
//------------------------------------------------------------
//medians of tests
  double testMedian(int j){
    int temp = 0;
    for(int k = j; k < 20;){
      tempOps[temp] = allGrades[k];
      temp++;
      k = k+5;
    }

    double tempMedian = 0;

    //Sort the temp array
    Arrays.sort(tempOps);

    //Assign the median grade to temp storage
    tempMedian = tempOps[1] + tempOps[2];
    tempMedian = tempMedian/2; 
    return tempMedian;
  }
//-------------------------------------------------------------------
//mode of tests
  int[] testMode(int j){
    int temp = 0;
    for(int m = j; m < 20;){
      tempOps[temp] = allGrades[m];
      temp++;
      m = m + 5;
    }

    //for(int l = 0; l < 4; l++) {
      //Assign random grades in array to temp storage
    //  temp1dArray[l] = tempOps[l];
    //}
    //Sort the temp array
    Arrays.sort(tempOps);


    //Mode of all grades
    int mode = -1;
    int modefreq = 1;
    int tempcounter = 1;
    int tempmode = 0;
    int tempModes = 0;
    int tempFreq = 0;
    for(int k = 0; k < 3; k++){
      //compares each number wiht the one next to it
      if(tempOps[k] == tempOps[k + 1]) {
        //every time the first number it = to the one next ot it temp counter = 1
        tempcounter++;
        tempmode = tempOps[k + 1];
        //if temp counter is greater than the modefreq then add one to mode freq and make the mode the number that appears the most
        if(modefreq < tempcounter){
          modefreq++;
          mode = tempOps[k];
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

}