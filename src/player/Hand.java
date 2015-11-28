package player;

import java.util.LinkedList;
import java.util.List;

import deck.*;
import utils.Cons;

/**
 * Hand describes all the cards that a player has in the current time
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 *
 */
public class Hand {
	private List<Card> cards;
	private int handValue;
	private Deck deck;

	public Hand(Deck deck) {
		this.cards = new LinkedList<Card>();
		this.handValue = 0;
		this.deck = deck;
	}

	public Card getCard() {
		Card card = deck.getCard();
		cards.add(card);
		this.handValue = computeHandValue();
		return card;
	}

	public int computeHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += getCardValue(card, value);
		}
		return value;
	}

	/**
	 * Computes the card value according to the blackjack rules. Special case is
	 * added to compute the Aces, so the total count needs to be present
	 * 
	 * @return Integer containing the card value
	 */
	private int getCardValue(Card card, int total) {
		int value = 0;
		int cardRank = card.getRank();
		if (cardRank == 1 && total < 11) {
			value = 11;
		} else if (cardRank == 1) {
			value = 11;
		} else if (cardRank == Cons.J || cardRank == Cons.Q || cardRank == Cons.K) {
			value = 10;
		} else {
			value = cardRank;
		}
		return value;
	}

	/**
	 * Resets the hand
	 */
	public void clear(){
		cards.clear();
		handValue=0;
		
	}
	public int getHandValue() {
		return handValue;
	}
}
