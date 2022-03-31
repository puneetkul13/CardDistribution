package cardDistribution;

public class Card {
	
	private String face;
	private String suit;
	public Card(String suit, String face) {
		this.suit = suit;
		this.face = face;
		
	}
	public String getFace() {
		return this.face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getSuit() {
		return this.suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
		
	}
}
