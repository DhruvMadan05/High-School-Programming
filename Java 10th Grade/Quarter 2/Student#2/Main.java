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

    for( int i = 0; i < 4; i++) {
      s[i] = new Student();
    }
    header();
    for( int i = 0; i < 4; i++) {
      s[i].printData(); 
      System.out.println();
    }
  }
} 
