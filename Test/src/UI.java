import java.awt.Container;

import javax.swing.JFrame;


public class UI extends JFrame{
	static final long serialVersionUID = 0;
	protected Container contentPane;
	protected int type;
	protected Player player;
	protected Deck deck;
	protected boolean turn;
	protected int place = 0;
	
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
	
	public void tempStop(){
		setEnabled(false);
	}
	
	public void tempStart(){
		setEnabled(true);
	}
	
	public void update(){
		
	}
	
	public int returnPlace(){
		return place;
	}
	
	public void setPlace(int place){
		this.place = place;
	}
}