package Model.Card;

public class Card {
	private Color color;
	private Suit suit;
	private int value;
	private String imageLocation;
	
	public Card()
	{
		
	}

	public Card(Card card)
	{
		this.color = card.getColor();
		this.suit = card.getSuit();
		this.value = card.getValue();
		this.imageLocation = card.getImageLocation();
	}
	
	public Card(Color color, Suit suit, int value, String imageLocation) {
		this.color = color;
		this.suit = suit;
		this.value = value;
		this.imageLocation = imageLocation;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
}
