import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;


public class UnoAI extends Player{
	protected ArrayList<Card> hand;
	protected int playerNum;
	protected Deck deck;
	
	public UnoAI(int playerNum, Deck deck){
		super(playerNum);
		this.deck = deck;
	}
	
	public void act(){
		Card chosen = chooseCard();
		if(chosen!=null){
			deck.receiveCard(giveCard(chosen));
			Main.returnGame().addText("AI" + playerNum +" played " + chosen);
		}
		else{
			drawCard();
			Main.returnGame().addText("AI" + playerNum +" drew a card");
		}
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
	
	public Deck returnDeck(){
		return deck;
	}
}
