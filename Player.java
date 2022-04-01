package cardDistribution;

import java.util.ArrayList;



public class Player {
	private String name;
	private String id;
	private ArrayList<Card> card_collection;
	boolean hasFaceCard = false;
	boolean hasSpadeCard = false;
	public Player(String name, String id, ArrayList<Card> card_collection) {
		this.name = name;
		this.id = id;
		this.card_collection = card_collection;
		
	}
	public boolean hasSpadeCard() {
		return this.hasSpadeCard;
	}
	public boolean hasFaceCard() {
		return this.hasFaceCard;
	}
	public void setHasSpadeCard(boolean hasSpadeCard) {
		this.hasSpadeCard = hasSpadeCard;
	}
	public void setHasFaceCard(boolean hasFaceCard) {
		this.hasFaceCard = hasFaceCard;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Card> getCard_collection(){
		return this.card_collection;
	}
	public void setCard_collection(ArrayList<Card> card_collection) {
		this.card_collection = card_collection;
	}
	public void addCard(Card card) {
		card_collection.add(card);
	}
}
