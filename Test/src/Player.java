import java.util.ArrayList;
import java.util.Collections;


public class Player{
	protected ArrayList<Card> hand;
	protected int playerNum;
	
	//creates a player with a specific playerNumber
	public Player(int playerNum){
		this.playerNum = playerNum;
		hand = new ArrayList<Card>(0);
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
	
	public int returnPlayerNum(){
		return playerNum;
	}
	
	public void displayHand(){
			System.out.println(hand);
	}
	
	public ArrayList<Card> returnHand(){
		return hand;
	}
}
