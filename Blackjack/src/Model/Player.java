package Model;

import java.util.List;

import Model.Card.Card;

public class Player {
	Hand hand;
	String image;
	
	public Player() {
		hand = new Hand();
	}
	
	public Player(String image) {
		hand = new Hand();	
		this.image = image;
	}
	
	//Hand Interaction
	public void card(Card card) {
		hand.addCard(card);
	}
	
	public void clearCardsInHand() {
		hand.clearHand();
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
		
	}
	
	public String[] cardImageList() {
		List<Card> playerHand = this.hand.getHand();
		String[] list = new String[playerHand.size()];
		int loop = 0;
		for(Card card : playerHand) {
			list[loop] = card.getImageLocation();
			loop++;
		}
		return list;
		
	}
	
	
}
