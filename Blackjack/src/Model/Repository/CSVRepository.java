package Model.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Card.Card;
import Model.Card.Color;
import Model.Card.Suit;

public class CSVRepository implements IRepository {
	Scanner sc;

	
	public CSVRepository() throws FileNotFoundException {
		Path path = Paths.get("/src/Resources/CardRepo3.csv");
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		String pathString = currentWorkingDir.toString() + path.toString();
		
		sc = new Scanner(new File(pathString));
		
	}

	public Card getNextCard() {
		if (!sc.hasNext()) {
			sc.close();
		}
		String line = sc.next();
		return getCardFromStringArray(line.split(","));
	}

	@Override
	public Boolean entriesLeft() {
		return sc.hasNext();
	}
	
	private Card getCardFromStringArray(String[] stringArray)
	{
		Card card = new Card();
		card.setImageLocation(stringArray[3]);
		card.setValue(Integer.parseInt(stringArray[2]));
		
		if(stringArray[0] == "Red") {
			card.setColor(Color.Red);
		}else {
			card.setColor(Color.Black);
		}
		
		if(stringArray[1] == "Hearts") {
			card.setSuit(Suit.Hearts);
		}else if(stringArray[1] == "Diamonds"){
			card.setSuit(Suit.Diamonds);
		}else if(stringArray[1] == "Spades"){
			card.setSuit(Suit.Spades);
		}else{
			card.setSuit(Suit.Clubs);
		}
		return card;
	}
}
