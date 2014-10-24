import java.awt.Color;
import java.util.ArrayList;


public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>(0);
	private ArrayList<Card> randomizedDeck;
	
	public Deck(int numDeck){
		if(numDeck>0){
			initializeDeck(numDeck);
		}
		randomize(deck);
	}
	
	public void randomize(ArrayList<Card> deck){
		randomizedDeck = new ArrayList<Card>(deck.size());
		int size = deck.size();
		for(int x=0; x<size; x++){
			int temp = (int)(Math.random()*deck.size());
			randomizedDeck.add(deck.get(temp));
			deck.remove(temp);
		}
	}
	
	public void initializeDeck(int numDeck){
		for(int x=0; x<numDeck; x++){
		initializeColorCards(Color.GREEN);
		initializeColorCards(Color.YELLOW);
		initializeColorCards(Color.BLUE);
		initializeColorCards(Color.RED);
		}
	}
	
	public void initializeColorCards(Color color){
		deck.add(new Card(0, color));
		for(int x=1; x<13; x++){
			for(int y=0; y<2; y++){
				deck.add(new Card(x, color));
			}
		}
		deck.add(new Card(13, Color.BLACK));
		deck.add(new Card(14, Color.BLACK));
	}
	
	public void displayCards(){
		System.out.println(deck.toString());
		System.out.println(deck.size());
	}
	
	public void displayRandomized(){
		System.out.println(randomizedDeck.toString());
		System.out.println(randomizedDeck.size());
	}
	
	public ArrayList<Card> returnRandomized(){
		return randomizedDeck;
	}
	
	public ArrayList<Card> returndeck(){
		return deck;
	}
	
	//returns a card and deletes it from randomizedDeck
	public Card giveCard(){
		int temp = (int)(Math.random()*randomizedDeck.size());
		Card card = randomizedDeck.get(temp);
		randomizedDeck.remove(temp);
		return card;
	}
	
	//randomizes deck(played cards) into randomizedDeck(if size() == 0)
	public void shuffle(){
		randomize(deck);
	}
	
	//receives played card from player
	public void receiveCard(Card card){
		deck.add(card);
	}
}
