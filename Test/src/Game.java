import java.util.ArrayList;


public class Game {
	public Deck deck;
	public ArrayList<UI> uiList = new ArrayList<UI>(0);
	
	public Game(int players, int deckNum){
		deck = new Deck(deckNum);
		for(int x=1; x<=players; x++){
			uiList.add(new UI(new Player(x), deck));
		}
		
	}
	
	public void push(){
		
	}
	
	public void pull(){
		
	}
}
