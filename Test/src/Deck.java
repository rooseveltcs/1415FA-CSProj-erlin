import java.awt.Color;
import java.util.ArrayList;


public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>(0);
	private ArrayList<Card> randomizedDeck;
	private int numDeck;
	private int draw = 0;
	private int skip = 0;
	
	//initializes a deck(with number of packs of cards)
	//to be added: infinite cards(every draw is random, MAY have all Wild or all +4)
	//	when input <=0
	public Deck(int numDeck){
		this.numDeck = numDeck;
		if(numDeck>0){
			initializeDeck(numDeck);
		}
		else{
			//to be added
		}
		randomize(deck);
	}
	
	//shuffles deck into randomizedDeck, removes cards in Deck
	public void randomize(ArrayList<Card> deck){
		randomizedDeck = new ArrayList<Card>(deck.size());
		int size = deck.size()-1;
		for(int x=0; x<size; x++){
			int temp = (int)(Math.random()*deck.size());
			randomizedDeck.add(deck.get(temp));
			if(randomizedDeck.get(randomizedDeck.size()-1).returnCardNum() == 13 || randomizedDeck.get(randomizedDeck.size()-1).returnCardNum() == 14){
				randomizedDeck.get(randomizedDeck.size()-1).setCardColor(Color.BLACK);
				randomizedDeck.get(randomizedDeck.size()-1).setColorInt(5);
				randomizedDeck.get(randomizedDeck.size()-1).setColorRep("BLACK");
			}
			randomizedDeck.get(randomizedDeck.size()-1).setUsed(false);
			deck.remove(temp);
		}
	}
	
	//creates deck(number of pack of cards)
	public void initializeDeck(int numDeck){
		for(int x=0; x<numDeck; x++){
		initializeColorCards(Color.GREEN);
		initializeColorCards(Color.YELLOW);
		initializeColorCards(Color.BLUE);
		initializeColorCards(Color.RED);
		}
	}
	
	//initializes cards of one color + one each: Wild and Wild+4
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
	
	//prints Deck
	public void displayDeck(){
		System.out.println(deck.toString());
		System.out.println(deck.size());
	}
	
	//prints RandomizedDeck
	public void displayRandomized(){
		System.out.println(randomizedDeck.toString());
		System.out.println(randomizedDeck.size());
	}
	
	public ArrayList<Card> returnRandomized(){
		return randomizedDeck;
	}
	
	public ArrayList<Card> returnDeck(){
		return deck;
	}
	
	//returns a card and deletes it from randomizedDeck. If rDeck empty, shuffle.
	public Card giveCard(){
		int temp = (int)(Math.random()*randomizedDeck.size());
		Card card = randomizedDeck.get(temp);
		randomizedDeck.remove(temp);
		if(randomizedDeck.isEmpty()){
			shuffle();
		}
		return card;
	}
	
	//randomizes deck(played cards) into randomizedDeck(if size() == 0).
	public void shuffle(){
		randomize(deck);
	}
	
	//receives played card from player. Adds card to deck.
	public void receiveCard(Card card){
		deck.add(card);
	}
	
	public Card returnLastCard(){
		return deck.get(deck.size()-1);
	}
	
	public Card returnPlayedCard(){
		Card card = deck.get(deck.size()-1);
		deck.remove(card);
		return card;
	}
	
	public int returnNumDeck(){
		return numDeck;
	}
	
	public int returnDraw(){
		return draw;
	}
	
	public void addDraw(int temp){
		draw = draw + temp;
	}
	
	public int returnSkip(){
		return skip;
	}
	
	public void addSkip(int temp){
		skip = skip + temp;
	}
}
