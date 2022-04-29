package Model;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Model.Card.Card;

public class Hand {
	private List<Card> hand;
	
	public Hand() {
		this.setHand(new Stack<Card>());
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void clearHand() {
		this.hand.clear();
	}

	
}
