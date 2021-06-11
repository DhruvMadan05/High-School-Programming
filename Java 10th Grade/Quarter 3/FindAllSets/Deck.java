import java.util.Random;
import java.util.ArrayList;

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
    for (int k = 0; k < 81; k++) {
			System.out.println();
      mycards[k].displayCards();
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
	void dealCards() {
		//Define the amount of cars to be dealt at once
		int dealNum = 12;
		for(int i = 0; i < dealNum; i++) {
			System.out.println();
			mycards[i].displayCards();
		}
	}
//-----------------------------------------------------------------
//Find 1 set of cards in the 12 delt cards
	ArrayList<Integer> findSet() {
		//define array list of all sets in the 12 cards
		ArrayList<Integer> setCards = new ArrayList<Integer>();
		//For loops to get 3 different consecutive cards
		for(int x = 0; x < 10; x++) {
			for(int y = x + 1; y < 11; y++) {
				for(int z = y + 1; z < 12; z++) {
					//If statements to test if there is a set of cards
					if((mycards[x].getIntNumber() + mycards[y].getIntNumber() + mycards[z].getIntNumber()) % 3 == 0) {
						if((mycards[x].getIntShape() + mycards[y].getIntShape() + mycards[z].getIntShape()) % 3 == 0) {
							if((mycards[x].getIntColor() + mycards[y].getIntColor() + mycards[z].getIntColor()) % 3 == 0) {
								if((mycards[x].getIntShading() + mycards[y].getIntShading() + mycards[z].getIntShading()) % 3 == 0) {
									//add the 3 cards to the array list
									setCards.add(x);
									setCards.add(y);
									setCards.add(z);
								}
							}
						}
					}
				}
			}
		}
		return setCards;
	}
	//--------------------------------------------------------------
	void getSet() {
		ArrayList<Integer> resultCards = findSet();
		if(resultCards.size() < 1) {
			System.out.println("No sets found");
		}
		else {
			int setNum = 1;
			for(int i = 0; i < resultCards.size(); i = i + 3) {
				System.out.print("Set Number " + setNum + ":");
				setNum++;
				System.out.println();
				mycards[resultCards.get(i)].displayCards();
				System.out.print("  |  ");
				mycards[resultCards.get(i + 1)].displayCards();
				System.out.print("  |  ");
				mycards[resultCards.get(i + 2)].displayCards();
				System.out.println("\n");
			}
		}
		
	}
}