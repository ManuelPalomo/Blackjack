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
	private Scanner scanner;

	public Game(Deck deck, Hand player, Hand dealer) {
		this.deck = deck;
		this.player = player;
		this.dealer = dealer;
		this.playerWins = 0;
		this.playerLoses = 0;
		this.stop = false;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		System.out.println("BLACKJACK");
		while (!stop) {
			System.out.println("Dealing the first two cards:");

			Card first = dealer.getCard();
			Card second = dealer.getCard();

			System.out.println("Dealer's first card is: " + first.toString());

			first = player.getCard();
			second = player.getCard();

			System.out.println("Your first two cards are: " + first.toString() + " and " + second.toString() + ".");
			System.out.println("Your current hand value is: " + player.getHandValue());

			int playerValue = playerTurn();
			int dealerValue = dealerTurn();

			System.out.println("=================");

			if (dealerValue > 21 || ((dealerValue < playerValue) && dealerValue < 21)) {
				System.out.println("Player wins!");
				playerWins++;
			} else if (playerValue > 21 || ((playerValue < dealerValue) && playerValue < 21)) {
				System.out.println("Dealer wins!");
				playerLoses++;
			} else if (playerValue == dealerValue) {
				System.out.println("Push!");
			}

			System.out.println("Player wins:" + playerWins);
			System.out.println("Player loses:" + playerLoses);

			System.out.println("Want to play again? (Y/N)");
			if (scanner.next().equals("N")) {
				stop = true;
				scanner.close();
			}
			prepareForNextTurn();

		}

	}

	private int playerTurn() {

		boolean end = false;

		System.out.println("Player's turn");
		while (!end) {
			System.out.println("What do you want to do now?");
			System.out.println("1-Hit");
			System.out.println("2-Stand");
			int operation = scanner.nextInt();

			switch (operation) {
			case 1:
				Card card = player.getCard();
				System.out.println("You pull a:" + card.toString());
				System.out.println("Your current hand value is: " + player.getHandValue());
				if (player.getHandValue() > 21) {
					System.out.println("You are bust!");
					end = true;
				}
				break;

			case 2:
				end = true;
			}

		}
		return player.getHandValue();
	}

	/**
	 * Play a turn of the dealer, that must keep drawing cards until the value
	 * of his hand is 17 or above
	 * 
	 * @return
	 */
	private int dealerTurn() {
		System.out.println("Dealer's turn");

		while (dealer.getHandValue() < 17) {
			Card card = dealer.getCard();
			System.out.println("Dealer draws a: " + card.toString());
			System.out.println("Dealer's hand value is: " + dealer.getHandValue());

		}
		return dealer.getHandValue();
	}

	/**
	 * Clears all the hands and shuffles the deck for the next turnF
	 */
	private void prepareForNextTurn() {
		player.clear();
		dealer.clear();
		deck.shuffleDeck();
	}

}
