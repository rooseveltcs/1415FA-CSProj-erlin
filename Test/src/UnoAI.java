import java.awt.Color;
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
	
	public void act(){
		Card chosen = chooseCard();
		if(chosen!=null){
			deck.receiveCard(giveCard(chosen));
		}
		else{
			drawCard();
		}
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
		for(int x=0; x<hand.size(); x++){
			if(deck.returnLastCard().returnCardColor().equals(hand.get(x).returnCardColor()) || deck.returnLastCard().returnCardNum() == (hand.get(x).returnCardNum()) || deck.returnLastCard().returnCardColor().equals(Color.BLACK)){
				return hand.get(x);
			}
		}
		for(int x=0; x<hand.size(); x++){
			if(hand.get(x).returnCardColor().equals(Color.BLACK)){
				return hand.get(x);
			}
		}
		return null;
	}
	
	public void drawCard(){
		receiveCard(deck.giveCard());
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
