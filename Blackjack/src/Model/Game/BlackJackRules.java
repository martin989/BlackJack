package Model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Model.Deck;
import Model.Hand;
import Model.Player;
import Model.Card.Card;

public class BlackJackRules implements IGameRules{

	private ArrayList<Player> players;
	private Deck deck;
	private int currentPlayer;
	
	
	public BlackJackRules()
	{
		newGameEvent();
	}
	
	
	@Override
	public String[] hitEvent() {
		Player player = players.get(currentPlayer);
		Card card = new Card(deck.getCard());
		player.addCardToHand(card);
		players.set(currentPlayer, player);
		return player.cardImageList();
	}
	
	@Override
	public String[] stayEvent() {
		if(currentPlayer == players.size()-1) {
			String[] list = new String[1];
			list[0] = "END OF GAME";
			return list;
		}else {
			currentPlayer++;
			Player player = players.get(currentPlayer);
			return player.cardImageList();
		}
	}

	@Override
	public String[] getEvent() {
		Player player = players.get(currentPlayer);
		return player.cardImageList();
	}
	
	public void shuffleEvent() {
		deck.shuttleDeck();
	}


	@Override
	public void newGameEvent() {
		players = new ArrayList<Player>();
		currentPlayer = 0;
		deck = new Deck();
		deck.createDeck();
		Player player1 = new Player();
		player1.addCardToHand(deck.getCard());
		player1.addCardToHand(deck.getCard());
		Player player2 = new Player();
		player2.addCardToHand(deck.getCard());
		player2.addCardToHand(deck.getCard());
		players.add(player1);
		players.add(player2);
	}
}
