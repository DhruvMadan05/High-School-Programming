import java.util.*;
import java.lang.*; 
import java.io.*; 

class Increment {
  int month; int Imonth; int Opmonth;
  int day; int Iday; int Opday;
  int year; int Iyear; int Opyear;
  int hour; int Ihour; int Ophour;
  int minute; int Iminute; int Opminute;
  int second; int Isecond; int Opsecond;



  //----------------------------------------------------------------
  //set user inputed date from time class
  void getDate() {
    Time TD = new Time();
    String comand1 = "Please type in the current date with slashes (M/D/Y): ";
    int result[] = TD.setDate(comand1);

    month = result[0];
    Imonth = result[0];

    day = result[1];
    Iday = result[1];

    year = result[2];
    Iyear = result[2];
  }
  //----------------------------------------------------------------
  //set user inputed time from time class
  void getTime() {
    Time TD = new Time();
    String comand2 = "Please type in the current time in 24 hour format with colon (H:M:S): ";
    int result[] = TD.setTime(comand2);

    hour = result[0];
    Ihour = result[0];

    minute = result[1];
    Iminute = result[1];

    second = result[2];
    Isecond = result[2];
  }
  //----------------------------------------------------------------
  //increment method
  void incrementTime(int Opsecond, int Opminute, int Ophour, int Opday, int Opmonth, int Opyear) {
    int max;
    //add increment in seconds to user defined seconds
    Isecond = Isecond + Opsecond;
    //if seconds is more than 60 add more to minutes
    if(Isecond > 59) {
      Iminute = Iminute + (Isecond / 60);
      Isecond = Isecond % 60;
    }
    //if minutes is more than 60 add more to hours
    Iminute = Iminute + Opminute;
    if(Iminute > 59) {
      Ihour = Ihour + (Iminute / 60);
      Iminute = Iminute % 60;
    }
    //if hours is more than 24 add more to days
    Ihour = Ihour + Ophour;
    if(Ihour > 23) {
      Iday = Iday + (Ihour / 24);
      Ihour = Ihour % 24;
    }

    int go = 1;
    Iday = Iday + Opday;
    while(go == 1) {
      max = 0;
      //Test month to set max days in the month 
      //test to see if the month has 31 days
      if(Imonth == 1|| Imonth == 3|| Imonth == 5 || Imonth == 7 || Imonth == 8 || Imonth == 10 || Imonth == 12 ) {
        max = 31;
      }
      //test to see if the month has 30 days
      else if(Imonth == 4 || Imonth == 6 || Imonth == 9 || Imonth == 11) {
        max = 30;
      }
      //test to se if the month has 28 or 29 days
      else if(Imonth == 2){
        //Tests to see if the year qualifies as a leap year
        if(Iyear % 4 != 0) {
          max = 28;
        }
        else if(Iyear % 100 != 0) {
          max = 29;
        }
        else if(Iyear % 400 != 0) {
          max = 28;
        }
        else {
          max = 29;
        }
      }
      //>>>>>>>>>>>>>
      //>>>>>>>>>>>>>
      //Check if there are more days in the month than there should be
      if(Iday > max) {
        Iday = Iday - max;
        Imonth++;
      }
      //check if there are more month than there should be 
      if(Imonth > 12) {
        Imonth = 1;
        Iyear++;
      }
      //Statement to exit loop
      if(Imonth < 13 && Iday < (max + 1)) {
        go = 2;
      }
    }

    Imonth = Imonth + Opmonth;

    while(Imonth > 12) {
      Imonth = Imonth - 12;
      Iyear++;
    }

    Iyear = Iyear + Opyear;


  }
  //--------------------------------------------------------------
  //Display the original time supplied by user
  void timeDisplay() {
    Time TD = new Time();
    
    TD.timeDisplay(second, minute, hour, day, month, year);
  }
  //-----------------------------------------------------------------
  //display the end time that is in the system
  void ItimeDisplay() {
    Time TD = new Time();
    
    TD.timeDisplay(Isecond, Iminute, Ihour, Iday, Imonth, Iyear);
  }
  //-------------------------------
  //Give OG numbers to decrement class if needed. 
  int[] giveData() {
    second = second * 1;
    return new int[] {second, minute, hour, day, month, year};
  }
}