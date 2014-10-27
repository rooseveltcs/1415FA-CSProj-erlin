import java.util.ArrayList;

import javax.swing.JFrame;


public class Player extends JFrame{
	static final long serialVersionUID = 0;
	private ArrayList<Card> hand;
	private int playerNum;
	
	public Player(int playerNum){
		this.playerNum = playerNum;
		createGui();
	}
	
	public void createGui(){
		this.setTitle("Player" + playerNum);
		this.setResizable(false);
		
	}

	
}
