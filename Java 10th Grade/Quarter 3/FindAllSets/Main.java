import java.util.Scanner;
class Main {
  public static void main(String[] args) {
		System.out.println("\n12 Random Cards:");
		//Create a new deck of cards
		Deck myDeck = new Deck();
		//shuffle deck of cards
		myDeck.shuffleDeck();
		//Display 12 random cards
		myDeck.dealCards();
		System.out.println("\n\nSets in 12 cards");
		myDeck.getSet();
  }
}