import javax.swing.JFrame;


public class UI extends JFrame{
	static final long serialVersionUID = 0;
	protected int type;
	protected Player player;
	protected UnoAI AI;
	
	//creates UI of a player, with # of decks
	public UI(){
		
	}
	
	public void endTurn(){
		
	}
	
	public int returnType(){
		return type;
	}
	
	public Player returnPlayer(){
		return player;
	}

	public UnoAI returnAI(){
		return AI;
	}
}