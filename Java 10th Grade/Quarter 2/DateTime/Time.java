import java.util.*;
import java.lang.*; 
import java.io.*; 

class Time{
  Scanner scan1 = new Scanner(System.in);
  
  //set storage module for date integer
  int month;
  int day;
  int year;
  int hour;
  int minute;
  int second;
  
  //-----------------------------------------------------------------------------
  //set current date
  int[] setDate(String comand1) {
    //get date in full standard format
    //Give user formating style
    System.out.println(comand1);
    //Take input
    String fullDate = scan1.nextLine();
    //define temp storage for full date
    String[] tempDate;
    //Define what character needs to be split and removed
    String delimiter = "/";
    //Split DAte
    tempDate = fullDate.split(delimiter);
    //Save 3 parts, divided by slash
    month = Integer.parseInt(tempDate[0]);
    day = Integer.parseInt(tempDate[1]);
    year = Integer.parseInt(tempDate[2]);

    return new int[] {month, day, year};
  }
  //------------------------------------------------------------------------------
  //set current time
  int[] setTime(String comand2) {
    //get time in full 24hour time
    //give formating style/istructions
    System.out.println(comand2);
    //Take input
    String fullTime = scan1.nextLine();
    //define temp storage for full date
    String[] tempTime;
    //Define what character needs to be split and removed
    String delimiter = ":";
    //Split time
    tempTime = fullTime.split(delimiter);
    //Save 3 parts, divided by slash
    hour = Integer.parseInt(tempTime[0]);
    minute = Integer.parseInt(tempTime[1]);
    second = Integer.parseInt(tempTime[2]);
    return new int[] {hour, minute, second};
  }

  //-----------------------------------------------------------------
  //display formatted time
  void timeDisplay(int second, int minute, int hour, int day, int month, int year) {

    System.out.print(month + "/" + day + "/" + year + " at " + hour + ":" + minute + ":" + second);
  }
  //------------------------------------------------------------------
  void timeDisplay(long second, long minute, int hour, int day, int month, int year) {

    System.out.print(month + "/" + day + "/" + year + " at " + hour + ":" + minute + ":" + second);
  }
}