import java.util.*;

class PlayerFirst{
	Scanner scan1 = new Scanner(System.in);

	void play() {
		System.out.print("\033[H\033[2J"); 
		int coins = 23;
		int win = 1;
		boolean takeTwo = false;
		System.out.println("Player 1 goes first");
		while (coins > 0) {

			while (true) {
				//System.out.print("\033[H\033[2J"); 
				System.out.println("Coins left: " + coins);
				System.out.println("Type 1 to take 1 coin");
				System.out.println("Type 2 to take 2 coins");
				int take = scan1.nextInt();

				if(take < 1 || take > 2) {
					System.out.print("\033[H\033[2J"); 
					System.out.println("You cannot take that many coins off the table, please try again");
					continue;
				}

				if (take == 1) {
					System.out.print("\033[H\033[2J");
					System.out.println("Computer takes 2");
					System.out.println("\n");
					coins -= 3;
					break;
				}	else if (take == 2) {
					if (takeTwo == false) {
						win = 0;
						coins -= 4;
						System.out.print("\033[H\033[2J");
						System.out.println("Computer takes 2");
						System.out.println("\n");
						takeTwo = true;
						break;
					} else {
						System.out.print("\033[H\033[2J");
						System.out.println("Computer takes 1");
						System.out.println("\n");
						coins -= 3;
						break;
					}
				}
			}

			if (coins <= 0) {
				if (win == 0) {
					System.out.print("\033[H\033[2J"); 
					System.out.println("Computer wins");
				}	else if (win == 1) {
					System.out.print("\033[H\033[2J"); 
					System.out.println("Player 1 wins!");
				}
				break;
			}
			
		}

	}
}