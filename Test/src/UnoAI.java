import java.util.ArrayList;
import java.util.Collections;


public class UnoAI {
	private ArrayList<Card> hand;
	private int playerNum;
	private Deck deck;
	
	public UnoAI(int playerNum, Deck deck){
		this.playerNum = playerNum;
		hand = new ArrayList<Card>(0);
		this.deck = deck;
	}
	
	//removes card from hand and gives it
	public Card giveCard(Card card){
		hand.remove(card);
		return card;
	}
		
	//sorts hand of cards by color, then number
	public void sortHand(){
		Collections.sort(hand);
	}
	
	//receives card and adds it to hand
	public void receiveCard(Card card){
		hand.add(card);
	}
	
	public Card chooseCard(){
			
	}
	
	public int returnPlayerNum(){
		return playerNum;
	}	
	
	public ArrayList<Card> returnHand(){
		return hand;
	}

	public void displayHand(){
		System.out.println(hand);
}
}
