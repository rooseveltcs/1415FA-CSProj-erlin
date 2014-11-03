import java.util.ArrayList;
import java.util.Collections;


public class Player{
	private ArrayList<Card> hand;
	private int playerNum;
	
	public Player(int playerNum){
		this.playerNum = playerNum;
		hand = new ArrayList<Card>(0);
	}
	
	//removes card from hand and gives it
	public Card giveCard(Card card){
		hand.remove(card);
		return card;
	}
	
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
}
