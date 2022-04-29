package Controller;

import Model.Game.IGameRules;
import View.CardTableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;


public class GameController implements IGameController {
	private CardTableView theView;
	private IGameRules theModel;

	public GameController(CardTableView theView, IGameRules theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addHitListener(new HitListerner());
		this.theView.addStayListener(new StayListerner());
		this.theView.addShuffleListener(new ShuffleListerner());
		this.theView.addNewGameListener(new NewGameListerner());
	}

	class HitListerner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theView.addCards(theModel.hitEvent());
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class StayListerner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				theView.addCards(theModel.stayEvent());
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	class ShuffleListerner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theModel.shuffleEvent();
		}
	}

	class NewGameListerner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theModel.newGameEvent();
			theView.enableGame();
			try {
				theView.addCards(theModel.getEvent());
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
