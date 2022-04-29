package Model.Game;


public interface IGameRules {
	String[] hitEvent();
	String[] stayEvent();
	String[] getEvent();
	void shuffleEvent();
	void newGameEvent();
}
