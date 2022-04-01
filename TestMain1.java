package cardDistribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TestMain1 {

	public static void main(String[] args) {
		Player p1 = new Player("A", "1",new ArrayList<Card>());
		Player p2 = new Player("B","2", new ArrayList<Card>());
		Player p3 = new Player("C","3", new ArrayList<Card>());
		Player p4 = new Player("D","4", new ArrayList<Card>());
		ArrayList<Card> cards_deck = new ArrayList<>();
		String[] suits = new String[]{"Heart", "Spade","Club","Diamond"};
		String[] faces = new String[] {"Ace","King","Queen","Jack","10","9","8","7","6","5","4","3","2"};
		for(int i=0;i<suits.length;i++) {
			for(int j=0;j<faces.length;j++) {
				String suit = suits[i];
				String face = faces[j];
				Card card = new Card(suit,face);
				cards_deck.add(card);
				
			}
			
		}
		Collections.shuffle(cards_deck);
		ArrayList<Card> cards_deck_copy = cards_deck;
		for(Card card:cards_deck) {
//			Card card = cards_deck.get(0);
			ArrayList<Player> players_array = new ArrayList<>();
			ArrayList<Player> players_array_copy = new ArrayList<>();
			if(p1.getCard_collection().size()<13) {
				players_array.add(p1);
				players_array_copy.add(p1);
			}
			if(p2.getCard_collection().size()<13) {
				players_array.add(p2);
				players_array_copy.add(p2);
			}
			if(p3.getCard_collection().size()<13) {
				players_array.add(p3);
				players_array_copy.add(p3);
			}
			if(p4.getCard_collection().size()<13) {
				players_array.add(p4);
				players_array_copy.add(p4);
			}
			if(card.getFace().equals("Jack") || card.getFace().equals("Queen") || card.getFace().equals("King") || card.getFace().equals("Ace")) {
				int temp=0;
				while(players_array.size()>0) {
					int player_number = new Random().nextInt(players_array.size());
					Player p = players_array.get(player_number);
					if(p.hasFaceCard==false) {
						p.addCard(card);
						p.hasFaceCard = true;
						if(card.getSuit().equals("Spade")) {
							p.hasSpadeCard = true;
						}
						temp++;
						break;
					}
					else {
						players_array.remove(p);
					}
					
				}
				if(temp==0 && players_array.size()==0) {
					int player_number = new Random().nextInt(players_array_copy.size());
					Player p = players_array_copy.get(player_number);
					p.addCard(card);
					if(card.getSuit().equals("Spade")) {
						if(p.hasSpadeCard==false) {
							p.hasSpadeCard = true;
						}
						
					}
				}}

			
			else if(card.getSuit().equals("Spade")) {
				
				
					int temp=0;
					while(players_array.size()>0) {
						int player_number = new Random().nextInt(players_array.size());
						Player p = players_array.get(player_number);
						if(p.hasSpadeCard==false) {
							p.addCard(card);
							p.hasSpadeCard = true;
							
							temp++;
							break;
						}
						else {
							players_array.remove(p);
						}
						
					}
					if(players_array.size()==0 && temp==0) {
						int player_number = new Random().nextInt(players_array_copy.size());
						Player p = players_array_copy.get(player_number);
						p.addCard(card);
					}
					
				

			}
			else {
				if( players_array.size()>0) {
					int player_number = new Random().nextInt(players_array.size());
					Player p = players_array.get(player_number);
					p.addCard(card);
				}
			}

		}
		p1.getCard_collection().forEach((x)->{System.out.println(x.getFace()+"---"+x.getSuit());});
		System.out.println("*****");
		p2.getCard_collection().forEach((x)->{System.out.println(x.getFace()+"---"+x.getSuit());});
		System.out.println("*****");
		p3.getCard_collection().forEach((x)->{System.out.println(x.getFace()+"---"+x.getSuit());});
		System.out.println("*****");
		p4.getCard_collection().forEach((x)->{System.out.println(x.getFace()+"---"+x.getSuit());});
		System.out.println(p1.getCard_collection().size());
		System.out.println(p2.getCard_collection().size());
		System.out.println(p3.getCard_collection().size());
		System.out.println(p4.getCard_collection().size());

	}

}
