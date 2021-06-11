import java.util.*;
import java.lang.*; 
import java.io.*; 



class Deck {
  static String[] myDeck = new String[53];

  void setDeck(){
    int s = 1;
    for(int i = 1; i < 14; i++) {
      for(int j = 1; j < 5; j++) {
        switch(j) {
          case 1:
            myDeck[s] = String.valueOf(i) + "C";
            s++;
            break;
          case 2:
            myDeck[s] = String.valueOf(i) + "D";
            s++;
            break;
          case 3:
            myDeck[s] = String.valueOf(i) + "H";
            s++;
            break;
          case 4:
            myDeck[s] = String.valueOf(i) + "S";
            s++;
            break;
        }
      }
    }

  }

  //------------------------------------------------------------
  void shuffleDeck(){
    String tempCard;
    int cardNum1;
    int cardNum2;
    for(int i = 1; i < 53; i++) {
      cardNum1 = (int)(Math.random() * 52 + 1);
      tempCard = myDeck[cardNum1];

      cardNum2 = (int)(Math.random()*52 + 1);
      myDeck[cardNum1] = myDeck[cardNum2];

      myDeck[cardNum2] = String.valueOf(tempCard);
    }
    
  }

  //------------------------------------------------------------
  void printDeck(){
    int s = 1;
    for(int i = 1; i < 14; i++) {
      for(int j = 1; j < 5; j++){
        System.out.print(myDeck[s]);
        System.out.print("\t");
        s++;
      }
      System.out.println();
    }
 
  }
}