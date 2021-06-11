import java.util.*;

class MultiplayerCoin{
	Scanner scan1 = new Scanner(System.in);

	void play(){
		System.out.print("\033[H\033[2J"); 
		int coins = 23;
		int play = 2;
		int Player = 1;

		while (coins > 0) {
		

			while (true) {

				if(play % 2 == 0){
					System.out.println("Player 1's turn");
					Player = 1;
				} else if(play % 2 == 1){
					System.out.println("Player 2's turn");
					Player = 2;
				}

				System.out.println("\nCoins left: " + coins);
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
					System.out.println("Player " + Player + " took 1 coin");
					System.out.println("\n");
					coins -= 1;
					break;
				}	else if (take == 2) {
					System.out.print("\033[H\033[2J");
					System.out.println("Player " + Player + " took 2 coins");
					System.out.println("\n");
					coins -= 2;
					break;
				}
				
			}
			play++;

			if (coins <= 0) {
				if(play % 2 == 0){
					Player = 1;
				} else if(play % 2 == 1){
					Player = 2;
				}
				System.out.print("\033[H\033[2J"); 
				System.out.println("Player " + Player + " wins!");
				break;
			}
			
		}
			
	}
}