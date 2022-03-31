package cardDistribution;

import java.util.ArrayList;



public class Player {
	private String name;
	private String id;
	private ArrayList<Card> card_collection;
	public Player(String name, String id, ArrayList<Card> card_collection) {
		this.name = name;
		this.id = id;
		this.card_collection = card_collection;
		
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
