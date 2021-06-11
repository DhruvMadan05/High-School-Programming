import java.util.*;
class Main {
  public static void header() {
    String[] topRow = {"Student Name\t", "Grade 1\t", "Grade 2\t", "Grade 3\t", "Grade 4\t", "Grade 5\t", "Average\t", "Median\t", "Mode\t"};

    //Print first column header
    System.out.print(topRow[0]);
    for(int k = 1; k < 9; k++) {
      //Print rest of the column headers
      System.out.print(topRow[k]);
    }
    //New line for table start
    System.out.println("\n");
  }
//----------------------------------------------------------------
  public static void main(String[] args) {
    Student [] s = new Student[4];
    Tests t = new Tests();

    for( int i = 0; i < 4; i++) {
      s[i] = new Student();
    }
    header();
    System.out.println("-------------------------------------------------------------");
    for( int i = 0; i < 4; i++) {
      s[i].printData(); 
      System.out.println();
    }
    //Get test Mean median Mode
    System.out.println("-------------------------------------------------------------");
    System.out.print("Test Averages:");
//Print averages of tests
    for(int j = 0; j < 5; j++){
      if(j == 0) {
        double tempMean = t.testMean(j);
        String strMean = String.valueOf(tempMean);  
        System.out.print(String.format("%7s", strMean));
        j++;
      }
      double tempMean = t.testMean(j);
      String strMean = String.valueOf(tempMean);  
      System.out.print(String.format("%8s", strMean));
    }
    System.out.println();
//Print Medians of tests
    System.out.print("Test Medians: ");
    for(int j = 0; j < 5; j++){
      if(j == 0) {
        double tempMedian = t.testMedian(j);
        System.out.print(String.format("%7s", tempMedian));
        j++;
      }
      double tempMedian = t.testMedian(j);
      System.out.print(String.format("%8s", tempMedian));
    }
    System.out.println();
//Print Modes of tests
    System.out.print("Test Modes:   ");

    for(int j = 0; j < 5; j++){
      if(j == 0) {
        //--------
        int result[] = t.testMode(j);
        if(result[0] == -1) {
          System.out.print(String.format("%7s", "N/A"));
        } else {
          System.out.print("\t" + result[0] + "  " + result[1] + "x");
        }
        //------------
        j++;
      }
      //---------------
      int result[] = t.testMode(j);
      if(result[0] == -1) {
        System.out.print(String.format("%8s", "N/A"));
      } else {
        System.out.print("\t" + result[0] + " " + result[1] + "x");
      }
      //--------
    }
  }
} 
