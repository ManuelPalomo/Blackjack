package game;

import java.util.Scanner;

import deck.Card;
import deck.Deck;
import player.Hand;

/**
 * Game represents a full game of blackjack, with 1 dealer and 1 player, playing
 * in consecutive turns until the player calls to stop.
 * 
 * Regular blackjack rules apply;
 * 
 * @author Odin
 *
 */
public class Game {
	private Deck deck;
	private Hand player;
	private Hand dealer;
	private int playerWins;
	private int playerLoses;
	private boolean stop;

	public Game(Deck deck, Hand player, Hand dealer) {
		this.deck = deck;
		this.player = player;
		this.dealer = dealer;
		this.playerWins = 0;
		this.playerLoses = 0;
	}

	/**
	 * 
	 * @return
	 */
	public int playerTurn() {

		boolean end = false;
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Player's turn");
		// Deal the two first cards
		Card first = player.getCard();
		Card second = player.getCard();

		System.out.println("Your first two cards are: " + first.getRank() + " and " + second.getRank() + ".");
		System.out.println("Your current hand value is: " + player.getHandValue());

		while (!end) {
			System.out.println("What do you want to do now?");
			System.out.println("1-Hit");
			System.out.println("2-Stand");
			int operation = scanner.nextInt();
			
			switch (operation) {
			case 1:
				Card card=player.getCard();
				System.out.println("You pull a:"+card.getRank());
				System.out.println("Your current hand value is: "+player.getHandValue());
				if(player.getHandValue()>21){
					System.out.println("You are bust!");
					end=true;
				}
				break;

			case 2:
				end=true;
			}

		}
		return player.getHandValue();
	}

}
