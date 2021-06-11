import java.util.Scanner;
class Main {
  public static void main(String[] args) {
  System.out.println("All Set Cards: ");
	//Create a new deck of cards
	Deck myDeck = new Deck();
	//display deck of cards, unshuffled
	myDeck.displayDeck();
	System.out.println("\nShuffled Deck:\n");
	//shuffle deck of cards
	myDeck.shuffleDeck();
	//Display shuffled deck of cards
	myDeck.displayDeck();
  }
}