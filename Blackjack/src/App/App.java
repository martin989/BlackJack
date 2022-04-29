package App;

import Controller.GameController;
import Controller.IGameController;
import Model.Deck;
import Model.Game.BlackJackRules;
import Model.Game.IGameRules;
import View.CardTableView;

public class App {

	public static void main(String[] args) {
		CardTableView theView = new CardTableView();
		IGameRules theModel = new BlackJackRules();
		
		IGameController theController = new GameController(theView,theModel);
		
		
		theView.setVisible(true);
	}

}
