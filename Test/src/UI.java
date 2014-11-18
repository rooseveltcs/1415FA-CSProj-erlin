import java.awt.Container;

import javax.swing.JFrame;


public class UI extends JFrame{
	static final long serialVersionUID = 0;
	protected Container contentPane;
	protected int type;
	protected Player player;
	protected Deck deck;
	protected boolean turn;
	
	//creates UI of a player, with # of decks
	public UI(){
		
	}
	
	public void act(){
		
	}
	
	public void endTurn(){
		
	}
	
	public void setTurn(boolean b){
		turn = b;
	}
	
	public boolean returnTurn(){
		return turn;
	}
	
	public int returnType(){
		return type;
	}
	
	public Player returnPlayer(){
		return player;
	}
	
	public Deck returnDeck(){
		return deck;
	}
}