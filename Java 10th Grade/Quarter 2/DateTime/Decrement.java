import java.util.*;
import java.lang.*; 
import java.io.*; 

class Decrement {

  int month; int Dmonth; int Opmonth;
  int day; int Dday; int Opday;
  int year; int Dyear; int Opyear;
  int hour; int Dhour; int Ophour;
  int minute; int Dminute; int Opminute;
  int second; int Dsecond; int Opsecond;

  //---------------------------------------------------------------
  //get data if needed from class main
  void getData(int second, int minute, int hour, int day, int month, int year) {
    Dsecond = second;
    Dminute = minute;
    Dhour = hour;
    Dday = day;
    Dmonth = month;
    Dyear = year;
  }
  //----------------------------------------------------------------
  //decrement method
  void decrementTime(int Opsecond, int Opminute, int Ophour, int Opday, int Opmonth, int Opyear) {

    //Start decrement by subtracting from secodns
    Dsecond = Dsecond - Opsecond;

    //test if seconds is smaller than it should be
    if(Dsecond < 0) {
      int minmin = (Dsecond / 60) - 1;
      minmin = minmin * (-1);
      Dsecond = Dsecond + (minmin * 60);
      Dminute = Dminute - minmin;
    }
    if(Dsecond == 60) {
      Dsecond = 0;
      Dminute = Dminute + 1;
    }
    //test if minutes is smaller thsn it should be
    Dminute = Dminute - Opminute;
    if(Dminute < 0) {
      int minhour = (Dminute / 60) - 1;
      minhour = minhour * (-1);
      Dminute = Dminute + (minhour * 60);
      Dhour = Dhour - minhour;
    }
    if(Dminute == 60) {
      Dminute = 0;
      Dhour = Dhour + 1;
    }
    //test if hour is smaller than it should be
    Dhour = Dhour - Ophour;
    if(Dhour < 0) {
      int minday = (Dhour / 24) - 1;
      minday = minday * (-1);
      Dhour = Dhour + (minday * 24);
      Dday = Dday - minday;
    }

    //Start day month year calcs
    Dday = Dday - Opday;
    while(Dday < 1) {
      Dmonth = Dmonth - 1;

      if(Dmonth < 1) {
        Dmonth = 12;
        Dyear = Dyear - 1;
      }

      //>>>>>>>>>>>>>>>
      //>>>>>>>>>>>>>>>
      //find max days in the month
      int max = 0;
      //Test month to set max days in the month 
      //test to see if the month has 31 days
      if(Dmonth == 1|| Dmonth == 3|| Dmonth == 5 || Dmonth == 7 || Dmonth == 8 || Dmonth == 10 || Dmonth == 12 ) {
        max = 31;
      }
      //test to see if the month has 30 days
      else if(Dmonth == 4 || Dmonth == 6 || Dmonth == 9 || Dmonth == 11) {
        max = 30;
      }
      //test to se if the month has 28 or 29 days
      else if(Dmonth == 2){
        //Tests to see if the year qualifies as a leap year
        if(Dyear % 4 != 0) {
          max = 28;
        }
        else if(Dyear % 100 != 0) {
          max = 29;
        }
        else if(Dyear % 400 != 0) {
          max = 28;
        }
        else {
          max = 29;
        }
      }
      //>>>>>>>>>>>>>
      //>>>>>>>>>>>>>

      Dday = Dday + max;

    }

    Dmonth = Dmonth - Opmonth;

    while(Dmonth < 1) {
      Dmonth = 12 + Dmonth;
      Dyear = Dyear - 1;
    }

    Dyear = Dyear - Opyear;

    if(Dyear == -1) {
      Dyear = 0;
      Dmonth = 0;
    }
  }

  //--------------------------------------------------------------
  //Display the original time supplied by user
  void timeDisplay() {
    Time TD = new Time();
    
    TD.timeDisplay(second, minute, hour, day, month, year);
  }
  //-----------------------------------------------------------------
  //display the end time that is in the system
  void DtimeDisplay() {
    Time TD = new Time();
    
    TD.timeDisplay(Dsecond, Dminute, Dhour, Dday, Dmonth, Dyear);
  }
  //---------------------------------------------------------------
  //Display age in correct format
  void AgeDisplay() {
    System.out.println("You are exactly: " + Dyear + " years, " + Dmonth + " months, "  + Dday + " Days, " + Dhour + " Hours, " + Dminute + " Minutes & " + Dsecond + " Seconds old.");
  }
}