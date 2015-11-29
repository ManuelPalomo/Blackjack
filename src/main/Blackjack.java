package main;

import deck.Deck;
import game.Game;
import player.Hand;

public class Blackjack {
	public static void main(String[]args){
		Deck deck = new Deck();
		deck.fillDeckWithStandardCards();
		
		Hand player = new Hand(deck);
		Hand dealer = new Hand(deck);
		
		Game game = new Game(deck, player, dealer);
		game.start();
	}
}
