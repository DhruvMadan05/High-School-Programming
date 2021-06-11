import java.util.*;
import java.lang.*; 
import java.io.*; 


class Main {
  public static void main(String[] args) {
    
    Deck Dek = new Deck();
    Dek.setDeck();
    System.out.println("\nDeck of Cards Unshuffled");
    Dek.printDeck();
    Dek.shuffleDeck();
    System.out.println("\n\n");
    System.out.println("\nDeck of Cards shuffled");
    Dek.printDeck();

  }
}