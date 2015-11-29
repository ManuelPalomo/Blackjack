package deck;

import utils.Cons;

/**
 * Card is the class that describes one of the 52 French playing cards
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 *
 */
public class Card {
	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public String toString(){
		String card = Integer.toString(rank);
		switch(suit){
		case Cons.CLUBS:
			card+=" Of Clubs";
			break;
		case Cons.DIAMONDS:
			card+=" Of Diamonds";
			break;
		case Cons.HEARTS:
			card+=" Of Hearts";
			break;
		case Cons.SPADES:
			card+=" Of Spades";
			break;
		}
		return card;
			
	}

}
