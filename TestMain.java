package cardDistribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class TestMain {

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
			String face = card.getFace();
			String suit = card.getSuit();
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
			
			
			if((face.equals("Jack") || face.equals("Queen") || face.equals("King")|| face.equals("Ace")) && players_array.size()>0) {
				int player_number1 = new Random().nextInt(players_array.size());
				Player pr1 = players_array.get(player_number1);
				
				boolean check1 = addFaceCard(pr1,card);
				if(!check1) {
					
					players_array.remove(player_number1);
					if(players_array.size()>0) {
						int player_number2 = new Random().nextInt(players_array.size());
						Player pr2 = players_array.get(player_number2);
						boolean check2 = addFaceCard(pr2,card);
						if(!check2) {
							
							players_array.remove(player_number2);
							if(players_array.size()>0) {
								int player_number3 = new Random().nextInt(players_array.size());
								Player pr3 = players_array.get(player_number3);
								boolean check3 = addFaceCard(pr3,card);
								if(!check3) {
									
									players_array.remove(player_number3);

									if(players_array.size()>0) {
										Player pr4 = players_array.get(0);
										boolean check4 = addFaceCard(pr4,card);

										if(!check4 && players_array_copy.size()>0) {
											
											int player_number = new Random().nextInt(players_array_copy.size());
											Player player = players_array_copy.get(player_number);
											player.addCard(card);
										}
									}
									
									
								}
							}
							
							
						}
					}
					
					
					
				}
				
				
				
			}
			else if(suit.equals("Spade") && players_array.size()>0) {
				int player_number1 = new Random().nextInt(players_array.size());
				Player pr1 = players_array.get(player_number1);
				
				boolean check1 = addSpadeCard(pr1,card);
				if(!check1) {
					
					players_array.remove(player_number1);
					if(players_array.size()>0) {
						int player_number2 = new Random().nextInt(players_array.size());
						Player pr2 = players_array.get(player_number2);
						boolean check2 = addSpadeCard(pr2,card);
						if(!check2) {
							
							players_array.remove(player_number2);
							if(players_array.size()>0) {
								int player_number3 = new Random().nextInt(players_array.size());
								Player pr3 = players_array.get(player_number3);
								boolean check3 = addSpadeCard(pr3,card);
								if(!check3) {
									
									players_array.remove(player_number3);

									if(players_array.size()>0) {
										Player pr4 = players_array.get(0);
										boolean check4 = addSpadeCard(pr4,card);
										if(!check4 && players_array_copy.size()>0) {
											
											int player_number = new Random().nextInt(players_array_copy.size());
											Player player = players_array_copy.get(player_number);
											player.addCard(card);
										}
										
									}
									
									
								}
								
							}
							
							
						}
					}
					
					
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
		ArrayList<Card> alloted_cards = new ArrayList<>();
		alloted_cards.addAll(p1.getCard_collection());
		alloted_cards.addAll(p2.getCard_collection());
		alloted_cards.addAll(p3.getCard_collection());
		alloted_cards.addAll(p4.getCard_collection());
		cards_deck.removeAll(alloted_cards);
		ArrayList<Player> players = new ArrayList<>();
		if(p1.getCard_collection().size()<13) {players.add(p1);}
		if(p2.getCard_collection().size()<13) {players.add(p2);}
		if(p3.getCard_collection().size()<13) {players.add(p3);}
		if(p4.getCard_collection().size()<13) {players.add(p4);}
		for(Card card:cards_deck) {
			int player_number = new Random().nextInt(players.size());
			Player p = players.get(player_number);
			p.addCard(card);
			ArrayList<Player> alloted_players = new ArrayList<>();
			for(Player p_check:players) {
				if(p_check.getCard_collection().size()>=13) {
					alloted_players.add(p_check);
				}
			}
			players.removeAll(alloted_players);
		}
		cards_deck.clear();

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
	public static boolean addFaceCard(Player p, Card card) {
		ArrayList<Card> p_cards = p.getCard_collection();
		int temp=0;
		for(Card p_card:p_cards) {
			if(p_card.getFace().equals("Jack") || p_card.getFace().equals("Queen")||p_card.getFace().equals("King")||p_card.getFace().equals("Ace")) {
				temp++;
				break;
			}
		}
		if(temp==0) {
			p.addCard(card);
			return true;
		}
		return false;
		
	}
	public static boolean addSpadeCard(Player p, Card card) {
		ArrayList<Card> p_cards = p.getCard_collection();
		int temp=0;
		for(Card p_card:p_cards) {
			if(p_card.getSuit().equals("Spade")){
				temp++;
				break;
			}}
		if(temp==0) {
			p.addCard(card);
			return true;
		}
		return false;
		
	}
	
}
					
		
		
		
	
	


