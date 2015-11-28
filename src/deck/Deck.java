package deck;

import java.util.Collections;
import java.util.Stack;

/**
 * Deck is the class that represents a playing deck, it's designed to allow more
 * card types in the future.
 * 
 * RemovedCards serves as a card repository, so no new cards needs to be created
 * in case that the deck needs to be shuffled
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 *
 */
public class Deck {
	private Stack<Card> cards;
	private Stack<Card> removedCards;

	public Deck() {
		cards = new Stack<Card>();
		removedCards = new Stack<Card>();
	}

	/**
	 * Fill the Stack with a full suite of cards Contains: 13 cards for each
	 * suite, with 3 face card and 1 Ace for each suite
	 */
	public void fillDeckWithStandardCards() {
		int totalSuits = 4; // Clubs,Spades,Diamonds and Hearts
		int cardsForEachSuite = 13;
		for (int suit = 0; suit < totalSuits; suit++) {
			// Create the number cards and the ace
			for (int rank = 1; rank <= cardsForEachSuite; rank++) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
		shuffleDeck();
	}

	public Card getCard() {
		Card card = cards.pop();
		removedCards.add(card);
		return card;

	}

	/**
	 * First, stacks all the removed cards, and then shuffles the deck
	 */
	public void shuffleDeck() {
		for (Card card : removedCards) {
			cards.add(card);
		}
		Collections.shuffle(cards);

	}
}
