import java.util.Random;

class Deck {
	//Define the array of individual cards
  Cards[] mycards = new Cards[81];
	//------------------------------------------------------------
	//set integer values for each individual card and attributes in them
  Deck() {
    int counter = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int n = 0; n < 3; n++) {
          for (int m = 0; m < 3; m++) {
            mycards[counter] = new Cards(i, j, n, m);
            counter++;
          }
        }
      }
    }
  }
//----------------------------------------------------------------
//Display each card in the deck
  void displayDeck() {
    int count = 0;
    for (int k = 0; k < 81; k++) {
        mycards[count].displayCards();
        count++;
    }
  }
//----------------------------------------------------------------
//Shuffle the deck of cards
  void shuffleDeck() {
		//Define temp card
    Random num = new Random();
    for (int i = 1; i <= 250; i++) {
      for (int j = 0; j < 81; j++) {
        int n = num.nextInt(mycards.length);
        Cards tempCard = mycards[j];
        mycards[j] = mycards[n];
        mycards[n] = tempCard;
      }
    }
  }
//----------------------------------------------------------------
}