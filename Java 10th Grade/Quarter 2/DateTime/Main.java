import java.util.*;


class Main {

  public static void main(String[] args) {
    //set all temporary storages
    int second;
    int minute;
    int hour;
    int day;
    int month;
    int year;
    System.out.println();
    System.out.println("Type '5' for 1 second increment & decrement project");
    System.out.println("Type '6' for any amount of time increment & decrement");
    System.out.println("Type '7' for Age calculator");
    System.out.println("Please type the number project you would like to run: ");

    Scanner scan1 = new Scanner(System.in);
    String choice = scan1.nextLine();
   

    if(choice.equals("5")) {
      System.out.println("Project 5: 1 second increment and decrement");
      //run all project specific methods for increment
      Increment Inc = new Increment();
      Inc.getDate();
      Inc.getTime();
      Inc.incrementTime(1, 0, 0, 0, 0, 0);
      System.out.print("The time you entered is: ");
      Inc.timeDisplay();
      System.out.print("\nThe new time after increment of 1 second is: ");
      Inc.ItimeDisplay();

      //run all project specific methods for decrement
      int result[] = Inc.giveData();
      second = result[0];
      minute = result[1];
      hour = result[2];
      day = result[3];
      month = result[4];
      year = result[5];

      Decrement Dek = new Decrement();
      Dek.getData(second, minute, hour, day, month, year);
      Dek.decrementTime(1, 0, 0, 0, 0, 0);
      System.out.print("\nThe new time after decrement of 1 second is: ");
      Dek.DtimeDisplay();
      
    }

//--------------------------------------------------------------
    if(choice.equals("6")) {
      System.out.println("Project 6: Add or subtract ");
      //run all project specific methods for increment
      Increment Inc = new Increment();
      Inc.getDate();
      Inc.getTime();

      //get time from time class
      Time TD = new Time();
      System.out.println("");
      int result[] = TD.setDate("Please type how many years, months or days you would like to add or subtract with slashes (If you do not want to add any, type 0 in its space) - (Months/Days/Years): ");
      int Smonth = result[0];
      int Sday = result[1];
      int Syear = result[2];

      int result1[] = TD.setTime("Please type how many hours, minutes, seconds you would like to add or subtract with colon (if you do not want to add any, type 0 in its space) - (Hour:Minute:Second): ");
      int Shour = result1[0];
      int Sminute = result1[1];
      int Ssecond = result1[2];

      Inc.incrementTime(Ssecond, Sminute, Shour, Sday, Smonth, Syear);
      System.out.print("The time you entered is: ");
      Inc.timeDisplay();
      System.out.print("\nThe New time after adding is: ");
      Inc.ItimeDisplay();

      int result2[] = Inc.giveData();
      second = result2[0];
      minute = result2[1];
      hour = result2[2];
      day = result2[3];
      month = result2[4];
      year = result2[5];

      Decrement Dek = new Decrement();
      Dek.getData(second, minute, hour, day, month, year);
      Dek.decrementTime(Ssecond, Sminute, Shour, Sday, Smonth, Syear);

      System.out.print("\nThe new time after subtracting: ");
      Dek.DtimeDisplay();
      

    }
//-------------------------------------------------------------------
    if(choice.equals("7")) {
      System.out.println("Project 7: Age calculator");
      //run all project specific methods for increment
      Increment Inc = new Increment();
      Inc.getDate();
      Inc.getTime();

      //get time from time class
      Time TD = new Time();
      System.out.println("");
      int result[] = TD.setDate("Please type your birthday - (Months/Days/Years): ");
      int Smonth = result[0];
      int Sday = result[1];
      int Syear = result[2];

      int result1[] = TD.setTime("Please type the time you were born- (Hour:Minute:Second): ");
      int Shour = result1[0];
      int Sminute = result1[1];
      int Ssecond = result1[2];

      Inc.incrementTime(Ssecond, Sminute, Shour, Sday, Smonth, Syear);

      int result2[] = Inc.giveData();
      second = result2[0];
      minute = result2[1];
      hour = result2[2];
      day = result2[3];
      month = result2[4];
      year = result2[5];

      Decrement Dek = new Decrement();
      Dek.getData(second, minute, hour, day, month, year);
      Dek.decrementTime(Ssecond, Sminute, Shour, Sday, Smonth, Syear);

      Dek.AgeDisplay();

    }
  }
}