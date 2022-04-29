package Model;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Model.Card.Card;
import Model.Card.Color;
import Model.Card.Suit;
import Model.Repository.CSVRepository;
import Model.Repository.IRepository;

public class Deck {
	private List<Card> deck;
	private IRepository repository;

	public Deck() {
		this.setDeck(new Stack<Card>());
		try {
			repository = new CSVRepository();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void createDeck() {
		List<Card> singleDeck = new Stack<Card>();
		Card card = new Card();
		while (repository.entriesLeft()) {
			card = new Card(repository.getNextCard());
			singleDeck.add(card);
		}
		deck.addAll(singleDeck);
		Collections.shuffle(deck);
	}
	
	public void shuttleDeck() {
		Collections.shuffle(deck);
	}
	
	public Card getCard() {
		Card card = new Card();
		card = deck.get(deck.size()-1);
		deck.remove(deck.size()-1);
		return card;
		
	}
}
