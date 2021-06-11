import java.util.*;

class Main {
//---------------------------------------------------------------
	public static void welcome() {
		System.out.print("\033[H\033[2J"); 
		System.out.println("Welcome to coin game");
		System.out.println("The aim of the game is to have your opponent pick up the last coin on the table");
	}
//------------------------------------------------------------
	public static void pickOption() {
		Scanner scan1 = new Scanner(System.in);

		while (true) {
			System.out.println("\n");
			System.out.println("Type 1 for 1 Player mode");
			System.out.println("Type 2 for 2 player mode");
			int choice = scan1.nextInt();

			if(choice < 1 || choice > 2) {
				System.out.print("\033[H\033[2J");
				System.out.println("Invalid choice, please try again");
				continue;
			}
			if(choice == 1) {
				System.out.print("\033[H\033[2J");
				while (true) {
					System.out.println("Type 1 if you would like to go first");
					System.out.println("Type 2 if you would like to go second");

					int option = scan1.nextInt();
					if(option < 1 || option > 2) {
						System.out.print("\033[H\033[2J");
						System.out.println("Invalid choice, please try again");
						continue;
					}
					if(option == 1) {
						PlayerFirst P1 = new PlayerFirst();
						P1.play();
						break;
					} else if(option == 2) {
						CompFirst C1 = new CompFirst();
						C1.play();
						break;
					}
				}
				break;
			} else if (choice == 2) {
				MultiplayerCoin MPlay = new MultiplayerCoin();
				MPlay.play();
				break;
			}
		}

	}
//------------------------------------------------------------
  public static void main(String[] args) {
    welcome();
		pickOption();

		
  }
}