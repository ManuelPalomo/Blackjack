package deck;

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

}
