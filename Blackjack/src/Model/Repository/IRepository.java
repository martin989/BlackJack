package Model.Repository;

import java.util.List;

import Model.Card.Card;

public interface IRepository {
	Card getNextCard();
	Boolean entriesLeft();
	
}
