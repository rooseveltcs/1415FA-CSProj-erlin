import java.awt.Color;
import java.util.ArrayList;


public class DeckCheck {
	static ArrayList<Card> randomizedDeck;
	static ArrayList<Card> cards;
	
	public static void main(String[] args){
		Deck deck = new Deck(1);
		randomizedDeck = deck.returnRandomized();
		compare(randomizedDeck);
	}
	
	//checks if cards are in a randomizedDeck
	public static void compare(ArrayList<Card> randomizedDeck){
		initializeCards();
		for(int x=0; x<cards.size(); x++){
			checkCard(cards.get(x));
		}
		System.out.println(randomizedDeck.size());
	}
	
	//checks inidivdual card present in randomizedDeck
	public static void checkCard(Card card){
		int temp = 0;
		for(int x=0; x<randomizedDeck.size(); x++){
			if(randomizedDeck.get(x).toString().equals(card.toString())){
				temp++;
			}
		}
		System.out.println(card.toString() + "-" + temp);
	}
	
	public static void initializeCards(){
		cards = new ArrayList<Card>(0);
		initializeColorCards(Color.GREEN);
		initializeColorCards(Color.YELLOW);
		initializeColorCards(Color.BLUE);
		initializeColorCards(Color.RED);
		cards.add(new Card(13, Color.BLACK));
		cards.add(new Card(14, Color.BLACK));
	}
	
	public static void initializeColorCards(Color color){
		cards.add(new Card(0, color));
		for(int x=1; x<13; x++){
				cards.add(new Card(x, color));
			}
	}
}
